<%@page import="com.cadre.bean.Cadre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
<script type="text/javascript" src="js/jquery-2.1.0.min.js"
	charset="utf-8"></script>
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script src="layui/layui.js" charset="utf-8"></script>
<script>
		layui.use('form', function() {
			var form = layui.form;
			form.on('submit(formDemo)', function(data) {
				layer.msg();
				return true;
			});
		});
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			laydate.render({
				elem : '#test1' 
			});
		});
	</script>
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
		Cadre cadre = (Cadre)request.getAttribute("cadre2");
		%>
	<form class="layui-form" action="cadre.do">
		<div class="layui-form-item" style="margin-top: 10px;">
			<label class="layui-form-label">编号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="employee_id" required
					lay-verify="required" autocomplete="off" class="layui-input"
					value="<%=cadre.getEmployee_id()%>" readonly="readonly"> <input
					style="width: 190px; display: none" type="text" name="opt" required
					lay-verify="required" autocomplete="off" class="layui-input"
					value="upd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="name" value="<%=cadre.getName()%>" required lay-verify="required"
					placeholder="请输入姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">国籍</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="nationality" value="<%=cadre.getNationality()%>" required
					lay-verify="required" placeholder="请输入国籍" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">目前所在地</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="cur_loca" value="<%=cadre.getCur_loca()%>" required
					lay-verify="required" placeholder="请输入目前所在地" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">民族</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="nation" value="<%=cadre.getNation()%>" required
					lay-verify="required" placeholder="请输入民族" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!-- 1 -->
		
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">编号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="loca_of_resid" value="<%=cadre.getLoca_of_resid()%>" required
					lay-verify="required" placeholder="请输入户口所在地" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">婚姻状况</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="mari_status" value="<%=cadre.getMari_status()%>"required
					lay-verify="required" placeholder="请输入婚姻状况" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">健康状况</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="heal_condi" value="<%=cadre.getHeal_condi()%>" required
					lay-verify="required" placeholder="请输入健康状况" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">年龄</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="age" value="<%=cadre.getAge()%>" required
					lay-verify="required" placeholder="请输入年龄" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!-- 2 -->
		
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="sex" value="<%=cadre.getSex()%>" required
					lay-verify="required" placeholder="请输入性别" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">最高学历</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="high_edu" value="<%=cadre.getHigh_edu()%>" required
					lay-verify="required" placeholder="请输入最高学历" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">政治面貌</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="poli_lands" value="<%=cadre.getPoli_lands()%>" required
					lay-verify="required" placeholder="请输入政治面貌" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">毕业学校</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="school" value="<%=cadre.getSchool()%>" required
					lay-verify="required" placeholder="请输入毕业学校" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!-- 3 -->
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">专业</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="prof" value="<%=cadre.getProf()%>" required
					lay-verify="required" placeholder="请输入专业" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">获得证书</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="certificate" value="<%=cadre.getCertificate()%>" required
					lay-verify="required" placeholder="请输入获得证书" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<%-- <label class="layui-form-label">当前职位</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="work_exper" value="<%=cadre.getWork_exper()%>" required
					lay-verify="required" placeholder="请输入当前职位" autocomplete="off"
					class="layui-input">
			</div> --%>
			<div class="layui-input-block" style="width: 190px">
			  <span style="margin-left: -80px">当前职位</span>
			 <select name="work_exper">
              <option value="部长" selected>部长</option>
              <option value="分管部长">分管部长</option>
              <option value="分管部长">区委书记</option>
              <option value="干部部长">干部部长</option>
              <option value="员工">员工</option>
           </select> 
           </div>
		</div>
		<!-- 4 -->
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">家庭主要成员</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="memb_fam"  value="<%=cadre.getMemb_fam()%>" required
					lay-verify="required" placeholder="请输入家庭主要成员" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">英语水平</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="english" value="<%=cadre.getEnglish()%>" required
					lay-verify="required" placeholder="请输入英语水平" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">自我评价</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="self_evalu" value="<%=cadre.getSelf_evalu()%>" required
					lay-verify="required" placeholder="请输入自我评价" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">兴趣爱好</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="hobbies" value="<%=cadre.getHobbies()%>" required
					lay-verify="required" placeholder="请输入兴趣爱好" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!-- 5 -->
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">入职时间</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="entry_time"  value="<%=cadre.getEntry_time()%>" required
					lay-verify="required" placeholder="请输入入职时间" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">离职时间</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="leave_time" value="<%=cadre.getLeave_time()%>" required
					lay-verify="required" placeholder="请输入在职时间" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">考核情况</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="asse_status" value="<%=cadre.getAsse_status()%>" required
					lay-verify="required" placeholder="请输入考核情况" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">违纪违规情况</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="viola_of_discip" value="<%=cadre.getViola_of_discip()%>" required
					lay-verify="required" placeholder="请输入违纪违规情况" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!-- 6 -->
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">审计情况</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="audit_status" value="<%=cadre.getAudit_status()%>" required
					lay-verify="required" placeholder="请输入审计情况" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">出国（境）情况</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="departure"  value="<%=cadre.getDeparture()%>" required
					lay-verify="required" placeholder="请输入出国（境）情况" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">语言能力</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="langu_ability" value="<%=cadre.getLangu_ability()%>" required
					lay-verify="required" placeholder="请输入语言能力" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">科室号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="ks_id"  value="<%=cadre.getKs_id()%>" required
					lay-verify="required" placeholder="请输入科室号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!--7  -->
		<div class="layui-form-item">
			<label class="layui-form-label">职位编号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="admin_id" value="<%=cadre.getAdmin_id()%>" required
					lay-verify="required" placeholder="请输入职位编号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<%-- <label class="layui-form-label">职位编号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="reserveposition" value="<%=cadre.getAdmin_id()%>" required
					lay-verify="required" placeholder="请输入职位编号" autocomplete="off"
					class="layui-input">
			</div> --%>
			<div class="layui-input-block" style="width: 190px">
			  <span style="margin-left: -80px">候补职位</span>
			 <select name="reserveposition">
              <option value="部长" selected>部长</option>
              <option value="分管部长">分管部长</option>
              <option value="分管部长">区委书记</option>
              <option value="干部部长">干部部长</option>
              <option value="员工">员工</option>
           </select> 
           </div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block" style="margin-top: 20px;">
				<button class="layui-btn layui-btn-warm" lay-submit
					lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
</html>