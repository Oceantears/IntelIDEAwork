<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职位信息</title>
   <script type="text/javascript" src="../js/jquery-2.1.0.min.js" charset="utf-8"></script>
   <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
   <script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#test'
        ,url:'../post.do?opt=queryAll'
        ,toolbar: '#toolbarDemo'
        ,cellMinWidth: 40
        ,title: '用户数据表'
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'job_no', title:'职位编号', width:120, fixed: 'left', unresize: true, sort: true}
            ,{field:'ks_no', title:'科室id', width:120, fixed: 'left', unresize: true, sort: true}
            ,{field:'job_title', title:'职位名称',align:'center'}
            ,{field:'job_description', title:'职位描述',align:'center'}
            ,{field:'job_duenum', title:'职位应有人数',align:'center'}
            ,{field:'job_realitynum', title:'职位现有人数',align:'center'}
            ,{field:'shortage_num', title:'职位短缺人数',align:'center'}
            ,{field:'job_preparation', title:'职位编制',align:'center'}
            ,{field:'a', title:'操作', toolbar: '#barDemo',align:'center'}
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
            var job_no=$("#job_no").val();
            //alert(search_name);
            table.reload('testReload',{
                where:{job_no:job_no}
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
				delArray.push(data[i].job_no);
				
			  }
            }
			var ids =delArray.join(",");
            
            
            layer.confirm('确认要删除嘛？' + delArray, function (index) {
                $.ajax({
                    type: 'POST',
                    url: '../post.do?opt=del',
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
                ,content: 'addPost.jsp'
                ,end:function () {
                    location.reload();
                }
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn').attr({
                        href: '../post.do?opt=queryAll'
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
                   delUser(data.job_no);
                    layer.close(index);
                    location.reload();
                });
                break;
            case 'edit':
               updateUser(data.job_no);
                break;
            case 'det':
              //  detGroup(data.user_id);
                break;
        };
    });


});

function delUser(id){
    //alert(id);
    $.ajax({
        type:'POST',
        url: '../post.do?opt=del&job_no='+id,
        success: function(msg){
            alert( "Data Saved: " + msg );
        }
    });
}
//修改
function  updateUser(id) {
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
        ,content: '../post.do?opt=findById&job_no='+id
        ,end:function () {
            location.reload();
        }
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn').attr({
                href: '../post.do?opt=queryAll'
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
        <input id="job_no" style="width: 200px" type="text" name="job_no" required lay-verify="required" placeholder="请输入用户名称" autocomplete="off" class="layui-input">
   
 </div>
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-warm" lay-event="getCheckLength">搜索</button>
        <%--<a href="" class="layui-btn layui-btn-warm" lay-event="getCheckLength">搜索</a>--%>
        <button class="layui-btn layui-btn-danger"lay-event="getCheckData" data-type="getCheckData">批量删除</button>
        <%--<button class="layui-btn layui-btn" lay-event="getCheckLength">获取选中数目</button>--%>
        <button class="layui-btn layui-btn" lay-event="isAll">添加用户</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
     <%--<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="det">详情</a>--%>
</script>

</body>
</html>