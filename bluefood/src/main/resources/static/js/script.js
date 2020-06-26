  function isNumberKey(evt){
 	var charCode = (evt.which) ? evt.which : event.key;
	
 	if((charCode>=48 && charCode <= 57) || charCode <= 31){
 		return true;
 	}	
	
 	return false; 		
 }