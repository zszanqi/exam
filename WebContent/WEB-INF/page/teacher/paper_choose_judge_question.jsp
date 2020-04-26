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
	
	<style>
		#datatable{
			background-color:white;
			margin-top:-50px;
		}
		.app-content{
			background-color:white;
			margin-left:-10%;
			width:110%;
		}
		#addbtn{
			margin-top:-120px;
			margin-left:10%;
		}
	</style>
</head>
<body class="app sidebar-mini rtl">

	<!-- 页面主体 -->
	<main class="app-content">
	<button class="btn btn-primary" type="button" id="addbtn"
								onclick="toSubmit()">
								<i class="fa fa-fw fa-lg fa-plus-circle"></i>添加
							</button>
		<table class="table table-hover" id="datatable">
				<thead align="center">
				
						<tr>
							<th>
							 <input type="checkbox">全选
							</th>
							<th>序号</th>
							<th>标题</th>
						</tr>
					</thead>
					<tbody align="center">
						<form id="listForm">
						<input type="hidden" value="${paperId }" name="paperId" id="paperId">
						<c:forEach items="${list }" var="question" varStatus="status">
							<tr id="tr${question.id }">
								<td>
									<input type="checkbox" name="questionId" value="${question.id }">
								</td>
								<td>${status.count }</td>
								<td>${question.title }</td>
							</tr>
						</c:forEach>
						</form>
					</tbody>
				</table>
				
	</main>

</body>
<script src="${basePath }js/jquery-3.2.1.min.js"></script>
	
<script type="text/javascript">
function toSubmit(){
	var paperId = $('#paperId').val();
	$.ajax({
		url:'${basePath}teacher/SelectJudgeServlet',
		type:'post',
		data:$('#listForm').serialize(),
		dataType:'text',
		success:function(data){
			if(data=='ok'){
				alert("添加成功");
				parent.document.getElementById("pageFramedown").src= "${basePath }teacher/ShowQuestionListServlet?paperId="+paperId;
			}else{
				alert("系统异常，请联系程序猿");
				return false;
			}
		}
	});
	
}
</script>
</html>