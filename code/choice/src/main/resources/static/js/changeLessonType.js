$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 4) {
            $("#hint-div").html("<span style='color: red;'>课程类型名称不应超过4个字！</span>");
        }
        else {
            var changeLessonType = {};
            var v = $("#bs3Select").val();
            changeLessonType.lessonTypeBefore = v;
            changeLessonType.lessonTypeAfter = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeLessonType',
                datatype: 'application/json; charset=UTF-8',
                data: changeLessonType,
                success: function (result) {
                    if (result == 1) {
                        $("#bs3Select option").each(function () {
                            if (v == $(this).val())
                            {
                                $(this).remove();
                                $("#bs3Select").append("<option>"+value+"</option>");
                            }
                        });
                        $("#hint-div").html("<span>更改课程类型成功！</span>");
                    }
                    else if (result == -1) {
                        $("#hint-div").html("<span style='color: red;'>更改课程类型失败！</span>");
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