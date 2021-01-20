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
							<h1>Field Installation</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Field Installation</li>
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
							<h3 class="card-title">Upload Field Installation Excel file</h3>
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
<!-- 								<button type="submit" class="btn btn-success ExportClass" id="ExportButton"><img src="fonts/dnload.png" > </button> -->
									<button type="submit" class="btn btn-success ">Upload
										Field Installation</button>
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	<button type="button" class="btn btn-danger ExportClass" id="ExportButton">Export </button> 
								</div>
								</form:form>
							</div>
						</div>
				</div>
			</section>
			</section>
			<c:if test="${command.viewType=='Edit' || command.viewType==null}">
				<form:form action="saveFieldInstallation">
					<section class="content">
						<div class="container-fluid">
							<!-- SELECT2 EXAMPLE -->
							<div class="card card-default">
								<div class="card-header">
									<h3 class="card-title">Field Installation</h3>
									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse">
											<i class="fas fa-minus"></i>
										</button>

									</div>
								</div>
								<!-- 						/.card-header -->
								<div class="card-body">
									<%-- <div class="row">
										<%@ include
											file="/WEB-INF/views/HierarchyLevels/HierarchyLevels.jsp"%>
									</div> --%>
									
									<div class="row">
									
										<div class="col-md-6">
										<c:if test="${command.viewType==null}">
											<div class="form-group">
												<label>Circle Id</label> <input type="text"
													 name="id.circleid" class="form-control"
													value="${command.id.circleid}" placeholder="Circle Id">
											</div>
											
											<div class="form-group">
												<label>Consumer No</label> <input type="text"
													 name="id.consumerNo" class="form-control"
													value="${command.id.consumerNo}" placeholder="Consumer No">
											</div>
											<div class="form-group">
												<label>Consumer Id</label> <input type="text"
													 name="id.consumerid"
													class="form-control" value="${command.id.consumerid}"
													placeholder="Consumer Id">
											</div>
											
											</c:if>
											<c:if test="${command.viewType=='Edit'}">
											<div class="form-group">
												<label>Circle Id</label> <input
													 name="id.circleid" class="form-control"
													value="${command.id.circleid}"  readonly="readonly">
											</div>
											<div class="form-group">
												<label>Consumer No</label> <input type="text"
													 name="id.consumerNo" class="form-control"
													value="${command.id.consumerNo}"  readonly="readonly">
											</div>
											<div class="form-group">
												<label>Consumer Id</label> <input type="text"
													 name="id.consumerid"
													class="form-control" value="${command.id.consumerid}"
													placeholder="Consumer Id"  readonly="readonly">
											</div>
											</c:if>
											
											
											<div class="form-group">
												<label>Cons Id </label> <input type="text"
													name="consId" class="form-control"
													value="${command.consId}"
													placeholder="Cons Id">
											</div>
											<div class="form-group">
												<label>Discom Id </label> <input type="text"
													name="discomid" class="form-control"
													value="${command.discomid}"
													placeholder="Discom Id">
											</div>
											<div class="form-group">
												<label>Dis Com</label> <input type="text"
													name="discom" class="form-control"
													value="${command.discom}"
													placeholder="Dis Com">
											</div>
											<div class="form-group">
												<label>Board Id</label> <input type="text"
													name="boardid" class="form-control"
													value="${command.boardid}" placeholder="Board Id">
											</div>
											<div class="form-group">
												<label>Board</label> <input type="text"
													name="board" class="form-control"
													value="${command.board}"
													placeholder="Board">
											</div>

											<%-- <div class="form-group">
												<label>Consumer Name</label> <input type="text"
													name="consumerName" class="form-control"
													value="${command.consumerName}" placeholder="Consumer Name">
											</div> --%>

											<div class="form-group">
												<label>Circle</label> <input type="text"
													name="circle" class="form-control"
													value="${command.circle}" placeholder="Circle">
											</div>

											<div class="form-group">
												<label>Division Id</label> <input type="text"
													name="divisionid" class="form-control"
													value="${command.divisionid}" placeholder="Division Id">
											</div>

											<div class="form-group">
												<label>Division</label> <input type="text"
													name="division" class="form-control"
													value="${command.division}"
													placeholder="Division">
											</div>

											<div class="form-group">
												<label>Sub Division Id</label> <input type="text"
													name="subdivisionid" class="form-control"
													value="${command.subdivisionid}"
													placeholder="Sub Division Id">
											</div>
											<div class="form-group">
												<label>Sub Division</label> <input type="text"
													name="subdivision" class="form-control"
													value="${command.subdivision}"
													placeholder="Sub Division">
											</div>
											
											<div class="form-group">
												<label>Schedule Power</label> <input type="text"
													 name="schedulePower"
													class="form-control" value="${command.schedulePower}"
													placeholder="Schedule Power">
											</div>
											 <div class="form-group">
												<label>Category </label> <input type="text"
													name="category" class="form-control"
													value="${command.category}"
													placeholder="Category">
											</div>
											<div class="form-group">
												<label>Meter Ct Type</label> <input type="text"
													name="meterCtType" class="form-control"
													value="${command.meterCtType}"
													placeholder="Meter Ct Type">
											</div>
											<div class="form-group">
												<label>Meter Ownership</label> <input type="text"
													name="meterOwnership" class="form-control"
													value="${command.meterOwnership}"
													placeholder="Meter Ownership">
											</div>
											<div class="form-group">
												<label>Meter Elec Type</label> <input type="text"
													name="meterElecType" class="form-control"
													value="${command.meterElecType}" placeholder="Meter Elec Type">
											</div>
											<div class="form-group">
												<label>Transformer OwnerShip</label> <input type="text"
													name="transformerownership" class="form-control"
													value="${command.transformerownership}"
													placeholder="Transformer OwnerShip">
											</div>

											<div class="form-group">
												<label>Transformers Capacity</label> <input type="text"
													name="transformerscapacity" class="form-control"
													value="${command.transformerscapacity}" placeholder="Transformers Capacity">
											</div>

											<div class="form-group">
												<label>Transformer Make</label> <input type="text"
													name="transformermake" class="form-control"
													value="${command.transformermake}" placeholder="Transformer Make">
											</div>

											<div class="form-group">
												<label>Transfer Location</label> <input type="text"
													name="transferLocation" class="form-control"
													value="${command.transferLocation}" placeholder="Transfer Location">
											</div>

											<div class="form-group">
												<label>Transformer Serial No</label> <input type="text"
													name="transformerserialno" class="form-control"
													value="${command.transformerserialno}"
													placeholder="Transformer Serial No">
											</div>

											<div class="form-group">
												<label>Independent</label> <input type="text"
													name="independent" class="form-control"
													value="${command.independent}"
													placeholder="Independent">
											</div>
											
											
											
											
											<div class="form-group">
												<label>Sim Provider Name </label> <input type="text"
													name="simProviderName" class="form-control"
													value="${command.simProviderName}"
													placeholder="Sim Provider Name">
											</div>
											<div class="form-group">
												<label>Modem Manufacturer Name</label> <input type="text"
													name="modemmanufacturername" class="form-control"
													value="${command.modemmanufacturername}"
													placeholder="Modem Manufacturer Name">
											</div>
											<div class="form-group">
												<label>Latitude</label> <input type="text"
													name="latitude" class="form-control"
													value="${command.latitude}"
													placeholder="Latitude">
											</div>
											<div class="form-group">
												<label>Longitude</label> <input type="text"
													name="longitude" class="form-control"
													value="${command.longitude}" placeholder="Longitude">
											</div>
											<div class="form-group">
												<label>Photo Location</label> <input type="text"
													name="photolocation" class="form-control"
													value="${command.photolocation}"
													placeholder="Photo Location">
											</div>

											<div class="form-group">
												<label>Sub Station</label> <input type="text"
													name=substation class="form-control"
													value="${command.substation}" placeholder="Sub Station">
											</div>


											<div class="form-group">
												<label>Substation Code</label> <input type="text"
													name="substationCode" class="form-control"
													value="${command.substationCode}" placeholder="Substation Code">
											</div>

											<div class="form-group">
												<label>Feeder</label> <input type="text"
													name="feeder" class="form-control"
													value="${command.feeder}" placeholder="Feeder">
											</div>

											<div class="form-group">
												<label>Feeder Code</label> <input type="text"
													name="feederCode" class="form-control"
													value="${command.feederCode}"
													placeholder="Feeder Code">
											</div>

											<div class="form-group">
												<label>Feeder Type</label> <input type="text"
													name="feedertype" class="form-control"
													value="${command.feedertype}"
													placeholder="feedertype">
											</div>
											<div class="form-group">
												<label>Meter Decimal</label> <input type="text"
													name="meterDecimal" class="form-control"
													value="${command.meterDecimal}"
													placeholder="Meter Decimal">
											</div>

											<div class="form-group">
												<label>Meter Digit</label> <input type="text"
													name="meterDigit" class="form-control"
													value="${command.meterDigit}"
													placeholder="Meter Digit">
											</div>
											
											

											<div class="form-group">
												<label>Meter Change Flag</label> <input type="text"
													name="meterChnageFlag" class="form-control"
													value="${command.meterChnageFlag}"
													placeholder="Meter Change Flag">
											</div>
											<div class="form-group">
												<label>Proprietor Name</label> <input type="text"
													name="proprietorName" class="form-control"
													value="${command.proprietorName}"
													placeholder="Proprietor Name">
											</div>

											<div class="form-group">
												<label>District</label> <input type="text"
													name="district" class="form-control"
													value="${command.district}"
													placeholder="District">
											</div>
											
											<div class="form-group">
												<label>Status</label> <input type="text"
													name="status" class="form-control"
													value="${command.status}" placeholder="Status">
											</div>

											<div class="form-group">
												<label>Flag 1</label> <input type="text" name="flag1"
													class="form-control" value="${command.flag1}"
													placeholder="Flag 1">
											</div>

											<div class="form-group">
												<label>Flag 2</label> <input type="text"
													name="flag2" class="form-control"
													value="${command.flag2}"
													placeholder="Flag 2">
											</div>
											<div class="form-group">
												<label>Bill Date</label> <input type="text"
													name="billDate" class="form-control"
													value="${command.billDate}"
													placeholder="Bill Date">
											</div>
											<div class="form-group">
												<label>Ussd Code</label> <input type="text"
													name="ussdCode" class="form-control"
													value="${command.ussdCode}"
													placeholder="Ussd Code">
											</div>
											
											<div class="form-group">
												<label>OffSet</label> <input type="text"
													name="offSet" class="form-control"
													value="${command.offSet}"
													placeholder="OffSet">
											</div>
											<%-- <div class="form-group">
												<label>Hid</label> <input type="text"
													name="hid" class="form-control"
													value="${command.hid}" placeholder="hid">
											</div> --%>
											<%-- <div class="form-group">
												<label>Modemme Id Number </label> <input type="text"
													name="modemmeidnumber" class="form-control"
													value="${command.modemmeidnumber}" placeholder="Modemme Id Number">
											</div>
											 --%>
											<%-- <div class="form-group">
												<label>Modem Number</label> <input type="text"
													name="modemnumber" class="form-control"
													value="${command.modemnumber}"
													placeholder="Modem Number">
											</div> --%>
											<div class="form-group">
												<label>Version Number</label> <input type="text"
													name="versionNumber" class="form-control"
													value="${command.versionNumber}"
													placeholder="Version Number">
											</div>
										<%-- <div class="form-group">
												<label>Modem Mdn </label> <input type="text"
													name="modemmdn" class="form-control"
													value="${command.modemmdn}" placeholder="Modem Mdn">
											</div> --%>
											
										</div>
										<div class="col-md-6">
										 	<div class="form-group">
												<label>Phase</label> <input type="text"
													 name="phase" class="form-control"
													value="${command.phase}" placeholder="Phase">
											</div>
											<div class="form-group">
												<label>Section Id</label> <input type="text"
													name="sectionid" class="form-control"
													value="${command.sectionid}" placeholder="sectionid">
											</div>
											<div class="form-group">
												<label>Section </label> <input type="text"
													name="section" class="form-control"
													value="${command.section}" placeholder="section">
											</div>
											<div class="form-group">
												<label>Registraton Id </label> <input type="text"
													name="registratonId" class="form-control"
													value="${command.registratonId}" placeholder="Registraton Id">
											</div>
											<div class="form-group">
												<label>Name</label> <input type="text"
													name="name" class="form-control"
													value="${command.name}"
													placeholder="Name">
											</div>
											<div class="form-group">
												<label>Addr</label> <input type="text"
													name="addr" class="form-control cc"
													value="${command.addr}"
													placeholder="Addr">
											</div>
											<div class="form-group">
												<label>Consumer Category</label> <input type="text"
													name="consumerCategory" class="form-control"
													value="${command.consumerCategory}"
													placeholder="Consumer Category">
											</div>

											<div class="form-group">
												<label>Cd Kva</label> <input type="text"
													name="cdKva" class="form-control"
													value="${command.cdKva}" placeholder="Cd Kva">
											</div>

											<div class="form-group">
												<label>Office Phone</label> <input type="text" name="officePhone"
													class="form-control" value="${command.officePhone}"
													placeholder="Office Phone">
											</div>

											<div class="form-group">
												<label>Mobile No</label> <input type="text"
													name="mobileNo" class="form-control"
													value="${command.mobileNo}"
													placeholder="Mobile No">
											</div>
											<div class="form-group">
												<label>Email Address</label> <input type="text"
													name="emailAddress" class="form-control"
													value="${command.emailAddress}"
													placeholder="Email Address">
											</div>
											<div class="form-group">
												<label>Load Type</label> <input type="text"
													name="loadType" class="form-control"
													value="${command.loadType}"
													placeholder="Load Type">
											</div>
											
											<div class="form-group">
												<label>Meter No</label> <input type="text"
													name="meterno" class="form-control"
													value="${command.meterno}"
													placeholder="Meter No">
											</div>
											<div class="form-group">
												<label>Hid</label> <input type="text"
													name="hid" class="form-control"
													value="${command.hid}" placeholder="hid">
											</div>
											<div class="form-group">
												<label>Modemme Id Number </label> <input type="text"
													name="modemmeidnumber" class="form-control"
													value="${command.modemmeidnumber}" placeholder="Modemme Id Number">
											</div>
											<div class="form-group">
												<label>Modem Mdn </label> <input type="text"
													name="modemmdn" class="form-control"
													value="${command.modemmdn}" placeholder="Modem Mdn">
											</div>
											<div class="form-group">
												<label>Modem Number</label> <input type="text"
													name="modemnumber" class="form-control"
													value="${command.modemnumber}"
													placeholder="Modem Number">
											</div>
											
											
											<div class="form-group">
												<label>Dt Name</label> <input type="text"
													name="dtname" class="form-control"
													value="${command.dtname}"
													placeholder="Dt Name">
											</div>
											<div class="form-group">
												<label>Dt Code</label> <input type="text"
													name="dtcode" class="form-control"
													value="${command.dtcode}" placeholder="dtcode">
											</div>
											<div class="form-group">
												<label>Permanent Pole Number </label> <input type="text"
													name="permanentpolenumber" class="form-control"
													value="${command.permanentpolenumber}" placeholder="Permanent Pole Number">
											</div>
											<div class="form-group">
												<label>Acno </label> <input type="text"
													name="acno" class="form-control"
													value="${command.acno}" placeholder="Acno">
											</div>
											<div class="form-group">
												<label>MCt</label> <input type="text"
													name="MCt" class="form-control"
													value="${command.MCt}"
													placeholder="MCt">
											</div>
											<div class="form-group">
												<label>MPt</label> <input type="text"
													name="MPt" class="form-control"
													value="${command.MPt}"
													placeholder="MPt">
											</div>
											<div class="form-group">
												<label>MF</label> <input type="text"
													name="mf" class="form-control"
													value="${command.mf}"
													placeholder="MF">
											</div>

											<div class="form-group">
												<label>Make</label> <input type="text"
													name="make" class="form-control"
													value="${command.make}" placeholder="Make">
											</div>

											<div class="form-group">
												<label>Meter Seal Date</label> <input type="text" name="meterSealDate"
													class="form-control" value="${command.meterSealDate}"
													placeholder="Meter Seal Date">
											</div>

											<div class="form-group">
												<label>Meter Seal No</label> <input type="text"
													name="meterSealNo" class="form-control"
													value="${command.meterSealNo}"
													placeholder="Meter Seal No">
											</div>
											<div class="form-group">
												<label>Meter Revolution Permit</label> <input type="text"
													name="meterRevolutionPermit" class="form-control"
													value="${command.meterRevolutionPermit}"
													placeholder="Meter Revolution Permit">
											</div>
											<div class="form-group">
												<label>Meter Mfg Date</label> <input type="text"
													name="meterMfgDate" class="form-control"
													value="${command.meterMfgDate}"
													placeholder="Meter Mfg Date">
											</div>
											
											
											
											
											
											
											
											
											
											<div class="form-group">
												<label>Meter Capacity</label> <input type="text"
													name=meterCapacity class="form-control"
													value="${command.meterCapacity}" placeholder="Meter Capacity">
											</div>

											<div class="form-group">
												<label>Current Rating</label> <input type="text"
													name="currentrating" class="form-control"
													value="${command.currentrating}" placeholder="Current Rating">
											</div>

											<div class="form-group">
												<label>Voltage Rating</label> <input type="text"
													name="voltagerating" class="form-control"
													value="${command.voltagerating}" placeholder="Voltage Rating">
											</div>

											<div class="form-group">
												<label>Connection Date</label> <input type="text"
													name="connectiondate" class="form-control"
													value="${command.connectiondate}"
													placeholder="Connection Date">
											</div>
											
											
											
											
											
												<div class="form-group">
												<label>Mcc</label> <input type="text"
													name="mcc" class="form-control"
													value="${command.mcc}"
													placeholder="mcc">
											</div>
											<div class="form-group">
												<label>Mnc</label> <input type="text"
													name="mnc" class="form-control"
													value="${command.mnc}"
													placeholder="Mnc">
											</div>

											<div class="form-group">
												<label>Lac</label> <input type="text"
													name="lac" class="form-control"
													value="${command.lac}" placeholder="Lac">
											</div>

											<div class="form-group">
												<label>Cell Id</label> <input type="text" name="cellid"
													class="form-control" value="${command.cellid}"
													placeholder="Cell Id">
											</div>

											<div class="form-group">
												<label>Squal</label> <input type="text"
													name="squal" class="form-control"
													value="${command.squal}"
													placeholder="Squal">
											</div>
											<div class="form-group">
												<label>Src Lev</label> <input type="text"
													name="srclev" class="form-control"
													value="${command.srclev}"
													placeholder="Src Lev">
											</div>
											<div class="form-group">
												<label>Imei Number</label> <input type="text"
													name="imeiNumber" class="form-control"
													value="${command.imeiNumber}"
													placeholder="Imei Number">
											</div>
											
											<div class="form-group">
												<label>Municipality VDC</label> <input type="text"
													name="municipalityVdc" class="form-control"
													value="${command.municipalityVdc}"
													placeholder="Municipality VDC">
											</div>
											<div class="form-group">
												<label>Ward No</label> <input type="text"
													name="wardNo" class="form-control"
													value="${command.wardNo}" placeholder="Ward No">
											</div>
											<div class="form-group">
												<label>Citizen Ship No </label> <input type="text"
													name="citizenshipNo" class="form-control"
													value="${command.citizenshipNo}" placeholder="Citizen Ship No">
											</div>
											<div class="form-group">
												<label>Citizenship Issued Dist </label> <input type="text"
													name="citizenshipIssuedDist" class="form-control"
													value="${command.citizenshipIssuedDist}" placeholder="Citizenship Issued Dist ">
											</div>
											<div class="form-group">
												<label>Supply Voltage</label> <input type="text"
													name="supplyVoltage" class="form-control"
													value="${command.supplyVoltage}"
													placeholder="Supply Voltage">
											</div>
											<div class="form-group">
												<label>MF Kva</label> <input type="text"
													name="mfKva" class="form-control"
													value="${command.mfKva}"
													placeholder="MF Kva">
											</div>
											
											
										
											
											
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
							<h3 class="card-title">Field Installation Master Information</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								
							</div>
						</div>
					
						<div class="card-body">
						<div class="row">
						
						<div class="col-md-6">
							<dl class="row">
							
								<dt class="col-sm-4">Circle Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.id.circleid}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer No</dt>
								<dd class="col-sm-8">
									<c:out value="${command.id.consumerNo}"></c:out>
								</dd>
								<dt class="col-sm-4">Cons Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consId}"></c:out>
								</dd>
								<dt class="col-sm-4">Discom Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.discomid}"></c:out>
								</dd>
								<dt class="col-sm-4">Discom </dt>
								<dd class="col-sm-8">
									<c:out value="${command.discom}"></c:out>
								</dd>
								<dt class="col-sm-4">Board Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.boardid}"></c:out>
								</dd>
								<dt class="col-sm-4">Board</dt>
								<dd class="col-sm-8">
									<c:out value="${command.board}"></c:out>
								</dd>
								<dt class="col-sm-4">Circle</dt>
								<dd class="col-sm-8">
									<c:out value="${command.circle}"></c:out>
								</dd>
								<dt class="col-sm-4">Division Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.divisionid}"></c:out>
								</dd>
								<dt class="col-sm-4">Division</dt>
								<dd class="col-sm-8">
									<c:out value="${command.division}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Sub Division Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.subdivisionid}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Sub Division</dt>
								<dd class="col-sm-8">
									<c:out value="${command.subdivision}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Sub Division</dt>
								<dd class="col-sm-8">
									<c:out value="${command.subdivision}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Meter Ct Type</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterCtType}"></c:out>
								</dd>
								<dt class="col-sm-4">Meter Elec Type</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterElecType}"></c:out>
								</dd>
								<dt class="col-sm-4">Transformer Make</dt>
								<dd class="col-sm-8">
									<c:out value="${command.transformermake}"></c:out>
								</dd>
								<dt class="col-sm-4">Transfer Location</dt>
								<dd class="col-sm-8">
									<c:out value="${command.transferLocation}"></c:out>
								</dd>
								<dt class="col-sm-4">Independent</dt>
								<dd class="col-sm-8">
									<c:out value="${command.independent}"></c:out>
								</dd>
								<dt class="col-sm-4">Meter No</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterno}"></c:out>
								</dd>
								<dt class="col-sm-4">Modem mdn</dt>
								<dd class="col-sm-8">
									<c:out value="${command.modemmdn}"></c:out>
								</dd>
								<dt class="col-sm-4">Modem Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.modemnumber}"></c:out>
								</dd>
								
								<dt class="col-sm-4">LAC</dt>
								<dd class="col-sm-8">
									<c:out value="${command.lac}"></c:out>
								</dd>
								<dt class="col-sm-4">Cell Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.cellid}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Imei Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.imeiNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Sim Provider Name</dt>
								<dd class="col-sm-8">
									<c:out value="${command.simProviderName}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Longitude</dt>
								<dd class="col-sm-8">
									<c:out value="${command.longitude}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Photo Location</dt>
								<dd class="col-sm-8">
									<c:out value="${command.photolocation}"></c:out>
								</dd>
								<dt class="col-sm-4">Sub Station</dt>
								<dd class="col-sm-8">
									<c:out value="${command.substation}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Feeder Code</dt>
								<dd class="col-sm-8">
									<c:out value="${command.feederCode}"></c:out>
								</dd>
								<dt class="col-sm-4">Feeder Type</dt>
								<dd class="col-sm-8">
									<c:out value="${command.feedertype}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Permanent Pole Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.permanentpolenumber}"></c:out>
								</dd>
								<dt class="col-sm-4">Acno</dt>
								<dd class="col-sm-8">
									<c:out value="${command.acno}"></c:out>
								</dd>
								
								<dt class="col-sm-4">MF</dt>
								<dd class="col-sm-8">
									<c:out value="${command.mf}"></c:out>
								</dd>
								<dt class="col-sm-4">make</dt>
								<dd class="col-sm-8">
									<c:out value="${command.make}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Meter Revolution Permit</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterRevolutionPermit}"></c:out>
								</dd>
								<dt class="col-sm-4">Meter Mfg Date</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterMfgDate}"></c:out>
								</dd>
								
								<dt class="col-sm-4">currentrating</dt>
								<dd class="col-sm-8">
									<c:out value="${command.currentrating}"></c:out>
								</dd>
								<dt class="col-sm-4">meterCapacity</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterCapacity}"></c:out>
								</dd>
								<dt class="col-sm-4">meterChnageFlag</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterChnageFlag}"></c:out>
								</dd>
								<dt class="col-sm-4">proprietorName</dt>
								<dd class="col-sm-8">
									<c:out value="${command.proprietorName}"></c:out>
								</dd>
								
								
								<dt class="col-sm-4">citizenshipNo</dt>
								<dd class="col-sm-8">
									<c:out value="${command.citizenshipNo}"></c:out>
								</dd>
								<dt class="col-sm-4">wardNo</dt>
								<dd class="col-sm-8">
									<c:out value="${command.wardNo}"></c:out>
								</dd>
								
								<dt class="col-sm-4">versionNumber</dt>
								<dd class="col-sm-8">
									<c:out value="${command.versionNumber}"></c:out>
								</dd>
								<dt class="col-sm-4">mfKva</dt>
								<dd class="col-sm-8">
									<c:out value="${command.mfKva}"></c:out>
								</dd>
								
								<dt class="col-sm-4">flag2</dt>
								<dd class="col-sm-8">
									<c:out value="${command.flag2}"></c:out>
								</dd>
								<dt class="col-sm-4">flag1</dt>
								<dd class="col-sm-8">
									<c:out value="${command.flag1}"></c:out>
								</dd>
								<dt class="col-sm-4">offSet</dt>
								<dd class="col-sm-8">
									<c:out value="${command.offSet}"></c:out>
								</dd>
							</dl>
							</div>
						
							<div class="col-md-6">
							<dl class="row">
							
								<dt class="col-sm-4">Section Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.sectionid}"></c:out>
								</dd>
								<dt class="col-sm-4">Section</dt>
								<dd class="col-sm-8">
									<c:out value="${command.section}"></c:out>
								</dd>
								<dt class="col-sm-4">Registraton Id</dt>
								<dd class="col-sm-8">
									<c:out value="${command.registratonId}"></c:out>
								</dd>
								<dt class="col-sm-4">Name</dt>
								<dd class="col-sm-8">
									<c:out value="${command.name}"></c:out>
								</dd>
								<dt class="col-sm-4">Addr</dt>
								<dd class="col-sm-8">
									<c:out value="${command.addr}"></c:out>
								</dd>
								<dt class="col-sm-4">Consumer Category</dt>
								<dd class="col-sm-8">
									<c:out value="${command.consumerCategory}"></c:out>
								</dd>
								<dt class="col-sm-4">CdKva</dt>
								<dd class="col-sm-8">
									<c:out value="${command.cdKva}"></c:out>
								</dd>
								<dt class="col-sm-4">Office Phone</dt>
								<dd class="col-sm-8">
									<c:out value="${command.officePhone}"></c:out>
								</dd>
								<dt class="col-sm-4">Mobile No</dt>
								<dd class="col-sm-8">
									<c:out value="${command.mobileNo}"></c:out>
								</dd>
								<dt class="col-sm-4">Email Address</dt>
								<dd class="col-sm-8">
									<c:out value="${command.emailAddress}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Load Type</dt>
								<dd class="col-sm-8">
									<c:out value="${command.loadType}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Schedule Power</dt>
								<dd class="col-sm-8">
									<c:out value="${command.schedulePower}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Category</dt>
								<dd class="col-sm-8">
									<c:out value="${command.category}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Transformer Ownership</dt>
								<dd class="col-sm-8">
									<c:out value="${command.transformerownership}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Transformers Capacity</dt>
								<dd class="col-sm-8">
									<c:out value="${command.transformerscapacity}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Transfer Location</dt>
								<dd class="col-sm-8">
									<c:out value="${command.transferLocation}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Transformer Serial No</dt>
								<dd class="col-sm-8">
									<c:out value="${command.transformerserialno}"></c:out>
								</dd>
								<dt class="col-sm-4">Hid</dt>
								<dd class="col-sm-8">
									<c:out value="${command.hid}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Modem meId Number</dt>
								<dd class="col-sm-8">
									<c:out value="${command.modemmeidnumber}"></c:out>
								</dd>
								
								<dt class="col-sm-4">MCC</dt>
								<dd class="col-sm-8">
									<c:out value="${command.mcc}"></c:out>
								</dd>
								
								<dt class="col-sm-4">MNC</dt>
								<dd class="col-sm-8">
									<c:out value="${command.mnc}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Squal</dt>
								<dd class="col-sm-8">
									<c:out value="${command.squal}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Srclev</dt>
								<dd class="col-sm-8">
									<c:out value="${command.srclev}"></c:out>
								</dd>
								<dt class="col-sm-4">Modem Manufacturer Name</dt>
								<dd class="col-sm-8">
									<c:out value="${command.modemmanufacturername}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Latitude</dt>
								<dd class="col-sm-8">
									<c:out value="${command.latitude}"></c:out>
								</dd>
								
								
								
								<dt class="col-sm-4">Sub Station Code</dt>
								<dd class="col-sm-8">
									<c:out value="${command.substationCode}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Feeder</dt>
								<dd class="col-sm-8">
									<c:out value="${command.feeder}"></c:out>
								</dd>
								
									<dt class="col-sm-4">DT Name</dt>
								<dd class="col-sm-8">
									<c:out value="${command.dtname}"></c:out>
								</dd>
								
								<dt class="col-sm-4">DT Code</dt>
								<dd class="col-sm-8">
									<c:out value="${command.dtcode}"></c:out>
								</dd>
								
									<dt class="col-sm-4">MCt</dt>
								<dd class="col-sm-8">
									<c:out value="${command.MCt}"></c:out>
								</dd>
								
								<dt class="col-sm-4">MPT</dt>
								<dd class="col-sm-8">
									<c:out value="${command.MPt}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Meter Seal Date</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterSealDate}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Meter Seal No</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterSealNo}"></c:out>
								</dd>
								
									<dt class="col-sm-4">Meter Decimal</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterDecimal}"></c:out>
								</dd>
								
								<dt class="col-sm-4">Meter Digit</dt>
								<dd class="col-sm-8">
									<c:out value="${command.meterDigit}"></c:out>
								</dd>
								
									<dt class="col-sm-4">voltagerating</dt>
								<dd class="col-sm-8">
									<c:out value="${command.voltagerating}"></c:out>
								</dd>
								
								<dt class="col-sm-4">connectiondate</dt>
								<dd class="col-sm-8">
									<c:out value="${command.connectiondate}"></c:out>
								</dd>
								
									<dt class="col-sm-4">municipalityVdc</dt>
								<dd class="col-sm-8">
									<c:out value="${command.municipalityVdc}"></c:out>
								</dd>
								
								<dt class="col-sm-4">district</dt>
								<dd class="col-sm-8">
									<c:out value="${command.district}"></c:out>
								</dd>
								
									<dt class="col-sm-4">supplyVoltage</dt>
								<dd class="col-sm-8">
									<c:out value="${command.supplyVoltage}"></c:out>
								</dd>
								
								<dt class="col-sm-4">citizenshipIssuedDist</dt>
								<dd class="col-sm-8">
									<c:out value="${command.citizenshipIssuedDist}"></c:out>
								</dd>
								
								<dt class="col-sm-4">createddate</dt>
								<dd class="col-sm-8">
									<c:out value="${command.createddate}"></c:out>
								</dd>
								
								<dt class="col-sm-4">status</dt>
								<dd class="col-sm-8">
									<c:out value="${command.status}"></c:out>
								</dd>
								
								<dt class="col-sm-4">ussdCode</dt>
								<dd class="col-sm-8">
									<c:out value="${command.ussdCode}"></c:out>
								</dd>
								
								<dt class="col-sm-4">billDate</dt>
								<dd class="col-sm-8">
									<c:out value="${command.billDate}"></c:out>
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
							<h3 class="card-title">Field Installation Details</h3>
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
										<th>Circle Id</th>
										<th>Consumer No</th>
										<th>Consumer Id</th>
										<th>Cons Id</th>
										<th>discomid</th>
										 <th>discom</th>
										<th>boardid</th>
										<th>board</th>
										<th>circle</th>
										<th>divisionid</th>
										<th>division</th>
										<th>subdivisionid</th>
										<th>subdivision</th>
										<th>sectionid</th>
										<th>section</th>
										<th>registratonId</th>
										<th>name</th>
										<th>addr</th>
										<th>consumerCategory</th>
										<th>cdKva</th>
										<th>officePhone</th>
										<th>mobileNo</th>
										<th>emailAddress</th>
										<th>loadType</th>
										<th>phase</th>
										<th>schedulePower</th>
										<th>category</th>
										<th>meterCtType</th>
										<th>meterOwnership</th>
										<th>meterElecType</th>
										<th>transformerownership</th>
										<th>transformerscapacity</th>
										<th>transformermake</th>
										<th>transferLocation</th>
										<th>transformerserialno</th>
										<th>independent</th>
										<th>meterno</th>
										<th>hid</th>
										<th>modemmeidnumber</th>
										<th>modemmdn</th>
										<th>modemnumber</th>
										<th>mcc</th>
										<th>mnc</th>
										<th>lac</th>
										<th>cellid</th>
										<th>squal</th>
										<th>srclev</th>
										<th>imeiNumber</th>
										<th>simProviderName</th>
										<th>modemmanufacturername</th>
										<th>latitude</th>
										<th>longitude</th>
										<th>photolocation</th>
										<th>substation</th>
										<th>substationCode</th>
										<th>feeder</th>
										<th>feederCode</th>
										<th>feedertype</th>
										<th>dtname</th>
										<th>dtcode</th>
										<th>permanentpolenumber</th>
										<th>acno</th>
										<th>MCt</th>
										<th>MPt</th>
										<th>mf</th>
										<th>make</th>
										<th>meterSealDate</th>
										<th>meterSealNo</th>
										<th>meterRevolutionPermit</th>
										<th>meterMfgDate</th>
										<th>meterDecimal</th>
										<th>meterDigit</th>
										<th>meterCapacity</th>
										<th>currentrating</th>
										<th>voltagerating</th>
										<th>connectiondate</th>
										<th>meterChnageFlag</th>
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
								"sAjaxSource": "fetchFieldInstallationMasterDetails?" + url,
								 "aoColumns": [
         	{
	                 "mData": "id",
	                 "defaultContent" : "-",
	                 render: function (data, type, row, meta) {
	                
	                 return meta.row + meta.settings._iDisplayStart + 1;
			    }
			},
			{"mData":"id.circleid", "defaultContent":"-"},
			{"mData":"id.consumerNo", "defaultContent":"-"},
		
{"mData":"id.consumerid", "defaultContent":"-"},

		
		/* {
	                 "mData": "id.consumerid",
	                 
	                render:  function (data, type, full) {
         return parseFloat(data).toFixed(1);
    }
			}, */
// 			{"mData":"id.consumerid", "defaultContent":"-"},
			{"mData":"consId", "defaultContent":"-"},
			{"mData":"discomid", "defaultContent":"-"},
         	{"mData":"discom", "defaultContent":"-"},
			{"mData":"boardid", "defaultContent":"-"},
			{"mData":"board", "defaultContent":"-"},
			{"mData":"circle", "defaultContent":"-"},
		 	{"mData":"divisionid", "defaultContent":"-"},
			{"mData":"division", "defaultContent":"-"},
			{"mData":"subdivisionid", "defaultContent":"-"},
			{"mData":"subdivision", "defaultContent":"-"},
			{"mData":"sectionid", "defaultContent":"-"},
			{"mData":"section", "defaultContent":"-"},
			{"mData":"registratonId", "defaultContent":"-"},
			{"mData":"name", "defaultContent":"-"},
			{"mData":"addr", "defaultContent":"-"},
			{"mData":"consumerCategory", "defaultContent":"-"},
			{"mData":"cdKva", "defaultContent":"-"},
			{"mData":"officePhone", "defaultContent":"-"},
			{"mData":"mobileNo", "defaultContent":"-"},
			{"mData":"emailAddress", "defaultContent":"-"},
			{"mData":"loadType", "defaultContent":"-"},
			{"mData":"phase", "defaultContent":"-"},
			{"mData":"schedulePower", "defaultContent":"-"},
			{"mData":"category", "defaultContent":"-"},
			{"mData":"meterCtType", "defaultContent":"-"},
			{"mData":"meterOwnership", "defaultContent":"-"},
			{"mData":"meterElecType", "defaultContent":"-"},
			{"mData":"transformerownership", "defaultContent":"-"},
			{"mData":"transformerscapacity", "defaultContent":"-"},
			{"mData":"transformermake", "defaultContent":"-"},
			{"mData":"transferLocation", "defaultContent":"-"},
			{"mData":"transformerserialno", "defaultContent":"-"},
			{"mData":"independent", "defaultContent":"-"},
			{"mData":"meterno", "defaultContent":"-"},
			{"mData":"hid", "defaultContent":"-"},
			{"mData":"modemmeidnumber", "defaultContent":"-"},
			{"mData":"modemmdn", "defaultContent":"-"},
			{"mData":"modemnumber", "defaultContent":"-"},
			{"mData":"mcc", "defaultContent":"-"},
			{"mData":"mnc", "defaultContent":"-"},
			{"mData":"lac", "defaultContent":"-"},
			{"mData":"cellid", "defaultContent":"-"},
			{"mData":"squal", "defaultContent":"-"},
			{"mData":"srclev", "defaultContent":"-"},
			{"mData":"imeiNumber", "defaultContent":"-"},
			{"mData":"simProviderName", "defaultContent":"-"},
			{"mData":"modemmanufacturername", "defaultContent":"-"},
			{"mData":"latitude", "defaultContent":"-"},
			{"mData":"longitude", "defaultContent":"-"},
			{"mData":"photolocation", "defaultContent":"-"},
			{"mData":"substation", "defaultContent":"-"},
			{"mData":"substationCode", "defaultContent":"-"},
			{"mData":"feeder", "defaultContent":"-"},
			{"mData":"feederCode", "defaultContent":"-"},
			{"mData":"feedertype", "defaultContent":"-"},
			{"mData":"dtname", "defaultContent":"-"},
			{"mData":"dtcode", "defaultContent":"-"},
			{"mData":"permanentpolenumber", "defaultContent":"-"},
			{"mData":"acno", "defaultContent":"-"},
			{"mData":"MCt", "defaultContent":"-"},
			{"mData":"MPt", "defaultContent":"-"},
			{"mData":"mf", "defaultContent":"-"},
			{"mData":"make", "defaultContent":"-"},
			{"mData":"meterSealDate", "defaultContent":"-"},
			{"mData":"meterSealNo", "defaultContent":"-"},
			{"mData":"meterRevolutionPermit", "defaultContent":"-"},
			{"mData":"meterMfgDate", "defaultContent":"-"},
			{"mData":"meterDecimal", "defaultContent":"-"},
			{"mData":"meterDigit", "defaultContent":"-"},
			{"mData":"meterCapacity", "defaultContent":"-"},
			{"mData":"currentrating", "defaultContent":"-"},
			{"mData":"voltagerating", "defaultContent":"-"},
			{"mData":"connectiondate", "defaultContent":"-"},
			{"mData":"meterChnageFlag", "defaultContent":"-"},
			{
				data: function(row, type, set) {
				return '<a class="btn btn-info btn-sm" onClick="submitMyForm(\'editFieldInstallationMaster \',\'' + row.id.circleid + '\',\'' + row.id.consumerid + '\',\'' + row.id.consumerNo + '\',\'' + 'View' + '\')"><i class="fas fa-binoculars"></i></a>';
			}
				}, 
				{
					data: function(row, type, set) {
						return ' <a class="btn btn-warning btn-sm" onClick="submitMyForm(\'editFieldInstallationMaster \',\'' + row.id.circleid + '\',\'' + row.id.consumerid + '\',\'' + row.id.consumerNo + '\',\'' + 'Edit' + '\')"><i class="fas fa-pencil-alt"></i></a>';
					}
					
					},
						{
					data: function(row, type, set) {
						return ' <a class="fa fa-trash" onClick="submitMyForm(\'deleteFieldInstallation \',\'' + row.id.circleid + '\',\'' + row.id.consumerid + '\',\'' + row.id.consumerNo + '\',\'' + 'Delete' + '\')"><i class=""></i></a>';
					}
					},
        ]
							});
							if(hideColumns != "") {
							alert(hideColumns);
								table.columns(hideColumns).visible(false);
								table.columns(showColumns).visible(true);
							} else {
							
								table.columns(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30).visible(true);//Total No.of columns
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
						
			
		$('.ExportClass').click(function(){
	    				var searchParameter = "",
							searchSelectVar = "",
							conditionStr = "";
	    				var action ="exportFieldInstallation?"+url;
$('<form method="post" action="'+action+'"></form>').appendTo('body').submit();
	    	});
					});
	</script>


	<script type="text/javascript">
		function submitMyForm(action, circleid,consumerNo,consumerid, viewType) {
		alert(consumerid);
						$('<form method="post" action="' + action + '"><input type="hidden" name="circleid" value="' + circleid + '" /><input type="hidden" name="consumerNo" value="' + consumerNo + '" /><input type="hidden" name="consumerid" value="' + consumerid + '" /><input type="hidden" name="viewType" value="' + viewType + '" /></form>').appendTo('body').submit();
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