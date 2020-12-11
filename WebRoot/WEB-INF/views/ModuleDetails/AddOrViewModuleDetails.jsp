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
					<link rel="stylesheet" href="datatables/datatables-bs4/css/dataTables.bootstrap4.min.css">
					<link rel="stylesheet" href="datatables/datatables-responsive/css/responsive.bootstrap4.min.css">
					<link rel="stylesheet" href="datatables/datatables-buttons/css/buttons.bootstrap4.min.css">
					<link rel="stylesheet" href="plugins/select2/css/select2.min.css">
					<link rel="stylesheet" href="plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
					<!-- Theme style -->
					<link rel="stylesheet" href="dist/css/adminlte.min.css">
					<link rel="stylesheet" href="css/styles.css"> </head>

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
												<h1>Module Details</h1> </div>
											<div class="col-sm-6">
												<ol class="breadcrumb float-sm-right">
													<li class="breadcrumb-item"><a href="#">Home</a> </li>
													<li class="breadcrumb-item active">Module Details</li>
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
											<c:if test="${command.viewType=='Edit' || command.viewType==null || command.viewType==''}">
												<div class="card-header">
													<h3 class="card-title">Add / Update Module Details</h3>
													<div class="card-tools">
														<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
													</div>
												</div>
												<div class="card-body">
													<form:form action="saveOrUpdateModuleDetails">
														<div class="row">
															<div class="col-sm-12">
																<div class="col-sm-6">
																	<div class="form-group">
																		<label>Module Type Name</label>
																		<input type="text" name="id.moduleTypeName" value="${command.id.moduleTypeName}" class="form-control moduleNameClass" autocomplete="off" placeholder="Module Type Name" required="required"> </div>
																	<div class="form-group">
																		<label>Module Action</label>
																		<input type="text" name="id.moduleAction" value="${command.id.moduleAction}" class="form-control moduleActionClass" autocomplete="off" placeholder="Module Action" required="required"> </div>
																	<div class="form-group">
																		<label>Module Description</label>
																		<input type="text" name="moduledescription" value="${command.moduledescription}" class="form-control" autocomplete="off" placeholder="Module Description" required="required"> </div>
																</div>
															</div>
															<div class="form-group col-sm-12" style="text-align: center;">
																<button type="submit" class="btn btn-success">Save/Update</button>
																<button type="reset" class="btn btn-warning">Reset</button>
															</div>
														</div>
													</form:form>
												</div>
											</c:if>
											<c:if test="${command.viewType=='View'}">
												<div class="card-header">
													<h3 class="card-title">View Module Details</h3>
													<div class="card-tools">
														<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
													</div>
												</div>
												<!-- /.card-header -->
												<div class="card-body">
													<div class="row">
														<div class="col-sm-12">
															<div class="col-sm-6">
																<div class="form-group">
																	<label>Module Type Name : <c:out
																			value="${command.id.moduleTypeName}"></c:out> </label>
																</div>
																<div class="form-group">
																	<label>Module Action : <c:out
																			value="${command.id.moduleAction}"></c:out> </label>
																</div>
																<div class="form-group">
																	<label>Module Description : <c:out
																			value="${command.moduledescription}"></c:out> </label>
																</div>
															</div>
														</div>
													</div>
												</div>
											</c:if>
										</div>
									</div>
								</section>
								<!-- Main content -->
								<section class="content">
									<div class="container-fluid">
										<div class="card card-default">
											<div class="card-header">
												<h3 class="card-title">Module Master Details</h3>
												<div class="card-tools">
													<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
												</div>
											</div>
											<div class="card-body">
												<div class="row col-sm-12">
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
												</div>
												<table id="example1" class="table ">
													<thead>
														<tr>
															<th>S.No</th>
															<th>Module Type Name</th>
															<th>Module Action</th>
															<th>Module Description</th>
															<th>View</th>
															<th>Edit</th>
															<th>Delete</th>
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
					<!-- jQuery -->
					<script src="plugins/jquery/jquery.min.js"></script>
					<!-- Bootstrap 4 -->
					<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
					<!-- DataTables  & Plugins -->
					<script src="datatables/datatables/jquery.dataTables.min.js"></script>
					<script src="datatables/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
					<script src="datatables/datatables-responsive/js/dataTables.responsive.min.js"></script>
					<script src="datatables/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
					<script src="datatables/datatables-buttons/js/dataTables.buttons.min.js"></script>
					<script src="datatables/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
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
						var hideColumns = "";
						var showColumns = "0";
						var url;
						url = "id.moduleTypeName=" + '${command.id.moduleTypeName}' + "&" +"searchSelectVar=" + '${command.searchSelectVar}' + "&" + "searchParameter=" + '${command.searchParameter}' + "&" + "conditionStr=" + '${command.conditionStr}';
						loadDataTable(url, "", "");

						function loadDataTable(url, hideColumns, showColumns) {
							var $table = $('#example1');
							var table = $table.DataTable({
								"responsive": true,
								"lengthChange": false,
								"autoWidth": false,
								"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
								"destroy": true,
								"bProcessing": true,
								"bServerSide": true,
								"sort": "position",
								"bStateSave": false,
								"iDisplayLength": 10,
								"iDisplayStart": 0,
								"processing": true,
						        "language": {
						            'loadingRecords': '&nbsp;',
						            'processing': '<div class="fa fa-spinner fa-pulse fa-2x fa-fw"></div>'
						        },
								"fnDrawCallback": function() {},
								"sAjaxSource": "fetchModuleViewDetails?" + url,
								"aoColumns": [{
									"mData": "id",
									"defaultContent": "-",
									render: function(data, type, row, meta) {
										return meta.row + meta.settings._iDisplayStart + 1;
									}
								},{
									"mData": "id.moduleTypeName",
									"defaultContent": "-"
								}, {
									"mData": "id.moduleAction",
									"defaultContent": "-"
								}, {
									"mData": "moduledescription",
									"defaultContent": "-"
								}, {
									data: function(row, type, set) {
										return '<a class="btn btn-info btn-sm" onClick="submitMyForm(\'viewModuleDetails \',\'' + row.id.moduleTypeName + '\',\'' + row.id.moduleAction + '\',\'' + 'View' + '\')"><i class="fas fa-binoculars"></i></a>';
									}
								}, {
									data: function(row, type, set) {
										return ' <a class="btn btn-warning btn-sm" onClick="submitMyForm(\'viewModuleDetails \',\'' + row.id.moduleTypeName + '\',\'' + row.id.moduleAction + '\',\'' + 'Edit' + '\')"><i class="fas fa-pencil-alt"></i></a>';
									}
								}, {
									data: function(row, type, set) {
										return ' <a class="btn btn-danger btn-sm" onClick="submitMyForm(\'deleteModuleDetails \',\'' + row.id.moduleTypeName + '\',\'' + row.id.moduleAction + '\',\'\')"><i class="fas fa-trash"></i></a>';
									}
								}, ]
							});
							if(hideColumns != "") {
								table.columns(hideColumns).visible(false);
								table.columns(showColumns).visible(true);
							} else {
								table.columns(0, 1, 2, 3, 4, 5, 6).visible(true); //Total No.of columns
							}
						}
						$('.showColumnsClass').on('click', function(e) {
							e.preventDefault();
							hideColumns = "";       
							showColumns = "0,4,5,6";			  					//S.No,View,Edit and Delete columns
							var columns = $('.displayColumnsClass').val().toString();
							if(columns!=""){
								for(var i = 0; i < 4; i++) {					//Iterate Columns
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
						});
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
								url = "id.moduleTypeName=" + '${command.id.moduleTypeName}' + "&" +"searchSelectVar=" + searchSelectVar + "&" + "searchParameter=" + searchParameter + "&" + "conditionStr=" + conditionStr;
								loadDataTable(url, "", "");
								$("#myModal").modal("hide");
							}
						});
					});
					</script>
					<script type="text/javascript">
					function submitMyForm(action, moduleTypeName, moduleAction, viewType) {
						var proceed='false';
						if(viewType==""){
							if(confirm("Are you sure You want to delete this record?")){
							proceed='true';
							}
						}else{
							proceed='true';
						}
						if(proceed=='true'){
							$('<form method="post" id="myForm" action="' + action + '"><input type="hidden" name="id.moduleTypeName" value="' + moduleTypeName + '" /><input type="hidden" name="id.moduleAction" value="' + moduleAction + '" /><input type="hidden" name="viewType" value="' + viewType + '" /></form>').appendTo('body').submit();
						}
					}
					</script>
					<script type="text/javascript">
					$(document).ready(function() {
						if($(".moduleNameClass").val() == '') {
							$(".moduleNameClass").prop('readonly', false);
						} else {
							$(".moduleNameClass").prop('readonly', 'true');
						}
						if($(".moduleActionClass").val() == '') {
							$(".moduleActionClass").prop('readonly', false);
						} else {
							$(".moduleActionClass").prop('readonly', 'true');
						}
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