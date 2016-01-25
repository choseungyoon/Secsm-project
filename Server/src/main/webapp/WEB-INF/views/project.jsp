<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*, com.nero.models.*"%>
<%@ page pageEncoding="utf-8" %>

<html>
	<head>
		<!-- Encoding -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<!-- jQuery -->
		<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		
		<!-- DataTables -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.dataTables.css" />">
		<script type="text/javascript" charset="utf8" src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
		
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		
		<!-- <script type="text/javascript" src="<c:url value="/resources/js/bootstrap-select.js" />"></script> -->
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-select.js" />"></script>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-select.css" />">

		<link rel="shortcut icon" type="image/ico" href="http://www.sprymedia.co.uk/media/images/favicon.ico">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ColumnFilterWidgets.css" />">
		<script type="text/javascript" charset="utf8" src="<c:url value="/resources/js/ColumnFilterWidgets.js" />"></script>
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
   		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
		    
    	<title>Project</title>

	</head>
	<%
		@SuppressWarnings("unchecked")
		List<SprintLevel> sprintList = (List<SprintLevel>) request.getAttribute("sprintList");
	%>

	<body >
		<!-- 모달 출력시 배경 삭제용 div -->
		<div id="modalBackground" name="modalBackground" style="display:none; background: #333333; width: 100%; height: 5000px"></div>
		
	<div id="pvrContent">
		
		<!-- 상단 네비게이션바 -->
		<div class="container" style="height:40px; padding-bottom:3em; border-bottom-color:black; border-bottom-width:1px; border-bottom-style:solid; border-bottom-color:#495C6F;">
			<div class="navbar-header">
				<div class="navbar-inner" style="padding-top:10px; padding-botton:10px;">
					<a style="margin-top:-10px; margin-bottom:0; margin-right:10px; font-size:18pt; font-weight:bold;" href="${pageContext.request.contextPath}/" class="navbar-brand"><img alt="Home" src="${pageContext.request.contextPath}/resources/images/home.png"></a>
					<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/TCM" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">TC Management</font></a>
					<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/PVR" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">PVR</font></a>
					<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/Unfold" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">횡전개</font></a>
					<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/TCPerformance" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">TC Performance</font></a>
					<a style="margin-bottom:0; margin-right:20px; padding-bottom:2px; display:inline-block;" href="${pageContext.request.contextPath}/Admin" onmouseover="this.style.background='transparent';" onmouseout="this.style.background='transparent';"><font color="MidnightBlue" size="4">Admin</font></a>
				</div>
			</div>
		</div>

		<div class="container body-content">
			<div class="row-fluid">
				<h1> PVR </h1>
				<input id="userInfo" name="userInfo" style="display:none;" />
				<div class="pull-right" style="margin-bottom:1em;">
					<a id="popbutton" class="btn" data-toggle="modal" style="height:18px; padding-top:4px; border: 1px solid #ccc">Register</a>
				</div>
			</div>
	
			<div id="column-filter-widgets" class="column-filter-widgets">
				<div id="widget3" class="column-filter-widget">
					<select id="widget-3" class="widget-3" onchange="javascript:addTableColumn('widget3','widget-3');">
						<option value="-1">Product</option>
						<%
							@SuppressWarnings("unchecked")
							List<String> productNames = (List<String>)request.getAttribute("productNames");
							if(productNames!=null)
							{
								for(String productName : productNames)
								{
									out.println("<option value=\""+ productName + "\">" + productName + "</option>");	
								}
							}
						%>
					</select>
				</div>
				<div id="widget4" class="column-filter-widget">
					<select id="widget-4" class="widget-4" onchange="javascript:addTableColumn('widget4','widget-4');">
						<option value="-1">Customer</option>
						<%
							@SuppressWarnings("unchecked")
							List<String> customers = (List<String>)request.getAttribute("customers");
							if(customers!=null)
							{
								for(String customer : customers)
								{
									out.println("<option value=\""+ customer + "\">" + customer + "</option>");	
								}
							}
						%>
					</select>
				</div>
				<div id="widget5" class="column-filter-widget">
					<select id="widget-5" class="widget-5" onchange="javascript:addTableColumn('widget5','widget-5');">
						<option value="-1">Controller</option>
						<%
							@SuppressWarnings("unchecked")
							List<String> controllerNames = (List<String>)request.getAttribute("controllerNames");
							if(controllerNames!=null)
							{
								for(String controllerName : controllerNames)
								{
									out.println("<option value=\""+ controllerName + "\">" + controllerName + "</option>");	
								}
							}
						%>
					</select>
				</div>
				<div id="widget6" class="column-filter-widget">
					<select id="widget-6" class="widget-6" onchange="javascript:addTableColumn('widget6','widget-6');">
						<option value="-1">Density</option>
						<%
							@SuppressWarnings("unchecked")
							List<String> densitys = (List<String>)request.getAttribute("densitys");
							if(densitys !=null)
							{
								for(String density : densitys)
								{
									out.println("<option value=\""+ density + "\">" + density + "</option>");	
								}
							}
						%>
					</select>
				</div>
				<div id="widget7" class="column-filter-widget">
					<select id="widget-7" class="widget-7" onchange="javascript:addTableColumn('widget7','widget-7');">
						<option value="-1">Patch</option>
						<%
							@SuppressWarnings("unchecked")
							List<String> patchs = (List<String>)request.getAttribute("patchs");
							if(patchs!=null)
							{
								for(String patch: patchs)
								{
									out.println("<option value=\""+ patch + "\">" + patch + "</option>");	
								}
							}
						%>
					</select>
				</div>
				<div id="widget8" class="column-filter-widget">
					<select id="widget-8" class="widget-8" onchange="javascript:addTableColumn('widget8','widget-8');">
						<option value="-1">RC</option>
						<%
							@SuppressWarnings("unchecked")
							List<String> rcs = (List<String>)request.getAttribute("rcs");
							if(rcs!=null)
							{
								for(String product: rcs)
								{
									out.println("<option value=\""+ product + "\">" + product + "</option>");	
								}
							}
						%>
					</select>
				</div>
				<div id="widget9" class="column-filter-widget">
					<select id="widget-9" class="widget-9" onchange="javascript:addTableColumn('widget9','widget-9');">
						<option value="-1">Status</option>
						<%
							@SuppressWarnings("unchecked")
							List<String> statuss = (List<String>)request.getAttribute("statuss");
							if(statuss!=null)
							{
								for(String status: statuss)
								{
									out.println("<option value=\""+ status + "\">" + status + "</option>");	
								}
							}
						%>
					</select>
				</div>
			</div>
		 
			<br>
		
			<!-- Validation 메인 테이블 -->
	        <table id="PVRTable_id" class="display" cellspacing="0" cellpadding="0" style="font-size:11px;">
             	<thead>
                 	<tr>
	                	<th>No.</th>
	                	<th>Start</th>
	                	<th>End</th>
	                	<th>Product</th>
						<th>Customer</th>
	                	<th>Controller</th>
	                	<th>Density</th>
	                	<th>Patch</th>
	                	<th>RC</th>
	                	<th>Status</th>
            		</tr>
           		</thead>
           		<tbody>
        		</tbody>
        	</table>

        	<div id="footer" style="text-align:center; border-top-width:1px; border-top-color:lightgray; border-top-style:solid; margin-top:20px; padding-top:10px;">
        		<span style="font-size:10px;">
            		Samsung Software Membership &copy; Junghoon Kim 2015, Samsung Software Membership &copy; Junil Ju 2015
            	</span>
        	</div>
    	</div>
    </div>
    
    	<!-- Validation 등록 팝업 -->
		<form name="reg_pvr_form" id="reg_pvr_form" action="${pageContext.request.contextPath}/AddPVR" enctype="multipart/form-data" method="post">
			<div id="pvr_register" class="modal fade" style="display: none; width: 80%; margin-left: -40%;">
	   			<div class="modal-dialog" style="overflow-x: hidden;">
	      			<div class="modal-content">
	         			<!-- header -->
	         			<div class="modal-header">
	            			<h4 class="modal-title">Register PVR</h4>
	            			<!-- 연계 등록인지 여부, value가 -1이면 일반등록 아니라면 연계등록 -->
	            			<input type="text" id="reg_validation_link" name="reg_validation_link" value="-1" style="display: none">
	         			</div>
	         			<div class="modal-body" style="font-size: 16px; padding-right: 4em;">
				
							<div class="row-fluid">
								<div class="span7">
									<div class="span3">
	                           		<% 
	                           			if(sprintList != null)
	                           			{
	                           				if(sprintList.size() > 0)
	                           					out.print("<input id=\"sprint_first\" name=\"sprint_first\" type=text style=\"display: none;\" value=\"" + sprintList.get(0).getSprintLevel() + "\"/>");	
	                           			}
	                           		%>
	                  					<select class="selectpicker" id="addPVRCbSprint" name="addPVRCbSprint" style="width: 100%; height: 20px; line-height: 20px;" data-width="100%" onchange="setChangeTable1(this);">
	                     				<%
	                        				out.println("<option value=\"-1\">평가 계획</option>");
	                     					if(sprintList != null)
	                     					{
	                        					for (SprintLevel sprint : sprintList) 
	                        					{
	                         	  					out.println("<option value=\"" + sprint.getSprintLevel() + "\">"
	                            	    				+ sprint.getSprintLevel() + "</option>");
	                        					}
	                     					}
	                     				%>
	                  					</select>
	               					</div>
	               					<div class="span3">
	                  					<select class="selectpicker" id="addPVRCbProduct" name="addPVRCbProduct" style="width: 100%" data-width="100%" onchange="refreshSelectTag_Delimeter_1(this, 'addPVRCbController','addPVRCbController_temp');">
	                     				<%
	                        				out.println("<option value=\"-1\">Product</option>");
	                     					if(productList != null)
	                  						{
	                        					for (Product product : productList) 
	                        					{
	                           						out.println("<option value=\"" + product.getPk() + ":" + product.getProductName() + "\">"
	                                						+ product.getProductName() + "</option>");
	                        					}
	                  						}
	                     				%>
	                  					</select>
	                  					<select id="addPVRCbProduct_cascade" name="addPVRCbProduct_cascade" style="display:none;">
	                     				<%
	                        				out.println("<option value=\"-1\">Pk</option>");
	                     					if(productList != null)
	                  						{
	                        					for (Product product : productList) 
	                        					{
	                           						out.println("<option value=\"" + product.getPk() + "\">" + product.getPk() + "</option>");
	                        					}
	                  						}
	                     				%>
		                              	</select>
	               					</div>
	               
	               					<div class="span3">
	                  					<!-- 고객사 -->
	                					<select class="selectpicker" id="addPVRCbCustomer" name="addPVRCbCustomer" data-width="100%" style="width: 100%">
	                  					<%
	                  						out.println("<option value=\"-1\">Customer</option>");
	                 						if(customerList != null)
	               							{
	                    						for(Customer customer : customerList)
	                     						{
	                            					out.println("<option value=\""+ customer.getCustomer() + "\">" + customer.getCustomer() + "</option>");
	                     						}
	               		 					}
	                  					%>
	                  					</select>
	               					</div>
	               
									<div class="span3">
										<select class="selectpicker" id="addPVRCbController" name="addPVRCbController" data-width="100%" >
		                                	<option value="-1">Controller</option>
		                              	</select> 
		                              	<select id="addPVRCbController_temp" name="addPVRCbController_temp" style="display: none; width: 100%">
		                              	<%
		                             		if(controllerList != null)
		                           		 	{
		                                 		for(Controller controller: controllerList)
		                                 		{
			                                    	out.println("<option value=\""+ controller.getPkProduct() + ":" + controller.getControllerName() + "\">" + controller.getControllerName() + "</option>");   
		                                 		}
		                           		 	}
		                              	%>
		                              	</select>
		                           	</div>
								</div>
								<div class="span5">
									<div class="span4">
	                					<select class="selectpicker" id="addPVRCbDensity" name="addPVRCbDensity" data-width="100%" title="Density" multiple>
	                  					<%
	                 						if(densityList != null)
	               							{
	                    						for(Density density : densityList)
	                     						{
	                            					out.println("<option value=\""+ density.getDensity() + "\">" + density.getDensity() + "</option>");
	                     						}
	               		 					}
	                  					%>
	                  					</select>
	               					</div>
	               
	                    			<div class="span4">
	                      				<select class="selectpicker" id="addPVRCbPatch" name="addPVRCbPatch" data-width="100%" style="width: 100%">
	                         			<%
	                            			out.println("<option value=\"-1\">Patch Ver</option>");
	                         				if(patchList != null)
	                   		 				{
	                             				for(Patch patch : patchList)
	                         					{
	                                    			out.println("<option value=\""+ patch.getPatch() + "\">" + patch.getPatch() + "</option>");
	                         					}
	                   		 				}
	                         			%>
	                      				</select>
	                   				</div>
	                   				<div class="span4">
	                   	  				<!-- RC Ver<br/> -->
	                      				<select class="selectpicker" id="addPVRCbRc" name="addPVRCbRc" data-width="100%" style="width: 100%">
	                         			<%
	                           				out.println("<option value=\"-1\">RC Ver</option>");
	                         				if(RCList != null)
	                		 				{
	                             				for(RC rc : RCList)
	                      						{
	                                    			out.println("<option value=\""+ rc.getRC() + "\">" + rc.getRC() + "</option>");
	                      						}
	                		 				}
	                         			%>
	                    				</select>
	                				</div>
								</div>
							</div>
	            
	                        <div class="row-fluid" style="margin-top: 10px;">
	                   			<div class="span2">
									<input type="button" value="Test" style="width: 90px" onclick="visibleTogglePatch_Rc();" >
								</div>
								<div class="span5" name="add_patch_rc_div" id="add_patch_rc_div" style="display: none;">
									<input type="text" id="addPVR_text_patch_rc" value="" style="width: 100px; vertical-align:middle;" >
									<input type="button" value="입력" style="width: 90px; vertical-align:text-bottom" onclick="addPatchRc();">
								</div>
	                		</div>
							
							<hr />
							
							<div>
								<font size="5"><b>[Sprint-1(변경점)]</b></font>
								<br/><br/>
	                       		<div id="changingTable1">
	                   				<table class="table table-striped" id="codeReviewTable" name="codeReviewTable" style="width:100%;" align="center">
										<tr>
											<td align="center" width="15%" style="text-align:center;">Code Review</td>
											<td align="center" width="85%"><input type="text" id="regValidationCodereview" name="regValidationCodereview" style="width: 90%;" readonly="readonly"></td>
										</tr>
										<tr>
											<td align="center" valign="middle" style="text-align:center; height: auto;" colspan="2" >
												<textarea name="changingTableData" id="changingTableData" rows="10" cols="100" style="width:99%; height: 500px; display: none;"></textarea>
											</td>
										</tr>
									</table>
								</div>
								<hr/>
								<div id="reg_validation_sprint_id" style="height: auto;">
									<font size="5"><b>[Sprint-X]</b></font>>
								</div> 
								<br/>
								<div >
									<textarea name="pvrTableData" id="pvrTableData" rows="10" cols="100" style="width:99%; height:500px; display:none;"></textarea>
								</div>
	                		</div>
	                
	                		<hr />
	                
	                		<div>
	                   			<div class="span3">
	                      			<label>PVR</label>
		                            <input type="text" id="regPvrDate" name="regPvrDate" style="width: 70%;" >
	                   			</div>
	                   			<div class="span3">
	                      			<label>PRA</label>
	                          		<input type="text" id="regPraDate" name="regPraDate" style="width: 70%">
	                   			</div>
	                   			<div class="pull-right">
	                      			<div class="span3">
	                         			Attachment
	                         			<input type="file" id="addPVRFileAttachment" name="addPVRFileAttachment">                              
	                      			</div>
	                   			</div>
	                		</div>
	         			</div>
	         			<div class="modal-footer">
	            			<button type="button" class="btn btn-default" datpdya-dismiss="modal" name="add_testcase_save" value="Save" onclick="submitContents(this);">Save</button>
	            			<button type="button" class="btn btn-default" data-dismiss="modal" onclick="hideModalBg();">Close</button>
	         			</div>
	      			</div>
	   			</div>
			</div>
		</form>   <!-- 등록 팝업 끝 -->
    
	</body>
</html>
