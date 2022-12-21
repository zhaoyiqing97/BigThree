<template>
  <div class="login">
    <el-tabs v-model="activeName"
             type="card"
             @tab-click="handleClick">
      <el-tab-pane label="login"
                   name="login">
        <div class="w-3/12 text-left">
          <div class="py-5">
            <label for="name_field">Email</label>
            <el-input id="name_field"
                      v-model="username"
                      type="email"/>
          </div>
          <div class="py-5">
            <label for="name_field">Password</label>
            <el-input id="name_field"
                      v-model="password"
                      show-password/>
          </div>
          <button class="nes-btn is-success"
                  type="button"
                  @click="login()">Login
          </button>
        </div>
      </el-tab-pane>
      <el-tab-pane label="register"
                   name="register">register
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import {doLogin} from "@/request/user";

export default {
  name: "login",
  data: () => {
    return {
      username: '',
      password: '',
      activeName: "login"
    }
  },
  methods: {
    handleClick() {

    },
    login() {
      doLogin(this.username, this.password).then(() => {
        this.$router.push(`/index`);
      })
    }
  }
}
</script>

<style scoped>
.login {
  min-height: 75vh;
}
</style>
