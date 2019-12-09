<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.0.min.js"
	charset="utf-8"></script>
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
	layui
			.use(
					'table',
					function() {
						var table = layui.table;
						table.render({
							elem : '#test',
							url : 'cadre.do?opt=queryAll',
							toolbar : '#toolbarDemo',
							cellMinWidth : 40,
							title : '用户数据表',
							cols : [ [ {
								type : 'checkbox',
								fixed : 'left'
							}, {
								field : 'employee_id',
								title : '干部ID',
								width : 80,
								fixed : 'left',
								unresize : true,
								sort : true
							},
							
						{field : 'name',title : '姓名',align : 'center',width : 60,}, 
						{field : 'nationality',title : '国籍',align : 'center',width : 60}, 
						{field : 'cur_loca',title : '目前所在地',align : 'center',hide:true}, 
						{field : 'nation',title : '民族',align : 'center',width : 90}, 
						{field : 'loca_of_resid',title : '户口所在地',align : 'center',hide:true}, 
						{field : 'mari_status',title : '婚姻状况',align : 'center',hide:true}, 
						{field : 'heal_condi',title : '健康状况',align : 'center',hide:true},
						{field : 'age',title : '年龄',align : 'center', width : 60},
						{field : 'sex',title : '性别',align : 'center',width : 60},
						{field : 'high_edu',title : '最高学历',align : 'center',hide:true},
						{field : 'poli_lands',title : '政治面貌',align : 'center',width : 90},
						{field : 'school',title : '毕业学校',align : 'center',width : 90},
						{field : 'prof',title : '专业',align : 'center',width : 90},
						{field : 'certificate',title : '获得证书',align : 'center',hide:true},
						{field : 'work_exper',title : '当前职位',align : 'center',width : 90},
						{field : 'memb_fam',title : '家庭主要成员',align : 'center',hide:true},												
						{field : 'english',title : '英语水平',align : 'center',hide:true},
						{field : 'self_evalu',title : '自我评价',align : 'center',hide:true},
						{field : 'hobbies',title : '兴趣爱好',align : 'center',hide:true},
						{field : 'entry_time',title : '入职时间',align : 'center',width : 150},
						{field : 'leave_time',title : '状态',align : 'center',hide:true},
						{field : 'asse_status',title : '考核情况',align : 'center',hide:true},
						{field : 'viola_of_discip',title : '违纪违规情况',align : 'center',hide:true},
						{field : 'audit_status',title : '审计情况',align : 'center',hide:true},
						{field : 'departure',title : '出国情况',align : 'center',hide:true},
						{field : 'langu_ability',title : '语言',align : 'center',hide:true},
						{field : 'ks_id',title : '科室编号',align : 'center'},
						{field : 'admin_id',title : '职位编号',align : 'center'},
						{field : 'reserveposition',title : '候补职位',align : 'center',width : 90},
						{field : 'a',title : '操作',toolbar : '#barDemo',align : 'center',width : 300} ] ],
						page : {
								layout : [ 'count', 'prev', 'page', 'next',
										'limit', 'refresh', 'skip' ]
							},
							id : 'testReload'
						});
						table.on('toolbar(test)', function(obj) {
							var checkStatus = table.checkStatus(obj.config.id);
							switch (obj.event) {
							case 'getCheckData':
								active.getCheckData();
								break;
							case 'getCheckLength':
								active.reload();
								break;
							case 'isAll':
								active.notice();
								break;
							}
							;
						});
						active = {
							reload : function() {
								var name = $("#name").val();
								table.reload('testReload', {
									where : {
										name : name
									}
								});
							},
							getCheckData : function() {
								var checkStatus = table
										.checkStatus('testReload'), data = checkStatus.data;
								if (data == "") {
									layer.msg('至少也得选一个吧', {
										icon : 2
									});
									return;
								}
								var delArray = [];
								if (data.length > 0) {
									for (var i = 0; i < data.length; i++) {
										delArray.push(data[i].employee_id);
									}
								}
								var ids = delArray.join(",");
								layer.confirm('确认要删除嘛？' + delArray, function(
										index) {
									$.ajax({
										type : 'POST',
										url : 'cadre.do?opt=del',
										data : {
											'delArray' : ids
										},

									});
									layer.msg('删除成功！', {
										icon : 1
									});
									location.reload();
								});

							},

							notice : function() {
								layer.open({
									type : 2,
									title : false //不显示标题栏
									,
									closeBtn : false,
									area : [ '600px', '500px' ] //控制弹窗大小
									,
									offset : [ '20px', '300px' ] //具体位置 顶部，左侧
									,
									id : 'LAY_layuipro' //设定一个id，防止重复弹出
									,
									btn : [ '退出' ],
									btnAlign : 'c',
									moveType : 1 //拖拽模式，0或者1
									,
									content : 'addcadre.jsp',
									end : function() {
										location.reload();
									},
									success : function(layero) {
										var btn = layero
												.find('.layui-layer-btn');
										btn.find('.layui-layer-btn').attr({
											href : 'cadre.do?opt=queryAll',
											target : '_blank'

										});
									}
								});
							}

						};

						//监听行工具事件
						table.on('tool(test)', function(obj) {
							var data = obj.data;
							switch (obj.event) {
							case 'del':
								layer.confirm("确认要删除吗，删除后不能恢复",
										function(index) {
											delUser(data.employee_id);
											layer.close(index);
											location.reload();
										});
								break;
							case 'edit':
								updateUser(data.employee_id);
								break;
							case 'det':
					
								break;
							case 'add':
								addreserve(data.name,data.work_exper,data.employee_id,data.reserveposition);
								break;
								
							}
							
							;
						});
					});
	
	function addreserve(name,work_exper,employee_id,reserveposition){
		//alert(name);
		window.location.href="reserve/Addreserve.jsp?name="+name+"&work_exper="+work_exper+"&employee_id="+employee_id+"&reserveposition="+reserveposition+"";
		
	}
	function delUser(id) {
		alert(id);
		$.ajax({
			type : 'POST',
			url : 'cadre.do?opt=del&employee_id=' + id,
			success : function(msg) {
				alert("Data Saved: " + msg);
			}
		});
	}
	//修改
	function updateUser(id) {
		alert(id);
		layer.open({
			type : 2,
			title : false //不显示标题栏
			,
			closeBtn : false,
			area : [ '600px', '500px' ] //控制弹窗大小
			,
			offset : [ '20px', '300px' ] //具体位置 顶部，左侧
			,
			id : 'LAY_layuipro' //设定一个id，防止重复弹出
			,
			btn : [ '退出' ],
			btnAlign : 'c',
			moveType : 1 //拖拽模式，0或者1
			,
			content : 'cadre.do?opt=findById&employee_id=' + id,
			end : function() {
				location.reload();
			},
			success : function(layero) {
				var btn = layero.find('.layui-layer-btn');
				btn.find('.layui-layer-btn').attr({
					href : 'cadre.do?opt=queryAll',
					target : '_blank'

				});
			}
		})

	}
	//修改编辑按钮权限
	function editButton(id) {
	    // alert("aa");
        document.getElementById(id).disabled=false;


    }
</script>
<script type="text/javascript">
    table.on('row(test)', function(obj){
	  console.log(obj.tr) //得到当前行元素对象
	  alert(obj.data) //得到当前行数据
	 
	});

</script>

</head>
<body onload="editButton('edit')">
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<script type="text/html" id="toolbarDemo">
    <div class="layui-input-block" style="width: 200px;float: left;margin-left:0px">
        <input id="name" style="width: 200px" type="text" name="name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input"> 
 </div>
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-warm" lay-event="getCheckLength">搜索</button>
        <button class="layui-btn layui-btn-danger"lay-event="getCheckData" data-type="getCheckData">批量删除</button>
        <button class="layui-btn layu-i-btn" lay-event="isAll">添加用户</button>
    </div>
</script>
	<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" id="edit" >编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
     <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="add">添加到后备表</a>
</script>
</body>
</html>