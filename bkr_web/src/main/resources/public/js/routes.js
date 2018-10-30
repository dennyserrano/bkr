app.config(function($routeProvider) {
    $routeProvider
  
    .when("/breadlist", {
        templateUrl : "../masterbread/breadlist.html"
    })
    .when("/templates", {
        templateUrl : "../templates/templatelist.html"
    })
    .when("/templatedetails/:templateId", {
        templateUrl : "../templates/templatedetails.html"
    })
});