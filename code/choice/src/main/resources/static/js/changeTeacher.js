$(document).ready(function () {
    $("#changeBtn").click(function () {
        var v1 = $("#selectTeacher").val();
        var v2 = $("#hide-name").val();
        var v3 = $("#hide-gender").val();
        var v4 = $("#selectSchool").val();
        var v5 = $("#hide-email").val();

        $("#input-id").val(v1);
        $("#input-name").val(v2);
        $("#input-email").val(v5);

        $("#selectGender option").each(function () {
            if (v3 == $(this).val())
            {
                $("#selectGender").val(v3);
            }
        });

        $("#bs3Select option").each(function () {
            if (v4 == $(this).val())
            {
                $("#bs3Select").val(v4);
            }
        });
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
            var changeTeacher = {};
            var value = $("#selectTeacher").val();
            var v3 = $("#selectGender").val();
            var v4 = $("#bs3Select").val();
            changeTeacher.teacherIdBefore = value;
            changeTeacher.teacherIdAfter = v1;
            changeTeacher.teacherNameAfter = v2;
            changeTeacher.teacherGenderAfter = v3;
            changeTeacher.teacherSchoolAfter = v4;
            changeTeacher.teacherEmailAfter = v5;
            changeTeacher.flag = 1;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeTeacher',
                datatype: 'application/json; charset=UTF-8',
                data: changeTeacher,
                success: function (result) {
                    if (result == 1) {
                        $("#selectSchool").val(v4);
                        findTeacherBySchool();
                        $("#selectTeacher option").each(function () {
                            if (v1 == $(this).val())
                            {
                                $("#selectTeacher").val(v1);
                            }
                        });

                        $("#hint-email").html("<span>更改教师信息成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-email").html("<span style='color: red;'>更改教师信息失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-email").html("<span style='color: red;'>教师已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });

    $("#deleteBtn").click(function () {
        var changeTeacher = {};
        var v = $("#selectTeacher").val();
        changeTeacher.teacherIdBefore = v;
        changeTeacher.flag = 0;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/changeTeacher',
            datatype: 'application/json; charset=UTF-8',
            data: changeTeacher,
            success: function (result) {
                if (result == 1) {
                    $("#selectTeacher option").each(function () {
                        if (v == $(this).val())
                        {
                            $(this).remove();
                        }
                    });
                    $("#hint-delete").html("<span>删除教师成功！</span>");
                }
                else if (result == 0) {
                    $("#hint-delete").html("<span style='color: red;'>删除教师失败！</span>");
                }
                else if (result == -200)
                {
                    $("#hint-delete").html("<span style='color: red;'>要删除的教师不存在！</span>");
                }
            },
            error: function () {

            }
        });
    });
});

function findTeacherBySchool()
{
    var schoolValue = $("#selectSchool").val();
    if (null != schoolValue && "" != schoolValue.trim())
    {
        var school = {};
        school.school = schoolValue;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/findTeacherBySchool',
            datatype: 'application/json; charset=UTF-8',
            data: school,
            success: function (result) {
                var html = "";
                for(var i=0;i<result.length;i++){
                    html += "<option>"+result[i].teacherId+"</option>";
                }
                $("#selectTeacher").html(html);
                findTeacherById(result[0].teacherId);
            },
            error: function () {

            }
        });
    }
}

function findTeacherById(data)
{
    var teacher = {};
    teacher.teacherId = data;
    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/findTeacherById',
        datatype: 'application/json; charset=UTF-8',
        data: teacher,
        success: function (result) {
            $("#hide-name").val(result.teacherName);
            $("#hide-gender").val(result.teacherGender);
            $("#hide-email").val(result.teacherEmail);
        },
        error: function () {

        }
    });
}