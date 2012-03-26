(function() { 
	var replace = function(divId) {
		return function () {
			$('#' + divId).html(this.html);	
		}
	}
	
	LDU.View.add('index', 		replace('main'));
	LDU.View.add('sidebar',	    replace('side'));
	
	LDU.View.add('info.about', 	  	    replace('main'));
	LDU.View.add('info.committee',	 	replace('main'));
	LDU.View.add('info.community',		replace('main'));
	LDU.View.add('info.join',      		replace('main'));
	LDU.View.add('info.news',      		replace('main'));
	LDU.View.add('info.contact',    	replace('main'));
	LDU.View.add('info.events',     	replace('main'));
	
	LDU.View.add('members.competition', replace('main'));
	LDU.View.add('members.feedback',   	replace('main'));
	LDU.View.add('members.fundingreq', 	replace('main'));
	LDU.View.add('members.resources', 	replace('main'));
	LDU.View.add('members.socials',  	replace('main'));
	LDU.View.add('members.rank',  		replace('main'));
	LDU.View.add('members.eudc',  		replace('main'));
	
	LDU.View.add('friends.openiv',    	replace('main'));
	LDU.View.add('friends.ync',  		replace('main'));
	
	LDU.View.add('school.sghs',  		replace('main'));
	
	LDU.View.add('dynamic.rank', 		replace('rankResults'));
	LDU.View.add('dynamic.api_test', 	replace('main'));
	
	LDU.Request.add('dynamic.api_test',    ['foo', Math.random()]);
	LDU.Request.add('dynamic.rank', 	   []);
}())
;