<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp" %>
<html lang="en">
  <head>
    <title>多选添加</title>
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
          <h1><i class="fa fa-edit"></i> 多选添加</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">多选管理</li>
          <li class="breadcrumb-item"><a href="#">添加</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <div class="row">
              <div class="col-lg-6">
                <form id="gradeForm" method="post">
                  <div class="form-group">
                    <label for="name">标题</label>
                    <input class="form-control" id="title" name="title" type="text" placeholder="请输入标题名称">
                  </div>
                  <div class="form-group">
                    <label for="name">选项A</label>
                    <input class="form-control" id="optionA" name="optionA" type="text" placeholder="请输入选项A">
                  </div>
                  <div class="form-group">
                    <label for="name">选项B</label>
                    <input class="form-control" id="optionB" name="optionB" type="text" placeholder="请输入选项B">
                  </div>
                  <div class="form-group">
                    <label for="name">选项C</label>
                    <input class="form-control" id="optionC" name="optionC" type="text" placeholder="请输入选项C">
                  </div>
                  <div class="form-group">
                    <label for="name">选项D</label>
                    <input class="form-control" id="optionD" name="optionD" type="text" placeholder="请输入选项D">
                  </div>
                  <div class="form-group">
                    <label for="name">答案</label>
                    <input class="form-control" id="answer" name="answer" type="text" placeholder="请输入答案">
                  </div>
                  <div class="form-group">
                    <label for="name">分值</label>
                    <input class="form-control" id="score" name="score" type="number" placeholder="请输入分值">
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
     		var title = $("#title").val();
     		if(title==null || title==''){
     			alert("标题不能为空");
     			$("#title").focus();
     			return false;
     		}
     		var optionA = $("#optionA").val();
     		if(optionA==null || optionA==''){
     			alert("选项不能为空");
     			$("#optionA").focus();
     			return false;
     		}
     		var optionB = $("#optionB").val();
     		if(optionB==null || optionB==''){
     			alert("选项不能为空");
     			$("#optionB").focus();
     			return false;
     		}
     		var optionC = $("#optionC").val();
     		if(optionC==null || optionC==''){
     			alert("选项不能为空");
     			$("#optionC").focus();
     			return false;
     		}
     		var optionD = $("#optionD").val();
     		if(optionD==null || optionD==''){
     			alert("选项不能为空");
     			$("#optionD").focus();
     			return false;
     		}
     		var answer = $("#answer").val();
     		if(answer==null || answer==''){
     			alert("答案不能为空");
     			$("#answer").focus();
     			return false;
     		}
     		var score = $("#score").val();
     		if(score==null || score==''){
     			alert("分值不能为空");
     			$("#score").focus();
     			return false;
     		}
     		//发送ajax请求
     		$.ajax({
     			url:'${basePath}teacher/DoMultiAddServlet',
     			type:'post',
     			data:{'title':title,'optionA':optionA,'optionB':optionB,'optionC':optionC,'optionD':optionD,'answer':answer,'score':score},
     			dataType:'text',
     			success:function(data){
     				if(data=='ok'){
     					window.location.href='${basePath}teacher/MultiServlet';
     				}else if(data=='exist'){
     					alert("该多选已被添加");
     				}else{
     					alert("系统异常，请稍后再试");
     				}
     			}
     			
     		});
     	}
    </script>
  </body>
</html>