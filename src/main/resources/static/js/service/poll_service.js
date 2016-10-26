'use strict';

 
angular.module('myApp').factory('PollService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080';
    var SERVICE = {
    		POLL : REST_SERVICE_URI+'/poll',
    		OPTION : REST_SERVICE_URI+'/poll/option'
    }
    
    var factory = {
        getPoll: getPoll,
        addOption: addOption
    };
 
    return factory;
 
    function getPoll() {
        var deferred = $q.defer();
        $http.get(SERVICE.POLL)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function addOption(poll, option, user) {
        var deferred = $q.defer();
        $http.post(SERVICE.OPTION, poll, option, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);