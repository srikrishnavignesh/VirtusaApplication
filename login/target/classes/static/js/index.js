$.ajax({
	url: "linechartdata",
	success : function(result) {
		var uname = JSON.parse(result).uname;
		var marks = JSON.parse(result).marks;
		drawLineChart(uname,marks);
	}
});

function drawLineChart(uname,marks) {
Highcharts.chart('container',{
	chart: {
		type :'line',
		width : 500
	},
	title : {
		text : 'Marks report'
	},
	xAxis : {
		categories : uname
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
