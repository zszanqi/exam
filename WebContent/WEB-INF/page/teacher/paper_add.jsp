<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp" %>

<html lang="en">
  <head>
    <title>添加试卷</title>
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
          <h1><i class="fa fa-edit"></i> 添加试卷</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">班级管理</li>
          <li class="breadcrumb-item"><a href="#">添加</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <div class="row">
              <div class="col-lg-6">
                <form id="paperForm" method="post">
           		  <div class="form-group">
           		  	<label for="">试卷标题</label>
           		  	<input class="form-control" id="papertitle" name="papertitle" type="text" placeholder="请输入试卷标题">           	
           		  </div>
                  <div class="form-group">
                    <label for="name">考试时长</label>
                    <input class="form-control" id="time" name="time" type="text" placeholder="请输入考试时长">
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
    	var papertitle = $('#papertitle').val();
    	if(papertitle==null || papertitle==''){
 			alert("标题不能为空");
 			$("#papertitle").focus();
 			return false;
 		}
    	var time = $("#time").val();
    	if(time==null || time==''){
 			alert("专业不能为空");
 			$("#time").focus();
 			return false;
 		}
 		var teacherId = ${sessionScope.user.id };
 		//发送ajax请求
 		$.ajax({
 			url:'${basePath}teacher/DoPaperAddServlet',
 			type:'post',
 			data:{'papertitle':papertitle,'time':time,'teacherId':teacherId},
 			dataType:'text',
 			success:function(data){
 				if(data=='ok'){
 					window.location.href='${basePath}teacher/PaperServlet';
 				}else{
 					alert("系统异常，请稍后再试");
 				}
 			}
 			
 		});
 	}
    </script>
  </body>
</html>