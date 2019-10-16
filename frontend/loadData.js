var ctx = document.getElementById("myChart").getContext('2d');
var opts = {
  angle: 0, // The span of the gauge arc
  lineWidth: 0.14, // The line thickness
  radiusScale: 1, // Relative radius
  percentColors: [[0.0, "#ff0000" ], [0.50, "#00ff00"], [1.0, "#ff0000"]],
  pointer: {
	length: 0.46, // // Relative to gauge radius
	strokeWidth: 0.015, // The thickness
	color: '#000000' // Fill color
  },
  limitMax: false,     // If false, max value increases automatically if value > maxValue
  limitMin: false,     // If true, the min value of the gauge will be fixed
  colorStart: '#6FADCF',   // Colors
  colorStop: '#8FC0DA',    // just experiment with them
  strokeColor: '#E0E0E0',  // to see which ones work best for you
  generateGradient: true,
  highDpiSupport: true,     // High resolution support
  
};
var target = document.getElementById("myChart"); // your canvas element
var gauge = new Gauge(target).setOptions(opts); // create sexy gauge!
gauge.maxValue = 14; // set max gauge value
gauge.setMinValue(0);  // Prefer setter over gauge.minValue = 0
gauge.animationSpeed = 30; // set animation speed (32 is default value)
gauge.set(7);

function loadData() {
	var tempVal;
	var tempField = $("#temperature");
	var pHVal;


	$.ajax({
		url: "https://api.waterdata.de/sensor/search/timedec",
		type: "get",
		success: function (response) {
		   
			if (response._embedded.sensor[0].sensor == "temp") {
				tempVal = Math.round(response._embedded.sensor[0].value * 10) / 10;
				pHVal = Math.round(response._embedded.sensor[1].value * 10) / 10;
			} else {
				tempVal = Math.round(response._embedded.sensor[1].value * 10) / 10;
				pHVal = Math.round(response._embedded.sensor[0].value * 10) / 10;
			}
			
			
			tempField.html(tempVal + "&deg;");
			gauge.set(pHVal);
			
			
			$("#currentPH").html(pHVal);
		},
		error: function(jqXHR, textStatus, errorThrown) {
		   console.log(textStatus, errorThrown);
		}
	});

}
loadData();
setInterval(loadData, 3000);