<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
				<!DOCTYPE html>
				<html lang="en">

				<head>
					<meta charset="utf-8">
					<meta name="viewport" content="width=device-width, initial-scale=1">
					<title>AdminLTE 3 | DataTables</title>
					<!-- Google Font: Source Sans Pro -->
					<link rel="stylesheet" href="fonts/sourceSans">
					<!-- Font Awesome -->
					<link rel="stylesheet" href="fonts/fontawesome-free/css/all.min.css">
					<!-- DataTables -->
					<link rel="stylesheet"
						href="datatables/datatables-bs4/css/dataTables.bootstrap4.min.css">
					<link rel="stylesheet"
						href="datatables/datatables-responsive/css/responsive.bootstrap4.min.css">
					<link rel="stylesheet"
						href="datatables/datatables-buttons/css/buttons.bootstrap4.min.css">
					<link rel="stylesheet" href="plugins/select2/css/select2.min.css">
					<link rel="stylesheet"
						href="plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
					<!-- Theme style -->
					<link rel="stylesheet" href="dist/css/adminlte.min.css">
					<script src="plugins/jquery/jquery.min.js"></script>
					<link rel="stylesheet" href="css/styles.css">
					<script src="js/validation.js"></script>
					<link href="css/date-picker/datapicker/datepicker3.css" rel="stylesheet">
					<link href="css/date-picker/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
<style type="text/css">
.dropdown-menu{
	overflow-y: scroll;
	height: 300px;
}
</style>
				<body class="hold-transition sidebar-mini">
					<div class="wrapper">
						<%@ include file="/WEB-INF/views/common/header.jsp"%>
							<!-- Content Wrapper. Contains page content -->
							<div class="content-wrapper">
								<!-- Content Header (Page header) -->
								<section class="content-header">
									<div class="container-fluid">
										<div class="row mb-2">
											<div class="col-sm-6">
												<h1>Instant Data</h1> </div>
											<div class="col-sm-6">
												<ol class="breadcrumb float-sm-right">
													<li class="breadcrumb-item"><a href="#">Home</a> </li>
													<li class="breadcrumb-item active">Instant Data</li>
												</ol>
											</div>
										</div>
									</div>
									<!-- /.container-fluid -->
								</section>
								<section class="content">
									<div class="container-fluid">
										<!-- SELECT2 EXAMPLE -->
										<div class="card card-default">
											<div class="card-header">
												<h3 class="card-title">Instant Data Information</h3>
												<div class="card-tools">
													<button type="button" class="btn btn-tool"
														data-card-widget="collapse">
														<i class="fas fa-minus"></i>
													</button>
					
												</div>
											</div>
					
											<div class="card-body">
												<form:form>
													<div class="row">
														<%@ include
															file="/WEB-INF/views/HierarchyLevels/HierarchyLevels.jsp"%>
													</div>
													</form:form>
												<div class="row">
													<div class="col-md-3">
														<div class="form-group">
															<label>From Date</label>
															<div class="input-group date" id="data_1">
																<div class="input-group date">
																	<span class="input-group-addon"><i
																		class="fa fa-calendar"></i> </span>
					
																	<form:input class="form-control" type="text" id="fromDate"
																		path="command.fromDate" readonly="true"></form:input>
																</div>
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>To Date</label>
															<div class="input-group date" id="data_1">
																<div class="input-group date">
																	<span class="input-group-addon"><i
																		class="fa fa-calendar"></i> </span>
					
																	<form:input class="form-control" type="text" id="toDate"
																		path="command.toDate" readonly="true"></form:input>
																</div>
															</div>
														</div>
					
					
													</div>
													<div class="col-md-1">
														<div class="form-group">
															<div class="" style="margin-top: 32px;">
																<button type="submit" class="btn btn-success submitClass">View</button>
															</div>
														</div>
													</div>
													<div class="col-md-2">
													<div class="form-group">
														<div class="" style="margin-top: 35px;">
															<button type="button" class="btn btn-outline-primary btn-block btn-sm" data-toggle="modal" data-target="#myModal"><i class="fa fa-binoculars"></i>Search Critearia</button>
														</div>
														</div>
													</div>
												</div>
												
										</div>
										</div>
									</div>
								</section>
								<section class="content">
									<div class="container-fluid">
										<div class="card card-default">
											<div class="card-header">
												<h3 class="card-title">Instant Data Details</h3>
												<div class="card-tools">
													<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
												</div>
											</div>
											<div class="card-body">
												<%-- <div class="row col-sm-12">
													<div class="col-sm-6">
														<div class="form-group">
															<div class="select2-purple">
																<form:select path="command.colStr" class="select2 displayColumnsClass" multiple="multiple" data-placeholder="Select a Column" data-dropdown-css-class="select2-purple" style="width: 100%;">
																	<form:options items="${command.columnsMap}" /> </form:select>
															</div>
														</div>
													</div>
													<div class="col-sm-2">
														<div class="form-group">
															<button type="button" class="btn btn-outline-primary btn-block btn-sm" data-toggle="modal" data-target="#myModal"><i class="fa fa-binoculars"></i>Search Critearia</button>
														</div>
													</div>
													<div class="col-sm-2">
														<button type="button" class="btn btn-danger showColumnsClass"><i class="fa fa-retweet"></i>Re-Load</button>
													</div>
													<div class="col-sm-2"> </div>
												</div> --%>
												<table id="example1" style="width: 100% !important;display: inline-table;"
													 class="table table-responsive">
													<thead>
														<tr>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th colspan="3">VOLTAGE</th>
															<th colspan="3">CURRENT</th>
															<th colspan="4">POWER FACTOR</th>
															<th colspan="3">POWER</th>
															<th colspan="2" >ACTIVE ENERGY</th>
															<th colspan="2" >APPARENT ENERGY</th>
															<th colspan="2" >REACTIVE ENERGY EXPORT</th>
															<th colspan="2" >REACTIVE ENERGY IMPORT</th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															<th></th>
															
														</tr>
														<tr>
															<th>S.NO</th>
															<th>METER </th>
															<th>CONSUMER NAME </th>
															<th>CONSUMER NUMBER</th>
															<th>METER TIME</th>
															<th>NODE </th>
															<th>NODE TIME</th>
															<th>SEQ.NO</th>
															<th>R-PHASE</th><!-- VOLTAGES -->
															<th>Y-PHASE</th>
															<th>B-PHASE</th>
															<th>R-PHASE</th><!-- CURRENTS -->
															<th>Y-PHASE</th>
															<th>B-PHASE</th>
															<th>R-PHASE</th><!-- POWER FACTORS -->
															<th>Y-PHASE</th>
															<th>B-PHASE</th>
															<th>AVERAGE</th>
															<th>ACTIVE</th><!-- POWER -->
															<th>APPARENT</th>
															<th>REACTIVE</th>
															<th>IMPORT</th><!-- ACTIVE ENERGY -->
															<th>EXPORT</th>
															<th>IMPORT</th><!-- APPARENT ENERGY -->
															<th>EXPORT</th>
															<th>LEAD</th><!-- REACTIVE ENERGY EXPORT -->
															<th>LAG</th>
															<th>LAG</th><!-- REACTIVE ENERGY IMPORT -->
															<th>LEAD</th>
															<th>FREQ</th>
															<th>SIGNAL STRENGTH</th>
															<th>BATTERY STATUS</th>
															<th>Utility</th>
															<th>Utility Code</th>
															<th>Region</th>
															<th>Region Code</th>
															<th>Circle</th>
															<th>Circle Code</th>
															<th>Division</th>
															<th>Division Code</th>
															<th>Sub Division</th>
															<th>Sub Division Code</th>
															<th>Town</th>
															<th>Town Code</th>
															<th>Section</th>
															<th>Section Code</th>
															<th>Sub Station</th>
															<th>Sub Station Code</th>
															<th>Feeder</th>
															<th>Feeder Code</th>
														</tr>
													</thead>
												</table>
												<div id="myModal" class="modal fade" role="dialog" aria-hidden="true" style="display: none;">
													<div class="modal-dialog">
														<!-- Modal content-->
														<div class="modal-content" style="width: 830px;">
															<div class="modal-header">
																<h4 class="modal-title">Search Fields</h4> </div>
															<input type="hidden" class="countClass" dest="1">
															<div class="modal-body" id="searchMainId">
																<div class="row" id="startingROw">
																	<div class="col col-md-4">
																		<form:select class="form-control checkVar0 searchSelectVarClass1" path="command.searchSelectVar">
																			<form:option value="SELECT" selected="selected">Column</form:option>
																			<form:options items="${command.searchColumnsMap}" /> </form:select>
																	</div>
																	<div class="col col-md-4">
																		<form:select class="form-control checkVar0 conditionStrClass1" path="command.conditionStr">
																			<form:options items="${command.conditionListStr}" /> </form:select>
																	</div>
																	<div class="col col-md-3">
																		<input type="text" class="form-control checkVar0 searchParameterC1" name="command.searchParameter" value="${command.searchParameter}" autocomplete="off" ondrop="return false;"> </div>
																	<div class="col col-md-1">
																		<div class="btn-group" role="group" aria-label="operation">
																			<a class="btn btn-success btn-plus btn-sm" href="#"> <i class="fas fa-plus"> </i> </a>&nbsp;
																		</div>
																	</div>
																</div>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-success" data-dismiss="modal" data-i18n="modalClose">Close</button>
																<button type="submit" class="btn btn-warning submitClass" data-dismiss="modal" data-i18n="modalOkay">Search</button>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- /.card -->
									</div>
								</section>
								<!-- /.content -->
							</div>
							<!-- /.content-wrapper -->
							<%@ include file="/WEB-INF/views/common/footer.jsp"%>
								<!-- Control Sidebar -->
								<aside class="control-sidebar control-sidebar-dark">
									<!-- Control sidebar content goes here -->
								</aside>
								<!-- /.control-sidebar -->
					</div>
					<!-- ./wrapper -->
					
					<script src="js/datepicker/datapicker/bootstrap-datepicker.js"></script>
					<script src="js/datepicker/daterangepicker/daterangepicker.js"></script>
					<!-- jQuery -->
					
					<!-- Bootstrap 4 -->
					<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
					<!-- DataTables  & Plugins -->
					<script src="datatables/datatables/jquery.dataTables.min.js"></script>
					<script src="datatables/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
					<script
						src="datatables/datatables-responsive/js/dataTables.responsive.min.js"></script>
					<script
						src="datatables/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
					<script
						src="datatables/datatables-buttons/js/dataTables.buttons.min.js"></script>
					<script
						src="datatables/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
					<script src="datatables/jszip/jszip.min.js"></script>
					<script src="datatables/pdfmake/pdfmake.min.js"></script>
					<script src="datatables/pdfmake/vfs_fonts.js"></script>
					<script src="datatables/datatables-buttons/js/buttons.html5.min.js"></script>
					<script src="datatables/datatables-buttons/js/buttons.print.min.js"></script>
					<script src="datatables/datatables-buttons/js/buttons.colVis.min.js"></script>
					<!-- Select2 -->
					<script src="plugins/select2/js/select2.full.min.js"></script>
					<!-- AdminLTE App -->
					<script src="dist/js/adminlte.min.js"></script>
					<!-- AdminLTE for demo purposes -->
					<script src="dist/js/demo.js"></script>
					<!-- Page specific script -->
					<script type="text/javascript">
					$(document).ready(function() {
						$('.levelSelectClass').change(function() {
							var levelIdRef = $(this).attr('id');
							if(levelIdRef == "level1Id") {
								levelCount = 1;
							} else if(levelIdRef == "level2Id") {
								levelCount = 2;
							} else if(levelIdRef == "level3Id") {
								levelCount = 3;
							} else if(levelIdRef == "level4Id") {
								levelCount = 4;
							} else if(levelIdRef == "level5Id") {
								levelCount = 5;
							} else if(levelIdRef == "level6Id") {
								levelCount = 6;
							} else if(levelIdRef == "level7Id") {
								levelCount = 7;
							} else if(levelIdRef == "level8Id") {
								levelCount = 8;
							} else if(levelIdRef == "level9Id") {
								levelCount = 9;
							} else if(levelIdRef == "level10Id") {
								levelCount = 10;
							}
							var a = levelCount + 1;
							$('#level' + a + 'Id').find('option').each(function() {
								$('#level' + a + 'Id option[value="NEW LEVEL"]').hide();
							});
						});
					});
					</script>					

					<script>
						$('#data_1 .input-group.date').datepicker({
				                 todayBtn: "linked",
				                 keyboardNavigation: false,
				                 forceParse: false,
				                 calendarWeeks: true,
				                 autoclose: true,
				                 endDate: 'today',
				                 format : 'yyyy-mm-dd',
				             });
					</script>
					<script type="text/javascript">
					$(document).ready(function() {
						var hideColumns = "";
						var showColumns = "0";
						var url;
						url="level1Id="+$('.level1Class').find('option:selected').val()+"&"+
							"level2Id="+$('.level2Class').find('option:selected').val()+"&"+
							"level3Id="+$('.level3Class').find('option:selected').val()+"&"+
							"level4Id="+$('.level4Class').find('option:selected').val()+"&"+
							"level5Id="+$('.level5Class').find('option:selected').val()+"&"+
							"level6Id="+$('.level6Class').find('option:selected').val()+"&"+
							"level7Id="+$('.level7Class').find('option:selected').val()+"&"+
							"level8Id="+$('.level8Class').find('option:selected').val()+"&"+
							"level9Id="+$('.level9Class').find('option:selected').val()+"&"+
							"level10Id="+$('.level10Class').find('option:selected').val()+"&"+
							"level11Id="+$('.level11Class').find('option:selected').val()+"&"+
							"level12Id="+$('.level12Class').find('option:selected').val()+"&"+
							"level13Id="+$('.level13Class').find('option:selected').val()+"&"+
							"level14Id="+$('.level14Class').find('option:selected').val()+"&"+
							"level15Id="+$('.level15Class').find('option:selected').val()+"&"+
							"fromDate="+'${command.fromDate}'+"&"+
							"toDate="+'${command.toDate}'+"&"+
							"searchSelectVar=" + '${command.searchSelectVar}' + "&" + 
							"searchParameter=" + '${command.searchParameter}' + "&" +
							"conditionStr=" + '${command.conditionStr}';
// 							alert(url);
						loadDataTable(url);

						function loadDataTable(url) {
							var $table = $('#example1');
							var table = $table.DataTable({
								/* "responsive": true,
								"lengthChange": false,
								"scrollX": true,
								"autoWidth": true, */
								 dom: 'Bfrtip',
								"buttons": ["colvis"],
								"bServerSide": true,
						        "bProcessing": true,
						        "pageLength": 100,
						        "bJQueryUI": true,
						        "render": true,
						        "bDestroy": true,
						        "scrollX": true,
								/* "destroy": true,
								"bProcessing": true,
								"bServerSide": true,
								"sort": "position",
								"bStateSave": false,
								"iDisplayLength": 10,
								"iDisplayStart": 0, */
								"processing": true,
						        "language": {
						            'loadingRecords': '&nbsp;',
						            'processing': '<div class="fa fa-spinner fa-pulse fa-2x fa-fw"></div>'
						        },
								"fnDrawCallback": function() {},
								"sAjaxSource": "fetchInstantDataDetails?" + url,
								"aoColumns": [
						         	{
							                 "mData": "id",
							                 "defaultContent" : "-",
							                 render: function (data, type, row, meta) {
							                 return meta.row + meta.settings._iDisplayStart + 1;
									    }
									},
									{ "mData": "id.meterNumber" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.consumerName" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.consumerNumber" ,  "defaultContent": "-"},
									{
									                 "mData": "id.meterDateTime",
									    			"render": function (data) {
									    			 if (data == null){ return '-'; }else{
									        		 var date = new Date(data);
									       			 var month = date.getMonth() + 1;
									       			 return (date.getDate() < 10 ? ("0"+date.getDate()) : date.getDate())+"-"+(month < 10 ? ("0"+month) : month) + "-" + date.getFullYear()+ "&nbsp;&nbsp;" 
									      +(date.getHours() < 10 ? ("0"+date.getHours()) : date.getHours())+ ":"
									      +(date.getMinutes() < 10 ? ("0"+date.getMinutes()) : date.getMinutes())+ ":"
									      +(date.getSeconds() < 10 ? ("0"+date.getSeconds()) : date.getSeconds());
									   }} },
									   { "mData": "nodeNumber" ,  "defaultContent": "-"},
									{
									                 "mData": "gsmDateTime",
									    			"render": function (data) {
									    			 if (data == null){ return '-'; }else{
									        		 var date = new Date(data);
									       			 var month = date.getMonth() + 1;
									       			return (date.getDate() < 10 ? ("0"+date.getDate()) : date.getDate())+"-"+(month < 10 ? ("0"+month) : month) + "-" + date.getFullYear()+ "&nbsp;&nbsp;" 
									      +(date.getHours() < 10 ? ("0"+date.getHours()) : date.getHours())+ ":"
									      +(date.getMinutes() < 10 ? ("0"+date.getMinutes()) : date.getMinutes())+ ":"
									      +(date.getSeconds() < 10 ? ("0"+date.getSeconds()) : date.getSeconds());
									   } }},
									{ "mData": "sequenceNumber" ,  "defaultContent": "-"},
									{ "mData": "voltageRPhase" ,  "defaultContent": "-"},
									{ "mData": "voltageYPhase" ,  "defaultContent": "-"},
									{ "mData": "voltageBPhase" ,  "defaultContent": "-"},
									{ "mData": "currentRPhase" ,  "defaultContent": "-"},
									{ "mData": "currentYPhase" ,  "defaultContent": "-"},
									{ "mData": "currentBPhase" ,  "defaultContent": "-"},
									{ "mData": "rphasepf" ,  "defaultContent": "-"},
									{ "mData": "yphasepf" ,  "defaultContent": "-"},
									{ "mData": "bphasepf" ,  "defaultContent": "-"},
									{ "mData": "averagePf" ,  "defaultContent": "-"},
									{ "mData": "activePower" ,  "defaultContent": "-"},
									{ "mData": "apparentPower" ,  "defaultContent": "-"},
									{ "mData": "reactivePower" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImp" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExp" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImp" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExp" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyLeadExp" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyLagExp" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyLagImp" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyLeadImp" ,  "defaultContent": "-"},
									{ "mData": "frequency" ,  "defaultContent": "-"},
									{ "mData": "signalStrength" ,  "defaultContent": "-"},
									{ "mData": "batteryStatus" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level1Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level1Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level2Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level2Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level3Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level3Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level4Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level4Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level5Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level5Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level6Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level6Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level7Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level7Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level8Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level8Code" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level9Name" ,  "defaultContent": "-"},
									{ "mData": "meterMasterObj.level9Code" ,  "defaultContent": "-"},
								]
							});
						}
						/* $('.showColumnsClass').on('click', function(e) {
							e.preventDefault();
							hideColumns = "";       
							showColumns = "0";			  					//S.No,View,Edit and Delete columns
							var columns = $('.displayColumnsClass').val().toString();
							if(columns!=""){
								for(var i = 0; i < 50; i++) {					//Iterate Columns
									var x = i + 1;
									if(columns.split(",").includes(x+"")) {	
										showColumns = x + "," + showColumns;
									} else {
										hideColumns = x + "," + hideColumns;
									}
								}
							}
							hideColumns = hideColumns.slice(0, -1);
							loadDataTable(url, hideColumns, showColumns);
						}); */
						$('.submitClass').click(function() {
							validate = true;
							var searchParameter = "",
								searchSelectVar = "",
								conditionStr = "";
							$(".countClass").each(function() {
								var i = $(this).attr('dest');
								searchParameter = searchParameter + $('.searchParameterC' + i).val() + ",";
								searchSelectVar = searchSelectVar + $('.searchSelectVarClass' + i).val() + ",";
								conditionStr = conditionStr + $('.conditionStrClass' + i).val() + ",";
								$('.checkVar' + i).each(function() {
									$(this).css('border-color', '');
									if($(this).val() == "SELECT" || $(this).val() == '' || $(this).val() == '0') {
										var abc = $(this).val();
										validate = false;
										$(this).css('border-color', 'red');
									}
								});
							});
							searchParameter = searchParameter.slice(0, -1);
							searchSelectVar = searchSelectVar.slice(0, -1);
							conditionStr = conditionStr.slice(0, -1);
							if(validate) {
							url="level1Id="+$('.level1Class').find('option:selected').val()+"&"+
								"level2Id="+$('.level2Class').find('option:selected').val()+"&"+
								"level3Id="+$('.level3Class').find('option:selected').val()+"&"+
								"level4Id="+$('.level4Class').find('option:selected').val()+"&"+
								"level5Id="+$('.level5Class').find('option:selected').val()+"&"+
								"level6Id="+$('.level6Class').find('option:selected').val()+"&"+
								"level7Id="+$('.level7Class').find('option:selected').val()+"&"+
								"level8Id="+$('.level8Class').find('option:selected').val()+"&"+
								"level9Id="+$('.level9Class').find('option:selected').val()+"&"+
								"level10Id="+$('.level10Class').find('option:selected').val()+"&"+
								"level11Id="+$('.level11Class').find('option:selected').val()+"&"+
								"level12Id="+$('.level12Class').find('option:selected').val()+"&"+
								"level13Id="+$('.level13Class').find('option:selected').val()+"&"+
								"level14Id="+$('.level14Class').find('option:selected').val()+"&"+
								"level15Id="+$('.level15Class').find('option:selected').val()+"&"+
								"fromDate="+$('#fromDate').val()+"&"+
								"toDate="+$('#toDate').val()+"&"+
								"searchSelectVar=" + searchSelectVar + "&" +
								"searchParameter=" + searchParameter + "&" + 
								"conditionStr=" + conditionStr;
								loadDataTable(url);
								$("#myModal").modal("hide");
							}
						});
					});
					</script>
					<script type="text/javascript">
					$(function() {
						$('.select2').select2();
					});
					</script>
					<script type="text/javascript">
					$(document).ready(function() {
						var y = 1;
						var columnsList = '${command.searchColumnsMap}';
						var conditionsList = '${command.conditionListStr}';
						$('#searchMainId').on('click', '.btn-plus', function() {
							validate = true;
							var i;
							for(i = 0; i <= y; i++) {
								$('.checkVar' + i).each(function() {
									$(this).css('border-color', '');
									if($(this).val() == "SELECT" || $(this).val() == '' || $(this).val() == '0') {
										var abc = $(this).val();
										validate = false;
										$(this).css('border-color', 'red');
									}
								});
							}
							if(validate) {
								++y;
								var htmlContent = "<div class='row removeDiv" + y + "'><div class='col col-md-4 removeDiv" + y + "'>" + "<div><select name='searchSelectVar' id='listStr" + y + "' class='form-control checkVar" + y + " searchSelectVarClass" + y + "'>" + "<option value='SELECT'>Column</option></select></div></div><div class='col col-md-4 removeDiv" + y + "'>" + "<select name='conditionStr' id='conditionListStr" + y + "' class='form-control checkVar" + y + " conditionStrClass" + y + "'>" + "</select><input type='hidden' class='form-control countClass' dest=" + y + "></div>" + "<div class='col col-md-3 removeDiv" + y + "'><input type='text' class='form-control checkVar" + y + " searchParameterC" + y + "' name='searchParameter' autocomplete='off' onpaste='return false;' ondrop='return false;'>" + "</div><div class='col col-md-1 removeDiv" + y + "'><div class='btn-group' role='group' aria-label='operation'><button type='button' class='btn btn-success btn-sm btn-plus btn-secondary'>" + "<span class='fa-img'><i class='fa fa-plus'></i></span></button>&nbsp;" + "<button type='button' class='btn btn-danger btn-sm btn-minus btn-secondary' dest='" + y + "'><span class='fa-img'>" + "<i class='fa fa-minus'></i></span></button></div></div>" + "</div>";
								$("#searchMainId").append(htmlContent);
								var searchCols = new Array();
								searchCols = columnsList.split(", ");
								for(var i = 0; i < searchCols.length; i++) {
									var splitArr = searchCols[i].split("=");
									var key = splitArr[0].replace("{", "").replace("}", "");
									var value = splitArr[1].replace("{", "").replace("}", "");
									$("#listStr" + y).append('<option value="' + key + '">' + value + '</option>');
								}
								
								var conditionCols = new Array();
								conditionCols = conditionsList.split(", ");
								for(var i = 0; i < conditionCols.length; i++) {
									var splitArr = conditionCols[i];
									var val = splitArr.replace("[", "").replace("]", "");
									$("#conditionListStr" + y).append('<option value="' + val + '">' + val + '</option>');
								}
								
								var itemNo = 0;
								$(".countClass").each(function() {
									itemNo = itemNo + 1;
									$(this).val(itemNo);
								});
							}
						});
						$('#searchMainId').on('click', '.btn-minus', function() {
							var destId = $(this).attr('dest');
							$('.removeDiv' + destId).remove();
							var itemNo = 0;
							$(".countClass").each(function() {
								itemNo = itemNo + 1;
								$(this).val(itemNo);
							});
						});
					});
</script>
				</body>

				</html>