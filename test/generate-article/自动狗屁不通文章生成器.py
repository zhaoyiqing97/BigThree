#!/usr/bin/python
# -*- coding: UTF-8 -*-

import random
import time

import pymysql
import requests as requests

import readJSON

data = readJSON.读JSON文件("data.json")
名人名言 = data["famous"]  # a 代表前面垫话，b代表后面垫话
前面垫话 = data["before"]  # 在名人名言前面弄点废话
后面垫话 = data['after']  # 在名人名言后面弄点废话
废话 = data['bosh']  # 代表文章主要废话来源

xx = "学生会退会"

重复度 = 2


def 洗牌遍历(列表):
    global 重复度
    池 = list(列表) * 重复度
    while True:
        random.shuffle(池)
        for 元素 in 池:
            yield 元素


下一句废话 = 洗牌遍历(废话)
下一句名人名言 = 洗牌遍历(名人名言)


def 来点名人名言():
    global 下一句名人名言
    xx = next(下一句名人名言)
    xx = xx.replace("a", random.choice(前面垫话))
    xx = xx.replace("b", random.choice(后面垫话))
    return xx


def 另起一段():
    xx = ". "
    xx += "\r\n"
    xx += "    "
    return xx


def 生成文章():
    res = ''
    for x in xx:
        tmp = str()
        while len(tmp) < 6000:
            分支 = random.randint(0, 100)
            if 分支 < 5:
                tmp += 另起一段()
            elif 分支 < 20:
                tmp += 来点名人名言()
            else:
                tmp += next(下一句废话)
        tmp = tmp.replace("x", xx)
        res = res + tmp
    return res


if __name__ == "__main__":
    xx = input("请输入文章主题:")
    db = pymysql.connect(host="127.0.0.1",
                         user="big_three",
                         port=3306,
                         password="big_three",
                         database="big_three")
    cursor = db.cursor()
    id_article = time.time()
    article = 生成文章()
    cursor.execute(f"""
    INSERT INTO big_three.article_info 
    (id, title, author_id, release_time, type_id, visit_num, comment_num, pay_kiss, cream, stick, is_done, markdown_content, html_content, state, create_time, create_user, update_time, update_user) 
    VALUES 
    (%s, %s, 1, %s, %s, %s, 0, 0, 0, 0, 1, %s, %s, 0, %s, 1, NULL, NULL);
    """, (
        id_article,
        xx,
        time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),
        random.randint(1, 4),
        random.randint(50, 400),
        article,
        article,
        time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
    ))
    db.commit()
    db.close()
    res = requests.post("http://127.0.0.1:9200/article-search/_doc", json={
        "id": id_article,
        "title": xx,
        "htmlContent": article
    })
    print(res)
