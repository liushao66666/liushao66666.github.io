<template>
  <div class="wrapper">

    <div
      style=" background-color: #fff; width:450px; height:450px;padding: 50px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);">

      <div style="height: 60px; line-height: 60px; text-align: center;margin-top: 10px;margin-bottom: 30px">
        <b style="color: #303133; font-size: 36px">
          人力资源管理系统
        </b>
      </div>
      <el-form :rules="rules" :model="staff" ref="loginForm">
        <el-form-item prop="code">
          <el-input size="medium" placeholder="请输入账号" style="margin: 10px 0;" prefix-icon="el-icon-user"
                    v-model.trim="staff.code"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input size="medium" placeholder="请输入密码" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password
                    v-model.trim="staff.password"></el-input>
        </el-form-item>
        <div style="margin: 20px 0; text-align: center">
          <el-form-item>
            <el-button type="primary" size="medium" style="width:100%;height: 40px;margin-top: 20px;font-size: 25px;text-align: center;line-height: 20px" @click="handleLogin">登 录</el-button>
          </el-form-item>
        </div>
      </el-form>
    </div>

  </div>
</template>
<script>
import { login } from '../../api/login'

export default {
  name: 'Login',
  data () {
    return {
      staff: {},
      // 效验规则
      rules: {
        code: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在3到10个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在3到10个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleLogin () {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          login(this.staff).then(
            response => {
              if (response.code === 200) {
                this.$store.commit('staff/SET_STAFF', response.data) // 存储用户信息
                this.$store.commit('token/SET_TOKEN', response.token) // 存储token
                this.$message.success('登录成功！')
                this.$router.push({
                  path: '/home'
                })
              } else {
                this.$message.error(response.message)
              }
            }
          )
        } else {
          return false
        }
      })
    }
  }
}
</script>
<style>
.wrapper {

  width:100%;
  height:100%;
  background-image: url("../../assets/bg3.jpg");
  background-size: 100% 100%;
  background-repeat: no-repeat;

}
</style>
