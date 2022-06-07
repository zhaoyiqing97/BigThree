package org.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDO {

    private int author_id; //作者id,对应user_info中的id      
    private int comment_num; //文章评论量                       
    private int cream; //是否是精华帖,0代表不是,1代表是         
    private Date create_time; //                            
    private int create_user; //                              
    private String html_content; //文章内容                   
    private int id; //主键                                   
    private int is_done; //是否是否结帖,0代表不是,1代表是       
    private String markdown_content; //文章内容               
    private int pay_kiss; //悬赏飞吻数                          
    private Date release_time; //发布时间                   
    private int state; //0代表存在,1代表已经被删除              
    private int stick; //是否是置顶帖,0代表不是,1代表是         
    private String title; //文章标题                           
    private int type_id; //文章类型id,对应article_type中的id 
    private Date upDate_time; //                            
    private int upDate_user; //                              
    private int visit_num; //文章浏览量
    
}
