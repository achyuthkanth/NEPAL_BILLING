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
							<h1>Views Master</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a>
								</li>
								<li class="breadcrumb-item active">Views Master</li>
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
							<h3 class="card-title">Add / Update Views Master Details</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								
							</div>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
						<c:if test="${command.viewType=='Edit' || command.viewType==null}">
							<form:form action="saveViewsMaster">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>View Name</label> <input type="text" required="required"
											name="viewname" class="form-control" value="${command.viewname}"
											placeholder="View Name">
									</div>
									<div class="form-group">
										<label>Action Name</label> <input type="text" required="required"
											name="actionname" class="form-control" value="${command.actionname}"
											placeholder="Action Name">
									</div>
									<div class="form-group">
										<label>Level Of View</label> <input type="text" required="required" readonly="readonly"
											name="viewLevel" class="form-control" value="${command.viewLevel}"
											placeholder="Level Of View">
									</div>
									
									
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>View Name</label> <input type="text" required="required"
											name="viewdescription" class="form-control" value="${command.viewdescription}"
											placeholder="View Description">
									</div>
									<div class="form-group">
										<label>Parent View</label> <input type="text" required="required" readonly="readonly"
											name="parentview" class="form-control" value="${command.parentview}"
											placeholder="Parent View">
									</div>
								</div>
								<div class="form-group col-sm-12" style="text-align: center;">
												<button type="submit" class="btn btn-success">Save/Update</button>
												<button type="reset" class="btn btn-warning">Reset</button>
											</div>
							</div>
							</form:form>
							</c:if>
							<%-- <c:if test="${command.viewType=='View'}">
												<div class="card-header">
													<h3 class="card-title">View Views Master</h3>
													<div class="card-tools">
														<button type="button" class="btn btn-tool" data-card-widget="collapse"> <i class="fas fa-minus"></i> </button>
													</div>
												</div>
												<!-- /.card-header -->

											<div class="col-md-6">
													<!-- /.card-header -->
													<div class="card-body">
														<dl class="row">

											<div class="col-md-6">
												<dt class="col-sm-4">View Name</dt>
															<dd class="col-sm-8">
																<c:out value="${command.viewname}"></c:out>
												<dt class="col-sm-4">Action Name</dt>
															<dd class="col-sm-8">
																<c:out value="${command.actionname}"></c:out>
												<dt class="col-sm-4">Level Of View</dt>
															<dd class="col-sm-8">
																<c:out value="${command.viewLevel}"></c:out>
											</div>
											<div class="col-md-6">
												<dt class="col-sm-4">View Description</dt>
															<dd class="col-sm-8">
																<c:out value="${command.viewdescription}"></c:out>
												<dt class="col-sm-4">Parent View</dt>
															<dd class="col-sm-8">
																<c:out value="${command.parentview}"></c:out>
											</div>


														</dl>
													</div>
													<!-- /.card-body -->
											</div>
										</c:if> --%>
						</div>
					</div>
				</div>
			</section>
			
			
			
			<section class="content">
				<div class="container-fluid">
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">VIEWS DETAILS FOR VIEWS MASTER-${command.viewLevel} Under Hierarchy ==> <b>${command.parentview}</b></h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<div class="card-body">
							<table cellpadding="0" cellspacing="0" border="0"
								class="table table-striped table-bordered table-condensed"
								id="example">
								<thead>
									<tr>
										<th>S.No</th>
										<th>View</th>
										<th>View Name</th>
										<th>Description</th>
										<th>Action</th>
										<th>Parent View</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${command.viewMasterList}" varStatus="status" var="views">
										<tr>
											<td><c:out value="${status.count}" /></td>
											<td><a class="btn btn-info btn-sm" href="#" onclick="submitMyForm('fetchViewDetails','viewLevel=${command.viewLevel}&parentview=${views.viewname}&viewname=${views.viewname}')"><i class="fas fa-eye"></i></a></td>
											<td>${views.viewname}</td>
											<td>${views.viewdescription} </td>
											<td>${views.actionname} </td>
											<td>${views.parentview} </td>
											<%-- <td><a class="btn btn-info btn-sm" href="#" onclick="submitMyForm('editViewData','viewLevel=${command.viewLevel}&parentview=${views.viewname}&viewname=${views.viewname}')"><i class="fas fa-binoculars"></i></a></td> --%>
											<td><a class="btn btn-warning btn-sm" href="#" onclick="submitMyForm('editViewData','viewLevel=${command.viewLevel}&parentview=${views.viewname}&viewname=${views.viewname}')"><i class="fas fa-pencil-alt"></i></a></td>
											<td><a class="btn btn-danger btn-sm" href="#" onclick="submitMyForm('deleteViewDetails','viewLevel=${command.viewLevel}&parentview=${views.viewname}&viewname=${views.viewname}')"><i class="fas fa-trash"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /.card -->
				</div>
			</section>
			
			
			
			
			


			<!-- Main content -->
					
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->

		<%@ include file="/WEB-INF/views/common/footer.jsp"%>

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
	
	<script src="plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="plugins/jquery-validation/additional-methods.min.js"></script>

<script type="text/javascript">
$(function () {
    $('.select2').select2();
});
</script>

		
<script type="text/javascript">
	function submitMyForm(actionname,actionvalues){
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

<script type="text/javascript">
$(document).ready( function () {
    $('#example').DataTable();
} );

</script>

</body>
</html>