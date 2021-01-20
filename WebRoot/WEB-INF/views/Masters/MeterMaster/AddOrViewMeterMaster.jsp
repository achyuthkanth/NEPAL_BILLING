<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
</head>
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
							<h1>Meter Master</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Meter Master</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
				<section class="content">
				<div class="container-fluid">
					<!-- SELECT2 EXAMPLE -->
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">Upload MeterMaster Excel file</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								
							</div>
						</div>
						<!-- /.card-header -->
							<div class="card-body">
							<form:form method="post" action="bulkMeterMasterUpload" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-12">
										
											<div id="information-part" class="content" role="tabpanel" aria-labelledby="information-part-trigger">
						                      <div class="form-group">
						                        <div class="input-group">
						                          <div class="custom-file">
						                            <input type="file" class="custom-file-input" name="MeterDataupload" id="exampleInputFile">
						                            <label class="custom-file-label" for="exampleInputFile">Choose file</label>
						                          </div>
						                        </div>
						                      </div>
						                    </div>
										
									</div>
								</div>
								<div class="form-group col-sm-12" style="text-align: center;">
									<button type="submit" class="btn btn-success">Upload
										MeterMaster</button>
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	<a href="exportMeterMasterReport"><img src="fonts/dnload.png" ></a>
								</div>
								</form:form>
							</div>
						</div>
				</div>
			</section>
			</section>
			<c:if test="${command.viewType=='Edit' || command.viewType==null}">
				<form:form action="saveMeterMasterDetails">
					<section class="content">
						<div class="container-fluid">
							<!-- SELECT2 EXAMPLE -->
							<div class="card card-default">
								<div class="card-header">
									<h3 class="card-title">Meter Master Information</h3>
									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse">
											<i class="fas fa-minus"></i>
										</button>

									</div>
								</div>
								<!-- 						/.card-header -->
								<div class="card-body">
									<div class="row">
										<%@ include
											file="/WEB-INF/views/HierarchyLevels/HierarchyLevels.jsp"%>
									</div>
									
									<div class="row">
									
										<div class="col-md-6">
										<c:if test="${command.viewType==null}">
											<div class="form-group">
												<label>Meter Number</label> <input type="text"
													required="required" name="meterNumber" class="form-control"
													value="${command.meterNumber}" placeholder="meter Number">
											</div>
											</c:if>
											<c:if test="${command.viewType=='Edit'}">
											<div class="form-group">
												<label>Meter Number</label> <input
													required="required" name="meterNumber" class="form-control"
													value="${command.meterNumber}"  readonly="readonly">
											</div>
											</c:if>
											
											<div class="form-group">
												<label>Meter Make</label> <input type="text"
													required="required" name="meterMake" class="form-control"
													value="${command.meterMake}" placeholder="Meter Make">
											</div>
											<div class="form-group">
												<label>Installation Type</label> <input type="text"
													required="required" name="installationType"
													class="form-control" value="${command.installationType}"
													placeholder="Installation Type">
											</div>
											<div class="form-group">
												<label>Installation Sub Type </label> <input type="text"
													name="installationSubType" class="form-control"
													value="${command.installationSubType}"
													placeholder="Installation Sub Typ">
											</div>
											<div class="form-group">
												<label>Identification Number </label> <input type="text"
													name="identificationNumber" class="form-control"
													value="${command.identificationNumber}"
													placeholder="Identification Number">
											</div>
											<div class="form-group">
												<label>Current Multiplier</label> <input type="text"
													name="currentMultiplier" class="form-control"
													value="${command.currentMultiplier}"
													placeholder="currentMultiplier">
											</div>
											<div class="form-group">
												<label>Sim Provider</label> <input type="text"
													name="simProvider" class="form-control"
													value="${command.simProvider}" placeholder="Sim Provider">
											</div>
											<div class="form-group">
												<label>Consumer Address</label> <input type="text"
													name="consumerAddress" class="form-control"
													value="${command.consumerAddress}"
													placeholder="Consumer Address">
											</div>

											<div class="form-group">
												<label>Consumer Name</label> <input type="text"
													name="consumerName" class="form-control"
													value="${command.consumerName}" placeholder="Consumer Name">
											</div>

											<div class="form-group">
												<label>Ip Address</label> <input type="text"
													name="ipAddress" class="form-control"
													value="${command.ipAddress}" placeholder="Ip Address">
											</div>

											<div class="form-group">
												<label>Feeder Code</label> <input type="text"
													name="feederCode" class="form-control"
													value="${command.feederCode}" placeholder="Feeder Code">
											</div>

											<div class="form-group">
												<label>Voltage Rating</label> <input type="text"
													name="voltageRating" class="form-control"
													value="${command.voltageRating}"
													placeholder="voltage Rating">
											</div>

											<div class="form-group">
												<label>Installation Id</label> <input type="text"
													name="installationId" class="form-control"
													value="${command.installationId}"
													placeholder="Installation Id">
											</div>

										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Connection Status</label> <input type="text"
													name="connectionStatus" class="form-control"
													value="${command.connectionStatus}"
													placeholder="Connection Status">
											</div>
											<div class="form-group">
												<label>Sim Number</label> <input type="text"
													name="simNumber" class="form-control"
													value="${command.simNumber}" placeholder="simNumber">
											</div>
											<div class="form-group">
												<label>Mdn Number </label> <input type="text"
													name="mdnNumber" class="form-control"
													value="${command.mdnNumber}" placeholder="mdnNumber">
											</div>
											<div class="form-group">
												<label>Modem Number </label> <input type="text"
													name="modemNumber" class="form-control"
													value="${command.modemNumber}" placeholder="Modem Number">
											</div>
											<div class="form-group">
												<label>Voltage Multiplier</label> <input type="text"
													name="voltageMultiplier" class="form-control"
													value="${command.voltageMultiplier}"
													placeholder="Voltage Multiplier">
											</div>
											<div class="form-group">
												<label>Energy Multiplier</label> <input type="text"
													name="energyMultiplier" class="form-control"
													value="${command.energyMultiplier}"
													placeholder="Energy Multiplier">
											</div>
											<div class="form-group">
												<label>Consumer Number</label> <input type="text"
													name="consumerNumber" class="form-control"
													value="${command.consumerNumber}"
													placeholder="Consumer Number">
											</div>

											<div class="form-group">
												<label>Account Id</label> <input type="text"
													name="accountId" class="form-control"
													value="${command.accountId}" placeholder="Account Id">
											</div>

											<div class="form-group">
												<label>Dt Code</label> <input type="text" name="dtCode"
													class="form-control" value="${command.dtCode}"
													placeholder="Dt Code">
											</div>

											<div class="form-group">
												<label>Substation Code</label> <input type="text"
													name="substationCode" class="form-control"
													value="${command.substationCode}"
													placeholder="Substation Code">
											</div>
											<div class="form-group">
												<label>Supply Direction</label> <input type="text"
													name="supplyDirection" class="form-control"
													value="${command.supplyDirection}"
													placeholder="Supply Direction">
											</div>
											<div class="form-group">
												<label>Rfd Node Number</label> <input type="text"
													name="rfdnodenumber" class="form-control"
													value="${command.rfdnodenumber}"
													placeholder="Rfd Node Number">
											</div>
											<c:if test="${command.viewType=='Edit'}">
											<div class="form-group">
												<label>Consumer Id</label> <input type="text"
													name="consumerId" class="form-control"
													value="${command.consumerId}"
													placeholder="Consumer Id" readonly="readonly">
											</div>
											</c:if>
											<c:if test="${command.viewType==null}">
											<div class="form-group">
												<label>Consumer Id</label> <input type="text"
													name="consumerId" class="form-control"
													value="${command.consumerId}"
													placeholder="Consumer Id" required="required">
											</div>
											</c:if>
										</div>

										<div class="form-group col-sm-12" style="text-align: center;">
											<button type="submit" class="btn btn-success">Save/Update</button>
											<button type="reset" class="btn btn-warning">Reset</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>

				</form:form>
			</c:if>

			<c:if test="${command.viewType=='View'}">
		<section class="content">
				<div class="container-fluid">
					<!-- SELECT2 EXAMPLE -->
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">Meter Master Information</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								
							</div>
						</div>
					
						<div class="card-body">
						<div class="row">
						<form:form>
								<div class="row">
										<%@ include
											file="/WEB-INF/views/HierarchyLevels/HierarchyLevels.jsp"%>
									</div>
						</form:form>
						<div class="col-md-6">
							<dl class="row">
							
								<dt class="col-sm-4">Meter Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Installation Type</dt>
								<dd class="col-sm-8">
									<c:out value="${command.installationType}"></c:out>
								</dd>
								<dt class="col-sm-4">Installation Sub Type</dt>
								<dd class="col-sm-8">
									<c:out value="${command.installationSubType}"></c:out>
								</dd>
								<dt class="col-sm-4">Identification Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.identificationNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Current Multiplier </dt>
								<dd class="col-sm-8">
									<c:out value="${command.currentMultiplier}"></c:out>
								</dd>
								<dt class="col-sm-4">Sim Provider</dt>
								<dd class="col-sm-8">
									<c:out value="${command.simProvider}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Address</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerAddress}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Name</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerName}"></c:out>
								</dd>
								<dt class="col-sm-4">Ip Address</dt>
								<dd class="col-sm-8">
									<c:out value="${command.ipAddress}"></c:out>
								</dd>
								<dt class="col-sm-4">Feeder Code</dt>
								<dd class="col-sm-8">
									<c:out value="${command.feederCode}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Voltage Rating</dt>
								<dd class="col-sm-8">
									<c:out value="${command.voltageRating}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Installation Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.installationId}"></c:out>
								</dd>
							</dl>
							</div>
						
							<div class="col-md-6">
							<dl class="row">
							
								<dt class="col-sm-4">Connection Status</dt>
								<dd class="col-sm-8">
									<c:out value="${command.connectionStatus}"></c:out>
								</dd>
								<dt class="col-sm-4">Sim Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.simNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Mdn Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.mdnNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Modem Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.modemNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Voltage Multiplier</dt>
								<dd class="col-sm-8">
									<c:out value="${command.voltageMultiplier}"></c:out>
								</dd>
								<dt class="col-sm-4">Energy Multiplier</dt>
								<dd class="col-sm-8">
									<c:out value="${command.energyMultiplier}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Address</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerAddress}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Name</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerName}"></c:out>
								</dd>
								<dt class="col-sm-4">Ip Address</dt>
								<dd class="col-sm-8">
									<c:out value="${command.ipAddress}"></c:out>
								</dd>
								<dt class="col-sm-4">Feeder Code</dt>
								<dd class="col-sm-8">
									<c:out value="${command.feederCode}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Voltage Rating</dt>
								<dd class="col-sm-8">
									<c:out value="${command.voltageRating}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Consumer Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerId}"></c:out>
								</dd>
							</dl>
							</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			
	</c:if>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">Meter Master Details</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>

							</div>
						</div>
						<div class="card-body">
							<div class="row col-sm-12">
								<div class="col-sm-6">
									<div class="form-group">
										<div class="select2-purple">
											<form:select path="command.colStr"
												class="select2 displayColumnsClass" multiple="multiple"
												data-placeholder="Select a Column"
												data-dropdown-css-class="select2-purple"
												style="width: 100%;">
												<form:options items="${command.columnsMap}" />
											</form:select>
										</div>
									</div>
								</div>
								<div class="col-sm-2">
									<div class="form-group">
										<button type="button"
											class="btn btn-outline-primary btn-block btn-sm"
											data-toggle="modal" data-target="#myModal">
											<i class="fa fa-binoculars"></i>Search Critearia
										</button>
									</div>
								</div>
								<div class="col-sm-2">
									<button type="button" class="btn btn-danger showColumnsClass">
										<i class="fa fa-retweet"></i>Re-Load
									</button>
								</div>
								<div class="col-sm-2"></div>
							</div>
							<table id="example1" class="table ">
								<thead>
									<tr>
										<th>S.No</th>
										
										<th>Meter Number</th>
										<th>Modem Number</th>
										<th>Meter Make</th>
										<th>Installation Type</th>
										<th>Installation SubType</th>
										<th>Identification Number</th>
										<th>Connection Status</th>
										<th>Sim Number</th>
										<th>MDN Number</th>
										<th>Voltage Multiplier</th>
										<th>Current Multiplier</th>
										<th>Energy Multiplier</th>
										<th>Installation Date</th>
										<th>Inserted Date</th>
										<th>Inserted User</th>
										<th>Sim Provider</th>
										<th>Consumer Number</th>
										<th>Consumer Address</th>
										<th>DT Code</th>
										<th>Feeder Code</th>
										<th>SubStation Code</th>
										<th>Voltage Rating</th>
										<th>Supply Direction</th>
										<th>Installation Id</th>
										<th>RFNode Number</th>
										<th>View</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
							</table>
							<div id="myModal" class="modal fade" role="dialog"
								aria-hidden="true" style="display: none;">
								<div class="modal-dialog">
									<!-- Modal content-->
									<div class="modal-content" style="width: 830px;">
										<div class="modal-header">
											<h4 class="modal-title">Search Fields</h4>
										</div>
										<input type="hidden" class="countClass" dest="1">
										<div class="modal-body" id="searchMainId">
											<div class="row" id="startingROw">
												<div class="col col-md-4">
													<form:select
														class="form-control checkVar0 searchSelectVarClass1"
														path="command.searchSelectVar">
														<form:option value="SELECT" selected="selected">Column</form:option>
														<form:options items="${command.searchColumnsMap}" />
													</form:select>
												</div>
												<div class="col col-md-4">
													<form:select
														class="form-control checkVar0 conditionStrClass1"
														path="command.conditionStr">
														<form:options items="${command.conditionListStr}" />
													</form:select>
												</div>
												<div class="col col-md-3">
													<input type="text"
														class="form-control checkVar0 searchParameterC1"
														name="command.searchParameter"
														value="${command.searchParameter}" autocomplete="off"
														ondrop="return false;">
												</div>
												<div class="col col-md-1">
													<div class="btn-group" role="group" aria-label="operation">
														<a class="btn btn-success btn-plus btn-sm" href="#"> <i
															class="fas fa-plus"> </i> </a>&nbsp;
													</div>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-success"
												data-dismiss="modal" data-i18n="modalClose">Close</button>
											<button type="submit" class="btn btn-warning submitClass"
												data-dismiss="modal" data-i18n="modalOkay">Search</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.card -->
				</div>
			</section>

			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

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
						url = "searchSelectVar=" + '${command.searchSelectVar}' + "&" + "searchParameter=" + '${command.searchParameter}' + "&" + "conditionStr=" + '${command.conditionStr}';
						loadDataTable(url, "", "");

						function loadDataTable(url, hideColumns, showColumns) {
// 							alert("hideColumns "+hideColumns);
// 							alert("showColumns "+showColumns);
							var $table = $('#example1');
							var table = $table.DataTable({
								/* "responsive": true,
								"lengthChange": false,
								"scrollX": true,
								"autoWidth": true, */
								"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
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
								"sAjaxSource": "fetchMeterMasterDetails?" + url,
								 "aoColumns": [
         	{
	                 "mData": "id",
	                 "defaultContent" : "-",
	                 render: function (data, type, row, meta) {
	                 return meta.row + meta.settings._iDisplayStart + 1;
			    }
			},
         	{ "mData": "meterNumber" ,  "defaultContent": "-"},
         	{ "mData": "modemNumber" ,  "defaultContent": "-"},
            { "mData": "meterMake" ,  "defaultContent": "-"},
            { "mData": "installationType" ,  "defaultContent": "-"},
            { "mData": "installationSubType" ,  "defaultContent": "-"},
            { "mData": "identificationNumber" ,  "defaultContent": "-"},
            { "mData": "connectionStatus" ,  "defaultContent": "-"},
            { "mData": "simNumber" ,  "defaultContent": "-"},
            { "mData": "mdnNumber" ,  "defaultContent": "-"},
            { "mData": "voltageMultiplier" ,  "defaultContent": "-"},
            { "mData": "currentMultiplier" ,  "defaultContent": "-"},
            { "mData": "energyMultiplier" ,  "defaultContent": "-"},
            {
                 "mData": "installationDate",
    			 "render": function (data) {
    			 if (data == null){ return '-'; }else{
        		 var date = new Date(data);
       			 var month = date.getMonth() + 1;
       			 return (date.getDate() < 10 ? ("0"+date.getDate()) : date.getDate())+"-"+(month < 10 ? ("0"+month) : month) + "-" + date.getFullYear()+ "&nbsp;&nbsp;" 
			      +(date.getHours() < 10 ? ("0"+date.getHours()) : date.getHours())+ ":"
			      +(date.getMinutes() < 10 ? ("0"+date.getMinutes()) : date.getMinutes())+ ":"
			      +(date.getSeconds() < 10 ? ("0"+date.getSeconds()) : date.getSeconds());
			   } }},
			   {
                 "mData": "insertedDate",
    			 "render": function (data) {
    			 if (data == null){ return '-'; }else{
        		 var date = new Date(data);
       			 var month = date.getMonth() + 1;
       			 return (date.getDate() < 10 ? ("0"+date.getDate()) : date.getDate())+"-"+(month < 10 ? ("0"+month) : month) + "-" + date.getFullYear()+ "&nbsp;&nbsp;" 
			      +(date.getHours() < 10 ? ("0"+date.getHours()) : date.getHours())+ ":"
			      +(date.getMinutes() < 10 ? ("0"+date.getMinutes()) : date.getMinutes())+ ":"
			      +(date.getSeconds() < 10 ? ("0"+date.getSeconds()) : date.getSeconds());
			   } }},
            
            { "mData": "insertedUser" ,  "defaultContent": "-"},
            { "mData": "simProvider" ,  "defaultContent": "-"},
            { "mData": "consumerNumber" ,  "defaultContent": "-"},
            { "mData": "consumerAddress" ,  "defaultContent": "-"},
            { "mData": "dtCode" ,  "defaultContent": "-"},
            { "mData": "feederCode" ,  "defaultContent": "-"},
            { "mData": "substationCode" ,  "defaultContent": "-"},
            { "mData": "voltageRating" ,  "defaultContent": "-"},
            { "mData": "supplyDirection" ,  "defaultContent": "-"},
            { "mData": "installationId" ,  "defaultContent": "-"},
            { "mData": "rfdnodenumber" ,  "defaultContent": "-"},
         	{
          		render: function (data, type, row)
                {
                return ' <a class="btn btn-info btn-sm" onClick="submitMyForm(\'editMeterMaster \',\'' + row.meterNumber + '\',\'' + 'View' + '\')"><i class="fas fa-binoculars"></i></a>';
                 }
            },
			{
          		render: function (data, type, row)
                {
                return ' <a class="btn btn-warning btn-sm" onClick="submitMyForm(\'editMeterMaster \',\'' + row.meterNumber + '\',\'' + 'Edit' + '\')"><i class="fas fa-pencil-alt"></i></a>';
                 }
            },
       		{
          		render: function (data, type, row){
         		return '<a class="fa fa-trash" onClick="submitMyForm(\'' + 'deleteMeterMaster' + '\',\'' + row.meterNumber + '\')"></a>';
         		}  
       		},
        ]
							});
							if(hideColumns != "") {
								table.columns(hideColumns).visible(false);
								table.columns(showColumns).visible(true);
							} else {
								table.columns(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28).visible(true);//Total No.of columns
							}
						}
						$('.showColumnsClass').on('click', function(e) {
							e.preventDefault();
							hideColumns = "";       
							showColumns = "0,26,27,28";			  	//S.No,View,Edit and Delete columns
							var columns = $('.displayColumnsClass').val().toString();
							if(columns!=""){
								for(var i = 0; i < 26; i++) {		//Iterate Columns
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
								url = "searchSelectVar=" + searchSelectVar + "&" + "searchParameter=" + searchParameter + "&" + "conditionStr=" + conditionStr;
								loadDataTable(url, "", "");
								$("#myModal").modal("hide");
							}
						});
					});
	</script>


	<script type="text/javascript">
		function submitMyForm(action, meterNumber, viewType) {
						$('<form method="post" action="' + action + '"><input type="hidden" name="meterNumber" value="' + meterNumber + '" /><input type="hidden" name="viewType" value="' + viewType + '" /></form>').appendTo('body').submit();
					}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
						if($(".applicationNameClass").val() == '') {
							$(".applicationNameClass").prop('readonly', false);
						} else {
							$(".applicationNameClass").prop('readonly', 'true');
						}
					});
	</script>
	<script type="text/javascript">
		$(function () {
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