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
                   @click="writeArticle">Ask Question</el-button>
      </div>
    </div>
    <div class="flex">
      <input v-model="input"
             class="nes-input"
             placeholder="请输入内容">

      <el-button slot="append"
                 class="nes-btn"
                 icon="el-icon-search"></el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "category",
  data: () => {
    return {
      input: ''
    }
  },
  methods: {
    writeArticle() {
      this.$router.push(`/write/${null}`);
    }
  }
}
</script>

<style scoped>

</style>
