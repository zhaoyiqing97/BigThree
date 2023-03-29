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
                    class="fly-tip stick">top</span>
              <span v-if="item.cream===1"
                    class="fly-tip jing">cream</span>
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
      <div class="flex items-center">
        <i class="nes-icon coin is-small"></i>
        <span class="mx-1">{{ item.commentNum }}</span>
        <i class="nes-icon like is-small"></i>
        <span class="mx-1">{{ item.visitNum | visitNum }}</span>
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
