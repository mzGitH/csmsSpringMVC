/**
 * ajax调用方法
 * @param {Object} reqType 请求的类型（get，post）
 * @param {Object} reqURL 要请求的路径
 * @param {Object} reqPara 要传递的参数列表，如{ op: 1, key: 2 }
 * @return {Object} returndata 查询结果
 */
function callAJAX(reqType, reqURL, reqPara) {
	var returndata = '';
	$.ajax({
		type: reqType,
		url: reqURL,
		datatype: 'json',
		async: false,//不做异步刷新，解决执行顺讯问题
		data: reqPara,
		success: function(data) {
			returndata = data;
		},
		error: function() {
			returndata = '';
		}
	});
	return returndata;
}

/**
 * 管理员角色信息下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadAdminRole(selectId, form){
	var reqType = 'post';
	var reqURL = '../adminrole/getrole';
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara)
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择管理员角色类型</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i].id + '>' + stageData.data[i].name + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到用户角色信息！', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到用户角色信息！', function(){});
	}
	
}

/**
 * 系统日志操作类型下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadSystemOperType(selectId, form){
	var reqType = 'post';
	var reqURL = '../adminsystem/getopertype';
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择日志类型</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i] + '>' + stageData.data[i] + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到日志类型', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到日志类型！', function(){});
	}
}
