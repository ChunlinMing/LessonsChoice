$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 10) {
            $("#hint-div").html("<span style='color: red;'>教室名称过长！</span>");
        }
        else {
            var classroom = {};
            var v = $("#bs3Select").val();
            classroom.classroom = value;
            classroom.building = v;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addClassroom',
                datatype: 'application/json; charset=UTF-8',
                data: classroom,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-div").html("<span>添加教室成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>添加教室失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>该教室已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});