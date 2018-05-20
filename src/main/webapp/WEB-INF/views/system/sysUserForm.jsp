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
<form class="layui-form" action="" lay-filter="example">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">昵称<span style="color:red"> *</span></label>
            <div class="layui-input-inline">
                <input type="text" name="userName" placeholder="请输入昵称" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">手机<span style="color:red"> *</span></label>
            <div class="layui-input-inline">
                <input type="tel" name="phone" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">生日<span style="color:red"> *</span></label>
            <div class="layui-input-inline">
                <input type="text" name="userBirthday" id="userBirthday" lay-verify="required" placeholder="请输入生日"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">邮箱<span style="color:red"> *</span></label>
            <div class="layui-input-inline">
                <input type="text" name="userEmail" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别<span style="color:red"> *</span></label>
        <div class="layui-input-block">
            <input type="radio" name="userSex" value="男" title="男" checked="">
            <input type="radio" name="userSex" value="女" title="女">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">座右铭<span style="color:red"> *</span></label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="userMotto"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="submit">提交</button>
        </div>
    </div>
</form>
<script src="<%=request.getContextPath()%>/static/lib/layui/layui.all.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/vue/vue.js-v2.5.16.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/vue/axios-v0.18.0.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#userBirthday'
        });
        //监听提交
        form.on('submit(submit)', function (data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            axios({
                method: 'post',
                url: 'insert.do',
                dataType: 'json',
                headers: {'Content-type': 'application/json;charset=UTF-8'},
                contentType: "application/json",
                data: JSON.stringify(data.field)
            }).then(function (response) {
                /*  alert(response.data);*/
            }).catch(function (error) {
                /* alert(error);*/
            });
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            window.parent.location.reload();
        });
        //表单初始赋值
        form.val('example', {
            "userName": "贤心" // "name": "value"
            , "password": "123456"
            , "interest": 1
            , "like[write]": true //复选框选中状态
            , "close": true //开关状态
            , "sex": "女"
            , "desc": "我爱 layui"
        })
    });
</script>
</body>
</html>