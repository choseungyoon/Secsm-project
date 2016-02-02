<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<!-- Encoding -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<jsp:include page="base/header.jsp" flush="false" />
    	<title>Book</title>
	</head>
	<jsp:include page="base/nav.jsp" flush="true" />
	<body>

		<div class="container body-content" style="margin-top: 150px">
			<div class="row-fluid">
				<h1> 도서 </h1>
			</div>
			<div class="row-fluid">
				<ul >
					<form action="bookSearch" method="get">
					<tr>
						<td> 검색 </td>
						<td> <input type="text" name="bTitle" size = "50"> </td>
					</tr>
					<tr >
						<td colspan="2"> <input type="submit" value="입력"></td>
					</tr>
					</form>
					<li role="presentation"><a role="menuitem" href="bookRental">대여 및 반납</a></li>
					<li role="presentation"><a role="menuitem" href="bookApply">도서 요청</a></li>
				</ul>
			</div>
			<jsp:include page="base/foot.jsp" flush="false" />
		</div>
		<div>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>Index</td>
			<td>이름</td>
			<td>Type</td>
			<td>재고</td>
			<td>상태</td>
			<br/>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td><a href="content_view?id=${dto.id}">${dto.name}</a></td>
			<td>${dto.type}</td>
			<td>${dto.count}</td>
			<td>${dto.statute}</td>
			<br/>
		</tr>
		</c:forEach>
		</table>
		</div>
</body>
</html>
