$("#createSprintForm").submit(function (event) {
    // Stop form from submitting normally
    event.preventDefault();

    // Get some values from elements on the page:
    var $form = $(this);
    var path = window.location.pathname;

    var data = {
        startDate: $form.find("input[name='start-date']").val(),
        endDate: $form.find("input[name='end-date']").val()
    };

    // Send the data using post
    $.ajax({
        type: 'post',
        url: path,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        traditional: true,
        success: function (data) {
            window.location.replace(path + '/' + data.id);
        }
    });
});