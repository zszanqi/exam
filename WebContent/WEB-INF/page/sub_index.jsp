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
	<!-- 教师页面主页 -->
	<c:if test="${sessionScope.roleId == 2 }">
	教师
	</c:if>
	
	<!-- 管理员页面主页 -->
	<c:if test="${sessionScope.roleId == 3 }">
	管理员
	</c:if>
	</main>

</body>
</html>