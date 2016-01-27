<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<html>
	<head>
		<!-- Encoding -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<jsp:include page="base/header.jsp" flush="false" />
    	<title>Question</title>
    	
	</head>
	<jsp:include page="base/nav.jsp" flush="true" />
	<body>

		<div class="container body-content" style="margin-top: 150px">
			<div class="row-fluid">
				<h1> 설문 </h1>
			</div>
			
			<div>
				<button type="button" class="btn" data-toggle="modal" data-target="#createProjectModal" style="margin: 5px;">프로젝트 등록</button>
			</div>
			
			<jsp:include page="base/foot.jsp" flush="false" />
		</div>	


</body>
</html>
