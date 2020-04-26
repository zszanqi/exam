<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>试卷管理</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Main CSS-->
<link rel="stylesheet" type="text/css" href="${basePath }css/main.css">
<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.my_del {
	height: 23px;
	line-height: 6px;
	padding-top: 3px;
	padding-left: 10px;
	width: auto;
}
</style>
</head>
<body class="app sidebar-mini rtl">
	<main class="app-content">
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> 试卷管理
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item active"><a href="#">试卷管理</a></li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<form class="row" method="post"
						action="${basePath }teacher/PaperQuestionServlet">
						<div class="form-group col-md-4 align-self-end">
							 <input class="form-control" name="name" id="questionName" type="text" placeholder="请输入题目名称">
							<button class="btn btn-primary" type="button"
								onclick="changeListSingle()">
								<i class="fa fa-fw fa-lg fa-check-circle"></i>单选题
							</button>
							<button class="btn btn-primary" type="button"
								onclick="changeListMulti()">
								<i class="fa fa-fw fa-lg fa-plus-circle"></i>多选题
							</button>
							<button class="btn btn-primary" type="button"
								onclick="changeListJudge()">
								<i class="fa fa-fw fa-lg fa-plus-circle"></i>判断题
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<h3 class="tile-title">试题列表</h3>
				<input type="hidden" value="${paperId }" id="paperId">
				<iframe name="pageFrame" id="pageFrame" src="" width="100%"
					height="300" frameborder="0"></iframe>
			</div>

			<button class="btn btn-primary" type="button" onclick="commit(${paperId })">
								<i class="fa fa-fw fa-lg fa-plus-circle"></i>完成</button>

			<div class="tile">
				<h3 class="tile-title">已选试题</h3>
				<iframe name="pageFramedown" id="pageFramedown" src="" width="100%"
					height="300" frameborder="0"></iframe>
				
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
		function changeListSingle() {
			document.getElementById("pageFrame").src = "${basePath }teacher/PaperSingleServlet?paperId=${paperId}&title=";
		}
		function changeListMulti() {
			document.getElementById("pageFrame").src = "${basePath }teacher/PaperMultiServlet?paperId=${paperId}&title=";
		}
		function changeListJudge() {
			document.getElementById("pageFrame").src = "${basePath }teacher/PaperJudgeServlet?paperId=${paperId}&title=";
		}
		function commit(id){
			window.location.href = '${basePath}teacher/CommitServlet?paperId='+id;
		}
	</script>
</body>
</html>