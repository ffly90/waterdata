function myRequest(url, func) { 
	$.ajax({
		url: url,
		type: "get",
		success: func,
		error: function(jqXHR, textStatus, errorThrown) {
		   console.log(textStatus, errorThrown);
		}
	});
}	