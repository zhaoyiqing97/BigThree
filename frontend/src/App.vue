<template>
  <div id="app">
    <el-container>
      <el-header class="p-0">
        <fly-header></fly-header>
      </el-header>
      <el-main class="mx-80">
        <router-view></router-view>
      </el-main>
      <el-divider></el-divider>
      <el-footer>
        <fly-footer></fly-footer>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import FlyFooter from "@/components/fly-footer";
import FlyHeader from "@/components/fly-header";

export default {
  name: 'App',
  components: {FlyHeader, FlyFooter},
}
</script>

<style>
#app {
  font-family: zpix-pixel-font, kongtext,serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: #eeeeee;
  color: #2c3e50;
}
</style>
