'use strict';


var App = angular.module('example', []);


App.controller('UserController', function ($scope, $http) {

    $http.get('/user').success(function (data) {
        $scope.users = data;

    });

    $http.get('/user/role').success(function (data) {
        $scope.roles_all = data;
    });

    $scope.selected = {};

    $scope.getTemplate = function (user) {
        if (user.id === $scope.selected.id) return 'edit';
        else return 'display';
    };

    $scope.addUser = function () {
        $scope.roleArray = [];

        angular.forEach($scope.roles_all, function(rol){
            if (!!rol.selected) $scope.roleArray.push(rol.id)
        })

        $http.post('user', $scope.user,{ params: { rolesId:$scope.roleArray  }}).success(function (data) {
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
        /** @namespace user.login */
        /** @namespace user.password */
        $http.get('/user/edit', { params: { userId: user.id,userName: user.name,userPassword: user.password,userLogin: user.login}}).success(function (data) {
            $scope.users = data;
            $scope.selected = {};
        })
    };

    $scope.findRoles = function (name) {
        $http.get('/user/find', { params: { name: name}}).success(function (data) {
            $scope.roles = data;
        })
    };
});
