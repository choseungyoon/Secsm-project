<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<html>
	<head>
		<!-- Encoding -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<jsp:include page="base/header.jsp" flush="false" />
		<link rel='stylesheet' href='./resources/fullcalendar/fullcalendar.css' />
		<script src='./resources/fullcalendar/lib/jquery.min.js'></script>
		<script src='./resources/fullcalendar/lib/moment.min.js'></script>
		<script src='./resources/fullcalendar/fullcalendar.js'></script>
    	<title>Duty</title>
    	<script type="text/javascript">
    	
	    	$(document).ready(function() {
	
	    	    // page is now ready, initialize the calendar...
	
	    	    $('#calendar').fullCalendar({
	    	        // put your options and callbacks here
	    	    })
	
	    	});
	    	
    	</script>
	</head>
	<jsp:include page="base/nav.jsp" flush="true" />
	<body>

		<div class="container body-content" style="margin-top: 150px">
			<div class="row-fluid">
				<h1> 당직 </h1>
			</div>
			
			<div>
				<div id='calendar'></div>
			</div>
			
			<jsp:include page="base/foot.jsp" flush="false" />
		</div>	


</body>
</html>
