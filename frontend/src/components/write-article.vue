<template>
  <div class="write-article p-5 flex flex-col">
    <p class="text-left title py-1 pl-3">发表问题</p>
    <p class="text-left py-3">
      <el-input>
        <template slot="prepend">标题</template>
      </el-input>
    </p>
    <div class="border-solid"
         style="min-height: 50vh">
      <vue-editor v-model="editorData"/>
    </div>
    <div class="flex">
      <div>
        <span>所在类别</span>
        <el-select v-model="categoryValue"
                   placeholder="请选择">
          <el-option
              v-for="item in categoryOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </div>
      <div>
        <label>悬赏飞吻</label>
        <el-select v-model="payValue"
                   placeholder="请选择">
          <el-option
              v-for="item in payOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </div>
    </div>
    <div class="flex">
      <el-button type="success">立即发布</el-button>
    </div>
  </div>
</template>
<script>
import {VueEditor} from "vue2-editor";

export default {
  name: "write-article",
  props: ['id'],
  components: {
    VueEditor
  },
  data() {
    return {
      editorData: '<p>Content of the editor.</p>',
      categoryValue: '选项1',
      payValue: 0,
      categoryOptions: [{
        value: '选项1',
        label: '黄金糕'
      }, {
        value: '选项2',
        label: '双皮奶'
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }, {
        value: '选项4',
        label: '龙须面'
      }, {
        value: '选项5',
        label: '北京烤鸭'
      }],
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
    onEditorInput(input) {
      console.log(input);
    }
  },
  created() {
    if (this.id) {
      console.log(this.id, 'this.id');
    }
  }

}
</script>

<style scoped>
@import "~vue2-editor/dist/vue2-editor.css";
/* Import the Quill styles you want */
@import '~quill/dist/quill.core.css';
@import '~quill/dist/quill.bubble.css';
@import '~quill/dist/quill.snow.css';

.write-article {
  background-color: white;

}

.title {
  background-color: #f8f8f8;
  line-height: 30px;
}
</style>
