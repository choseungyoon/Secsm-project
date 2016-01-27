<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="com.secsm.info.EquipmentTypeInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<html>
	<head>
		<!-- Encoding -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<jsp:include page="base/header.jsp" flush="false" />
    	<title>Equipment</title>
    	
    	<script type="text/javascript">
    	
    		function showSearch(){
    			var divSearch = document.getElementById("divSearch");
    			var divRental = document.getElementById("divRental");
    			var divApply = document.getElementById("divApply");
    			
    			divSearch.style.display = "";
    			divRental.style.display = "none";
    			divApply.style.display = "none";

    		}
    		
    		function showRental(){
    			var divSearch = document.getElementById("divSearch");
    			var divRental = document.getElementById("divRental");
    			var divApply = document.getElementById("divApply");
    			
    			divSearch.style.display = "none";
    			divRental.style.display = "";
    			divApply.style.display = "none";
    		}
    		
    		function showApply(){
    			var divSearch = document.getElementById("divSearch");
    			var divRental = document.getElementById("divRental");
    			var divApply = document.getElementById("divApply");
    			
    			divSearch.style.display = "none";
    			divRental.style.display = "none";
    			divApply.style.display = "";
    		}
    	
    	</script>
    	
	</head>
	<jsp:include page="base/nav.jsp" flush="true" />
	<body>

		<div class="container body-content" style="margin-top: 150px">
			<div class="row-fluid">
				<h1> 장비 </h1>
			</div>
			
			<div class="row-fluid">
				<ul >
					<li role="presentation"><a role="menuitem" onclick="showSearch()">장비 검색</a></li>
					<li role="presentation"><a role="menuitem" onclick="showRental()">대여 및 반납</a></li>
					<li role="presentation"><a role="menuitem" onclick="showApply()">장비 요청</a></li>
				</ul>
			
			</div>
			
			<!-- 장비 검색 -->
			<div name="divSearch" id="divSearch" style="display: none;">
				장비 검색
			</div>
			
			<!-- 대여 및 반납 -->
			<div name="divRental" id="divRental" style="display: none;">
				대여 및 반납
				
				<div class="column-filter-widget">
					<select id="equipmentType">
						<option value="0">전체</option>
						<%
							@SuppressWarnings("unchecked")
							ArrayList<EquipmentTypeInfo> equipmentTypeList = (ArrayList<EquipmentTypeInfo>)request.getAttribute("equipmentTypeList");
							if(equipmentTypeList != null)
							{
								for(EquipmentTypeInfo equipmentType : equipmentTypeList)
								{
									if(equipmentType.getType() == 1)
										out.println("<option value=\"" + equipmentType.getId() + "\">" + equipmentType.getName() + "</option>");	
								}
							}
						%>
					</select>
				</div>
				
				<div class="column-filter-widget">
					<input type="text">
				</div>
				
			</div>
			
			<!-- 장비 요청 -->
			<div name="divApply" id="divApply" style="display: none;">
				장비 요청
			
			</div>
			
			<jsp:include page="base/foot.jsp" flush="false" />
		</div>	


</body>
</html>
