<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<body layadmin-themealias="default">
    <div class="layui-fluid">
    
        <div class="layui-row layui-col-space15">
        	<div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">文件上传</div>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn" id="test1">
								  <i class="layui-icon">&#xe67c;</i>上传图片
								</button>
                        </div>
                    </div>
                </div>
            </div>
            
             <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">拖拽上传</div>
                    <div class="layui-card-body">
                        <div class="layui-upload-drag" id="test-upload-drag">
                            <i class="layui-icon"></i>
                            <p>点击上传，或将文件拖拽到此处</p>
                        </div><input class="layui-upload-file" type="file" accept="undefined" name="file">
                    </div>
                </div>
            </div>
            
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">选完文件后不自动上传</div>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn layui-btn-normal"
                                id="test-upload-change">选择文件</button><input class="layui-upload-file" type="file"
                                accept="undefined" name="file"><span
                                class="layui-inline layui-upload-choose"></span>
                            <button type="button" class="layui-btn" id="test-upload-change-action">开始上传</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">高级应用：制作一个多文件列表</div>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn layui-btn-normal"
                                id="test-upload-testList">选择多文件</button><input class="layui-upload-file" type="file"
                                accept="undefined" name="file" multiple="">
                            <div class="layui-upload-list">
                                <table class="layui-table">
                                    <thead>
                                        <tr>
                                            <th>文件名</th>
                                            <th>大小</th>
                                            <th>状态</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="test-upload-demoList"></tbody>
                                </table>
                            </div>
                            <button type="button" class="layui-btn" id="test-upload-testListAction">开始上传</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <script src="../layui/layui.js"></script>
	<script>
        layui.config({
            base: '../' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'upload'], function () {
            var $ = layui.jquery
                , upload = layui.upload;

			 //执行实例
		  var uploadInst = upload.render({
		    elem: '#test1' //绑定元素
		    ,url: '../upload' //上传接口
		    ,done: function(res){
		      //上传完毕回调
			      layer.alert('文件上传成功！路劲在D盘photo',{icon:1});
		    }
		    ,error: function(){
		      //请求异常回调
		    	layer.alert('文件上传失败！',{icon:2});
		    }
		  });
			
            //选完文件后不自动上传
            upload.render({
                elem: '#test-upload-change'
                , url: '../upload'
                , auto: false
                //,multiple: true
                , done: function (res) {
                    console.log(res)
                }
            });
            
            //拖拽上传
            upload.render({
                elem: '#test-upload-drag'
                , url: '../upload'
                , done: function (res) {
                	layer.alert('文件上传成功！路劲在D盘photo',{icon:1});           
                }
            });

            //多文件列表示例
            var demoListView = $('#test-upload-demoList')
                , uploadListIns = upload.render({
                    elem: '#test-upload-testList'
                    , url: '/upload/'
                    , accept: 'file'
                    , multiple: true
                    , auto: false
                    , bindAction: '#test-upload-testListAction'
                    , choose: function (obj) {
                        var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                        //读取本地文件
                        obj.preview(function (index, file, result) {
                            var tr = $(['<tr id="upload-' + index + '">'
                                , '<td>' + file.name + '</td>'
                                , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                                , '<td>等待上传</td>'
                                , '<td>'
                                , '<button class="layui-btn layui-btn-mini test-upload-demo-reload layui-hide">重传</button>'
                                , '<button class="layui-btn layui-btn-mini layui-btn-danger test-upload-demo-delete">删除</button>'
                                , '</td>'
                                , '</tr>'].join(''));

                            //单个重传
                            tr.find('.test-upload-demo-reload').on('click', function () {
                                obj.upload(index, file);
                            });

                            //删除
                            tr.find('.test-upload-demo-delete').on('click', function () {
                                delete files[index]; //删除对应的文件
                                tr.remove();
                                uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                            });

                            demoListView.append(tr);
                        });
                    }
                    , done: function (res, index, upload) {
                        if (res.code == 0) { //上传成功
                            var tr = demoListView.find('tr#upload-' + index)
                                , tds = tr.children();
                            tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                            tds.eq(3).html(''); //清空操作
                            return delete this.files[index]; //删除文件队列已经上传成功的文件
                        }
                        this.error(index, upload);
                    }
                    , error: function (index, upload) {
                        var tr = demoListView.find('tr#upload-' + index)
                            , tds = tr.children();
                        tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                        tds.eq(3).find('.test-upload-demo-reload').removeClass('layui-hide'); //显示重传
                    }
                });
        });
    </script>
    <style id="LAY_layadmin_theme">
        .layui-side-menu,
        .layadmin-pagetabs .layui-tab-title li:after,
        .layadmin-pagetabs .layui-tab-title li.layui-this:after,
        .layui-layer-admin .layui-layer-title,
        .layadmin-side-shrink .layui-side-menu .layui-nav>.layui-nav-item>.layui-nav-child {
            background-color: #20222A !important;
        }

        .layui-nav-tree .layui-this,
        .layui-nav-tree .layui-this>a,
        .layui-nav-tree .layui-nav-child dd.layui-this,
        .layui-nav-tree .layui-nav-child dd.layui-this a {
            background-color: #009688 !important;
        }

        .layui-layout-admin .layui-logo {
            background-color: #20222A !important;
        }
    </style>
    <div class="layui-layer-move"></div>
</body>
</html>