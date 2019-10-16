var express = require('express');
var morgan = require('morgan');
var app = express();

app.use(morgan('combined'));
app.set('json spaces', 2)

app.get('/', function (req, res) {
	var obj={_okay:true, _error:""};
  	res.json(obj);
});
app.get('/measurement/all', function(req, res) {
	var obj={num: 2, measurements:[{start:0, end: 100, id: "asdsdf", state: "stopped", channels:{pH:{min: 1, max: 2, avg: 1.5},temp:{min: 1, max: 2, avg: 1.5}}},
	{start: 200, id: "asfqw", state: "running",channels:{pH:{min: 1, max: 2, avg: 1.5},temp:{min: 1, max: 2, avg: 1.5}}}],_okay:true, _error:""};
	res.json(obj);
});
app.get('/measurement/latest', function(req, res) {
        var obj={start:0, end: 100, id: "asfqw", state: "running", channels:{pH:{min: 1, max: 2, avg: 1.5, data:[{timestamp:0,value:1.1},{timestamp:1,value:1.1}]},
	temp:{min: 1, max: 2, avg: 1.5, data:[{timestamp:0,value:1.1},{timestamp:1,value:1.1}]}},_okay:true, _error:""};
        res.json(obj);
});
app.get('/measurement/start', function(req, res) {
	var obj={id: "asdfdasdfase",_okay:true, _error:""};
	res.json(obj);
});
app.get('/measurement/is_running', function(req, res) {
        var obj={id: "asfqw",running:"true",_okay:true, _error:""};
        res.json(obj);
})
app.get('/measurement/asdfdasdfase/stop', function(req, res) {
        var obj={_okay:true, _error:""};
        res.json(obj);
});
app.get('/measurement/asdsdf', function(req, res) {
        var obj={start:0, end: 100, id: "asdsdf", state: "stopped", channels:{pH:{min: 1, max: 2, avg: 1.5, data:[{timestamp:0,value:1.1},{timestamp:1,value:1.1}]},
        temp:{min: 1, max: 2, avg: 1.5, data:[{timestamp:0,value:1.1},{timestamp:1,value:1.1}]}},_okay:true, _error:""};
        res.json(obj);
});


app.listen(8081);
console.log("API listening");
