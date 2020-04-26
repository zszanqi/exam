<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>教师管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${basePath }css/main.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  	<style type="text/css">
  		.my_del{
  			height:23px;
  			line-height:6px;
  			padding-top:3px;
  			padding-left:10px;
  			width:50px;
  		}
  		.my_edit{
  			height:23px;
  			line-height:6px;
  			padding-top:3px;
  			padding-left:10px;
  			width:50px;
  		}
  		.my_editps{
  			height:23px;
  			line-height:6px;
  			padding-top:3px;
  			padding-left:10px;
  			width:100px;
  		}
  	</style>
  </head>
  <body class="app sidebar-mini rtl">
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i>教师管理</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item active"><a href="#" >教师管理</a></li>
        </ul>
      </div>
      <div class="row">
      	<div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <form class="row" method="post" action="${basePath }manager/TeacherServlet">
                <div class="form-group col-md-3">
                  <label class="control-label">教师名称</label>
                  <input class="form-control" name="name" type="text" value="${name }" placeholder="请输入名称">
                </div>
                <div class="form-group col-md-4 align-self-end">
                  <button class="btn btn-primary" type="submit"><i class="fa fa-fw fa-lg fa-check-circle"></i>查询</button>
                   <button class="btn btn-primary" type="button" onclick="toAdd()"><i class="fa fa-fw fa-lg fa-plus-circle"></i>添加</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <h3 class="tile-title">教师列表</h3>
            <table class="table table-hover">
              <thead align="center">
                <tr>
                  <th>序号</th>
                  <th>教师名称</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody align="center">
              	<c:forEach items="${page.data }" var="teacher" varStatus="status">
              		<tr>
	                  <td>${status.count}</td>
	                  <td>${teacher.realname }</td>
	                  <td>
	                        <button class="btn btn-info my_edit" type="button" onclick="editTeacher('${teacher.id }')">修改</button>
	                  		<button class="btn btn-danger my_del" type="button" onclick="deleteTeacher('${teacher.id }')">删除</button>
	                  		<button class="btn btn-primary my_editps" type="button" onclick="editpsTeacher('${teacher.id }')">重置密码</button>
	                  		<button class="btn btn-primary my_editps" type="button" onclick="editclazzTeacher('${teacher.id }')">编辑班级</button>
	                  </td>
	                </tr>
              	</c:forEach>
              </tbody>
            </table>
             <p:page action="manager/TeacherServlet"/>
          </div>
        </div>
      </div>
    </main>
    <!-- Essential javascripts for application to work-->
    <script src="${basePath }js/jquery-3.2.1.min.js"></script>
    <script src="${basePath }js/popper.min.js"></script>
    <script src="${basePath }js/bootstrap.min.js"></script>
    <script src="${basePath }js/main.js"></script>
    <script type="text/javascript">
    function toAdd(){
		window.location.href='${basePath}ToTeacherAddServlet';
	}
    function deleteTeacher(id) {
		if (confirm("您确定要删除吗？")) {
			window.location.href = "${basePath}DeleteTeacherServlet?id=" + id;
		}
	}
    function editTeacher(id) {
		if (confirm("您确定要修改吗？")) {
			window.location.href = "${basePath}ToTeacherEditServlet?id=" + id;
		}
	}
    function editpsTeacher(id) {
		if (confirm("您确定要重置密码吗？")) {
			window.location.href = "${basePath}ToTeacherEditpsServlet?id=" + id;
		}
	}
    function editclazzTeacher(id) {
		if (confirm("您确定编辑班级吗？")) {
			window.location.href = "${basePath}TeacherClazzServlet?flag=1&id=" + id;
			//window.location.href='${basePath}manager/teaList?flag=1&teaId='+teaId;
		}
	}
    </script>
  </body>
</html>