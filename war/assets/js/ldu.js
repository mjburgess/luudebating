var LDU = (function() {
	function getTemplate (endPoint, callback) {
		$.get('/views/' + endPoint + '.html', callback); 
	}
	
	function getData(endPoint, callback) {
		if(endPoint in LDU.Request) {
			console.log('/api/view/' + endPoint + '/' + LDU.Request.get(endPoint));
			$.getJSON('/api/view/' + endPoint + '/' + LDU.Request.get(endPoint), callback);
		} else {
			callback();
		}
	}
	
	function recieveTemplate(action) {
		return function (template) {
			getData(action, function (data) {
				var view = LDU.View[action];
				view.template = template;
				view.vars = data; 
				view.html = Mustache.render(view.template , view.vars)
				view();
			});
		}	
	}
	
	return {
		Dispatch: {
			route: function (router) {
				LDU.Dispatch.to(router());
			},
			
			to: function (action) {
				LDU.Controller.render(action);
			}
		},
		
		Router: {
			defaultRoute: 'index',
			
			hashRouter: function () { 
		    	var loc = location.hash.substring(1); 
		    	return loc && loc in LDU.View ? loc : LDU.Router.defaultRoute; 
		   	}
		},
		
		Request: {
			new: function(name, params) {
				LDU.Request[name] = params;
			},
			
			get: function (name) {
				return LDU.Request[name].join('/');
			},
			
			set: function (name, values) {
				LDU.Request[name] = values;
			}
		},
		
		View: {			
			new: function (name, renderFnc) {
				LDU.View[name] 	    = function () { return renderFnc.call(LDU.View[name]); }
				LDU.View[name].html     = ''; 
				LDU.View[name].template = ''; 
				LDU.View[name].vars		= {};
			},
			
			isComplete: function (name) {
				return name in LDU.View && LDU.View[name].html;
			},
			
			get: function (name) {
				return LDU.View[name];
			}
		},
		
		Controller: {
			new: function (name, actionFnc) {
				LDU.Controller[name] = actionFnc;
			},
			
			get: function (name) {
				if(name in LDU.Controller) {
					return LDU.Controller[name];
				} else {
					return function () {}
				}
			},
			
			render: function(action) {
				LDU.Controller.get(action)();
				
				if(!LDU.View.isComplete(action) || action in LDU.Request) {
					getTemplate(action, recieveTemplate(action));
				} else {
					LDU.View.get(action)();
				}
				
			}
		}
	}
}());
