'use strict';


var App = angular.module('example', []);


App.controller('UserController', function ($scope, $http) {

    $http.get('/user').success(function (data) {
        $scope.users = data;

    });
    $scope.selected = {};

    $scope.getTemplate = function (user) {
        if (user.id === $scope.selected.id) return 'edit';
        else return 'display';
    };


    $scope.addUser = function () {

        $http.post('user', $scope.user).success(function (data) {
            $scope.user = {};
            $scope.users = data;

        });
    };
    $scope.remove = function(user) {
       $http.delete('/user', { params: { userId: user.id }}).success(function (data) {
            $scope.users = data;
        })
    };

    $scope.userEdit = function (user) {
        $scope.selected = angular.copy(user);
    };

    $scope.reset = function () {
        $scope.selected = {};
    };

    $scope.userUpdate = function (user) {
        $http.get('/user/edit', { params: { userId: user.id,userName: user.name,userPassword: user.password }}).success(function (data) {
            /** @namespace user.password */
            $scope.users = data;
            $scope.selected = {};
        })

    };

    $scope.findRoles = function (name) {
        console.log(name);

        $http.get('/user/find', { params: { name: name}}).success(function (data) {
            $scope.roles = data;
        })
    };

});
