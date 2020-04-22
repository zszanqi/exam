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
	                  	<button class="btn btn-danger my_del" type="button">删除</button>
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
      
    </script>
  </body>
</html>