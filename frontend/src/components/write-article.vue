<template>
  <div class="write-article p-5 flex flex-col">
    <p class="text-left title py-1 pl-3 nes-text is-primary">Ask Question</p>
    <p class="text-left py-3">
      <label for="title">title</label>
      <input id="title"
             v-model="title"
             class="nes-input">
    </p>
    <div class="border-solid"
         style="min-height: 50vh">
      <editor
          v-model="editorDataHtml"
          :init="editorInit"
          api-key="no-api-key"
          output-format="html"
      />
    </div>
    <p>category</p>
    <div class="flex justify-center my-5">
      <div v-for="item in categoryOptions"
           :key="item.value">
        <label>
          <input v-model="categoryValue"
                 :value="item.value"
                 class="nes-radio"
                 name="cate_select"
                 type="radio"/>
          <span>{{ item.label }}</span>
        </label>
      </div>
    </div>
    <div class="my-5">
      <label for="pay_select">pay</label>
      <div class="nes-select">
        <select id="pay_select"
                v-model="payValue">
          <option disabled
                  hidden
                  selected
                  value="">Select...
          </option>
          <option
              v-for="item in payOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </option>
        </select>
      </div>
    </div>
    <div class="flex my-5">
      <button class="nes-btn is-success is-large"
              type="button"
              @click="publishNow()">Publish Now
      </button>
    </div>
  </div>
</template>
<script>
import {articleType, articlePush} from "@/request/article";
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

export default {
  name: "write-article",
  props: ['id'],
  components: {
    'editor': Editor
  },
  data() {
    return {
      editorInit: {
        height: 500,
        max_height: 500,
        min_height: 500,

        plugins: 'link lists image code table wordcount', // 用到的插件：链接、列表、图片、代码块、表格、字数
        toolbar: 'undo redo | bold italic underline strikethrough | formatselect fontsizeselect | forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist | outdent indent blockquote | link unlink table image | removeformat',
        fontsize_formats: '12px 14px 16px 18px 24px 36px 48px 56px 72px',

        // 工具栏
        images_upload_base_path: 'http://xxxx.com', // 上传图片基础路径
        images_upload_url: '/api/', // 上传图片地址
        statusbar: true, // 底部的状态栏
        menubar: false, // 最上方的菜单
        branding: false, // 水印“Powered by TinyMCE”
      },
      title: 'title',
      editorDataHtml: '',
      categoryValue: null,
      payValue: 0,
      categoryOptions: [],
      payOptions: [
        {
          value: 0,
          label: '0'
        }, {
          value: 1,
          label: '1'
        }, {
          value: 2,
          label: '2'
        }, {
          value: 3,
          label: '3'
        }, {
          value: 4,
          label: '4'
        }
      ]
    };
  },
  methods: {
    async publishNow() {
      const text = window.tinyMCE.activeEditor.getContent({format: 'text'})
      const data = {
        title: this.title,
        typeId: this.categoryValue,
        payKiss: this.payValue,
        isDone: 0,
        markdownContent: text,
        htmlContent: this.editorDataHtml
      }
      const res = await articlePush(data);
      console.log(res);
      this.$notify({
        title: '成功',
        message: '发布成功',
        type: 'success'
      });
    }
  },
  async created() {
    if (this.id) {
      console.log(this.id, 'this.id');
    }
    const res = await articleType();
    this.categoryOptions = res.data.map(it => {
      return {label: it.typename, value: it.id}
    });
    this.categoryValue = this.categoryOptions[0].value;
  },
  mounted() {
    tinymce.init({});
  }
}
</script>

<style scoped>

.write-article {
  background-color: white;

}

.title {
  background-color: #f8f8f8;
  line-height: 30px;
}
</style>
