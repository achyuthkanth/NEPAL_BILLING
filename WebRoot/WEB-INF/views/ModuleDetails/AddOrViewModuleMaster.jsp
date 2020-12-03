<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">



<!-- Theme style -->
<link rel="stylesheet" href="dist/css/adminlte.min.css">

<link rel="stylesheet" href="css/styles.css">


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
							<h1>Module Master</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a>
								</li>
								<li class="breadcrumb-item active">Module Master</li>
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

						<c:if test="${command.viewType=='Edit' || command.viewType==null}">
							<div class="card-header">
								<h3 class="card-title">Add / Update Module Master</h3>
								<div class="card-tools">
									<button type="button" class="btn btn-tool"
										data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>

								</div>
							</div>

							<div class="card-body">
								<form:form action="saveOrUpdateModuleMaster">
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label>Module Type Name</label> <input type="text"
													name="moduleTypeName" value="${command.moduleTypeName}"
													class="form-control moduleNameClass"
													placeholder="Module Type Name">
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Module Type Code</label> <input type="text"
													name="moduleTypeCode" value="${command.moduleTypeCode}"
													class="form-control" placeholder="Module Type Code">
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Module Description</label> <input type="text"
													name="moduleDescription"
													value="${command.moduleDescription}" class="form-control"
													placeholder="Module Description">
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
								<h3 class="card-title">View Module Master</h3>
								<div class="card-tools">
									<button type="button" class="btn btn-tool"
										data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>

								</div>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<form:form action="saveOrUpdateModuleMaster">

									<div class="row">
										<div class="col-sm-6">
											<label class="col-sm-5 col-xs-12">Module Type Name</label>
											<div class="col-sm-7 col-xs-12"
												style="color: blue;font-weight: bold;">
												<c:out value="${command.moduleTypeName}"></c:out>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Module Type Code</label>
												<div class="col-sm-7 col-xs-12"
													style="color: blue;font-weight: bold;">
													<c:out value="${command.moduleTypeCode}"></c:out>
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label>Module Description</label>
												<div class="col-sm-7 col-xs-12"
													style="color: blue;font-weight: bold;">
													<c:out value="${command.moduleDescription}"></c:out>
												</div>
											</div>
										</div>
									</div>

								</form:form>
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
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								
							</div>
						</div>
						<!-- 
					<div class="row">
						<div class="col-12">
							<div class="card card-secondary">
								<div class="card-header">
									<h3 class="card-title">Application Master Details</h3>
								</div> -->
								
								
								<div class="card-body">
									<div class="row col-sm-12" >
										<div class="col-sm-6" >
											<div class="form-group">
							                  <label>Select Columns</label>
							                  <div class="select2-purple">
							                    <select class="select2" multiple="multiple" data-placeholder="Select a State" data-dropdown-css-class="select2-purple" style="width: 100%;">
							                      <option>Alabama</option>
							                      <option>Alaska</option>
							                      <option>California</option>
							                      <option>Delaware</option>
							                      <option>Tennessee</option>
							                      <option>Texas</option>
							                      <option>Washington</option>
							                    </select>
							                  </div>
							                </div>
										</div>
										<div class="col-sm-4" >
										</div>
										<div class="col-sm-2" >
							                <div class="form-group">
							                	<button type="button" class="btn btn-outline-danger btn-block btn-sm" data-toggle="modal" data-target="#myModal"><i class="fa fa-binoculars"></i>Search Critearia</button>
								                  <!-- <button type="button" class="btn btn-primary pull-left btn-form-data" data-toggle="modal" data-target="#myModal" >Search Critearia</button> -->
							                </div>
							                
										</div>
									</div>
									
									<table id="example1" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>S.No</th>
												<th>Module Type Name</th>
												<th>Module Type Code</th>
												<th>Module Description</th>
												<th></th>
											</tr>
										</thead>
										<!-- <tbody>
											<tr>
												<td>Trident</td>
												<td>Internet Explorer 4.0</td>
												<td>Win 95+</td>
												<td>4</td>
												<td>X</td>
												<td  class="tableButtonTd"> <a class="btn btn-info btn-sm" href="#"> <i class="fas fa-binoculars"> </i>  </a>
												<a class="btn btn-warning btn-sm" href="#"> <i class="fas fa-pencil-alt"> </i>  </a>
												<a class="btn btn-danger btn-sm" href="#"> <i class="fas fa-trash"> </i>  </a></td>
											</tr>
											<tr>
												<td>Trident</td>
												<td>Internet Explorer 4.0</td>
												<td>Win 95+</td>
												<td>4</td>
												<td>X</td>
												<td  class="tableButtonTd"> <a class="btn btn-info btn-sm" href="#"> <i class="fas fa-binoculars"> </i> </a>
												<a class="btn btn-warning btn-sm" href="#"> <i class="fas fa-pencil-alt"> </i> </a>
												<a class="btn btn-danger btn-sm" href="#"> <i class="fas fa-trash"> </i> </a></td>
											</tr>
											<tr>
												<td>Trident</td>
												<td>Internet Explorer 4.0</td>
												<td>Win 95+</td>
												<td>4</td>
												<td>X</td>
												<td class="tableButtonTd"> <a class="btn btn-info btn-sm" href="#"> <i class="fas fa-binoculars"> </i> </a>
												<a class="btn btn-warning btn-sm" href="#"> <i class="fas fa-pencil-alt"> </i> </a>
												<a class="btn btn-danger btn-sm" href="#"> <i class="fas fa-trash"> </i> </a></td>
											</tr> -->
									</table>

							<div id="myModal" class="modal fade" role="dialog"
								aria-hidden="true" style="display: none;">
								<div class="modal-dialog">

									<!-- Modal content-->
									<div class="modal-content" style="width: 830px;">
										<div class="modal-header">
											<h4 class="modal-title">Search Fields</h4>
										</div>

										<div class="modal-body" id="searchMainId">
											<div class="row" id="startingROw">
												<div class="col col-md-4">
													<select id="searchSelectVar" name="searchSelectVar"
														class="form-control checkVar0 searchSelectVarClass1">
														<option selected="selected" value="SELECT">Column</option>
														<option value="FREQUENCY">FREQUENCY</option>
														<option value="ACTIVE_CURRENT_R">ACTIVE_CURRENT_R</option>
														<option value="ACTIVE_ENERGY_EXPORT">ACTIVE_ENERGY_EXPORT</option>
														<option value="ACTIVE_CURRENT_B">ACTIVE_CURRENT_B</option>
														<option value="ACTIVE_CURRENT_Y">ACTIVE_CURRENT_Y</option>
														<option value="METER NUMBER">METER NUMBER</option>
														<option value="METER DATE TIME">METER DATE TIME</option>
														<option value="ACTIVE_ENERGY_IMPORT">ACTIVE_ENERGY_IMPORT</option>
													</select>
												</div>
												<div class="col col-md-4">
													<select id="conditionStr" name="conditionStr"
														class="form-control checkVar0 conditionStrClass1">
														<option value="SELECT">Type</option>
														<option value="LIKE">LIKE</option>
														<option value="EQUAL TO">EQUAL TO</option>
														<option value="NOT EQUAL TO">NOT EQUAL TO</option>
													</select>
												</div>

												<div class="col col-md-3">
													<input type="text"
														class="form-control checkVar0 searchParameterC1"
														name="command.searchParameter" value="" autocomplete="off"
														ondrop="return false;">
												</div>

												<div class="col col-md-1">
													<div class="btn-group" role="group" aria-label="operation">
														<a class="btn btn-success btn-sm" href="#"> <i class="fas fa-plus"> </i> </a>&nbsp;
														<a class="btn btn-danger btn-sm" href="#"> <i class="fas fa-minus"> </i> </a>
													</div>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal" data-i18n="modalClose">Close</button>
											<input type="submit" value="Search" data-i18n="modalOkay"
												class="btn btn-danger btn-sm submitClass">
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
	<script>
  $(function () {
    /* $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)'); */
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
<script type="text/javascript">
$(document).ready(function() {
    $("#example1").dataTable( {
   		"responsive": true, "lengthChange": false, "autoWidth": false,
    	"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
        "bProcessing": true,
        "dom": 't',
        "bServerSide": true,
        "sort": "position",
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
          },        
        "sAjaxSource": "fetchModuleMasterDetails",
        "aoColumns": [
        		{
	                 "mData": "id",
	                 "defaultContent" : "-",
	                 render: function (data, type, row, meta) {
	                 return meta.row + meta.settings._iDisplayStart + 1;
			    }
			},
       		{ "mData": "moduleTypeName" ,  "defaultContent": "-"},
         	{ "mData": "moduleTypeCode" ,  "defaultContent": "-"},
         	{ "mData": "moduleDescription" ,  "defaultContent": "-"},
         	{ data: function ( row, type, set ) {
			    return '<a class="btn btn-info btn-sm" onClick="submitMyForm(\'' + 'viewModuleMaster' + '\',\'' + row.moduleTypeName + '\',\'' + 'View' + '\')"><i class="fas fa-binoculars"></i></a>'
                +' <a class="btn btn-warning btn-sm" onClick="submitMyForm(\'' + 'viewModuleMaster' + '\',\'' + row.moduleTypeName + '\',\'' + 'Edit' + '\')"><i class="fas fa-pencil-alt"></i></a>'
                +" <a href='deleteModuleMaster?moduleTypeName=" + row.moduleTypeName + "' class='btn btn-danger btn-sm' onclick=\"return confirm('Are You Sure Want To Delete this record?')\"><i class='fas fa-trash'></i></a>";
				} 
			},
         
        ]
    } ).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');

} );
</script>
<script type="text/javascript">
function submitMyForm(action,moduleTypeName,viewType){
    $('<form method="post" action="'+action+'"><input type="text" name="moduleTypeName" value="'+moduleTypeName+'" /><input type="text" name="viewType" value="'+viewType+'" /></form>').appendTo('body').submit();
}
</script>
<script type="text/javascript">
$(document).ready(function() {
   if ($(".moduleNameClass").val() == '') {
   $(".moduleNameClass").prop('readonly', false);
   }else{
   $(".moduleNameClass").prop('readonly', 'true');
   }
});
</script>
<script type="text/javascript">
 $(function () {
    //Initialize Select2 Elements
    $('.select2').select2();
    
    });


</script>

</body>
</html>