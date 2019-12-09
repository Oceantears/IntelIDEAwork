<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>变更表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js" charset="utf-8"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#test'
        ,url:'../ChangetableServlet?opt=queryAll'
        ,toolbar: '#toolbarDemo'
        ,cellMinWidth: 40
        ,title: '变更表'
        ,cols: [[
        	{type: 'checkbox', fixed: 'left'}
            ,{field:'zizeng', title:'序号', width:120, fixed: 'left',type:'numbers'}
            ,{field:'employee_id', title:'员工Id', width:120, unresize: true,fixed: 'left', sort: true}
            ,{field:'name', title:'姓名',align:'center'}
            ,{field:'work_exper', title:'当前职位',align:'center'}
            ,{field:'reserveposition', title:'候补职位',align:'center'}
            ,{field:'a', title:'操作', toolbar: '#barDemo',align:'center',width : 650}
        ]]
        ,page: {layout:['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']}
        ,id:'testReload'
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'getCheckData':
                active.getCheckData();
                break;
            case 'getCheckLength':
                active.reload();
                break;
            case 'isAll':
                active.notice();
                break;
        };
    });
    //添加事件
    //触发事件
    active = {
        //页面重新加载
        reload:function(){
            var name=$("#name").val();
            //alert(search_name);
            table.reload('testReload',{
                where:{name:name}
            });
        },
        getCheckData:function() {
            //获取选中数据
            var checkStatus = table.checkStatus('testReload'),
                data = checkStatus.data;
            if (data == "") {
                layer.msg('至少也得选一个吧', {icon: 2});
                return;
            }  
          
            var delArray=[];
            //获取单元格选中的行
            if (data.length > 0) {
			   for(var i=0;i<data.length;i++){
				delArray.push(data[i].employee_id);
				
			  }
            }
			var ids =delArray.join(",");
            
            
            layer.confirm('确认要删除嘛？' + delArray, function (index) {
                $.ajax({
                    type: 'POST',
                    url: '../ChangetableServlet?opt=del',
                    data: {'delArray': ids},

                });
                layer.msg('删除成功！', {icon: 1});
                location.reload();
            });

        },

        notice: function(){
            //示范一个公告层
            layer.open({
                type: 2
                ,title: false //不显示标题栏
                ,closeBtn: false
                ,area: ['600px', '500px'] //控制弹窗大小
                ,offset: ['20px', '300px'] //具体位置 顶部，左侧
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['退出']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: 'addChangetable1.jsp'
                ,end:function () {
                    location.reload();
                }
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn').attr({
                        href: '../ChangetableServlet?opt=queryAll'
                        ,target: '_blank'

                    });
                }
            });
        }


    };

    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        //console.log(obj)
        switch(obj.event){
            case 'del':
                layer.confirm("确认要删除吗，删除后不能恢复", function (index) {
                	
                	//alert(data.user_id);
                   delChangetable(data.employee_id);
                    layer.close(index);
                    location.reload();
                });
                break;
            case 'edit':
               updateChangtable(data.employee_id);
                break;
            case 'det':
              //  detGroup(data.user_id);
                break;
            case 'submission':
            	
            	//del3(data.employee_id);
            	
            	submission(data.reserveposition,data.employee_id);
            	break;
            case  'delreserve':
            	delreserve(data.employee_id);
            	break;
            case  'delsuggest':
            	delsuggest(data.employee_id);
        };
    });


});

 function delreserve(employee_id){
	
	//alert("employee_id--->"+employee_id);
	window.location.href="../ReserveServlet?opt=del&employee_id="+employee_id+"";
	del2(data.employee_id);
}
 function delsuggest(employee_id){
	
	//alert("employee_id--->"+employee_id);
	window.location.href="../SuggestServlet?opt=del&employee_id="+employee_id+"";
} 

/* function del3(employee_id){
	
	//alert("employee_id--->"+employee_id);
	window.location.href="../ChangetableServlet?opt=del&employee_id="+employee_id+"";
} */

function submission(reserveposition,employee_id){
	//alert(employee_id--->employee_id);
	window.location.href="../updateposition.jsp?reserveposition="+reserveposition+"&employee_id="+employee_id+"";
	
}
function delChangetable(id){
    //alert(id);
    $.ajax({
        type:'POST',
        url: '../ChangetableServlet?opt=del&employee_id='+id,
        success: function(msg){
            alert( "Data Saved: " + msg );
        }
    });
}
//修改
function  updateChangtable(id) {
    layer.open({
        type: 2
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: ['600px', '500px'] //控制弹窗大小
        ,offset: ['20px', '300px'] //具体位置 顶部，左侧
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['退出']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '../ChangetableServlet?opt=findById2&employee_id='+id
        ,end:function () {
            location.reload();
        }
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn').attr({
                href: '../ChangetableServlet?opt=queryAll'
                ,target: '_blank'

            });
        }
    })

}
</script>

</head>
<body>
<table class="layui-hide" id="test" lay-filter="test">
</table>
<script type="text/html" id="toolbarDemo">
    <div class="layui-input-block" style="width: 200px;float: left;margin-left:0px">
        <input id="name" style="width: 200px" type="text" name="name" required lay-verify="required" placeholder="请输入用户名称" autocomplete="off" class="layui-input">
   
 </div>
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-warm" lay-event="getCheckLength">搜索</button>
        <button class="layui-btn layui-btn-danger"lay-event="getCheckData" data-type="getCheckData">批量删除</button>
        <button class="layui-btn layui-btn" lay-event="isAll">添加用户</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除本行</a> 
      <%--人事管理员（干部科长）提交人事变更;--%>

    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="submission">提交人事变更</a>
<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="delreserve">删除后备表同Id行</a>
<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="delsuggest">删除提议表同Id行</a>
</script>

</body>
</html>