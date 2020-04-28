<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base.jsp" %>

<html lang="en">
  <head>
    <title>判断题</title>
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
  			width:auto;
  		}
  	</style>
  </head>
  <body class="app sidebar-mini rtl">
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i>判断题</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item active"><a href="#" >判断题</a></li>
        </ul>
      </div>
      <div class="row">
      	<div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <form class="row" method="post" action="${basePath }teacher/QuestionJudgeServlet">
                <div class="form-group col-md-3">
                  <label class="control-label">题名</label>
                  <input class="form-control" name="name" type="text" value="${name }" placeholder="请输入名称">
                </div>
                <div class="form-group col-md-4 align-self-end">
                  <button class="btn btn-primary" type="submit"><i class="fa fa-fw fa-lg fa-check-circle"></i>搜索</button>
                   <button class="btn btn-primary" type="button" onclick="toAdd()"><i class="fa fa-fw fa-lg fa-plus-circle"></i>添加题目</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <h3 class="tile-title">判断题</h3>
            <table class="table table-hover">
              <thead align="center">
                <tr>
                  <th>id</th>
                  <th>标题</th>
                  <th>答案</th>
                  <th>分值</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody align="center">
    			<c:forEach items="${page.data }" var="q" varStatus="status">
              		<tr id="tr${q.id }">
	                  <td>${status.count}</td>
	                  <td>${q.title }</td>
	                  <td>${q.answer }</td>
	                  <td>${q.score }</td>
	                  <td>
	                        <button class="btn btn-info my_del" type="button" onclick="editQuestionJudge('${q.id }')">编辑</button>
	                        <button class="btn btn-success my_del" type="button" onclick="submitQuestionJudge('${q.id }')">正答率</button>
	                  		<button class="btn btn-danger my_del" type="button" onclick="deleteQuestionJudge('${q.id }')">删除</button>
	                  </td>
	                </tr>
              	</c:forEach>
              </tbody>
            </table>
             <p:page action="teacher/QuestionJudgeServlet"/>
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
		window.location.href='${basePath}teacher/ToQuestionJudgeAddServlet';
	}
    function deleteQuestionJudge(id) {
		if (confirm("您确定要删除吗？")) {
			$.ajax({
				url:'${basePath}teacher/DeleteQuestionJudgeServlet',
				type:'post',
				data:{"id":id},
				dataType:'text',
				success:function(data){
					if(data=="ok"){
						alert("删除成功");
						//删除该行
						$('#tr'+id).remove();
					}else{
						alert("删除失败，请稍后再试");
					}
				}
			});
		}
	}
    function editQuestionJudge(id) {
		if (confirm("您确定要修改吗？")) {
			window.location.href = "${basePath}teacher/ToQuestionJudgeEditServlet?id=" + id;
		}
	}

    </script>
  </body>
</html>