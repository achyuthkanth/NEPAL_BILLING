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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
							<h1>Consumer Master</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Consumer Master</li>
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
							<h3 class="card-title">Upload Consumer Master Excel file</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								
							</div>
						</div>
						<!-- /.card-header -->
							<div class="card-body">
							<form:form method="post" action="bulkConsumerMasterUpload" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-12">
											<div id="information-part" class="content" role="tabpanel" aria-labelledby="information-part-trigger">
						                      <div class="form-group">
						                        <div class="input-group">
						                          <div class="custom-file">
						                            <input type="file" class="custom-file-input" name="ConsumerDataupload" id="exampleInputFile">
						                            <label class="custom-file-label" for="exampleInputFile">Choose file</label>
						                          </div>
						                        </div>
						                      </div>
						                    </div>
									</div>
								</div>
								<div class="form-group col-sm-12" style="text-align: center;">
									<button type="submit" class="btn btn-success">Upload
										ConsumerMaster</button>
								</div>
								</form:form>
							</div>
						</div>
				</div>
			</section>
			</section>
			<c:if test="${command.viewType=='Edit' || command.viewType==null}">
				<form:form action="saveConsumerMasterDetails">
					<section class="content">
						<div class="container-fluid">
							<!-- SELECT2 EXAMPLE -->
							<div class="card card-default">
								<div class="card-header">
									<h3 class="card-title">Consumer Master Information</h3>
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
									<div id="new">
										<div class="row">
									
										<div class="col-md-6">
											<div class="form-group">
												<label>Consumer Id</label> <input type="text"
													required="required" name="consumerId" class="form-control consumerIdClass"
													value="${command.consumerId}" placeholder="Consumer Id">
											</div>
											<div class="form-group">
												<label>Consumer Number</label> <input type="text"
													required="required" name="consumerNumber" class="form-control"
													value="${command.consumerNumber}" placeholder="Consumer Number">
											</div>
											<div class="form-group">
												<label>Consumer Address</label> <input type="text"
													required="required" name="consumerAddress"
													class="form-control" value="${command.consumerAddress}"
													placeholder="Consumer Address">
											</div>
											<div class="form-group">
												<label>Consumer Company Details </label> <input type="text"
													name="consumerCompanyDetails" class="form-control"
													value="${command.consumerCompanyDetails}"
													placeholder="Consumer Company Details">
											</div>
											<div class="form-group">
												<label>Email Address</label> <input type="text"
													name="emailAddress" class="form-control"
													value="${command.emailAddress}" placeholder="Email Address">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>Contact No </label> <input type="text"
													name="contactNo" class="form-control"
													value="${command.contactNo}"
													placeholder="Contact Number">
											</div>
											<div class="form-group">
												<label>Alternate Contact</label> <input type="text"
													name="alternateContact" class="form-control"
													value="${command.alternateContact}"
													placeholder="Alternate Contact">
											</div>
											<div class="form-group">
												<label>Identification Number</label> <input type="text"
													name="identificationNumber" class="form-control"
													value="${command.identificationNumber}"
													placeholder="Identification Number">
											</div>

											<div class="form-group">
												<label>Connection Status</label>
													<form:select path="connectionStatus" class="form-control">
														<form:option value="NONE" label="--Select Status--" />
														<form:options items="${command.statusList}"/>
													</form:select>
											</div>
										</div>
									</div>
									</div>
									<!-- <div id="content">
									</div> -->
									<%-- <c:if test="${command.viewType=='Edit'}">
									<c:forEach items="${command.csmMeterMasterList}"
																		var="author" varStatus="status">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
												<input type="hidden" class='sNoClass'>
														<input type="text" value="${author.id.meterNumber}" autocomplete="off"
														dest="${status.count}" onkeypress="mulSelFunction(this)" id="autoCompId${status.count}"
															class="form-control meterNumClass" placeholder="Select Meter Number"
															name="csmMeterMasterObj.id.meterNumber" id="statusListId"
															required="required">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
														<form:select path="csmMeterMasterObj.statusOfMeter"
															class="form-control">
															<c:set var="moduleValue" value="${author.statusOfMeter}" />
															<form:option value="${author.statusOfMeter}"></form:option>
															<c:forEach var="theUser"
																items="${command.statusList}">
																<c:choose>
																	<c:when test="${theUser eq moduleValue}">
																	</c:when>
																	<c:otherwise>
																		<form:option value="${theUser}"></form:option>
																	</c:otherwise>
																</c:choose>
															</c:forEach>
														</form:select>
												</div>
											</div>
												<div class="col-md-4">
													<div class="form-group">
														<input style="height: min-content;background: darkgray;"
															type="button" value="-" dest="${status.count}" onclick="removeRow(this)">
													</div>
												</div>
											</div>
									</c:forEach>
									</c:if> --%>
									
								 <c:if test="${command.viewType=='Edit' || command.viewType==null}">
									<div class="card-header">
										<h3 class="card-title">Add Meter</h3>
									</div>
									<input type="hidden" class="indexCountClass" dest="1">
										<div class="modal-body" id="addMeterMainId">
											<div class="row" id="startingROw">
											<c:choose>
												<c:when test="${fn:length(command.csmMeterMasterList) > 0}">
												<c:forEach items="${command.csmMeterMasterList}"
																		var="author" varStatus="status"> 
													<div class="col-md-4">
														<div class="form-group">
															<input type="hidden" class='indexCountClass'
																dest="${status.count}"> <input type="text"
																value="${author.id.meterNumber}" autocomplete="off"
																dest="${status.count}" onkeypress="mulSelFunction(this)"
																id="autoCompId${status.count}"
																class="form-control meterNumClass"
																placeholder="Select Meter Number"
																name="csmMeterMasterObj.id.meterNumber"
																id="statusListId" readonly>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<form:select path="csmMeterMasterObj.statusOfMeter"
																class="form-control">
																<c:set var="moduleValue" value="${author.statusOfMeter}" />
																<form:option value="${author.statusOfMeter}"></form:option>
																<c:forEach var="theUser" items="${command.statusList}">
																	<c:choose>
																		<c:when test="${theUser eq moduleValue}">
																		</c:when>
																		<c:otherwise>
																			<form:option value="${theUser}"></form:option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="col col-md-4">
														<div class="btn-group" role="group"
															aria-label="operation">
															<a class="btn btn-success btn-plus btn-sm"> <i
																class="fas fa-plus"> </i> </a>&nbsp;
														</div>
													</div>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<div class="col col-md-4">
														<div class="form-group">
															<input type="hidden" class='sNoClass'> <input
																type="text" value="${author.id.meterNumber}"
																autocomplete="off" dest="${status.count}"
																onkeypress="mulSelFunction(this)"
																id="autoCompId${status.count}"
																class="form-control meterNumClass"
																placeholder="Select Meter Number"
																name="csmMeterMasterObj.id.meterNumber"
																id="statusListId" required="required">
														</div>
													</div>
													<div class="col col-md-4">
														<div class="form-group">
															<form:select
																class="form-control checkVar0 conditionStrClass1"
																path="csmMeterMasterObj.statusOfMeter">
																<form:options items="${command.statusList}" />
															</form:select>
														</div>
													</div>
													<div class="col col-md-4">
														<div class="btn-group" role="group"
															aria-label="operation">
															<a class="btn btn-success btn-plus btn-sm"> <i
																class="fas fa-plus"> </i> </a>&nbsp;
														</div>
													</div>
													</c:otherwise>

											</c:choose>
											</div>
										</div>
										<%-- </c:forEach> --%>
									<!-- </div> -->
									<br>
										<div class="form-group col-sm-12" style="text-align: center;">
											<button type="submit" class="btn btn-success">Save/Update</button>
											<button type="reset" class="btn btn-warning">Reset</button>
										</div>
									</c:if>
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
							<h3 class="card-title">Consumer Master Information</h3>
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
						<div class="col-md-6">
							<dl class="row">
								<dt class="col-sm-4">Consumer Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerId}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Address</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerAddress}"></c:out>
								</dd>
								<dt class="col-sm-4">Email Address</dt>
								<dd class="col-sm-8">
									<c:out value="${command.emailAddress}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Company Details</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerCompanyDetails}"></c:out>
								</dd>
							</dl>
							</div>
							<div class="col-md-6">
							<dl class="row">
								<dt class="col-sm-4">Contact No </dt>
								<dd class="col-sm-8">
									<c:out value="${command.contactNo}"></c:out>
								</dd>
								<dt class="col-sm-4">Alternate Contact</dt>
								<dd class="col-sm-8">
									<c:out value="${command.alternateContact}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Identification Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.identificationNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Connection Status</dt>
								<dd class="col-sm-8">
									<c:out value="${command.connectionStatus}"></c:out>
								</dd>
							</dl>
							</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<section class="content">
				<div class="container-fluid">
					<!-- SELECT2 EXAMPLE -->
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">Consumer Meters Information</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								
							</div>
						</div>
					
						<div class="card-body">
						<div class="row">
						<c:forEach items="${command.csmMeterMasterList}"
																		var="author" varStatus="status">
						<div class="col-md-6">
							<dl class="row">
								<dt class="col-sm-4">Meter Number</dt>
								<dd class="col-sm-8">
									<c:out value="${author.id.meterNumber}"></c:out>
								</dd>
							</dl>
							</div>
							<div class="col-md-6">
							<dl class="row">
								<dt class="col-sm-4">Status Of Meter</dt>
								<dd class="col-sm-8">
									<c:out value="${author.statusOfMeter}"></c:out>
								</dd>
							</dl>
							</div>
							</c:forEach>
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
							<h3 class="card-title">Consumer Master Details</h3>
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
							<table id="example1" style="width: 100% !important;display: inline-table;"
													 class="table table-responsive">
								<thead>
									<tr>
										<th>S.No</th>
										<th>Consumer Id</th>
										<th>Consumer Number</th>
										<th>Consumer Address</th>
										<th>Consumer Company Details</th>
										<th>Contact No</th>
										<th>Alternate Contact</th>
										<th>Email Address</th>
										<th>Identification Number</th>
										<th>Connection Status</th>
										<th>Installation Date</th>
										<th>Inserted Date</th>
										<th>Inserted User</th>
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
								"sAjaxSource": "fetchConsumerMasterDetails?" + url,
								 "aoColumns": [
         	{
	                 "mData": "id",
	                 "defaultContent" : "-",
	                 render: function (data, type, row, meta) {
	                 return meta.row + meta.settings._iDisplayStart + 1;
			    }
			},
         	{ "mData": "consumerId" ,  "defaultContent": "-"},
         	{ "mData": "consumerNumber" ,  "defaultContent": "-"},
            { "mData": "consumerAddress" ,  "defaultContent": "-"},
            { "mData": "consumerCompanyDetails" ,  "defaultContent": "-"},
            { "mData": "contactNo" ,  "defaultContent": "-"},
            { "mData": "alternateContact" ,  "defaultContent": "-"},
            { "mData": "emailAddress" ,  "defaultContent": "-"},
            { "mData": "identificationNumber" ,  "defaultContent": "-"},
            { "mData": "connectionStatus" ,  "defaultContent": "-"},
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
         	{
          		render: function (data, type, row)
                {
                return ' <a class="btn btn-info btn-sm" onClick="submitMyForm(\'viewConsumerMaster \',\'' + row.consumerId + '\',\'' + 'View' + '\')"><i class="fas fa-binoculars"></i></a>';
                 }
            },
			{
          		render: function (data, type, row)
                {
                return ' <a class="btn btn-warning btn-sm" onClick="submitMyForm(\'viewConsumerMaster \',\'' + row.consumerId + '\',\'' + 'Edit' + '\')"><i class="fas fa-pencil-alt"></i></a>';
                 }
            },
       		{
          		render: function (data, type, row){
         		return '<a class="btn btn-danger btn-sm" onClick="submitMyForm(\'deleteConsumerMaster \',\'' + row.consumerId + '\',\'\')"><i class="fas fa-trash"></i></a>';
         		}  
       		},
        ]
							});
							if(hideColumns != "") {
								table.columns(hideColumns).visible(false);
								table.columns(showColumns).visible(true);
							} else {
								table.columns(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15).visible(true);//Total No.of columns
							}
						}
						$('.showColumnsClass').on('click', function(e) {
// 							e.preventDefault();
							hideColumns = "";       
							showColumns = "0,13,14,15";			  	//S.No,View,Edit and Delete columns
							var columns = $('.displayColumnsClass').val();
							if(columns!=null){
								columns = columns.toString();
							}else{
								columns = "";
							}
							if(columns!=""){
								for(var i = 0; i < 13; i++) {		//Iterate Columns
									var x = i + 1;
									if(columns.split(",").includes(x+"")) {	
										showColumns = x + "," + showColumns;
									} else {
										hideColumns = x + "," + hideColumns;
									}
								}
							}
// 							alert(hideColumns);
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
		function submitMyForm(action, consumerId, viewType) {
				var proceed='false';
						if(viewType==""){
							if(confirm("Are you sure You want to delete this record?")){
							proceed='true';
							}
						}else{
							proceed='true';
						}
						if(proceed=='true'){
						$('<form method="post" action="' + action + '"><input type="hidden" name="consumerId" value="' + consumerId + '" /><input type="hidden" name="viewType" value="' + viewType + '" /></form>').appendTo('body').submit();
						}
				}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
						if($(".consumerIdClass").val() == '') {
							$(".consumerIdClass").prop('readonly', false);
						} else {
							$(".consumerIdClass").prop('readonly', 'true');
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
<script type="text/javascript">
function mulSelFunction(e){

var destId = $(e).attr('dest');
// alert(destId);
	var list = '${command.meterNumbersList}';
		list = list.replace("[", "").replace("]", "");
		var xy = new Array();
		xy = list.split(", ");
		var arr = [];
		for ( var i = 0; i < xy.length; i++) {
			arr.push(xy[i]);
		}
			$("#autoCompId"+destId).autocomplete({
					      source: arr,
					      focus: function( event, ui ) {
					        return false;
					      },
					        select: function (event, ui) {
					        var str = "";
					        $(".meterNumClass").each(function(){
								 var abc=$(this).val();
						       	 if(ui.item.label==abc){
						       	 alert("Please select another Meter Number!!");
						       	 str = "true";
						       	 }
							});
					        
					        if(str == "true"){
				                $(this).parent().parent().find(".meterNumClass").val("");
				                return false;
					        }
					     }
		}); 
}
</script>

<script type="text/javascript">
		$(document).ready(function() {
						var y = 0;
						$('#addMeterMainId').on('click', '.btn-plus', function() {
							validate = true;
								$('.meterNumClass').each(function() {
									$(this).css('border-color', '');
									if($(this).val() == '' || $(this).val() == '0') {
										var abc = $(this).val();
										validate = false;
										$(this).css('border-color', 'red');
									}
								});
							if(validate) {
					           $( ".indexCountClass" ).each(function() {
					                       y=y+1;
					                       $(this).val(y);
					           });
							      var htmlContent = "<div class='row removeDiv" + y + "'><div class='col col-md-4 removeDiv" + y + "'><br>" + "<div><input type='text' required='required' name='csmMeterMasterObj.id.meterNumber' autocomplete='off' class='form-control meterNumClass' dest='"+y+"' onkeypress='mulSelFunction(this)' id='autoCompId"+y+"' placeholder='Select Meter Number'/></div></div><div class='col col-md-4 removeDiv" + y + "'><br>" + "<select name='csmMeterMasterObj.statusOfMeter' id='statusListStr" + y + "' class='form-control'></select><input type='hidden' class='form-control countClass' dest=" + y + "></div>" + "<div class='col col-md-4 removeDiv" + y + "'><br><div class='btn-group' role='group' aria-label='operation'><button type='button' class='btn btn-success btn-sm btn-plus btn-secondary'>" + "<span class='fa-img'><i class='fa fa-plus'></i></span></button>&nbsp;" + "<button type='button' class='btn btn-danger btn-sm btn-minus btn-secondary' dest='" + y + "'><span class='fa-img'>" + "<i class='fa fa-minus'></i></span></button></div></div>" + "</div>";
								$("#addMeterMainId").append(htmlContent);
								
								var statusList = '${command.statusList}';
			 					var statusCols = new Array();
								statusCols = statusList.split(", ");
								for(var i = 0; i < statusCols.length; i++) {
									var splitArr = statusCols[i];
									var val = splitArr.replace("[", "").replace("]", "");
									$("#statusListStr"+y).append('<option value="' + val + '">' + val + '</option>');
								}
								
								var itemNo = 0;
								$(".indexCountClass").each(function() {
									itemNo = itemNo + 1;
									$(this).val(itemNo);
								});
							}
						});
						$('#addMeterMainId').on('click', '.btn-minus', function() {
							var destId = $(this).attr('dest');
							$('.removeDiv' + destId).remove();
							var itemNo = 0;
							$(".indexCountClass").each(function() {
								itemNo = itemNo + 1;
								$(this).val(itemNo);
							});
						});
					});
</script>


</body>
</html>