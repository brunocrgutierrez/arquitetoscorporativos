'use strict';

var app = angular.module('sri', [
     'ngSanitize',
     'brasil.filters',
     'ngResource',
     'ngRoute',
     'ui.bootstrap',
     'ngGrid',
     'notification',
     'ngWebsocket',
     'ui.grid', 
     'ui.grid.selection',
     'ui.select',
     'angular-toArrayFilter',
     'ui.mask',
     'ui.utils.masks'
]).config(['$httpProvider', 'uiSelectConfig', function ($httpProvider, uiSelectConfig) {
	
	    uiSelectConfig.theme = 'bootstrap';

    }]);



app.run(['$rootScope', '$location', '$window', 'TIPO_ALERTAS', 'AlertApp',
    function ($rootScope, $location, $window, TIPO_ALERTAS, AlertApp) {
        
		 $rootScope.$on('$routeChangeStart', function (event, next) {
	
			 AlertApp.clear();

	     });
    }]);