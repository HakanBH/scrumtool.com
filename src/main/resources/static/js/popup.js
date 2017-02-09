/**
 * Created by User on 9.2.2017 г..
 */
$(document).ready(function() {

    $(".onclick").click(function() {
        $("#new-issue-popup").css("display", "block");
    });
    $("#new-issue #close").click(function() {
        $(this).parent().parent().parent().hide();
    });

    // $("#send").click(function() {
    //     var name = $("#name").val();
    //     var email = $("#email").val();
    //     var contact = $("#contactno").val();
    //     var message = $("#message").val();
    //     if (name == "" || email == "" || contactno == "" || message == ""){
    //         alert("Please Fill All Fields");
    //     }else{
    //         if (validateEmail(email)) {
    //             $("#contactdiv").css("display", "none");
    //         }else {
    //             alert('Invalid Email Address');
    //         }
    //         function validateEmail(email) {
    //             var filter = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
    //             if (filter.test(email)) {
    //                 return true;
    //             }else {
    //                 return false;
    //             }
    //         }
    //     }
    // });
});