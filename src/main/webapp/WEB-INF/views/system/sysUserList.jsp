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

<div id="app">
    <button class="layui-btn layui-btn-primary" @click="gotoAddForm(-1)">增加按钮</button>
    <button class="layui-btn" @click="delUser">删除按钮</button>
    <button class="layui-btn layui-btn-warm" @click="selUser">查询按钮</button>
    <table class="layui-table" lay-skin="line">
        <thead>
        <tr>
            <th>序号</th>
            <th hidden>id</th>
            <th>昵称</th>
            <th>加入时间</th>
            <th>签名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(item, index) in dataList">
            <td>{{index+1}}</td>
            <td hidden>{{item.userId}}</td>
            <td>{{item.userName}}</td>
            <td>{{item.userMobile}}</td>
            <td>{{item.userEmail}}</td>
            <td>
            <button class="layui-btn layui-btn-normal" @click="gotoUpdateForm(item.userId)">编辑</button>
                <button>删除</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div id="page"></div>
<script src="<%=request.getContextPath()%>/static/lib/layui/layui.all.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/vue/vue.js-v2.5.16.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/vue/axios-v0.18.0.js"></script>
<script>
    var vm = new Vue({
        el: "#app",
        data: {
            userName: "",
            userId:"",
            dataList: [] /*[{"createTime":"2018年5月16日15:19:42","createUserId":"1","passWord":"845376854","roleIdList":null,"userEmail":"1345528755@qq.com","userId":"1","userMobile":"13298899809","userName":"爱丽丝、如歌","userStatus":1},{"createTime":null,"createUserId":null,"passWord":null,"roleIdList":null,"userEmail":null,"userId":"2","userMobile":null,"userName":"小鸭梨","userStatus":null}]*/
        },
        mounted() {
            this.selUser()
        },
        methods: {
            gotoAddForm(userId){
                layer.open({
                    //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                    type: 2,
                    title: "添加员工",
                    skin: "myclass",
                    area: [800,600],
                    content: 'form.do?userId='+userId
                });
            },
            gotoUpdateForm(userId){
                layer.open({
                    //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                    type: 2,
                    title: "修改员工",
                    skin: "myclass",
                    area: [800,600],
                    content: 'form.do?userId='+userId
                });
            },
            delUser() {
                alert(2)
            },
            updUser() {
                alert(3)
            },
            selUser() {
                var that = this;
                layui.use('laypage', function () {
                    var laypage = layui.laypage;
                    //完整功能
                    laypage.render({
                        elem: 'page'
                        , count: 100
                        , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                        , jump: function (e) {
                            axios.get('/sysUser/list.do', {
                                headers: {'Content-Type': 'text/x-www-form-urlencoded'},
                                params: {
                                    curr: e.curr,
                                    limit: e.limit
                                }
                            }).then(function (response) {
                                that.dataList = response.data.dataList;
                                console.log(that.dataList);
                            }).catch(function (response) {
                                console.log(response);//发生错误时执行的代码
                            });
                        }
                    });
                });
            }
        }
    });
</script>
</body>
</html>
