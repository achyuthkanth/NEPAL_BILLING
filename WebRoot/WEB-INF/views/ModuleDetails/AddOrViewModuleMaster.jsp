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


<!-- Theme style -->
<link rel="stylesheet" href="dist/css/adminlte.min.css">


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
					<div class="row">
						<div class="col-12">
							<div class="card card-secondary">
								<div class="card-header">
									<h3 class="card-title">Add / Update Module Master</h3>
								</div>
								<!-- /.card-header -->
								<form:form action="saveModuleMasterDetails">
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label>Module Type Name</label> <input type="text"
														name="moduleTypeName" class="form-control"
														placeholder="Module Type Name">
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label>Module Type Code</label> <input type="text"
														name="moduleTypeCode" class="form-control"
														placeholder="Module Type Code">
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label>Module Description</label> <input type="text"
														name="moduleDescription" class="form-control"
														placeholder="Module Description">
												</div>
											</div>
											<div class="form-group col-sm-12" style="text-align: center;">
												<button type="submit" class="btn btn-success">Save</button>
											</div>
											<!-- <div class="form-group"></div> -->
										</div>
									</div>
								</form:form>
						</div>
					</div>
				</div>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<!-- <div class="card">
								<div class="card-header">
									<h3 class="card-title">DataTable with minimal features &
										hover style</h3>
								</div>
								/.card-header
								<div class="card-body"></div>
								/.card-body
							</div> -->
							<!-- /.card -->

							<div class="card">
								<div class="card-header">
									<h3 class="card-title">Module Master Details</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>S.No</th>
												<th>Module Type Name</th>
												<th>Module Type Code</th>
												<th>Module Description</th>
												<th>View</th>
											</tr>
										</thead>
										<!-- <tbody>
											<tr>
												<td>Trident</td>
												<td>Internet Explorer 4.0</td>
												<td>Win 95+</td>
												<td>4</td>
												<td class="project-actions text-right"><a
													class="btn btn-primary btn-sm" href="#"> <i
														class="fas fa-folder"> </i> View </a> <a
													class="btn btn-info btn-sm" href="#"> <i
														class="fas fa-pencil-alt"> </i> Edit </a> <a
													class="btn btn-danger btn-sm" href="#"> <i
														class="fas fa-trash"> </i> Delete </a></td>
											</tr> -->
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
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
       		/* {
          		render: function (data, type, row){
         		return '<a class="fa fa-eye" onClick="submitMyForm(\'' + 'viewModuleDetails' + '\',\'' + row.moduleName + '\')"></a>';
         		}  
       		}, */
       		{ "mData": "moduleTypeName" ,  "defaultContent": "-"},
         	{ "mData": "moduleTypeCode" ,  "defaultContent": "-"},
         	{ "mData": "moduleDescription" ,  "defaultContent": "-"},
         	{
          		render: function (data, type, row)
                {
                return '<a class="btn btn-primary btn-sm" onClick="submitMyForm(\'' + 'viewModuleMaster' + '\',\'' + row.moduleTypeName + '\')"><i class="fas fa-folder"></i> View</a>';
                 }
            },
         	/* {
          		render: function (data, type, row)
                {
                return '<a class="fa fa-edit" onClick="submitMyForm(\'' + 'editModuleMaster' + '\',\'' + row.moduleName + '\')"></a>';
                 }
            },
         	{
          		render: function (data, type, row)
                {
                return '<a class="fa fa-trash" onClick="submitMyForm(\'' + 'deleteModuleMaster' + '\',\'' + row.moduleName + '\')"></a>';
                 }
            }, */
         
        ]
    } ).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');

} );
</script>

</body>
</html>