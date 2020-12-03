<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="plugins/jquery/jquery.min.js"></script>

<!-- Theme style -->
<link rel="stylesheet" href="dist/css/adminlte.min.css">

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
							<h1>HIERARCHY LEVELS</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">HIERARCHY LEVELS</li>
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
									<h3 class="card-title">Upload  HierarchyLevels </h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">

									<form:form method="post" action="saveHierarchies" enctype="multipart/form-data">
										<div class="row">
											<input type="file" name="file" id="fileToUpload"
												class="form-control">
										</div>
										<div class="col-sm-12" align="center">
										<button type="submit" class="btn btn-danger">Upload
											Hierarchies</button>
									</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
			</section>
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card card-secondary">
								<div class="card-header">
									<h3 class="card-title">Add HierarchyLevels Details</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">

									<form:form method="post" action="">
										<div class="row">
											<%@ include
												file="/WEB-INF/views/HierarchyLevels/HierarchyLevels.jsp"%>
										</div>

									</form:form>
									<div class="" align="center" style="margin-top: 20px;">
										<button type="submit" class="btn btn-danger submitClass">View
											Hierarchies</button>
									</div>
								</div>
							</div>
						</div>
					</div>

					<a class='updateCall' href='javascript:void(0)'> <input
						type="button" id="myDataToggle" data-toggle='modal'
						data-target='#addtagblock' style="display: none;" /> </a>

					<div class="modal fade" id="addtagblock" tabindex="-1"
						role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" id="myModalLabel"></h4>
								</div>
								<div class="modal-body">
									<form method="post" id="levelForm">
										<div id="tableform">
											<table>
												<tr>
													<td id="LevelNameVal"></td>
													<td></td>
													<td><label>Level Name</label> <input name="levelName"
														id="levelName" class="text_field"></input>
													</td>
												</tr>
												<tr>
													<td id="levelCodeVal"></td>
													<td></td>
													<td><label>Level Code</label><input name="levelCode"
														id="levelCode" class="text_field" /> <input type="hidden"
														value="" id="levelIdRef" /> <input type="hidden" value=""
														id="levelValue" /> <input type="hidden" value=""
														id="levelCount" /></td>
												</tr>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<input type="reset" class="btn btn-primary" value="Reset" />
											<input type="submit" class="btn btn-primary"
												id="submitButton" value="Save" />
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<!-- /.card -->

							<div class="card">
								<div class="card-header">
									<h3 class="card-title">DataTable with default features</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>S.NO</th>
												<th>LEVEL ID</th>
												<th>LEVEL NAME</th>
												<th>LEVEL CODE</th>
												<th>UNIQUE CODE</th>
												<th>PREVIOUS LEVEL ID</th>
											</tr>
										</thead>
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
	<!-- <script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
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
</script> -->
	<script>
	$(document).ready(function(){
	 function loadDataTable(url) {
		$('#example1').dataTable({
	        "bServerSide": true,
	        "bProcessing": true,
	        "bJQueryUI": true,
	        "render": true,
	         "bDestroy": true,
	        "sAjaxSource": "fetchHierarchies?"+url,
	        "fnServerData": function (sSource, aoData, fnCallback) {
	            $.ajax({
	                "dataType": 'json',
	                "type": "GET",
	                "url": sSource,
	                "data": aoData,
	                "success":fnCallback
	            });
	        },
	        "aoColumns": [
	        {
               "mData": "id",
               "defaultContent" : "-",
	            render: function (data, type, row, meta) {
	               return meta.row + meta.settings._iDisplayStart + 1;
             	}
          	},
	       		{ "mData": "hLevelId",  "defaultContent": "-" },
	          	{ "mData": "hLevelName" ,  "defaultContent": "-"},
	         	{ "mData": "hLevelCode" ,  "defaultContent": "-"},
	            { "mData": "hLevelUniqueCode" ,  "defaultContent": "-"},  
	            { "mData": "hPreviousLevelId" ,  "defaultContent": "-"}	  	  		
	        ]
	    } ).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
	    }
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
								"level15Id="+$('.level15Class').find('option:selected').val();
								loadDataTable(url);
	    
	    	$('.submitClass').click(function(){
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
								"level15Id="+$('.level15Class').find('option:selected').val();
	    	loadDataTable(url);
	    	
	    	});
 });
</script>
</body>
</html>