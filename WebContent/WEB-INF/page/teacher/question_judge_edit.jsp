<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>判断题修改</title>
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
          <h1><i class="fa fa-edit"></i>判断题修改</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">判断题管理</li>
          <li class="breadcrumb-item"><a href="#">修改</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <div class="row">
              <div class="col-lg-6">
              <form action="${basePath }DoQuestionJudgeEditServlet" method="post" id="editquestion_judgeForm">
              <input type="hidden" name="id" value="${question_judge.id }">
                  <div class="form-group">
                    <label for="name">判断题题目</label>
                    <input class="form-control" id="title" name="title" type="text" value="${question_judge.title}" placeholder="请输入判断题题目">
                    <label for="name">判断题答案</label>
                    <input class="form-control" id="answer" name="answer" type="text" value="${question_judge.answer}" placeholder="请输入判断题答案">
                    <label for="name">判断题分数</label>
                    <input class="form-control" id="score" name="score" type="text" value="${question_judge.score}" placeholder="请输入判断题分数">
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
 		var answer=$("#answer").val();
 		var score=$("#score").val();
 		
 		if(title==null || title==''){
 			alert("题目不能为空");
 			$("#title").focus();
 			return false;
 		}
 		if(answer==null || answer==''){
 			alert("答案不能为空");
 			$("#answer").focus();
 			return false;
 		}
 		if(score==null || score==''){
 			alert("分数不能为空");
 			$("#score").focus();
 			return false;
 		}
 		//发送ajax请求
 		$.ajax({
 			url:'${basePath}DoQuestionJudgeEditServlet',
 			type:'post',
 			data:$("#editquestion_judgeForm").serialize(),
 			dataType:'text',
 			success:function(data){
 				if(data=='ok'){
 					window.location.href='${basePath}manager/QuestionJudgeServlet';
 				}else{
 					alert("系统异常，请稍后再试");
 				}
 			}
 			
 		});
 	}
    </script>
  </body>
</html>