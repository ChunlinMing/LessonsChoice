$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 10) {
            $("#hint-div").html("<span style='color: red;'>教学班班号过长！</span>");
        }
        else {
            var stuClass = {};
            var v = $("#bs3Select").val();
            stuClass.stuClass = value;
            stuClass.school = v;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addClass',
                datatype: 'application/json; charset=UTF-8',
                data: stuClass,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-div").html("<span>添加教学班成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>添加教学班失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>该教学班已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});