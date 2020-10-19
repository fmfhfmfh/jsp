<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
<!-- 			접속을 안했을 때 :        ==> [] -->
<!-- 			접속을 했을 때 : [brown] ==> [brown]  -->
			<a class="navbar-brand" href="#">JSP/SPRING
					<c:if test="${S_MEMBER.userid != null}">[${S_MEMBER.userid}]</c:if>
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>