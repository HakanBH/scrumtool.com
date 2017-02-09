$(document).ready(function () {
    $.getJSON("/projects", function (data) {
        if (data.length > 0) {
            var projectList = $('#project-list');
            projectList.append('<li class="divider"></li>');

            $.get("/fragments/dailyAlert.html", function (data) {
                $(".custom-container").append(data);
            });

            $.each(data, function (key, value) {
                var projectUrl = "/projects/" + value.id;
                var listItem = '<li><a href=' + projectUrl + '>' + value.name + '</a></li>';
                projectList.append(listItem);

                var dailyMeeting = value.dailyMeetings;
                var a = dailyMeeting.split(":");
                var dailyHour = a[0];
                var dailyMinutes = a[1];
                var dailySeconds = a[2];

                var dailyTime = new Date();

                dailyTime.setHours(dailyHour);
                dailyTime.setMinutes(dailyMinutes);
                if (dailySeconds != null) {
                    dailyTime.setSeconds(dailySeconds);
                } else {
                    dailyTime.setSeconds(00);
                }
                var timeToDaily = dailyTime - Date.now();
                var seconds = (timeToDaily / (1000)) | 0;
                console.log("Seconds to daily : " + seconds);

                if (timeToDaily > 0) {
                    var timeout = setTimeout(function () {
                        $("#edno").text(value.name);
                        $("#dve").text(value.name);

                        $('#\\#dailyAlert').modal('show');
                    }, timeToDaily);
                }
            });
        } else {
            if (window.location.pathname === '/main' || window.location.pathname === '/') {
                $(".custom-container").load("/fragments/noProjects.html");
            }
        }
    });
});

