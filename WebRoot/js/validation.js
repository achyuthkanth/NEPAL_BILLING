/*$(document).ready(function() {
	$(document).bind("contextmenu", function(e) {
		alert("Right click is not allowed");
		return false;
	});
}); 
*/


$(document).ready(function() {
	 $(".levelSelectClass").change(function() {
		 
		 var levelIdRef=$(this).attr('id');
		 var levelValue=$(this).val();
		 var levelCount=1;

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
		 if(levelIdRef=="-1"){
			 return false;
		 }else{
			 for(var i=15;i>levelCount;i--){
				$('#level'+i+'Id').find('option').remove().end();
				$('#level'+i+'Id').append('<option selected value=-1>SELECT</option>');
			 }		
			 
			 var levelMapString="levelCount="+levelCount+"&levelValue="+levelValue;
			 for(var i=levelCount;i>=1;i--){
//				 levelMapString=levelMapString+"level"+i+"Id="+$('#level'+i+'Id').val();
				 levelMapString=levelMapString;
				 if(i>1){
					 levelMapString=levelMapString+"&";
				 }
			 }
			 
			 if(levelValue=="-1"){
				 return false; 
			 }else if(levelValue=="NEW LEVEL"){
				 var levelName=$(".levelNameClass").val();
				 
				 $("#myModalLabel").text("ADD NEW LEVEL"+levelCount+" DETAILS");
			 		$("#levelCodeVal").text(levelName+" Code");
			 		$("#LevelNameVal").text(levelName);
			 		$("#levelIdRef").val(levelIdRef);
			 		$("#levelValue").val(levelValue);
			 		$("#levelCount").val(levelCount);
			 		
			 		if(levelCount==1){
			 			$('#level'+levelCount+'Id').val("-1");
			 			$('#myDataToggle').click();
			 		}else{
				 		 var prelevelCount=levelCount-1;
						 if($('#level'+prelevelCount+'Id').val()=="-1"){
//							alert("Please select level"+prelevelCount+"Id");
							$('#level'+levelCount+'Id').val("-1");
							return false;
						 }else if($('#level'+prelevelCount+'Id').val()=="NEW LEVEL"){
//						 	alert("Please select level"+prelevelCount+"Id");
							$('#level'+levelCount+'Id').val("-1");
							return false;
						 }else{
						 	$('#level'+levelCount+'Id').val("-1");
					 	 	$('#myDataToggle').click();	
					 	 }
			 		}
				 
			 }else{ 
				 for(var i=15;i>levelCount;i--){
					$('#level'+i+'Id').find('option').remove().end();
					$('#level'+i+'Id').append('<option selected value=-1>SELECT</option>');
					$('<option>').val("NEW LEVEL").text("NEW LEVEL").appendTo('#level'+i+'Id');
				 }	
				 
				 var levelMapString="levelCount="+levelCount+"&levelValue="+levelValue;

				 $.getJSON('hierarchylevelsmap?'+levelMapString,{
						},function(jsonResponse) {
							$.each(jsonResponse,function(key,value) {
								$('<option>').val(key).text(value).appendTo('#level'+(levelCount+1)+'Id');
							});
					});
			 }
			 
		 }
	 });
	 
});
	 
	 $(document).ready(function() {
		 $(".appLevelSelectClass").change(function() {
			 var levelIdRef=$(this).attr('id');
			 var levelValue=$(this).val();
			 var levelCount=1;

			 if(levelIdRef=="appLevel1Id"){
				 levelCount=1;
			 }else if(levelIdRef=="appLevel2Id"){
				 levelCount=2;
			 }else if(levelIdRef=="appLevel3Id"){
				 levelCount=3;
			 }else if(levelIdRef=="appLevel4Id"){
				 levelCount=4;
			 }else if(levelIdRef=="appLevel5Id"){
				 levelCount=5;
			 }else if(levelIdRef=="appLevel6Id"){
				 levelCount=6;
			 }else if(levelIdRef=="appLevel7Id"){
				 levelCount=7;
			 }else if(levelIdRef=="appLevel8Id"){
				 levelCount=8;
			 }else if(levelIdRef=="appLevel9Id"){
				 levelCount=9;
			 }else if(levelIdRef=="appLevel10Id"){
				 levelCount=10;
			 }else if(levelIdRef=="appLevel11Id"){
				 levelCount=11;
			 }else if(levelIdRef=="appLevel12Id"){
				 levelCount=12;
			 }else if(levelIdRef=="appLevel13Id"){
				 levelCount=13;
			 }else if(levelIdRef=="appLevel14Id"){
				 levelCount=14;
			 }else if(levelIdRef=="appLevel15Id"){
				 levelCount=15;
			 }
			 
			 if(levelIdRef=="-1"){
				 return false;
			 }else{
				 
				 for(var i=15;i>levelCount;i--){
					$('#appLevel'+i+'Id').find('option').remove().end();
					$('#appLevel'+i+'Id').append('<option selected value=-1>SELECT</option>');
				 }		
				 
				 var levelMapString="levelCount="+levelCount+"&levelValue="+levelValue;
				 for(var i=levelCount;i>=1;i--){
//					 levelMapString=levelMapString+"appLevel"+i+"Id="+$('#appLevel'+i+'Id').val();
					 levelMapString=levelMapString;
					 if(i>1){
						 levelMapString=levelMapString+"&";
					 }
				 }
//				 var levelMapString="levelCount="+levelCount+"&levelValue="+levelValue;
				 
				 if(levelValue=="-1"){
					 return false; 
				 }else if(levelValue=="NEW LEVEL"){
					 $("#myModalLabel").text("ADD NEW LEVEL"+levelCount+" DETAILS");
				 		$("#levelCodeVal").text("Level"+levelCount+" Code");
				 		$("#LevelNameVal").text("Level"+levelCount+" Name");
				 		
				 		$("#levelIdRef").val(levelIdRef);
				 		$("#levelValue").val(levelValue);
				 		$("#levelCount").val(levelCount);
				 		
				 	
				 		
				 		if(levelCount==1){
				 			$('#appLevel'+levelCount+'Id').val("-1");
				 				$( "#myDataToggle" ).click();
				 		}else{
					 		 var prelevelCount=levelCount-1;
							 if($('#appLevel'+prelevelCount+'Id').val()=="-1"){
								alert("Please select level"+prelevelCount+"Id");
								$('#appLevel'+levelCount+'Id').val("-1");
								return false;
							 }else if($('#level'+prelevelCount+'Id').val()=="NEW LEVEL"){
							 	alert("Please select level"+prelevelCount+"Id");
								$('#appLevel'+levelCount+'Id').val("-1");
								return false;
							 }else{
							 	$('#appLevel'+levelCount+'Id').val("-1");
							 	$( "#myDataToggle" ).click();
						 	 }
				 		}
					 
				 }else{
					 
					 for(var i=15;i>levelCount;i--){
							$('#level'+i+'Id').find('option').remove().end();
							$('#level'+i+'Id').append('<option selected value=-1>SELECT</option>');
							$('<option>').val("NEW LEVEL").text("NEW LEVEL").appendTo('#appLevel'+i+'Id');
						 }	
					 
					 $.getJSON('appHierarchyLevelsMap?'+levelMapString,{
						},function(jsonResponse) {
								$.each(jsonResponse,function(key,value) {
								$('<option>').val(key).text(value).appendTo('#appLevel'+(levelCount+1)+'Id');
							});
					});
			 }
			 
		 }
	});

	});

	 $(document).ready(function() {
	 $('input#submitButton').click( function() {
			var url = "saveHierarchyDetails";
			var formString="";
			var levelCount=$("#levelCount").val();
			var prelevelCount=levelCount-1;
			
				for(var i=1;i<=15;i++){
					if(i==levelCount){
						formString=formString+'<input type="hidden" name="level'+i+'Id" value="-1" />';
					}else{
						formString=formString+'<input type="hidden" name="level'+i+'Id" value="' + $('#level'+i+'Id').val() + '" />';
					}
				}
				formString=formString+'<input type="hidden" name="levelIdRef" value="' + $("#levelIdRef").val() + '" />';
				formString=formString+'<input type="hidden" name="levelValue" value="' + $("#levelValue").val() + '" />';
				formString=formString+'<input type="hidden" name="levelCount" value="' + $("#levelCount").val() + '" />';
				formString=formString+'<input type="hidden" name="HierStatus" value="' + $("#submitMeterH").val() + '" />';
				$(formString).appendTo('#tableform');
				$('#levelForm').attr('action', "saveHierarchyDetails");
				$('form#levelForm').submit();
			
			});
	 
	 
	 $('input#appLevelsSubmitButton').click( function() {
			var url = "saveApplicationHierarchyDetails";
			var formString="";
			var levelCount=$("#levelCount").val();
			var prelevelCount=levelCount-1;
			
				for(var i=1;i<=15;i++){
					if(i==levelCount){
						formString=formString+'<input type="hidden" name="appLevel'+i+'Id" value="-1" />';
					}else{
						formString=formString+'<input type="hidden" name="appLevel'+i+'Id" value="' + $('#appLevel'+i+'Id').val() + '" />';
					}
				}
				formString=formString+'<input type="hidden" name="levelIdRef" value="' + $("#levelIdRef").val() + '" />';
				formString=formString+'<input type="hidden" name="levelValue" value="' + $("#levelValue").val() + '" />';
				formString=formString+'<input type="hidden" name="levelCount" value="' + $("#levelCount").val() + '" />';
				$(formString).appendTo('#tableform');
				$('#levelForm').attr('action', "saveApplicationHierarchyDetails");
				$('form#levelForm').submit();
			
			});
	 
	 });



$(document).keydown(function(objEvent) {
                                                 
});
