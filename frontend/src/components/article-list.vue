<template>
  <div class="article-list">
    <div class="top mb-3 p-2">
      <ul class="divide-y"
          style="overflow:auto">
        <li v-for="(item,index) in topList"
            :key="index"
            class="p-1">
          <article-item :item="item"></article-item>
        </li>
      </ul>
    </div>
    <div class="bottom p-2">
      <ul :infinite-scroll="load"
          class="infinite-list divide-y"
          style="overflow:auto">
        <li v-for="(item,index) in articleList"
            :key="index"
            class="p-1">
          <article-item :item="item"></article-item>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import ArticleItem from "@/components/article-item";
import {articleInfoPage} from "@/request/article";

export default {
  name: "article-list",
  components: {ArticleItem},
  data() {
    return {
      page: 1,
      topList: [
        {
          "id": 0,
          "title": "String",
          "authorName": "authorName",
          "releaseTime": "2022-06-17 09:11:46",
          "typeId": 0,
          "visitNum": 0,
          "commentNum": 0,
          "payKiss": 0,
          "cream": 0,
          "stick": 1,
          "isDone": 0,
          "markdownContent": "String",
          "htmlContent": "String"
        },
        {
          "id": 1,
          "title": "String",
          "authorName": "authorName",
          "releaseTime": "2022-06-17 09:11:46",
          "visitNum": 0,
          "commentNum": 0,
          "payKiss": 0,
          "cream": 1,
          "stick": 1,
          "isDone": 0,
          "markdownContent": "String",
          "htmlContent": "String"
        }
      ],
      articleList: []
    }
  },
  async mounted() {
    this.loadData();
  },
  methods: {
    async load() {
      this.page++;
      this.loadData();
    },
    async loadData() {
      let res = await articleInfoPage({
        page: this.page,
        size: 10,
        sort: "releaseTime,desc"
      });
      this.articleList.push(...res.data.content);
    }
  }
}
</script>

<style scoped>
.top {
  background-color: white;
}

.bottom {
  background-color: white;

}
</style>
