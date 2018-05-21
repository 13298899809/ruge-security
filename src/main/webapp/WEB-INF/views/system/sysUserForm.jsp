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
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/lib/layui/css/layui.css" media="all">

</head>
<body>
<form class="layui-form"  lay-filter="example">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="userName" lay-verify="required|userName" autocomplete="off" class="layui-input"
                       value="${user.userName}">
            </div>
        </div>
        <div class="layui-inline">
            <input type="text" name="userId" value="${user.userId}">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-inline">
                <input type="text" name="userMobile"  autocomplete="off" class="layui-input"
                       value="${user.userMobile}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="tel" name="userBirthday" lay-verify="userBirthday" autocomplete="off" class="layui-input"
                       id="date" value="${user.userBirthday}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="userMobile"  autocomplete="off" class="layui-input"
                       value="${user.userEmail}">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="userSex" value="男" title="男" ${user.userSex=='1'?"checked":""}>
            <input type="radio" name="userSex" value="女" title="女" ${user.userSex=='0'?"checked":""}>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">座右铭</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="userMotto">
                ${user.userMotto}
            </textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="submit">立即提交</button>
        </div>
    </div>
</form>
<script src="<%=request.getContextPath()%>/static/lib/jquery/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/layui/layui.all.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        //监听提交
        form.on('submit(submit)', function (data) {
            $.ajax({
               type:"POST",
                url:"update.do",
                headers: {'Content-type': 'application/json;charset=UTF-8'},
                contentType:"application/json",
                async: false,   //问题的关键，明确是异步提交数据
                dataType: 'json',  //请求数据类型
                data: JSON.stringify(data.field),
                success(data){
                layer.alert(data);
                },
                error(data){
                layer.alert(data);
                }
            });
            closeCurrForm();
        });
    });
    //关闭当前窗口
    function closeCurrForm(){
        //获取窗口索引
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);

    }
</script>
</body>
</html>