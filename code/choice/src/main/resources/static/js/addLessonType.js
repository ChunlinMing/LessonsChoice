$(document).ready(function () {
    $("button").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 4) {
            $("#hint-div").html("<span style='color: red;'>课程类型名称不应超过4个字！</span>");
        }
        else {
            var lessonType = {};
            lessonType.lessonTypeName = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addLessonType',
                datatype: 'application/json; charset=UTF-8',
                data: lessonType,
                success: function (result) {
                    if (result == 1) {
                        $("#list").append("<tr style=\"font-size: 16px;font-family: \'Comic Sans MS\';height: 30px;\"><td>"+value+"</td></tr>");
                        $("#hint-div").html("<span>添加课程类型成功！</span>");
                    }
                    else if (result == -1) {
                        $("#hint-div").html("<span style='color: red;'>添加课程类型失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>课程类型已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});