$(document).ready(function () {
    $("#changeBtn").click(function () {
        var v1 = $("#input-id").val();
        var v2 = $("#input-name").val();
        var v3 = $("#selectGender").val();
        var v4 = $("#bs3Select").val();
        var v5 = $("#input-email").val();

        $("#id").html("工号:"+v1);
        $("#name").html("姓名："+v2);
        $("#gender").html("性别："+v3);
        $("#school").html("学院："+v4);
        $("#email").html("邮箱："+v5);
    });

    $("#confirmBtn").click(function () {
        var v1 = $("#input-id").val();
        var v2 = $("#input-name").val();
        var v5 = $("#input-email").val();
        if (null == v1 || "" == v1.trim()) {
            $("#hint-id").html("<span style='color: red;'>工号不能为空或全空格！</span>");
        }
        else if (v1.length > 15) {
            $("#hint-id").html("<span style='color: red;'>工号过长！</span>");
        }
        else if (null == v2 || "" == v2.trim())
        {
            $("#hint-name").html("<span style='color: red;'>姓名不能为空或全空格！</span>");
        }
        else if (v2.length > 10)
        {
            $("#hint-name").html("<span style='color: red;'>姓名过长！</span>");
        }
        else if (null == v5 || "" == v5.trim())
        {
            $("#hint-email").html("<span style='color: red;'>邮箱不能为空或全空格！</span>");
        }
        else if (v5.length > 35)
        {
            $("#hint-email").html("<span style='color: red;'>邮箱过长！</span>");
        }
        else {
            var teacher = {};
            var v3 = $("#selectGender").val();
            var v4 = $("#bs3Select").val();
            teacher.teacherId = v1;
            teacher.teacherName = v2;
            teacher.teacherGender = v3;
            teacher.teacherSchool = v4;
            teacher.teacherEmail = v5;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addTeacher',
                datatype: 'application/json; charset=UTF-8',
                data: teacher,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-email").html("<span>添加教师成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-email").html("<span style='color: red;'>添加教师失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-email").html("<span style='color: red;'>该教师已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});