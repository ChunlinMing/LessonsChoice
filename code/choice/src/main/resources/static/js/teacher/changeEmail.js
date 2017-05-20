$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var userId = $("#userId").text();
        var newEmail = $("#newEmail").val();
        if (null == newEmail || "" == newEmail.trim())
        {
            $("#hint-div").html("<span style='color: red;'>邮箱不能为空或全空格！</span>");
        }
        else
        {
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeEmail',
                datatype: 'application/json; charset=UTF-8',
                data: {"userId":userId,"newEmail":newEmail},
                success: function (result) {
                    if (result == 1) {
                        $("#mail").html("邮箱："+newEmail);
                    }
                    else if (result == 0) {
                        alert("更改邮箱失败，请稍后重试！");
                    }
                },
                error: function () {

                }
            });
        }
    });
});