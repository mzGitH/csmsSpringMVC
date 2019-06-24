layui.define(['jquery', 'form', 'layer', 'element'], function(exports) {
	var $ = layui.jquery,
		form = layui.form,
		layer = layui.layer,
		element = layui.element;
	var menu = [];
	var curMenu;
	
	//�˵���Ϣ����,��¼�û���Ϣ����
	$.ajax({
		type : 'get',
		url : "../systemmodel/getsystemmodelbyrole",
		async:false, 
		datatype : 'json',
		success : function(menudata) {
			//����menu��json����
			if(menudata.code==0){
				//$("#userrole").text(menudata.loginuser[0].name);
				var menu = "";
				for (var i = 0; i < menudata.data.length; i++) {
					if (menudata.data[i].parentid == 0 && menudata.data[i].deepth==1 && menudata.data[i].isedit==true) {		// ��ѯ���и���˵�
						menu += "<li>"
						menu +="<a href='javascript:;'><i class='layui-icon' style='font-size:18px'>"+menudata.data[i].imageurl+"</i>"
						menu += "<cite>"+ menudata.data[i].chinesename +"<cite>"
						menu +="<i class='iconfont nav_right'>&#xe697;</i></a>"
						menu +="<ul class='sub-menu'>"
						for (var j = 0; j < menudata.data.length; j++) {
							if (menudata.data[j].parentid == menudata.data[i].sysid) {// �жϸ���˵��µ�����˵�
								menu += "<li>"
								menu += "<a _href="+menudata.data[j].navurl+"><i class='iconfont'>&#xe6a7;" +
										"</i><cite>"+menudata.data[j].chinesename+"</cite></a>"
								menu += "</li>"
							}
						}
						menu +="</ul>"
						menu += "</li>"
					}
				}
				$("#nav").html(menu);
				var element = layui.element;
			}
		},
		error : function() {}
	});
	
	//��ർ���˵�����ʾ������
	$('.container .left_open i').click(function(event) {
		if($('.left-nav').css('left') == '0px') {
			//�˴����˵�����ʾ״̬���������
			$('.left-nav').animate({
				left: '-221px'
			}, 100);
			$('.page-content').animate({
				left: '0px'
			}, 100);
			$('.page-content-bg').hide();
		} else {
			//�˴����˵�������״̬�������ʾ
			$('.left-nav').animate({
				left: '0px'
			}, 100);
			$('.page-content').animate({
				left: '200px'
			}, 100);
			//�����ʾ���ж���Ļ��Ƚ�Сʱ��ʾ���ֱ���
			if($(window).width() < 768) {
				$('.page-content-bg').show();
			}
		}
	});
	
	/*�˳�ϵͳ*/
	$("#loginout").click(function(){
		$.ajax({
			type: 'get',
			url: '../sysadminusermanager/logoutsystem',
			datatype: 'json',
			success: function(data) {
				if(data.code=="10001"){
					window.location.href = "../html/login.jsp";
				}else{
					layer.msg(data.msg,{icon:2});
				}
			},
			error: function() {}
		});
	});
	
	/*�����޸�*/
	$("#ddpersonalmsg").click(function(){
		var title = $(this).html();
		var url ="../html/personMessage.jsp";
		changeURL(url,title);
	});

	
	/*�����޸�*/
	$("#changepwd").click(function(){
		var title = $(this).html();
		var url ="../html/changePwd.jsp";
		changeURL(url,title);
	});

	//������Ӽ���չ����û�оʹ�frame
	$('.left-nav #nav li').click(function(event) {
		if($(this).children('.sub-menu').length) {
			if($(this).hasClass('open')) {
				$(this).removeClass('open');
				$(this).find('.nav_right').html('&#xe697;');
				$(this).children('.sub-menu').stop().slideUp();
				$(this).siblings().children('.sub-menu').slideUp();
			} else {
				$(this).addClass('open');
				$(this).children('a').find('.nav_right').html('&#xe6a6;');
				$(this).children('.sub-menu').stop().slideDown();
				$(this).siblings().children('.sub-menu').stop().slideUp();
				$(this).siblings().find('.nav_right').html('&#xe697;');
				$(this).siblings().removeClass('open');
			}
		} else {
			$(this).children().addClass("navacolor");
			$(this).siblings().children().removeClass("navacolor");
			var url = $(this).children('a').attr('_href');
			var title = $(this).find('cite').html();
			changeURL(url,title);
		}
		event.stopPropagation();
	});
	
	//�����ߵ�����ҳ����ת
	function changeURL(url,title){
		$("#ifram1").attr("src", url);
		$("#liformtitle").text(title);
	}

	//@todo ���¼���iframe�߶�
	function FrameWH() {
		var h = $(window).height() - 80;
		$("iframe").css("height", h + "px");
	}
	$(window).resize(function() {
		FrameWH();
	});
});
