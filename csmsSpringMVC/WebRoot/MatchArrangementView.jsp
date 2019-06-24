<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>比赛安排</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style type="text/css">
	body {
    background-color: rgb(209, 207, 207);
    overflow: hidden;
      overflow-y: scroll;
    
}

body::-webkit-scrollbar {
        display: none;
    }
</style>
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>比赛安排</h2>
        </div>
        <div class="layui-card-body">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="password" name="password" required lay-verify="required" placeholder="请输入查询条件"
                        autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="margin-left: -10px;">
                    <button type="button" class="layui-btn layui-btn">查询</button>
                </div>
            </div>
            <table class="layui-table">
                <colgroup>
                    <col width="70">
                    <col width="200">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                </colgroup>
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>项目名称</th>
                        <th>场次</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>比赛地点</th>
                        <th>比赛级别</th>
                        <th>比赛状态</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>1000米</td>
                        <td>第一次</td>
                        <td>2019-5-20 9:00</td>
                        <td>2019-5-20 9:20</td>
                        <td>田径场</td>
                        <td>半决赛</td>
                        <td>未比赛</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>

</html>