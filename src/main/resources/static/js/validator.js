/*
 Login & Register form validation
 */

jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-z]+$/i.test(value);
}, "Names must contain letters only.");

jQuery.validator.addMethod("alphanumeric", function(value, element) {
    return this.optional(element) || /^\w+$/i.test(value);
}, "Password can contain letters, numbers, spaces or `_` only");

$(document).ready(function() {
    $('#registerForm').validate({ // initialize the plugin
        errorClass : "my-error-class",

        rules : {
            firstName : {
                required : true,
                lettersonly : true
            },
            lastName : {
                required : true,
                lettersonly : true
            },
            regPassword : {
                alphanumeric : true,
                minlength : 4,
                maxlength : 24
            },
            passwordConfirm : {
                required : true,
                equalTo : "#regPassword"
            }
        },
        messages : {
            passwordConfirm : {
                equalTo : "Passwords dont match."
            }
        }
    });
});