<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/16
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/lib/layui/css/layui.css" media="all">
</head>
<body>

<div id="user">
    <a href="/sysUser/init.do" class="layui-btn layui-btn-primary">跳转至用户页面</a>
    <button class="layui-btn" @click="delUser">删除按钮</button>
    <button class="layui-btn layui-btn-normal" @click="updUser">修改按钮</button>
    <button class="layui-btn layui-btn-warm" @click="selUser">查询按钮</button>
</div>

<script src="<%=request.getContextPath()%>/static/lib/layui/layui.all.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/vue/vue.js-v2.5.16.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/vue/axios-v0.18.0.js"></script>
<script>
    var vm = new Vue({
        el: "#user",
        data: {
            userId: "",
            userName: "",
            passWord: "",
            userMobile: "",
            userEmail: "",
            userStatus: ""
        },
        methods: {
            gotoSysUserList(){
                axios.get('/sysUser/init.do').then(function(response){
                    console.log(response);//请求正确时执行的代码
                }).catch(function (response){
                    console.log(response);//发生错误时执行的代码
                });
            },
            delUser(){
                alert(2)
            },
            updUser(){
                alert(3)
            },
            selUser() {
                alert(4);
                axios.post('sysUser/list.do', {
                    userName: 'userName',
                    userMobile: 'userMobile',
                    userEmail:"userEmail"

                })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        }

    });

</script>
</body>
</html>
