app.config(function($routeProvider) {
    $routeProvider
  
    .when("/breadlist", {
        templateUrl : "../secure/masterbread/breadlist.html"
    })
    .when("/templates/:msgId", {
        templateUrl : "../secure/templates/templatelist.html"
    })
    .when("/templatedetails/:templateId", {
        templateUrl : "../secure/templates/templatedetails.html"
    })
    .when("/dailylist", {
        templateUrl : "../secure/dailysales/dailylist.html"
    })
    .when("/dailydetails", {
        templateUrl : "../secure/dailysales/dailydetails.html"
    })
});