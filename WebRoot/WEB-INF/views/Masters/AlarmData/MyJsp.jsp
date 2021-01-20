<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>TANGEDCO - MDAS</title>
 <link rel="icon" href="img/TANGEDCO.png" type="image/gif" sizes="32x32"> 

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dashboard.css">
<link rel="stylesheet"
	href="css/font-awesome-4.7.0/css/font-awesome.min.css">

<script type="text/javascript" language="javascript"
	src="js/datatable/jquery-3.3.1.js"></script>
<script type="text/javascript" language="javascript"
	src="js/datatable/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" href="js/datatable/dataTables.bootstrap4.min.css">
<script type="text/javascript"
	src="js/datatable/jquery.dataTables.min.js"></script>
	<script src="js/validation.js"></script>
 <link href="css/date-picker/datapicker/datepicker3.css" rel="stylesheet">
<link href="css/date-picker/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
<style type="text/css">
#example_filter {
	display: none;
}
</style>
<style>
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch input { 
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
var url;
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
			"level15Id="+$('.level15Class').find('option:selected').val()+"&"+
			"instType="+'${command.instType}'+"&"+
			"meterNumber="+'${command.meterNumber}';
			
			loadDataTable(url);
			
function loadDataTable(url) {
	var $dtable = $('#example');
var dtable  = $dtable.DataTable({
	        "bServerSide": true,
	        "bProcessing": true,
	        "bJQueryUI": true,
	        "render": true,
	         "bDestroy": true,
	        "sAjaxSource": "fetchAlarmDataLatestDetails?"+url,    
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
			{ "mData": "nodeNumber" ,  "defaultContent": "-"},
			{ "mData": "meterNumber" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.consumerName" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.consumerNumber" ,  "defaultContent": "-"},
			{
	                 "mData": "alarmDate",
	    			"render": function (data) {
	    			 if (data == null){ return '-'; }else{
	        		 var date = new Date(data);
	       			 var month = date.getMonth() + 1;
	       			  return (date.getDate() < 10 ? ("0"+date.getDate()) : date.getDate())+"-"+(month < 10 ? ("0"+month) : month) + "-" + date.getFullYear()+ "&nbsp;&nbsp;" 
			      +(date.getHours() < 10 ? ("0"+date.getHours()) : date.getHours())+ ":"
			      +(date.getMinutes() < 10 ? ("0"+date.getMinutes()) : date.getMinutes())+ ":"
			      +(date.getSeconds() < 10 ? ("0"+date.getSeconds()) : date.getSeconds());
			   } }},
			{ "mData": "sequenceNumber" ,className: "sensitive",   "defaultContent": "-"},
			{ "mData": "alarmCode" , className: "sensitive",  "defaultContent": "-"},
			{ "mData": "alarmDescription" ,className: "sensitive",  "defaultContent": "-"},
			/* { "mData": "meterMasterObj.installationType" ,  "defaultContent": "-"}, */
			{ "mData": "meterMasterObj.level1Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level1Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level2Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level2Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level3Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level3Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level4Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level4Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level5Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level5Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level6Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level6Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level7Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level7Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level8Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level8Code" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level9Name" ,  "defaultContent": "-"},
			{ "mData": "meterMasterObj.level9Code" ,  "defaultContent": "-"},
		]
	    } );
	    
	    
	    $('.rect-check input').change(function(e){
		var className = '.sensitive';
		var isChecked = document.getElementById("checkId").checked;
		  var columns = dtable.columns(className);
		  columns.each(function() { 
		    this.visible(!isChecked)
		  }) 
		})
	    
}

function loadUrlData(){
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
					"level15Id="+$('.level15Class').find('option:selected').val()+"&"+
					"instType="+$('.installationTypeC').val()+"&"+
					"meterNumber="+$('#meterNumber').val();
}

	$('.submitClass').click(function(){
				$("#checkId").prop("checked", false);
	  				loadUrlData();
			    	loadDataTable(url);
	    	});
	    	
	    	   		$('.ExportClass').click(function(){
	    				loadUrlData(url); 
	    				var action ="exportAlarmLatestDataDetails?"+url;
$('<form method="post" action="'+action+'"></form>').appendTo('body').submit();
	    	});
} );




</script>

<script type="text/javascript">
function callFunction(){

 var columns = $('#example').columns(className);
 
 alert(columns);


	if(document.getElementById("checkId").checked==false){
	//  alert("false");
	}else{
	// alert("true");
	}
}
</script>

</head>

<body>
	<div class="wrapper">
		<!-- Sidebar  -->
		<%@ include file="/WEB-INF/Views/common/header.jsp"%>

		<!-- Page Content  -->
		<div class="container">
		<div id="content">
			<div class="col-sm-12">
				
				<div class="">
					<div class="card">
						<div class="chart-wrapper mb-4">
							<div class="ibox">
										<div class="card-title bg-black" style="color:#fff !important;">
											<h4>ALARM DATA LATEST</h4>
											<div class="card-sub-heading">
												<a class="collapse-link" href=""> <i
													class="fa fa-chevron-up"></i> </a> <a class="close-link" href="">
													<i class="fa fa-times"></i> </a>
											</div>
										</div>
										<div class="ibox-content">
							<form:form>
								<div class="card-content">
								<div class="row">
						 			<%@ include file="/WEB-INF/Views/Hierarchies/HierarchyLevels.jsp"%>
								</div>
							</div>
							</form:form>
							<div class="card-content">
							<div class="row">
										<div class="col-sm-3 form-box">
											<label>Meter Number </label>
													<form:input class="form-control control1 col-sm-6" type="text"
														id="meterNumber" path="command.meterNumber"
														autocomplete="off"  ondrop="return false;"></form:input> 
												</div>
												
												<div class="col-sm-2 form-box">
															<label>Select Installation Type </label> 
																	<form:select path="command.instType"
																		cssClass="control1 form-control col-sm-6 installationTypeC">
																		<form:option value="ALL" label="ALL" />
																		<form:options items="${instTypeList}" />
																	</form:select>
																</div>
												<div class="button-center col-sm-2">
													<div class="" style="margin-top: 20px;">
														<!-- <div class="rect-check">
															<input data-column=".sensitive" type="checkbox">
															Show sensitive
														</div> -->
														<button type="submit" class="btn btn-danger submitClass">View</button>
														<button type="button" class="btn btn-danger ExportClass" id="ExportButton"><span class="icon-img"><img src="img/icons/excel.png" style="width:22px;height:22px;"></span> Export</button>
													</div>
												</div>
												
												<div class="rect-check" style="float:left;margin-top:20px;"><label class="switch" class="rect-check"> 
														<input type="checkbox" id="checkId"> <span class="slider round"></span> </label>
														</div>
										</div>
							
							</div>
							</div>
							</div>
							</div>
						<div class="chart-wrapper mb-4">
							<div class="ibox">
										<div class="card-title bg-black" style="color:#fff !important;">
											<h4>ALARM DATA LATEST DETAILS</h4>
											<div class="card-sub-heading">
<!-- 												<a href="#" class="btn btn-dark-blue btn-circle active tip-top btn-sm" data-toggle="tooltip" title="" data-original-title="Upload"><i class="fas fa-file-excel"></i></a> -->
													<a class="collapse-link" href=""> <i
														class="fa fa-chevron-up"></i> </a> <a class="close-link" href="">
														<i class="fa fa-times"></i> </a>
												</div>
										</div>
										<div class="ibox-content">
							<div class="card-content">
								<table cellpadding="0" cellspacing="0" border="0"
									class="inline-block nowrap table table-responsive table-bordered table-hover table-striped dataTable no-footer"
									id="example" style="display: block !important;">
									<thead>
										<tr>
											<th>S.No</th>
											<th>Node Number</th>
											<th>Meter Number</th>
											<th>Consumer Name</th>
											<th>Consumer Number</th>
											<th>Date Time</th>
											<th>seq. no</th>
											<th>Alarm Code</th>
											<th>Alarm Description</th>
											<!-- <th>Installation Type</th> -->
											<th>Utility</th>
											<th>Utility Code</th>
											<th>Region</th>
											<th>Region Code</th>
											<th>Circle</th>
											<th>Circle Code</th>
											<th>Division</th>
											<th>Division Code</th>
											<th>Sub Division</th>
											<th>Sub Division Code</th>
											<th>Town</th>
											<th>Town Code</th>
											<th>Section</th>
											<th>Section Code</th>
											<th>Sub Station</th>
											<th>Sub Station Code</th>
											<th>Feeder</th>
											<th>Feeder Code</th>
										</tr>
									</thead>
								</table>
								</div>
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<%@ include file="/WEB-INF/Views/common/footer.jsp"%>
	
	</div>
<script defer src="js/solid.js"></script>
<script defer src="js/fontawesome.js"></script>

<script src="js/bootstrap.min.js"></script>
<script src="js/datepicker/datapicker/bootstrap-datepicker.js"></script>
<script src="js/datepicker/daterangepicker/daterangepicker.js"></script>
<script type="text/javascript">
$(document).ready(function() {
$('.LevelSelectClass').change(function(){
  var levelIdRef=$(this).attr('id');
    if(levelIdRef=="level1Id"){
			 levelCount=1;
		 }else if(levelIdRef=="level2Id"){
			 levelCount=2;
		 }else if(levelIdRef=="level3Id"){
			 levelCount=3;
		 }else if(levelIdRef=="level4Id"){
			 levelCount=4;
		 }else if(levelIdRef=="level5Id"){
			 levelCount=5;
		 }else if(levelIdRef=="level6Id"){
			 levelCount=6;
		 }else if(levelIdRef=="level7Id"){
			 levelCount=7;
		 }else if(levelIdRef=="level8Id"){
			 levelCount=8;
		 }else if(levelIdRef=="level9Id"){
			 levelCount=9;
		 }else if(levelIdRef=="level10Id"){
			 levelCount=10;
		 }
		 var a =levelCount+1;
$('#level'+a+'Id').find('option').each(function()
{
   $('#level'+a+'Id option[value="NEW LEVEL"]').hide();
});
});
});
</script>
<script>
		$('#data_1 .input-group.date').datepicker({
                 todayBtn: "linked",
                 keyboardNavigation: false,
                 forceParse: false,
                 calendarWeeks: true,
                 autoclose: true,
                 format : 'yyyy-mm-dd',
                 enableOnReadonly: false,
             });
</script>
<script>
		$('#data_2 .input-group.date').datepicker({
                todayBtn: "linked",
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true,
                format : 'yyyy-mm-dd',
                enableOnReadonly: false,
            });
</script>
<script>
		$('.collapse-link').on('click', function (e) {
        e.preventDefault();
        var ibox = $(this).closest('div.ibox');
        var button = $(this).find('i');
        var content = ibox.children('.ibox-content');
        content.slideToggle(200);
        button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
        ibox.toggleClass('').toggleClass('border-bottom');
        setTimeout(function () {
            ibox.resize();
            ibox.find('[id^=map-]').resize();
        }, 50);
    });

	 // Close ibox function
    $('.close-link').on('click', function (e) {
        e.preventDefault();
        var content = $(this).closest('div.ibox');
        content.remove();
    });
	</script>
</body>
</html>
