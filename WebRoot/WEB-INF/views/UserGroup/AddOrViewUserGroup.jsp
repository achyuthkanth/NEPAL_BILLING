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
					<link rel="stylesheet" href="datatables/datatables-bs4/css/dataTables.bootstrap4.min.css">
					<link rel="stylesheet" href="datatables/datatables-responsive/css/responsive.bootstrap4.min.css">
					<link rel="stylesheet" href="datatables/datatables-buttons/css/buttons.bootstrap4.min.css">
					<link rel="stylesheet" href="plugins/select2/css/select2.min.css">
					<link rel="stylesheet" href="plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
					<!-- Theme style -->
					<link rel="stylesheet" href="dist/css/adminlte.min.css">
					<link rel="stylesheet" href="css/styles.css"> </head>
				<!-- jQuery -->
				<script src="plugins/jquery/jquery.min.js"></script>
				<style>
				.container {
					display: grid;
					grid-template-columns: 1fr 3fr;
				}
				</style>
				<script type="text/javascript">
				$(document).ready(function() {
					$(".userViewClass").change(function() {
						if(this.checked) {
							$(this).siblings('ul').find("input[type='checkbox']").prop('checked', true);
						} else {
							$(this).siblings('ul').find("input[type='checkbox']").prop('checked', false);
						}
					});
					$(".mainCheckAll").change(function() {
						var nameStr = $(this).prop('name');
						var moduleName = $(this).prop('value');
						var updateClassName = "";
						if(nameStr == 'selectAll') {
							updateClassName = "actionClass";
						}
						if(nameStr == 'createAll') {
							updateClassName = "createClass";
						}
						if(nameStr == 'readAll') {
							updateClassName = "readClass";
						}
						if(nameStr == 'updateAll') {
							updateClassName = "updateClass";
						}
						if(nameStr == 'deleteAll') {
							updateClassName = "deleteClass";
						}
						if(this.checked) {
							$(this).parent().parent().parent().parent().find("tbody>tr").find("." + updateClassName + "." + moduleName).prop('checked', true);
						} else {
							$(this).parent().parent().parent().parent().find("tbody>tr").find("." + updateClassName + "." + moduleName).prop('checked', false);
						}
					});
				});
				</script>
				<script type="text/javascript">
		function submitMyForm(actionname,actionvalues){
		alert("Enter");
		var proceed='false';
		if(actionname.startsWith("delete")){
			if(confirm("Are you sure You want to delete?")){
			proceed='true';
			}
		}else{
			proceed='true';
		}
		
		if(proceed=='true'){
			var strArr=actionvalues.split("&");
			var formStr="<form action='"+actionname+"' method='post' >";
			for(var i=0;i<strArr.length;i++){
				var atrSrr=strArr[i].split("=");
				formStr=formStr+"<input type='hidden' value='"+atrSrr[1]+"' name='"+atrSrr[0]+"'/>";
			}
			formStr=formStr+"</form>";
			$(formStr).appendTo('body').submit();
		}
	}
	</script>

				<body class="hold-transition sidebar-mini">
					<div class="wrapper">
						<%@ include file="/WEB-INF/views/common/header.jsp"%>
							<!-- Content Wrapper. Contains page content -->
							<div class="content-wrapper">
								<form action="saveUserGroup" method="post">
									<!-- Content Header (Page header) -->
									<section class="content-header">
										<div class="container-fluid">
											<div class="row mb-2">
												<div class="col-sm-6">
													<h1>New User Group  Master</h1> </div>
												<div class="col-sm-6">
													<ol class="breadcrumb float-sm-right">
														<li class="breadcrumb-item"><a href="#">Home</a></li>
														<li class="breadcrumb-item active">New User Group Master</li>
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
													<h3 class="card-title">Add / Update New User Group Master</h3>
													<div class="card-tools">
														<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
													</div>
												</div>
												<div class="card-body">
													<div class="row">
														<!-- <div class="col-sm-12"> -->
														<div class="col-sm-6">
															<div class="form-group">
																<label>Group Name</label>
																<input type="text" name="id.groupname" class="form-control moduleNameClass" value="${command.id.groupname}" autocomplete="off" placeholder="Group Name" required="required"> </div>
															<div class="form-group">
																<label>Group Description</label>
																<input type="text" name="groupdescription" class="form-control" autocomplete="off" value="${command.groupdescription}" placeholder="Group Description" required="required"> </div>
														</div>
														<!-- </div> -->
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
													<h3 class="card-title">ADD / UPDATE USER GROUP VIEWS</h3>
													<div class="card-tools">
														<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
													</div>
												</div>
												<div class="card-body"> ${viewsCheckBoxStr} </div>
											</div>
										</div>
									</section>
									<section class="content">
										<div class="container-fluid">
											<!-- SELECT2 EXAMPLE -->
											<div class="card card-default">
												<div class="card-header">
													<h3 class="card-title">ADD / UPDATE USER GROUP ACTIONS</h3>
													<div class="card-tools">
														<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
													</div>
												</div>
												<div class="card-body">
													<div class="col-sm-12 list-style-none"> ${moduleActionsStr} </div>
													<div class="form-group col-sm-12" style="text-align: center;">
														<button type="submit" class="btn btn-success">Save/Update</button>
														<button type="reset" class="btn btn-warning">Reset</button>
													</div>
												</div>
											</div>
										</div>
									</section>
									<!-- Main content -->
									<section class="content">
										<div class="container-fluid">
											<div class="card card-default">
												<div class="card-header">
													<h3 class="card-title">USER GROUP DETAILS</h3>
													<div class="card-tools">
														<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
													</div>
												</div>
												<div class="card-body">
													<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-condensed" id="example">
														<thead>
															<tr>
																<th>S.No</th>
																<th>Group Name</th>
																<th>Group Description</th>
																<th>Edit</th>
																<th>Delete</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${command.userGroupList}" varStatus="status" var="views">
																<tr>
																	<td>
																		<c:out value="${status.count}" />
																	</td>
																	<td>${views.id.groupname}</td>
																	<td>${views.groupdescription} </td>
																	<td><a href="#" onclick="submitMyForm('editUserGroup','id.groupname=${views.id.groupname}')"><i class="fas fa-edit"></i></a></td>
																	<td><a href="#" onclick="submitMyForm('deleteUserGroup','id.groupname=${views.id.groupname}')"><i class="fas fa-trash"></i></a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
													</div>
											</div>
											<!-- /.card -->
										</div>
									</section>
									<!-- /.content -->
								</form>
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
					<script>
					$(function() {
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
	
	
					
					
					
				</body>

				</html>