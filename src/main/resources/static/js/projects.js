$(document).ready(function () {
    var path = window.location.pathname;
    var navCol = $(".navigation-col");
    navCol.load("/fragments/sidebar.html");

    var pathVariables = path.split("/");
    var getSprintsUrl = "/" + pathVariables[1] + "/" + pathVariables[2] + "/sprints";

    $.getJSON(getSprintsUrl, function (data) {
        if (data.length > 0) {
            var projectSprints = $('#project-sprints');
            projectSprints.append('<li class="divider"></li>');

            $.each(data, function (key, value) {
                var sprintUrl = getSprintsUrl + '/' + value.id;
                var listItem = '<li><a href=' + sprintUrl + '>' + 'Sprint ' + value.number + '</a></li>';
                projectSprints.append(listItem);
            });
        }
    });
});