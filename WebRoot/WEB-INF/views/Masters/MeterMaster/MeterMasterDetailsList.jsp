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

			<!-- Main content --> 3
			
			<section class="content">
				<div class="container-fluid">
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">BULK UPLOAD METER MASTER FAILURE
								DETAILS</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>

							</div>
						</div>
						<div class="card-body">
							<table
								class="table table-bordered table-striped table-responsive">
								<tr>
									<th>S.No</th>
									<th>Meter Number</th>
									<th>Message</th>
								</tr>
								<c:forEach items="${failureMap}" var="author" varStatus="status">
									<tr class="lable-text-blue">
										<td>${status.count}</td>
										<td><c:out value="${author.key}"></c:out>
										</td>
										<td><c:out value="${author.value}"></c:out>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<!-- /.card -->
				</div>
			</section>

			<section class="content">
				<div class="container-fluid">
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">BULK UPLOAD METER MASTER SUCCESS
								DETAILS</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>

							</div>
						</div>
						<div class="card-body">
							<table
								class="table table-bordered table-striped table-responsive">
								<tr>
									<th>S.No</th>
									<th>Meter Number</th>
									<th>Message</th>
								</tr>
								<c:forEach items="${successMap}" var="author" varStatus="status">
									<tr class="lable-text-blue">
										<td>${status.count}</td>
										<td><c:out value="${author.key}"></c:out>
										</td>
										<td><c:out value="${author.value}"></c:out>
										</td>
									</tr>
								</c:forEach>
							</table>
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
</body>
</html>