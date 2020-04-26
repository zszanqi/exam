<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>首页</title>
<meta charset="utf-8">
<!-- Main CSS-->
<link rel="stylesheet" type="text/css" href="${basePath }css/main.css">
<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="app sidebar-mini rtl">

	<!-- 页面主体 -->
	<main class="app-content">
	 <div class="app-title">
        <div>
          <h1><i class="fa fa-laptop"></i> 功能介绍</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <c:if test="${sessionScope.roleId == 2 }">
          	<li class="breadcrumb-item">教师</li>
          </c:if>
          <c:if test="${sessionScope.roleId == 3 }">
          	<li class="breadcrumb-item">管理员</li>
          </c:if>
          <li class="breadcrumb-item"><a href="#">主页</a></li>
        </ul>
      </div>
      <!-- 教师页面主页 -->
		<c:if test="${sessionScope.roleId == 2 }">
		<div class="row">
       		 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">试卷列表</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">试卷添加</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	<div class="clearfix"></div>
        	<div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">单选题</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">多选题</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	<div class="clearfix"></div>
        	<div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">判断题</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">关于我们</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	<div class="clearfix"></div>
        </div>
		</c:if>
		
      <!-- 管理员页面主页 -->
		<c:if test="${sessionScope.roleId == 3 }">
			<div class="row">
       		 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">年级管理</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据年级编号查询年级基本信息</li>
            				<li>添加、删除年级</li>
            			</ul>
            		</div>
            		
          		</div>
        	</div>
        	 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">专业管理</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	<div class="clearfix"></div>
        	<div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">班级管理</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据年级、专业编号查询班级信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">学生管理</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	<div class="clearfix"></div>
        	<div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">教师管理</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            				<li>添加、修改、删除专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	 <div class="col-md-6">
          		<div class="tile">
            		<h3 class="tile-title">关于我们</h3>
            		<div class="tile-body">
            			<ul>
            				<li>根据专业名称查询专业信息</li>
            			</ul>
            		</div>
          		</div>
        	</div>
        	<div class="clearfix"></div>
        </div>
		</c:if>
    
       
	</main>

</body>
</html>