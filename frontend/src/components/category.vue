<template>
  <div class="category">
    <div class="flex justify-between my-1">
      <div>
        <el-button-group>
          <button class="nes-btn">全部</button>
          <button class="nes-btn">未结帖</button>
          <button class="nes-btn">已采纳</button>
          <button class="nes-btn">精贴</button>
          <button class="nes-btn">我的贴</button>
        </el-button-group>
      </div>
      <div>
        <button class="nes-btn is-success"
                @click="writeArticle">Ask Question
        </button>
      </div>
    </div>
    <div class="flex">
      <el-select v-model="input"
                 :loading="loading"
                 :remote-method="querySearchAsync"
                 class="w-full p-0"
                 filterable
                 placeholder="请输入内容"
                 remote
                 @change="handleSelect">
        <el-option
            v-for="item in articleList"
            :key="item.id"
            :value="item.id">
          <span>
            <span v-html="item.title"></span>
            <el-divider class="my-1"
                        direction="vertical"></el-divider>
            <span v-html="item.content"></span>
          </span>
        </el-option>
      </el-select>
    </div>
  </div>
</template>

<script>
import {articleSearch} from "@/request/article";

export default {
  name: "category",
  data: () => {
    return {
      input: '',
      articleList: [],
      loading: false
    }
  },
  methods: {
    writeArticle() {
      this.$router.push(`/write`);
    },
    async querySearchAsync(queryString) {
      if (!queryString) {
        return;
      }
      console.log('querySearchAsync', queryString);
      this.loading = true;
      this.articleList = [];
      const res = await articleSearch(queryString);
      this.articleList = res.data;
      this.loading = false;
    },
    handleSelect(it) {
      this.$router.push(`/article-info/${it}`);
    }
  }
}
</script>

<style scoped>

</style>
