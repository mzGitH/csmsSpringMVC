<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文章内容</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
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
<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <div class="layui-card-header">
			<div class="layui-row">
			<span class="layui-breadcrumb">
					<a href="home.jsp">首页</a>
					<a href="forumList.jsp">文章列表</a>
				<a><cite>文章内容</cite></a></span>
				</div>
				<div class="layui-row text-center">
				</div>
			</div>
        </div>
        <div class="layui-card-body">
            <div id="content">
            <table width="80%" style="font-size:16px; margin-bottom:15px;">
            	<tr>
                	<td id = "articletopic" ><b style="font-size:19px;">标题：</b>${forum.title }</td>
                    <td id = "articlereview"><b style="font-size:19px;">作者：</b>${forum.author }  |  </td>
                    <td id = "articlecreate"><b style="font-size:19px;">时间：</b></h3>${forum.createtime }</td>
                </tr>
            </table>
                <c:forEach items="${listcontent }" var="content">
                    <div class="layui-row" style="text-align:center;">
                        <div><img src="${content.picpath }" width="80%"></div>
                    </div>
                    <div class="layui-row" style="width:80%;margin:auto;">
                        <div style="padding:30px 0;font-size:20px;margin:auto 0;">${content.textcontent }</div>
                    </div>
                 </c:forEach>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form', 'element' ],function() {
		var form = layui.form;
		var element = layui.element;
	});
</script>
</html>