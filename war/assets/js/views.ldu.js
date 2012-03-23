(function() { 
	var replace = function(divId) {
		return function () {
			$('#' + divId).html(this.html);	
		}
	}
	
	LDU.View.new('index', 		replace('main'));
	LDU.View.new('about', 	    replace('main'));
	LDU.View.new('committee', 	replace('main'));
	LDU.View.new('community',   replace('main'));
	LDU.View.new('competition', replace('main'));
	LDU.View.new('contact',    	replace('main'));
	LDU.View.new('events',     	replace('main'));
	LDU.View.new('feedback',   	replace('main'));
	LDU.View.new('fundingreq', 	replace('main'));
	LDU.View.new('join',      	replace('main'));
	LDU.View.new('news',      	replace('main'));
	LDU.View.new('openiv',    	replace('main'));
	LDU.View.new('resources', 	replace('main'));
	LDU.View.new('socials',  	replace('main'));
	LDU.View.new('training',  	replace('main'));
	LDU.View.new('ync',  		replace('main'));
	LDU.View.new('rank',  		replace('main'));
	LDU.View.new('rankResults', replace('rankResults'));
	
	LDU.View.new('api.test', replace('main'));
	
	LDU.View.new('sidebar', replace('side'));
	
	LDU.Request.new('api.test', ['foo', 123]);
	LDU.Request.new('rankResults', []);
}());