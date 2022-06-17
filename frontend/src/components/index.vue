<template>
  <div class="index">
    <div class="flex ">
      <div class="left w-2/3 mr-2">
        <category class="mb-3"></category>
        <article-list></article-list>
      </div>
      <div class="right w-1/3 ml-2">
        <top class="mb-3"></top>
        <hot-view class="mb-3"></hot-view>
        <hot-comment></hot-comment>
      </div>
    </div>
  </div>
</template>

<script>

import Category from "@/components/category";
import Top from "@/components/top";
import ArticleList from "@/components/article-list";
import HotView from "@/components/hot-view";
import HotComment from "@/components/hot-comment";

export default {
  name: 'index',
  components: {HotComment, HotView, ArticleList, Category, Top},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
