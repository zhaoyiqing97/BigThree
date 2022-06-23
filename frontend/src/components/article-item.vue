<template>
  <div class="article-item">
    <div class=" p-1 flex justify-between items-end">
      <div class="flex items-end">
        <el-avatar class="mr-1"
                   icon="el-icon-user-solid"></el-avatar>
        <div>
          <div>
            <h2 class="text-left">{{ item.title }}
              <span v-if="item.stick ===1"
                    class="fly-tip stick">置顶</span>
              <span v-if="item.cream===1"
                    class="fly-tip jing">精帖</span>
            </h2>
          </div>
          <div>
            <p>
              <span class="mr-1">{{ item.authorName }}</span>
              <span>{{ item.releaseTime }}</span>
            </p>
          </div>
        </div>
      </div>
      <div class="flex">
        <div class="flex">
          <img alt=""
               height="20"
               src="../assets/comment.svg"
               width="20">
          <span>{{ item.commentNum }}</span>
        </div>
        <div class="flex">
          <img alt=""
               height="20"
               src="../assets/views.svg"
               width="20">
          <span>{{ item.visitNum }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "article-item",
  props: ['item']
}
</script>

<style scoped>
.stick {
  background-color: #393D49;
}

.fly-tip {
  color: #fff;
  font-size: 12px;
  height: 20px;
  line-height: 20px;
  padding: 5px;
  text-align: center;
  margin-left: 5px;
  vertical-align: top;
}

.jing {
  background-color: #c00;
}
</style>
