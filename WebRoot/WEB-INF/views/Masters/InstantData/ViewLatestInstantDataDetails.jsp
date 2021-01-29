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
												<h1>Instant Latest Data </h1> </div>
											<div class="col-sm-6">
												<ol class="breadcrumb float-sm-right">
													<li class="breadcrumb-item"><a href="#">Home</a> </li>
													<li class="breadcrumb-item active">Instant Data Latest</li>
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
												<h3 class="card-title">Instant Latest Data Information</h3>
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
												<h3 class="card-title">Instant Latest Data Details</h3>
												<div class="card-tools">
													<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
												</div>
											</div>
											<div class="card-body">
												<table id="example1" style="width: 100% !important;display: inline-table;"
													 class="table table-responsive">
													<thead>
														<tr>
															<th>S.No</th>
															<th>Meter Number</th>
															<th>Meter Date Time</th>
															<th>intervalNo</th>
															<th>Active Energy</th>
															<th>Active Energy Import</th>
															<th>Active Energy Import L1</th>
															<th>Active Energy Import L2</th>
															<th>Active Energy Import L3</th>
															<th>Active Energy Import T1</th>
															<th>Active Energy Import T2</th>
															<th>Active Energy Import T3</th>
															<th>Active Energy Import T4</th>
															<th>Active Energy Import T5</th>
															<th>Active Energy Import T6</th>
															<th>Active Energy Import T7</th>
															<th>Active Energy Import T8</th>
															<th>Active Energy Export</th>
															<th>Active Energy Export L1</th>
															<th>Active Energy Export L2</th>
															<th>Active Energy Export L3</th>
															<th>Active Energy Export T1</th>
															<th>Active Energy Export T2</th>
															<th>Active Energy Export T3</th>
															<th>Active Energy Export T4</th>
															<th>Active Energy Export T5</th>
															<th>Active Energy Export T6</th>
															<th>Active Energy Export T7</th>
															<th>Active Energy Export T8</th>
															<th>Active Energy CombinedTotal</th> 
															<th>Active Energy CombinedTotal T1</th> 
															<th>Active Energy CombinedTotal T2</th> 
															<th>Active Energy CombinedTotal T3</th> 
															<th>Active Energy CombinedTotal T4</th> 
															<th>Active Energy CombinedTotal T5</th> 
															<th>Active Energy CombinedTotal T6</th> 
															<th>Active Energy CombinedTotal T7</th> 
															<th>Active Energy CombinedTotal T8</th> 
															<th>Active Energy NetTotal</th> 
															<th>Active Energy NetTotal T1</th> 
															<th>Active Energy NetTotal T2</th> 
															<th>Active Energy NetTotal T3</th> 
															<th>Active Energy NetTotal T4</th> 
															<th>Active Energy NetTotal T5</th> 
															<th>Active Energy NetTotal T6</th> 
															<th>Active Energy NetTotal T7</th> 
															<th>Active Energy NetTotal T8</th> 
															<th>Reactive Energy </th> 
															<th>Reactive Energy Import </th> 
															<th>Reactive Energy Export </th> 
															<th>Reactive Energy Q1</th> 
															<th>Reactive Energy Q2</th> 
															<th>Reactive Energy Q3</th> 
															<th>Reactive Energy Q4</th> 
															<th>Apparent Energy </th> 
															<th>Apparent Energy Import </th> 
															<th>Apparent Energy Import T1</th> 
															<th>Apparent Energy Import T2</th> 
															<th>Apparent Energy Import T3</th> 
															<th>Apparent Energy Import T4</th> 
															<th>Apparent Energy Import T5</th> 
															<th>Apparent Energy Import T6</th> 
															<th>Apparent Energy Import T7</th> 
															<th>Apparent Energy Import T8</th>
															<!-- <th>apparentEnergyExport</th>
															<th>apparentEnergyExportT1</th>
															<th>apparentEnergyExportT2</th>
															<th>apparentEnergyExportT3</th>
															<th>apparentEnergyExportT4</th>
															<th>apparentEnergyExportT5</th>
															<th>apparentEnergyExportT6</th>
															<th>apparentEnergyExportT7</th>
															<th>apparentEnergyExportT8</th>
															<th>activePowerImport</th>
															<th>activePowerImportL1</th>
															<th>activePowerImportL2</th>
															<th>activePowerImportL3</th>
															<th>activePowerExport</th>
															<th>activePowerExportL1</th>
															<th>activePowerExportL2</th>
															<th>activePowerExportL3</th>
															<th>reactivePower</th>
															<th>reactivePowerImport</th>
															<th>reactivePowerImportL1</th>
															<th>reactivePowerImportL2</th>
															<th>reactivePowerImportL3</th>
															<th>reactivePowerExport</th>
															<th>reactivePowerExportL1</th>
															<th>reactivePowerExportL2</th>
															<th>reactivePowerExportL3</th>
															<th>apparentPower</th>
															<th>apparentPowerImport</th>
															<th>apparentPowerImportL1</th>
															<th>apparentPowerImportL2</th>
															<th>apparentPowerImportL3</th>
															<th>apparentPowerExport</th>
															<th>apparentPowerExportL1</th>
															<th>apparentPowerExportL2</th>
															<th>apparentPowerExportL3</th>
															<th>powerFactor</th>
															<th>powerFactorL1</th>
															<th>powerFactorL2</th>
															<th>powerFactorL3</th>
															<th>phaseAngle</th>
															<th>phaseAngleL1</th>
															<th>phaseAngleL2</th>
															<th>phaseAngleL3</th>
															<th>voltage</th>
															<th>voltageL1</th>
															<th>voltageL2</th>
															<th>voltageL3</th>
															<th>current</th>
															<th>currentL1</th>
															<th>currentL2</th>
															<th>currentL3</th>
															<th>ampereHoursInAbsenceOfVoltageL1</th>
															<th>ampereHoursInAbsenceOfVoltageL2</th>
															<th>ampereHoursInAbsenceOfVoltageL3</th>
															<th>activeDemand</th>
															<th>activeDemandImport</th>
															<th>activeDemandImportOccTime</th>
															<th>activeDemandExport</th>
															<th>activeDemandExportOccTime</th>
															<th>apparentDemand</th>
															<th>apparentDemandImport</th>
															<th>apparentDemandImportOccTime</th>
															<th>apparentDemandExport</th>
															<th>apparentDemandExportOccTime</th> -->
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
								"sAjaxSource": "fetchLatestInstantDataDetails?" + url,
								"aoColumns": [
						         	{
							                 "mData": "id",
							                 "defaultContent" : "-",
							                 render: function (data, type, row, meta) {
							                 return meta.row + meta.settings._iDisplayStart + 1;
									    }
									},
									{ "mData": "meterNumber" ,  "defaultContent": "-"},
									{
									                 "mData": "meterDateTime",
									    			"render": function (data) {
									    			 if (data == null){ return '-'; }else{
									        		 var date = new Date(data);
									       			 var month = date.getMonth() + 1;
									       			 return (date.getDate() < 10 ? ("0"+date.getDate()) : date.getDate())+"-"+(month < 10 ? ("0"+month) : month) + "-" + date.getFullYear()+ "&nbsp;&nbsp;" 
									      +(date.getHours() < 10 ? ("0"+date.getHours()) : date.getHours())+ ":"
									      +(date.getMinutes() < 10 ? ("0"+date.getMinutes()) : date.getMinutes())+ ":"
									      +(date.getSeconds() < 10 ? ("0"+date.getSeconds()) : date.getSeconds());
									   }} },
									{ "mData": "intervalNo" ,  "defaultContent": "-"},
									{ "mData": "activeEnergy" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImport" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportL1" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportL2" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportL3" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT1" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT2" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT3" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT4" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT5" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT6" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT7" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyImportT8" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExport" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportL1" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportL2" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportL3" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT1" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT2" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT3" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT4" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT5" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT6" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT7" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyExportT8" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotal" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT1" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT2" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT3" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT4" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT5" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT6" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT7" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyCombinedTotalT8" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotal" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT1" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT2" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT3" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT4" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT5" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT6" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT7" ,  "defaultContent": "-"},
									{ "mData": "activeEnergyNetTotalT8" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergy" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyImport" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyExport" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyQ1" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyQ2" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyQ3" ,  "defaultContent": "-"},
									{ "mData": "reactiveEnergyQ4" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergy" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImport" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT1" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT2" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT3" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT4" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT5" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT6" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT7" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyImportT8" ,  "defaultContent": "-"},
									/* { "mData": "apparentEnergyExport" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT1" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT2" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT3" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT4" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT5" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT6" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT7" ,  "defaultContent": "-"},
									{ "mData": "apparentEnergyExportT8" ,  "defaultContent": "-"},
									{ "mData": "activePowerImport" ,  "defaultContent": "-"},
									{ "mData": "activePowerImportL1" ,  "defaultContent": "-"},
									{ "mData": "activePowerImportL2" ,  "defaultContent": "-"},
									{ "mData": "activePowerImportL3" ,  "defaultContent": "-"},
									{ "mData": "activePowerExport" ,  "defaultContent": "-"},
									{ "mData": "activePowerExportL1" ,  "defaultContent": "-"},
									{ "mData": "activePowerExportL2" ,  "defaultContent": "-"},
									{ "mData": "activePowerExportL3" ,  "defaultContent": "-"},
									{ "mData": "reactivePower" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerImport" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerImportL1" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerImportL2" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerImportL3" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerExport" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerExportL1" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerExportL2" ,  "defaultContent": "-"},
									{ "mData": "reactivePowerExportL3" ,  "defaultContent": "-"},
									{ "mData": "apparentPower" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerImport" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerImportL1" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerImportL2" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerImportL3" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerExport" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerExportL1" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerExportL2" ,  "defaultContent": "-"},
									{ "mData": "apparentPowerExportL3" ,  "defaultContent": "-"},
									{ "mData": "powerFactor" ,  "defaultContent": "-"},
									{ "mData": "powerFactorL1" ,  "defaultContent": "-"},
									{ "mData": "powerFactorL2" ,  "defaultContent": "-"},
									{ "mData": "powerFactorL3" ,  "defaultContent": "-"},
									{ "mData": "phaseAngle" ,  "defaultContent": "-"},
									{ "mData": "phaseAngleL1" ,  "defaultContent": "-"},
									{ "mData": "phaseAngleL2" ,  "defaultContent": "-"},
									{ "mData": "phaseAngleL3" ,  "defaultContent": "-"},
									{ "mData": "voltage" ,  "defaultContent": "-"},
									{ "mData": "voltageL1" ,  "defaultContent": "-"},
									{ "mData": "voltageL2" ,  "defaultContent": "-"},
									{ "mData": "voltageL3" ,  "defaultContent": "-"},
									{ "mData": "current" ,  "defaultContent": "-"},
									{ "mData": "currentL1" ,  "defaultContent": "-"},
									{ "mData": "currentL2" ,  "defaultContent": "-"},
									{ "mData": "currentL3" ,  "defaultContent": "-"},
									{ "mData": "ampereHoursInAbsenceOfVoltageL1" ,  "defaultContent": "-"},
									{ "mData": "ampereHoursInAbsenceOfVoltageL2" ,  "defaultContent": "-"},
									{ "mData": "ampereHoursInAbsenceOfVoltageL3" ,  "defaultContent": "-"},
									{ "mData": "activeDemand" ,  "defaultContent": "-"},
									{ "mData": "activeDemandImport" ,  "defaultContent": "-"},
									{ "mData": "activeDemandImportOccTime" ,  "defaultContent": "-"},
									{ "mData": "activeDemandExport" ,  "defaultContent": "-"},
									{ "mData": "activeDemandExportOccTime" ,  "defaultContent": "-"},
									{ "mData": "apparentDemand" ,  "defaultContent": "-"},
									{ "mData": "apparentDemandImport" ,  "defaultContent": "-"},
									{ "mData": "apparentDemandImportOccTime" ,  "defaultContent": "-"},
									{ "mData": "apparentDemandExport" ,  "defaultContent": "-"},
									{ "mData": "apparentDemandExportOccTime" ,  "defaultContent": "-"}, */
								]
							});
						}
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