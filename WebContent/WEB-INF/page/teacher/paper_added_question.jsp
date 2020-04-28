<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>

<html lang="en">
<head>
<title>已添加</title>
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
			margin-top:-85px;
			margin-left:10%;
		}
	</style>
</head>
<body class="app sidebar-mini rtl">

	<!-- 页面主体 -->
	<main class="app-content">
	<button class="btn btn-primary" type="button" id="addbtn"
								onclick="toDel()">
								<i class="fa fa-fw fa-lg fa-plus-circle"></i>删除
							</button>
		<table class="table table-hover" id="datatable">
				<thead align="center">
						<tr>
							<th>
							 
							</th>
							<th>序号</th>
							<th>标题</th>
							<th>题型</th>
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
								<td>${question.type }</td>
							</tr>
						</c:forEach>
						</form>
					</tbody>
				</table>
	</main>

</body>
<script src="${basePath }js/jquery-3.2.1.min.js"></script>
	
<script type="text/javascript">
function toDel(){
	var paperId = $('#paperId').val();
	$.ajax({
		url:'${basePath}teacher/DelQuestionServlet',
		type:'post',
		data:$('#listForm').serialize(),
		dataType:'text',
		success:function(data){
			if(data=='ok'){
				alert("删除成功");
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