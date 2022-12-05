angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $rootScope, $http) {
    const contextPath = 'http://localhost:8180/app/api/v1/students';

    $scope.loadStudents = function (pageIndex = 1) {
        $http({
            url: contextPath + '/findAll',
            method: 'GET',
            params: {
                name_part: $scope.filter ? $scope.filter.name_part : null,
                age: $scope.filter ? $scope.filter.age : null
            }
        }).then(function (response) {
            $scope.StudentsPage = response.data;
        });
    };

    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath + '/delete/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.updateStudent = function (){
        $http.put(contextPath + '/update', $scope.Student
        ).then(function (response) {
            $scope.loadStudents( );
        })
    }

    $scope.saveStudent = function (){
        $http.post(contextPath + '/save', $scope.newStudent
        ).then(function (response) {
            $scope.loadStudents( );
        })
    }

    $scope.loadStudents();
});