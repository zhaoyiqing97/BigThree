<template>
  <div class="article-info p-5 flex flex-col">
    <p class="text-left py-3">
      <label for="title">title</label>
      <input id="title"
             v-model="title"
             class="nes-input"
             disabled>
    </p>
    <p class="text-left py-3">
      <label for="author">author</label>
      <input id="author"
             v-model="author"
             class="nes-input"
             disabled>
    </p>
    <div class="border-solid"
         style="min-height: 50vh">
      <editor
          v-model="editorDataHtml"
          :init="editorInit"
          api-key="no-api-key"
          disabled
          output-format="html"
      />
    </div>
    <p>category</p>
    <div class="flex justify-center my-5">
      <input v-model="categoryValue"
             class="nes-input"
             disabled>
    </div>
    <div class="my-5">
      <label for="pay_select">pay</label>
      <input id="pay_select"
             v-model="payValue"
             class="nes-input"
             disabled>
    </div>
  </div>
</template>

<script>
// 引入组件
import Editor from '@tinymce/tinymce-vue'
import tinymce from 'tinymce/tinymce'
import 'tinymce/icons/default/icons' // 解决了icons.js 报错Unexpected token '<'
// 引入富文本编辑器主题的js和css
import 'tinymce/themes/silver/theme.min.js'
import 'tinymce/skins/ui/oxide/skin.min.css'
// 扩展插件
import 'tinymce/plugins/link'
import 'tinymce/plugins/lists'
import 'tinymce/plugins/image'
import 'tinymce/plugins/code'
import 'tinymce/plugins/table'
import 'tinymce/plugins/wordcount'
import {articleGet} from "@/request/article";

export default {
  name: "article-info",
  props: ['id'],
  components: {
    'editor': Editor
  },
  data: () => {
    return {
      editorInit: {
        height: 600,
        max_height: 600,
        min_height: 600,

        plugins: 'link lists image code table wordcount', // 用到的插件：链接、列表、图片、代码块、表格、字数
        toolbar: false,
        fontsize_formats: '12px 14px 16px 18px 24px 36px 48px 56px 72px',

        // 工具栏
        images_upload_base_path: 'http://xxxx.com', // 上传图片基础路径
        images_upload_url: '/api/', // 上传图片地址
        statusbar: true, // 底部的状态栏
        menubar: false, // 最上方的菜单
        branding: false, // 水印“Powered by TinyMCE”
      },
      title: 'title',
      author: 'author',
      editorDataHtml: '',
      categoryValue: null,
      payValue: 0
    }
  },
  methods: {},
  async created() {
    console.log(this.id, 'this.id');
    const res = await articleGet(this.id);
    console.log(res);
    this.title = res.data.title;
    this.editorDataHtml = res.data.htmlContent;
    this.categoryValue = res.data.typeName;
    this.payValue = res.data.payKiss;
    this.author = res.data.authorName;
  },
  mounted() {
    tinymce.init({readonly: 1});
  }

}
</script>

<style scoped>

</style>
