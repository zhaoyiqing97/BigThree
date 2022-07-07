<template>
  <div class="top">
    <p class="text-left title py-1 pl-3">month most answer</p>
    <div class=" grid grid-cols-4 gap-4 p-4 user-grid">
      <div v-for="(item,index) in topList"
           :key="index">
        <img
            alt=""
            height="100%"
            src="../assets/default.jpeg"
            style="image-rendering: pixelated;"
            width="100%">
        <div class="user-name">{{ item.name }}</div>
        <span class="user-comment">{{ item.commentNum }}</span>
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
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 234,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
        },
        {
          name: "纸飞机",
          commentNum: 159,
          img: '../assets/default.jpeg'
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

.user-grid {
  background: white;
}

.user-name {
  position: relative;
  top: -20px;

  width: 100%;
  color: white;
  height: 20px;
  line-height: 20px;
  text-align: center;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 12px;
  background-color: rgba(0, 0, 0, .2);
}
</style>
