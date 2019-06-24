<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>主页面</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="css/mian.css">
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
    <div class="layui-fluid div-box">
        <div class=" head-div layui-col-space20" id="top">
            <div class="layui-col-md2 logo">
                <img class="layui-col-md10" src="image/log.png">
            </div>
            <div class="layui-col-md8">
                <ul class="layui-nav" lay-filter="">
                    <li class="layui-nav-item layui-this"><a class="a-nav" href="home.jsp">首页</a></li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">成绩查看</a>
                        <dl class="layui-nav-child">
                            <!-- 二级菜单 -->
                            <dd><a class="a-nav" href="getproject.action?op=project">项目成绩</a></dd>
                            <dd><a class="a-nav" href="getcollege.action?op=college">学院成绩</a></dd>
                            <dd><a class="a-nav" href="getcollege.action?op=major">专业成绩</a></dd>
                            <dd><a class="a-nav" href="getcollege.action?op=class">班级成绩</a></dd>
                            <dd><a class="a-nav" href="getcollege.action?op=single">个人成绩</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">比赛报名</a>
                        <dl class="layui-nav-child">
                            <!-- 二级菜单 -->
                            <dd><a class="a-nav" href="projectSignUp.jsp">比赛项目查看</a></dd>
                            <dd><a class="a-nav" href="arrangeview.action?op=list">比赛时间安排</a></dd>
                            <dd><a class="a-nav" href="getproject.action?op=getproject">比赛场次查看</a></dd>
                            <dd><a class="a-nav" href="myproject.action?userid=${loginuser.userid}">查看我的项目</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-col-md2">
                <ul class="layui-nav" lay-filter="">
                    <li class="layui-nav-item">
                        <a href="javascript:;">你好：${loginuser.username }</a>
                        <dl class="layui-nav-child">
                            <!-- 二级菜单 -->
                            <dd><a class="a-nav" href="changePwd.jsp">修改密码</a></dd>
                            <dd><a href="logout.action">退出登陆</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
        <!--导航栏结束-->
        <div class="layui-row" id="main">
            <article class="">
                <iframe id="iframe" style="margin-top: 20px;" frameborder="0" scrolling="auto" src="home.jsp" width="100%"></iframe>
            </article>
        </div>
    </div>

</body>
<script src="js/jquery-2.1.1.min.js"></script>
<script src="layui/layui.js" charset="utf-8"></script>

<script src="js/main.js" charset="utf-8"></script>
<script>
    layui.use(['element', 'carousel'], function() {
        var element = layui.element;
        var carousel = layui.carousel;
        //轮播
        carousel.render({
            elem: '#lb',
            width: '100%' //设置容器宽度
                ,
            height: 600,
            arrow: 'always' //始终显示箭头
                //,anim: 'updown' //切换动画方式
        });
    });
</script>

</html>