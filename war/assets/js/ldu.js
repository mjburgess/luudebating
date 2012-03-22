LDU = {
	getTemplate: function (callback) {
		$.get('/tpl', callback); 
	},
	
	render: function (action) {
		LDU.Controller[action]();
		
	},
	
	onTemplateRecieved: function (action) {
		return function (template) { 
			var view = LDU.View[action];
			console.log(view);
			view.template = template;
			view.html = Mustache.render(view.template , view.vars);
			view.render();
		}
	},
	
		
	View: {
		index: {
			 html: '', 
			 template: '', 
			 vars: { content: "from /tpl!" }, 
			 render: function () { 
				 $('#main').html(LDU.View.index.html); 
			 }
		}
	},
	
	Controller: {
		index: function() {
			LDU.getTemplate('index', LDU.onTemplateRecieved('index'));
		}
	}
}