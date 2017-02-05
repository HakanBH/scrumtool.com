$(document).ready(function () {
    var navCol = $(".navigation-col");
    var mainContainer = $(".main-container");
    var projectList = $('#project-list');

    navCol.load( "/fragments/sidebar.html" );
    mainContainer.load("/fragments/dailyAlert.html");

    $.getJSON("http://localhost:8080/projects", function (data) {
        if (data.length > 0) {
            projectList.append('<li class="divider"></li>');
        }
        $.each(data, function (key, value) {
            var projectUrl = "/projects/" + value.id;
            var listItem = '<li><a href=' + projectUrl + '>' + value.name + '</a></li>';
            projectList.append(listItem);

            var dailyMeeting = value.dailyMeetings;
            console.log("Daily Meeting: " + dailyMeeting);
            var a = dailyMeeting.split(":");
            var dailyHour = a[0];
            var dailyMinutes = a[1];
            var dailyTime = new Date();

            dailyTime.setHours(dailyHour);
            dailyTime.setMinutes(dailyMinutes);
            dailyTime.setSeconds(0);
            var timeToDaily = dailyTime - Date.now();

            var seconds =  (timeToDaily / (1000)) | 0;
            console.log("Seconds to daily : " + seconds);
            console.log("Milis : " + timeToDaily);

            if (timeToDaily > 0) {
                var timeout = setTimeout(function () {
                    $('#\\#myModal').modal('show');
                }, timeToDaily);
            }
            console.log("------------------");
        });
    });
});

