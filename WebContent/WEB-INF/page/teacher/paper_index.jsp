<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>

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
						action="${basePath }teacher/PaperServlet">
						<div class="form-group col-md-3">
							<label class="control-label">查询</label> <input
								class="form-control" name="name" type="text" value="${name }"
								placeholder="请输入试卷名称">
						</div>
						<div class="form-group col-md-4 align-self-end">
							<button class="btn btn-primary" type="submit">
								<i class="fa fa-fw fa-lg fa-check-circle"></i>查询
							</button>
							<button class="btn btn-primary" type="button" onclick="toAdd()">
								<i class="fa fa-fw fa-lg fa-plus-circle"></i>添加
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
				<h3 class="tile-title">试卷列表</h3>
				<table class="table table-hover">
					<thead align="center">
						<tr>
							<th>序号</th>
							<th>标题</th>
							<th>适用班级</th>
							<th>考试时长</th>
							<th>状态</th>
							<th>状态切换</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody align="center">
						<c:forEach items="${page.data }" var="paper" varStatus="status">
							<tr id="tr${paper.id }">
								<td>${status.count }</td>
								<td>${paper.title }</td>
								<td>
									<button class="btn btn-info my_del" type="button"
										onclick="toClazzList('${paper.id}')">显示</button>
								</td>
								<td>${paper.time_limit }</td>
								<td id="status${paper.id }">${paper.status }<c:if
										test="${paper.fk_status == 2 }">
										<a href="#">成绩统计</a>
									</c:if>
								</td>
								<td id="sbtn${paper.id }"><c:if
										test="${paper.fk_status == 1 }">
										<button class="btn btn-secondary my_del" type="button"
											disabled="disabled">未初始化</button>
									</c:if> <c:if test="${paper.fk_status == 2 }">
										<button class="btn btn-warning rowsCount = 0; my_del"
											onclick="setStatus('3','${paper.id}')" type="button">开始运行</button>
									</c:if> <c:if test="${paper.fk_status == 3 }">
										<button class="btn btn-danger my_del"
											onclick="setStatus('4','${paper.id}')" type="button">立即停止</button>
									</c:if> <c:if test="${paper.fk_status == 4 }">
										<button class="btn btn-success my_del"
											onclick="setStatus('3','${paper.id}')" type="button">重新运行</button>
									</c:if></td>
								<td>
									<button class="btn btn-danger my_del" type="button"
										onclick="deletePaper('${paper.id }')">删除</button>
									<button class="btn btn-success my_del" type="button" onclick="toEdit(${paper.id})">编辑</button>
									<button class="btn btn-info my_del" type="button"
										onclick="toAppend('${paper.id }')">试题</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p:page action="teacher/PaperServlet" />
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
		function setStatus(status, paperId) {
			if (confirm("您确定要切换吗")) {
				$.ajax({
							url : '${basePath}teacher/SetStatusServlet',
							type : 'post',
							data : {
								'status' : status,
								'paperId' : paperId
							},
							dataType : 'text',
							success : function(data) {

								if (data == 'ok') {
									alert("设置成功");
									if (status == '3') {
										$("#status" + paperId).html("运行中");
										$("#sbtn" + paperId)
												.html("<button class=\"btn btn-danger my_del\" onclick=\"setStatus('4',"+paperId+")\" type=\"button\">立即停止</button>");
									}
									if (status == '4') {
										$("#status" + paperId).html("已结束");
										$("#sbtn" + paperId)
												.html("<button class=\"btn btn-success my_del\" onclick=\"setStatus('4',"+paperId+")\" type=\"button\">重新运行</button>");
									}
								} else {
									alert("设置失败");
								}
							}
						});
			}

		}
		function deletePaper(id) {
			if (confirm("您确定要删除吗？")) {
				$.ajax({
					url : '${basePath}teacher/DeletePaperServlet',
					type : 'get',
					dataType : 'text',
					data : {
						'id' : id
					},
					success : function(data) {
						if (data == 'ok') {
							alert("删除成功");
							//删除该行
							$('#tr' + id).remove();
						} else {
							alert("删除失败，请稍后再试");
						}
					}
				});
			}
		}
		function toAdd(){
			window.location.href = '${basePath}teacher/ToAddPaperServlet';
		}
		function toAppend(paperId) {
			window.location.href = '${basePath}teacher/ToAppendQuestionServlet?paperId='+paperId;
		}
		function toClazzList(paperId){
	    	  window.location.href='${basePath}teacher/ChoosePaperClazzServlet?flag=1&paperId='+paperId;
	      }
		function toEdit(paperId){
			window.location.href='${basePath}teacher/ToEditPaperServlet?paperId='+paperId;
		}
	</script>
</body>
</html>