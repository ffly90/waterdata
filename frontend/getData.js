
function timeConverter(UNIX_timestamp){
  var a = new Date(UNIX_timestamp * 1000);
  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  var year = a.getFullYear();
  var month = months[a.getMonth()];
  var date = a.getDate();
  var hour = a.getHours();
  var min = a.getMinutes();
  var sec = a.getSeconds();
  var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
  return time;
}


function getData(measureID) {
	/*var url;
	if (measureID == -1) {
		//TODO: latest
		url = "https://api.waterdata.de/sensor";
	} else {
		//TODO //done
		url = "https://api.waterdata.de/measure/objectID?objectID=" + measureID;
	}
	
	//data as array for charts
	var dataTemp = [];
	var dataPH = [];
	
	$.ajax({
		url: url,
		type: "get",
		success: function (response) {
			
			var bufferTemp = [];
			var bufferPH = [];
			
			alert(JSON.stringify(response, null, 2));
			for (var i = 0; i < allVals.length; i++) {
				if (allVals[i].sensor == "pH") {
					bufferPH.push(allVals[i]);
				} else {
					bufferTemp.push(allVals[i]);
				}
			}
			
			
			for (var i = 0; i < bufferTemp.length; i++) {
				dataTemp[i] = { x: new moment(bufferTemp[i].timestamp),  y: bufferTemp[i].value };
				dataPH[i] = { x: new moment(bufferPH[i].timestamp), y: bufferPH[i].value };
			}
			
			var tempData = {
			  datasets: [{
				label: "Temp",
				data: dataTemp,
				borderColor: '#267b9f',
			  }],
			};
				 
			var chartOptions = {
			  scales: {
				xAxes: [{
				type: 'time'
				}]
			  },
			  legend: false
			};
			
			var lineChart = new Chart($("#myChart1"), {
				type: 'line',
				data: tempData,
				options: chartOptions
			});
				
			var pHData = {
			  datasets: [{
				label: "pH",
				data: dataPH,
				borderColor: '#267b9f',
			  }]
			};
			 
			chartOptions = {
				scales: {
				xAxes: [{
				type: 'time'
				}]
				},
				legend: false
			};
			
			var ctx = $("#myChart2");
			var lineChart = new Chart(ctx, {
				type: 'line',
				data: pHData,
				options: chartOptions
			});
			
			
			//draw max, min, avg
			/*$("#tempMax").html("Max: " + response.channels.temp.max + "&deg;");
			$("#tempMin").html("Min: " + response.channels.temp.min + "&deg;");
			$("#tempAvg").html("Avg: " + response.channels.temp.avg + "&deg;");
			$("#phMax").html("Max: " + response.channels.pH.max);
			$("#phMin").html("Min: " + response.channels.pH.min);
			$("#phAvg").html("Avg: " + response.channels.pH.avg);
			
			
			//draw table
			for (var i = 0; i < bufferTemp.length; i++) {
				$("#staticTableBody").append("<tr id=row" + i + " class='tableRow'><td>" + timeConverter(bufferTemp[i].timestamp) + "</td><td>" + bufferTemp[i].value + "</td><td>" + bufferPH[i].value + "</td></tr>");
			}
			
			
		},
		error: function(jqXHR, textStatus, errorThrown) {
		   console.log(textStatus, errorThrown);
		   alert("not");
		}
	});
	*/
	
	
	var data = [{
			  x: new moment().add(-10, "months"),
			  //x: new moment(1318874398806),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-8, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-6, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-4, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-2, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-0, "months"),
			  y: Math.random() * 100
			}];

		var data1 = [{
			  x: new moment().add(-10, "months"),
			  //x: new moment(1318874398806),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-8, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-6, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-4, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-2, "months"),
			  y: Math.random() * 100
			},
			{
			  x: new moment().add(-0, "months"),
			  y: Math.random() * 100
			}];
			
			
			var tempData = {
			  datasets: [{
				label: "Temp",
				data: data,
				borderColor: '#267b9f',
			  }],
			};
				 
			var chartOptions = {
			  scales: {
				xAxes: [{
				type: 'time'
				}]
			  },
			  legend: false
			};
			
			var lineChart = new Chart($("#myChart1"), {
				type: 'line',
				data: tempData,
				options: chartOptions
			});
				
			var pHData = {
			  datasets: [{
				label: "pH",
				data: data1,
				borderColor: '#267b9f',
			  }]
			};
			 
			chartOptions = {
				scales: {
				xAxes: [{
				type: 'time'
				}]
				},
				legend: false
			};
			
			var ctx = $("#myChart2");
			var lineChart = new Chart(ctx, {
				type: 'line',
				data: pHData,
				options: chartOptions
			});

	//return data;
}