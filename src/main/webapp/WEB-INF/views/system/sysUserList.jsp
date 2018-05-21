<%--
  Created by IntelliJ IDEA.
  User: wujian
  Date: 2018-05-19
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/static/lib/jquery/jquery-3.3.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/lib/layui/layui.all.js"></script>
    <script src="<%=request.getContextPath()%>/static/lib/vue/vue.js-v2.5.16.js"></script>
    <script src="<%=request.getContextPath()%>/static/lib/vue/axios-v0.18.0.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/lib/layui/css/layui.css" media="all">
</head>
<body>
<div id="app" lay-filter="demo">
</div>
<script type="text/html" id="userBar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    let userContext = "";
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
        layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element; //元素操作
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.open({
                    //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                    type: 2,
                    title: "修改信息",
                    skin: "myclass",
                    area: [800, 600],
                    content: 'form.do?userId=' + data.userId
                });
            }
        });
        //执行一个 table 实例
        table.render({
            elem: '#app'
            , height: 332
            , url: '/sysUser/list.do' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'userId', title: 'ID', sort: true, fixed: 'left'},
                {field: 'userName', title: '用户名'},
                {field: 'userSex', title: '性别', sort: true},
                {fixed: 'right', align: 'center', toolbar: '#userBar'}
            ]]
        });
    });
</script>
</body>
</html>
