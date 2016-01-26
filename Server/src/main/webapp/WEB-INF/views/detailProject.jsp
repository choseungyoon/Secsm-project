<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="com.secsm.info.ProjectInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<html>
	<head>
		<!-- Encoding -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<!-- jQuery -->
		<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    	<title>Project</title>

	</head>

	<%
		ArrayList<ProjectInfo> projectList = (ArrayList<ProjectInfo>) request.getAttribute("projectList");
	%>

	<body>
		<div id="pvrContent">
			<!-- 상단 네비게이션바 -->
			<div class="container" style="height:40px; padding-bottom:3em; border-bottom-color:black; border-bottom-width:1px; border-bottom-style:solid; border-bottom-color:#495C6F;">
				<div class="navbar-header">
					<div class="navbar-inner" style="padding-top:10px; padding-botton:10px">
						<a style="margin-top:-10px; margin-bottom:0; margin-right:10px; font-size:18pt; font-weight:bold;" href="${pageContext.request.contextPath}/" class="navbar-brand"><img alt="Home" src="${pageContext.request.contextPath}/resources/images/home.png"></a>
						<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">Home</font></a>
						<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/living" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">생활</font></a>
						<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/project" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">교육</font></a>
						<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/equipment" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">기자제</font></a>
						<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/px" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">PX</font></a>
					</div>
				</div>
			</div>

		<div class="container body-content">
			<div class="row-fluid">
				<h1> Project </h1>
			</div>
			
			<div>
			</div>
			
			
		</div>	
    
		<form name="formRegProject" id="formRegProject" action="${pageContext.request.contextPath}/addProject" method="post">
			<div id="modalRegProject" class="modal fade" style="display: none; width: 80%; margin-left: -40%;">
	   			<div class="modal-dialog" style="overflow-x: hidden;">
	      			<div class="modal-content">
	         			<!-- header -->
	         			<div class="modal-header">
	            			<h4 class="modal-title">Register Project</h4>
	         			</div>
	         			<div class="modal-body" style="font-size: 16px; padding-right: 4em;">
							
	                    </div>
	         			
	         			<div class="modal-footer">

	         			</div>
	      			</div>
	   			</div>
			</div>
		</form>
    
	</body>
</html>
