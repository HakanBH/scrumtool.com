/*
 Create issue popup.
 */

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
                var issues = value.issues;

                $.each(issues, function (key, value) {
                    var issueCode = '#' + value.id;
                    switch (value.status) {
                        case "To Do":
                            $(issueCode + '.issue-status').val('todo');
                            break;
                        case "Done":
                            $(issueCode + '.issue-status').val('done');
                            break;
                        case "Blocked":
                            $(issueCode + '.issue-status').val('blocked');
                            break;
                        case "In Progress":
                            $(issueCode + '.issue-status').val('in-progress');
                            break;
                    }

                    switch (value.priority) {
                        case "Blocker":
                            $(issueCode + '.issue-priority').val('blocker');
                            break;
                        case "Critical":
                            $(issueCode + '.issue-priority').val('critical');
                            break;
                        case "High":
                            $(issueCode + '.issue-priority').val('high');
                            break;
                        case "Normal":
                            $(issueCode + '.issue-priority').val('normal');
                            break;
                        case "Trivial":
                            $(issueCode + '.issue-priority').val('trivial');
                            break;
                    }
                });
            });
        }
    });

    $(".onclick").click(function () {
        $("#new-issue-popup").css("display", "block");

        var sprintId = $(this).attr('id');
        var url = "/issues/" + sprintId;

        $("#createIssueForm").submit(function (event) {
            // Stop form from submitting normally
            event.preventDefault();
            // Get some values from elements on the page:
            var $form = $(this);

            var data = {
                summary: $form.find("input[id='summary']").val(),
                type: $form.find("select[id='issue-type']").val(),
                priority: $form.find("select[id='priority']").val(),
                storyPoints: $form.find("input[id='story-points']").val(),
                description: $form.find("textarea[id='description']").val()
            };

            $.ajax({
                type: 'post',
                url: url,
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                traditional: true,
                success: function (data) {
                    window.location.replace(path);
                }
            });
        });
    });

    $(".issue-status").change(function () {
        var issueId = $(this).attr('id');
        var url = "/issues/" + issueId;

        var newStatus = "#" + issueId + ".issue-status" + " option:selected";

        var data = {
            status: $(newStatus).text()
        };

        $.ajax({
            type: 'put',
            url: url,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                window.location.replace(path);
            }
        });
    });

    $(".issue-priority").change(function () {
        var issueId = $(this).attr('id');
        var url = "/issues/" + issueId;
        var newPriority = "#" + issueId + ".issue-priority" + " option:selected";

        var data = {
            priority: $(newPriority).text()
        };

        $.ajax({
            type: 'put',
            url: url,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                window.location.replace(path);
            }
        });
    });

    $("#new-issue #close").click(function () {
        $(this).parent().parent().parent().hide();
    });
});