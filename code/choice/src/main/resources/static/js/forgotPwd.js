$(document).ready(function () {
    $("#codeBtn").click(function () {
        var Uid = $("#input-id").val();
        if (null == Uid || "" == Uid || !(Uid.indexOf(" ") == -1))
        {
            $("#hint-div").html("<span style='color: red;'>账号不能为空，且不能包含空格！</span>");
            $("#hint-field").html("");
        }
        else
        {
            $("#hint-div").html("<span style='color: red;'>正在发送验证码，请稍候……</span>");
            $("#hint-field").html("");
            var loginInfo = {};
            loginInfo.userId = Uid;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/sendResetPwdMail',
                datatype: 'application/json; charset=UTF-8',
                data: loginInfo,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-div").html("<span>已将验证码发送至您的邮箱！</span>");
                        $("#hint-field").html("");
                    }
                    else if (result == 0 || result == -1000) {
                        $("#hint-div").html("<span style='color: red;'>验证码发送失败！</span>");
                        $("#hint-field").html("");
                    }
                    else if (result == 2) {
                        $("#hint-div").html("<span style='color: red;'>该账号未注册，请先注册！</span>");
                        $("#hint-field").html("");
                    }
                    else if(result == -200)
                    {
                        $("#hint-div").html("<span style='color: red;'>该账号不存在，请检查账号是否正确！</span>");
                        $("#hint-field").html("");
                    }
                },
                error: function () {

                }
            });
        }
    });

    $("#signUpBtn").click(function () {
        var Uid = $("#input-id").val();
        var Upwd = $("#input-pwd").val();
        var Uconf = $("#input-confirmPwd").val();
        var Ucode = $("#input-code").val();
        if (null == Uid || "" == Uid || !(Uid.indexOf(" ") == -1))
        {
            $("#hint-div").html("<span style='color: red;'>账号不能为空，且不能包含空格！</span>");
            $("#hint-field").html("");
        }
        else if (null == Ucode || "" == Ucode || Ucode.length != 15)
        {
            $("#hint-div").html("<span style='color: red;'>验证码长度应为15位！</span>");
            $("#hint-field").html("");
        }
        else if (null == Upwd || "" == Upwd || Upwd.length < 8 || Upwd.length > 16)
        {
            $("#hint-div").html("<span style='color: red;'>密码长度应在8到16位之间！</span>");
            $("#hint-field").html("");
        }
        else if (!(Upwd.indexOf(" ") == -1))
        {
            $("#hint-div").html("<span style='color: red;'>密码中不能有空格！</span>");
            $("#hint-field").html("");
        }
        else if (null == Uconf || "" == Uconf || Uconf != Upwd)
        {
            $("#hint-div").html("<span style='color: red;'>两次输入的密码不一致！</span>");
            $("#hint-field").html("");
        }
        else
        {
            do_encrypt();
        }
    });
});


function do_encrypt(){
    var username = $("#input-id").val();
    var password = $("#input-pwd").val();
    var code = $("#input-code").val();
    var publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCul1ofPwliC1apADYLVZMmpcJ4u4cr5ivX0xWAhDt5Cic3SawMvyn03LB3LlUrrvP7ctm5s731S862UJuT4fMvixnhGCmYrheX2PPvWLX8nzz/CRwiJgngr7/bhHBYT7UVeNhuVHU4ZMX7STSC2/1vqYp6zKTGqV+pEXIznLWa6QIDAQAB";
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey);

    document.rsa.userId.value = username;
    document.rsa.userPwd.value=encrypt.encrypt(password);
    document.rsa.length.value = password.length;
    document.rsa.code.value = code;
    $('#signUp_form').submit();
}