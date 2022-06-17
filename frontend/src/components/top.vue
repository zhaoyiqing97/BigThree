<template>
  <div class="top">
    <p class="text-left title py-1">近一月回答榜 - TOP 12</p>
    <div class=" grid grid-cols-3">
      <div v-for="(item,index) in topList"
           :key="index">
        <div :style="{backgroundImage:'url('+item.img+')'}"
             class="text-black  align-bottom text-center"
             style="width: 65px;height: 65px;">
          {{ item.name }}
        </div>
        <i class="user-comment">{{ item.commentNum }}次回答</i>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "top",
  data() {
    return {
      topList: [
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.png'
        }
      ]
    }
  }
}
</script>

<style scoped>
.top {
  background-color: white;
}

.title {
  background-color: #f8f8f8;
}
</style>
