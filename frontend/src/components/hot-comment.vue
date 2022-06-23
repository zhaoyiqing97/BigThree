<template>
  <div class="hot-comment">
    <p class="text-left title py-1 pl-3">近期热议</p>
    <div class="p-2">
      <div v-for="(item,index) in hotList"
           :key="index">
        <div class="flex justify-between">
          <span class="truncate hot-title text-left">{{ item.title }}</span>
          <div class="flex">
            <img alt=""
                 height="20"
                 src="../assets/comment.svg"
                 width="20">
            <span>{{ item.commentNum }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "hot-comment",
  data() {
    return {
      hotList: [
        {
          title: "使用 layui 秒搭后台大布局（基本结)使用 layui 秒搭后台大布局（基本结)使用 layui 秒搭后台大布局（基本结)",
          commentNum: 159,
        },
        {
          title: "使用 layui 秒搭后台大布局（基本结)",
          commentNum: 159,
        },
        {
          title: "使用 layui 秒搭后台大布局（基本结)",
          commentNum: 159,
        },
        {
          title: "使用 layui 秒搭后台大布局（基本结)",
          commentNum: 159,
        }
      ]
    }
  }
}
</script>

<style scoped>
.hot-comment {
  background: white;
}

.title {
  background-color: #f8f8f8;
}

.hot-title {
  width: 80%;
}
</style>
