<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="com.secsm.info.ProjectInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf-8" %>

<html>
	<head>
		<!-- Encoding -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<jsp:include page="base/header.jsp" flush="false" />
    	<title>Project</title>
    	
    	<script type="text/javascript">
    	
    		// 프로젝트 등록 다이얼로그
    		function createProject(){
    			var param = "createProjectName" + "=" + $("#createProjectName").val() + "&" + 
			    			"createProjectSummary" + "=" + $("#createProjectSummary").val() + "&" + 
			    			"createProjectDiscription" + "=" + $("#createProjectDiscription").val() + "&" + 
			    			"createProjectPL" + "=" + $("#createProjectPL").val() + "&" + 
			    			"createProjectTeam" + "=" + $("#createProjectTeam").val() + "&" + 
			    			"createProjectStartDate" + "=" + $("#createProjectStartDate").val() + "&" + 
    						"createProjectEndDate" + "="+ $("#createProjectEndDate").val();
    			$.ajax({
    				url : "/api_createProject",
    				type : "POST",
    				data : param,
    				cache : false,
    				async : false,
    				dataType : "text",
    		
    				success : function(response) {								
    					if(response=='1')
    					{
    						loginsuccess();
    					}
    					else if(response=='0')
    					{
    						alert("이메일이 존재하지 않습니다.");
    					}
    					else if(response=='3')
    					{
    						alert("비밀번호가 틀렸습니다.");
    					}
    					else if(response=='email')
    					{
    						alert("이메일이 너무 깁니다.");
    					}
    					else if(response=='password')
    					{
    						alert("비밀번호가 너무 깁니다.");
    					}
    					else
    					{
    						return false;
    					}	
    					
    					//alert(check);
    				},
    				error : function(request, status, error) {
    					if (request.status != '0') {
    						alert("code : " + request.status + "\r\nmessage : " + request.reponseText + "\r\nerror : " + error);
    					}
    				}
    		
    			});
    		}
    	</script>
    	
	</head>

	<%
		ArrayList<ProjectInfo> projectList = (ArrayList<ProjectInfo>) request.getAttribute("projectList");
	%>

	<jsp:include page="base/nav.jsp" flush="true" />
	<body>

		<div class="container body-content" style="margin-top: 150px">
			<div class="row-fluid">
				<h1> Project </h1>
			</div>
			
			<div>
				<button type="button" class="btn" data-toggle="modal" data-target="#createProjectModal" style="margin: 5px;">프로젝트 등록</button>
			</div>
			
			<jsp:include page="base/foot.jsp" flush="false" />
		</div>	

		<!-- 프로젝트 생성 모달 -->
		<div class="modal fade" id="createProjectModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form name="createProjectForm" id="createProjectForm" action="/api_createProject">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="SignInModalLabel">프로젝트 등록</h4>
						</div>
						
						<div class="modal-body">
							<div class="form-group">
								<label for="createProjectName" cond="">프로젝트 명</label> 
								<input name="createProjectName" id="createProjectName" type="text" class="form-control" />
							</div>
							<div class="form-group">
								<label for="createProjectSummary" cond="">요약</label> 
								<input name="createProjectSummary" id="createProjectSummary" type="text" class="form-control"/>
							</div>
							<div class="form-group">
								<label for="createProjectDiscription" cond="">내용</label> 
								<input name="createProjectDiscription" id="createProjectDiscription" type="text" class="form-control"/>
							</div>
							<div class="form-group">
								<label for="createProjectPL" cond="">PL</label> 
								<input name="createProjectPL" id="createProjectPL" type="text" class="form-control"/>
							</div>
							<div class="form-group">
								<label for="createProjectTeam" cond="">팀원</label> 
								<input name="createProjectTeam" id="createProjectTeam" type="text" class="form-control"/>
							</div>
							<div class="form-group">
								<label for="createProjectStartDate" cond="">시작일</label> 
								<input name="createProjectStartDate" id="createProjectStartDate" type="text" class="form-control"/>
							</div>
							<div class="form-group">
								<label for="createProjectEndDate" cond="">완료일</label> 
								<input name="createProjectEndDate" id="createProjectEndDate" type="text" class="form-control"/>
							</div>
							
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-primary" onclick='createProject()'>등록</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
		</div>

</body>
</html>
