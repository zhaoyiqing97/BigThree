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
      <vue-editor v-model="editorData"/>
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
import {VueEditor} from "vue2-editor";
import {articleType, pushArticle} from "@/request/article";

export default {
  name: "write-article",
  props: ['id'],
  components: {
    VueEditor
  },
  data() {
    return {
      title: 'title',
      editorData: '<p>Content of the editor.</p>',
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
      const data = {
        title: this.title,
        typeId: this.categoryValue,
        payKiss: this.payValue,
        isDone: 0,
        markdownContent: '',
        htmlContent: this.editorData
      }
      const res = await pushArticle(data);
      console.log(res);
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
