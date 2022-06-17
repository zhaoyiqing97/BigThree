<template>
  <div class="article-item">
    <div class=" pb-1 flex justify-between items-end">
      <div class="flex items-end">
        <el-avatar class="mr-1"
                   icon="el-icon-user-solid"></el-avatar>
        <div>
          <div>
            <h2 class="text-left">{{ item.title }}</h2>
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

</style>
