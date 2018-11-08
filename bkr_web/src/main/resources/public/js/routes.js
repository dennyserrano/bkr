app.config(function($routeProvider) {
    $routeProvider
  
    .when("/breadlist", {
        templateUrl : "../masterbread/breadlist.html"
    })
    .when("/templates/:msgId", {
        templateUrl : "../templates/templatelist.html"
    })
    .when("/templatedetails/:templateId", {
        templateUrl : "../templates/templatedetails.html"
    })
    .when("/dailylist", {
        templateUrl : "../dailysales/dailylist.html"
    })
    .when("/dailydetails", {
        templateUrl : "../dailysales/dailydetails.html"
    })
});