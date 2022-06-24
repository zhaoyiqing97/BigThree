<template>
  <div class="category">
    <div class="flex justify-between">
      <div>
        <el-button-group>
          <el-button>全部</el-button>
          <el-button>未结帖</el-button>
          <el-button>已采纳</el-button>
          <el-button>精贴</el-button>
          <el-button>我的贴</el-button>
        </el-button-group>
      </div>
      <div>
        <el-input v-model="input"
                  placeholder="请输入内容">+
          <el-button slot="append"
                     icon="el-icon-search"></el-button>
        </el-input>
      </div>
      <div>
        <el-button type="success"
                   @click="writeArticle">发布问题
        </el-button>
      </div>
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
