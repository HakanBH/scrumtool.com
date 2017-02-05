/*
    Login, register and recover form changer
 */

$(function() {
    $('#register-form-link').click(function(e) {
        $("#registerForm").delay(100).fadeIn(100);
        $("#loginForm").fadeOut(100);
        $("#recoverForm").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#login-form-link').click(function(e) {
        $("#loginForm").delay(100).fadeIn(100);
        $("#registerForm").fadeOut(100);
        $("#recoverForm").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

    $('#recover-form-link').click(function(e) {
        $("#recoverForm").delay(100).fadeIn(100);
        $("#loginForm").fadeOut(100);
        e.preventDefault();
    });
});

/*
    Background changer
 */
$(window).load(function() {

    $('img.bgfade').hide();
    var dg_H = $(window).height();
    var dg_W = $(window).width();
    $('#wrap').css({
        'height' : dg_H,
        'width' : dg_W
    });
    function anim() {
        $("#wrap img.bgfade").first().appendTo('#wrap').fadeOut(1500);
        $("#wrap img").first().fadeIn(1500);
        setTimeout(anim, 10000);
    }
    anim();
})

$(window).resize(function() {
    window.location.href = window.location.href
})

/*
    Add members form expanding
 */

$(function () {
    $(document).on('focus', 'div.member:last-child div.member-email input', function () {

        var sInputGroupHtml = $(this).parent().parent().parent().html();
        var sInputGroupClasses = $(this).parent().parent().parent().attr('class');
        $(this).parent().parent().parent().parent().append('<div class="' + sInputGroupClasses + '">' + sInputGroupHtml + '</div>');

    });

    $(document).on('click', 'div.member div.member-email .remove-member', function(){
        $(this).parent().parent().parent().remove();
    });
});
