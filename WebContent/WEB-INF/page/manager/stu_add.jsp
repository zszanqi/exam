<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp" %>
<html lang="en">
  <head>
    <title>学生添加</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${basePath }css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body class="app sidebar-mini rtl">
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-edit"></i> 学生添加</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">学生管理</li>
          <li class="breadcrumb-item"><a href="#">添加</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <div class="row">
              <div class="col-lg-8">
                <form id="gradeForm" method="post">
                  <div class="form-group" style="margin-left:16px">
                    <label for="clazzSelect">所属班级</label>
                    <div style="display:flex">
	                    <select class="form-control"  id="gradeSelect" name="gradeId" style="width:33%" onchange="initClazz()">
	                      <option value="">--请选择年级--</option>
	                      <c:forEach items="${gradeList }" var="g">
	                      	<option value="${g.id }">${g.name }</option>
	                      </c:forEach>
	                    </select>
	                    <select class="form-control" id="majorSelect" name="majorId" style="width:33%" onchange="initClazz()">
	                      <option value="">--请选择专业--</option>
	                      <c:forEach items="${majorList }" var="m">
	                      	<option value="${m.id }">${m.name }</option>
	                      </c:forEach>
	                    </select>
	                    <select class="form-control" id="clazzSelect" name="fk_clazz" style="width:34%">
	                      <option value="">--请选择班级--</option>
	                    </select>
                    </div>
                  </div>
                  <div class="form-group col-lg-8">
                    <label for="name">用户名</label>
                    <input class="form-control" id="username" name="username" type="text" placeholder="请输入用户名">
                  </div>
                  <div class="form-group col-lg-8">
                    <label for="name">真实姓名</label>
                    <input class="form-control" id="realname" name="realname" type="text" placeholder="请输入真实姓名">
                  </div>
                  
                </form>
              </div>
            </div>
            <div class="tile-footer">
              <button class="btn btn-primary" type="button" onclick="toSubmit()">提交</button>
            </div>
          </div>
        </div>
      </div>
    </main>
    <!-- Essential javascripts for application to work-->
    <script src="${basePath }js/jquery-3.2.1.min.js"></script>
    <script src="${basePath }js/popper.min.js"></script>
    <script src="${basePath }js/bootstrap.min.js"></script>
    <script src="${basePath }js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script type="text/javascript">
     	function toSubmit(){
     		var fk_clazz = $("#clazzSelect").val();
     		if(fk_clazz==null || fk_clazz==''){
     			alert("班级不能为空");
     			$("#clazzSelect").focus();
     			return false;
     		}
     		var username = $("#username").val();
     		if(username==null || username==''){
     			alert("用户名不能为空");
     			$("#username").focus();
     			return false;
     		}
     		var realname = $("#realname").val();
     		if(realname==null || realname==''){
     			alert("真实姓名不能为空");
     			$("#realname").focus();
     			return false;
     		}
     		//发送ajax请求
     		$.ajax({
     			url:'${basePath}manager/DoStudentAddServlet',
     			type:'post',
     			data:{'fk_clazz':fk_clazz,'username':username,'realname':realname},
     			dataType:'text',
     			success:function(data){
     				if(data=='ok'){
     					//刷新页面
     					alert("添加成功");
     					window.location.reload();
     				}else if(data=='exist'){
     					alert("该学生已添加");
     				}else{
     					alert("系统异常，请稍后再试");
     				}
     			}
     			
     		});
     	}
     	
     	//初始化班级下拉框
     	function initClazz(){
     		var gradeId = $("#gradeSelect").val();
     		var majorId = $("#majorSelect").val();
     		if(gradeId==null || gradeId==''){
     			$("#gradeSelect").focus();
     			return false;
     		}
     		if(majorId==null || majorId==''){
     			$("#majorSelect").focus();
     			return false;
     		}
     		$.ajax({
     			url:'${basePath}manager/ToStudentAddServlet',
     			type:'get',
     			data:{'flag':'1','gradeId':gradeId,'majorId':majorId},
     			dataType:'json',
     			success:function(data){
     				var $_clazz = $("#clazzSelect");
     				$_clazz.html("<option value=''>--请选择班级--</option>");
     				for(var i=0;i<data.length;i++){
     					$_clazz.append("<option value='"+data[i].id+"'>"+data[i].cno+"</option>");
     				}
     			}
     		});
     	}
    </script>
  </body>
</html>