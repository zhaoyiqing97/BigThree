<template>
  <div class="category">
    <div class="flex justify-between my-1">
      <div>
        <el-button-group>
          <el-button class="nes-btn">全部</el-button>
          <el-button class="nes-btn">未结帖</el-button>
          <el-button class="nes-btn">已采纳</el-button>
          <el-button class="nes-btn">精贴</el-button>
          <el-button class="nes-btn">我的贴</el-button>
        </el-button-group>
      </div>
      <div>
        <el-button class="nes-btn is-success"
                   type="success"
                   @click="writeArticle">Ask Question
        </el-button>
      </div>
    </div>
    <div class="flex">
      <el-select v-model="input"
                 :loading="loading"
                 :remote-method="querySearchAsync"
                 class="nes-input p-0"
                 filterable
                 placeholder="请输入内容"
                 remote
                 @change="handleSelect">
        <el-option
            v-for="item in articleList"
            :key="item.id"
            :label="item.label"
            :value="item.id">
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
      console.log('querySearchAsync', queryString);
      this.loading = true;
      this.articleList = [];
      const res = await articleSearch(queryString);
      console.log(res.data);
      this.articleList = res.data.map(it => {
        return {
          label: it.content.title[0],
          id: it.id
        }
      })
      this.loading = false;
    },
    handleSelect(it) {
      console.log('handleSelect', it);
      this.$router.push(`/article-info/${it}`);
    }
  }
}
</script>

<style scoped>

</style>
