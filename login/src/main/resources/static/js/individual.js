$.ajax({
	url: "individualstuddata",
	success : function(result) {
		var testid = JSON.parse(result).testid;
		var marks = JSON.parse(result).marks;
		drawLineChart(testid,marks);
	}
});

function drawLineChart(testid,marks) {
Highcharts.chart('container',{
	chart: {
		type :'line',
		width : 500
	},
	title : {
		text : 'Marks report'
	},
	xAxis : {
		categories : testid
	},
	tooltip : {
		formatter: function() {
			return '<strong>'+this.x+'</strong>'+this.y;
		}
	},
	series : [{
		data : marks
	}]
}); 
}
