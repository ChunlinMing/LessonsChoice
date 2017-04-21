$(document).ready(function () {
    $("button").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 20) {
            $("#hint-div").html("<span style='color: red;'>学院名称过长！</span>");
        }
        else {
            var school = {};
            school.school = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addSchool',
                datatype: 'application/json; charset=UTF-8',
                data: school,
                success: function (result) {
                    if (result == 1) {
                        $("#list").append("<tr style=\"font-size: 16px;font-family: \'Comic Sans MS\';height: 30px;\"><td>"+value+"</td></tr>");
                        $("#hint-div").html("<span>添加学院成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>添加学院失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>学院已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});