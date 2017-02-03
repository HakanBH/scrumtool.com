$(document).ready(function () {
    var projectList = $('#project-list');

    $.getJSON("http://localhost:8080/projects", function (data) {
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

            var timeToDaily = dailyTime - Date.now();

            console.log("Seconds to daily : " + timeToDaily/1000);

            if(timeToDaily > 0){
                var timeout = setTimeout(function () {
                    $('#\\#myModal').modal('show');
                }, timeToDaily);
            }

            console.log("------------------");
        });
    });
});

