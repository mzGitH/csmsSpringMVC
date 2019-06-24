<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="layui/css/layui.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  	<form action="getscore.action">
  		<button type="submit">获取表格</button>
  	</form>
    <table class="layui-table" id="forumlist" lay-filter="test" width="100%"></table>
  </body>
  <script src="layui/layui.all.js"></script>
  <script id="barDemo" type="text/html">
    <button class="layui-btn  layui-btn-sm layui-bg-green">查看详情</button>
</script>
<script type="text/javascript">
    layui.use(['table', 'laydate', 'form', 'jquery'], function() {
        var table = layui.table;
        var $ = layui.jquery;
        var laydate = layui.laydate;
        var form = layui.form;

        table.render({
            elem: '#scoretable',
            height: '800px', //高度最大化减去差值,
            url: 'getscore.action',
            page: true //开启分页
                ,
            even: true //每行颜色分隔
                ,
                limit:5,
                limits:[5,10,15],
            skin: "nob",
            cellMinWidth: 35 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                //,toolbar: '#toolbarDemo'
                ,
            title: '用户数据表',
            cols: [
                [{
                    field: '',
                    width: 40,
                    title: '序号',
                    type:'numbers'
                }, {
                    field: 'collegename',
                    width: 250,
                    title: '学院名称',
                }, {
                    field: 'majorname',
                    width: 250,
                    title: '专业名称',
                }, {
                    field: 'classname',
                    title: '班级名称',
                    width: 250,
                },{
                    fixed: 'scorenumber',
                    title: '班级成绩',
                    width: 100
                },
                 {
                    fixed: '',
                    title: '操作',
                    toolbar: '#barDemo',
                    width: 120
                }]
            ]
        });

        //监听工具条
        table.on('tool(test)', function(obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function(index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });
    });
</script>
</html>
