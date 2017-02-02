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
