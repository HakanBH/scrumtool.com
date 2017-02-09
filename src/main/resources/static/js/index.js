/*
 Login, register and recover form changer
 */

$(function () {
    $('#register-form-link').click(function (e) {
        $("#registerForm").delay(100).fadeIn(100);
        $("#loginForm").fadeOut(100);
        $("#recoverForm").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#login-form-link').click(function (e) {
        $("#loginForm").delay(100).fadeIn(100);
        $("#registerForm").fadeOut(100);
        $("#recoverForm").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

    $('#recover-form-link').click(function (e) {
        $("#recoverForm").delay(100).fadeIn(100);
        $("#loginForm").fadeOut(100);
        e.preventDefault();
    });
});

/*
 Background changer
 */
$(window).load(function () {

    $('img.bgfade').hide();
    var dg_H = $(window).height();
    var dg_W = $(window).width();
    $('#wrap').css({
        'height': dg_H,
        'width': dg_W
    });
    function anim() {
        $("#wrap img.bgfade").first().appendTo('#wrap').fadeOut(1500);
        $("#wrap img").first().fadeIn(1500);
        setTimeout(anim, 10000);
    }

    anim();
})

$(window).resize(function () {
    window.location.href = window.location.href
})

/*
    Register form validation
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