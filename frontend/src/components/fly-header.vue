<template>
  <div class="fly-header">
    <div class="h-16 bg-gray-800 flex justify-between">
      <div id="rY"
           class="h-full ml-80 p-1"
           @click="go('/index')">
        <i class="nes-icon is-medium heart"></i>
      </div>
      <div class="h-full flex justify-around items-end">
        <div class="h-full flex items-center">
          <i class="nes-icon trophy is-medium"></i>
          <a class="text-white"
             href="#">Q&A</a>
        </div>
        <div class="h-full flex items-center">
          <i class="nes-icon coin is-medium"></i>
          <a class="text-white"
             href="#">VIP</a>
        </div>
      </div>
      <div class="h-full mr-80 flex justify-center items-center">
        <div class="mx-1">
          <img alt=""
               class="nes-avatar"
               style="image-rendering: pixelated;"
               src="../assets/default.jpeg">
        </div>
        <el-button class="text-white mx-1 nes-btn is-primary"
                   @click="go('/login')">login
        </el-button>
        <el-button class="text-white mx-1 nes-btn is-success">register</el-button>
        <i class="nes-icon twitter is-medium mx-2"></i>
        <i class="nes-icon facebook is-medium mx-2"></i>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "fly-header",
  methods: {
    go(path) {
      this.$router.push(path);
    }
  }
}
</script>

<style scoped>
@keyframes turnY {

  0% {
    transform: rotateY(0deg);
  }

  100% {
    transform: rotateY(360deg);
  }

}


#rY:hover {

  animation-name: turnY;

  animation-duration: 3s;

  animation-iteration-count: 1;

}
</style>
