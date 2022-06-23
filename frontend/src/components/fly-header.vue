<template>
  <div class="fly-header">
    <div class="h-16 bg-gray-800 flex justify-between">
      <div class="h-full ml-80 flex align-center">
        <img alt=""
             height="50"
             src="../assets/logo.png"
             width="200">
      </div>
      <div class="h-full flex justify-around items-end">
        <div class="h-full flex items-center">
          <img alt=""
               class="mx-2"
               height="30"
               src="../assets/question.svg"
               width="30">
          <a class="text-white"
             href="#">问答</a>
        </div>
        <div class="h-full flex items-center">
          <img alt=""
               class="mx-2"
               height="30"
               src="../assets/vip.svg"
               width="30">
          <a class="text-white"
             href="#">会员</a>
        </div>
      </div>
      <div class="h-full mr-80 flex justify-center items-center">
        <div class="mx-1">
          <el-avatar icon="el-icon-user-solid"></el-avatar>
        </div>
        <div class="text-white mx-1">登入</div>
        <div class="text-white mx-1">注册</div>
        <div class="mx-1"><img alt="" height="30" src="../assets/qq.svg" width="30"></div>
        <div class="mx-1"><img alt="" height="30" src="../assets/weibo.svg" width="30"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "fly-header"
}
</script>

<style scoped>
</style>
