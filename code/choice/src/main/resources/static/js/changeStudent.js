$(document).ready(function () {
    $("#changeBtn").click(function () {
        var v1 = $("#selectStudent").val();
        var v2 = $("#hide-name").val();
        var v3 = $("#hide-gender").val();
        var v4 = $("#hide-gradeYear").val();
        var v5 = $("#selectSchool").val();
        var v6 = $("#selectClass").val();
        var v7 = $("#hide-email").val();

        $("#input-id").val(v1);
        $("#input-name").val(v2);
        $("#selectGender").val(v3);
        $("#selectGradeYear").val(v4);
        $("#bs3Select").val(v5);
        $("#selectBs3Class").val(v6);
        $("#input-email").val(v7);
    });

    $("#confirmBtn").click(function () {
        var v1 = $("#input-id").val();
        var v2 = $("#input-name").val();
        var v7 = $("#input-email").val();
        if (null == v1 || "" == v1.trim()) {
            $("#hint-id").html("<span style='color: red;'>学号不能为空或全空格！</span>");
        }
        else if (v1.length > 15) {
            $("#hint-id").html("<span style='color: red;'>学号过长！</span>");
        }
        else if (null == v2 || "" == v2.trim())
        {
            $("#hint-name").html("<span style='color: red;'>姓名不能为空或全空格！</span>");
        }
        else if (v2.length > 10)
        {
            $("#hint-name").html("<span style='color: red;'>姓名过长！</span>");
        }
        else if (null == v7 || "" == v7.trim())
        {
            $("#hint-email").html("<span style='color: red;'>邮箱不能为空或全空格！</span>");
        }
        else if (v7.length > 35)
        {
            $("#hint-email").html("<span style='color: red;'>邮箱过长！</span>");
        }
        else {
            var changeStudent = {};
            var value = $("#selectStudent").val();
            var v3 = $("#selectGender").val();
            var v4 = $("#selectGradeYear").val();
            var v5 = $("#bs3Select").val();
            var v6 = $("#selectBs3Class").val();
            changeStudent.stuIdBefore = value;
            changeStudent.stuIdAfter = v1;
            changeStudent.stuNameAfter = v2;
            changeStudent.stuGenderAfter = v3;
            changeStudent.gradeYearAfter = v4;
            changeStudent.stuSchoolAfter = v5;
            changeStudent.stuClassAfter = v6;
            changeStudent.stuEmailAfter = v7;
            changeStudent.flag = 1;
            $.ajax({
                catch: false,
                async: false,
                type: 'post',
                url: 'http://localhost:8080/changeStudent',
                datatype: 'application/json; charset=UTF-8',
                data: changeStudent,
                success: function (result) {
                    if (result == 1) {
                        $("#selectSchool").val(v5);
                        findClassBySchool(v5,2);
                        $("#selectClass").val(v6);
                        findStudentByStuClass(v6);
                        $("#selectStudent").val(v1);
                        $("#hint-email").html("<span>更改学生信息成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-email").html("<span style='color: red;'>更改学生信息失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-email").html("<span style='color: red;'>该生已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });

    $("#deleteBtn").click(function () {
        var changeStudent = {};
        var value = $("#selectStudent").val();
        changeStudent.stuIdBefore = value;
        changeStudent.flag = 0;
        $.ajax({
            catch: false,
            async: false,
            type: 'post',
            url: 'http://localhost:8080/changeStudent',
            datatype: 'application/json; charset=UTF-8',
            data: changeStudent,
            success: function (result) {
                if (result == 1) {
                    $("#selectStudent option").each(function () {
                        if (value == $(this).val())
                        {
                            $(this).remove();
                        }
                    });
                    $("#hint-delete").html("<span>删除学生成功！</span>");
                }
                else if (result == 0) {
                    $("#hint-delete").html("<span style='color: red;'>删除学生失败！</span>");
                }
                else if (result == -200)
                {
                    $("#hint-delete").html("<span style='color: red;'>要删除的学生不存在！</span>");
                }
            },
            error: function () {

            }
        });
    });
});

function findClassBySchool(data, flag)
{
    if (null != data && "" != data.trim())
    {
        var school = {};
        school.school = data;
        $.ajax({
            catch: false,
            async: false,
            type: 'post',
            url: 'http://localhost:8080/findClassBySchool',
            datatype: 'application/json; charset=UTF-8',
            data: school,
            success: function (result) {
                var html = "";
                for (var i = 0; i < result.length; i++) {
                    html += "<option>" + result[i].stuClass + "</option>";
                }
                if (1 == flag)
                {
                    $("#selectBs3Class").html(html);
                }
                else if (2 == flag)
                {
                    $("#selectClass").html(html);
                    findStudentByStuClass(result[0].stuClass);
                    $("#selectBs3Class").html(html);
                }
            },
            error: function () {

            }
        });
    }
}

function findStudentByStuClass(data)
{
    var stuClassValue = $("#selectClass").val();
    if (null != stuClassValue && "" != stuClassValue.trim())
    {
        var stuClass = {};
        stuClass.stuClass = stuClassValue;
        $.ajax({
            catch: false,
            async: false,
            type: 'post',
            url: 'http://localhost:8080/findStudentByStuClass',
            datatype: 'application/json; charset=UTF-8',
            data: stuClass,
            success: function (result) {
                var html = "";
                for(var i=0;i<result.length;i++){
                    html += "<option>"+result[i].stuId+"</option>";
                }
                $("#selectStudent").html(html);
                findStudentById(result[0].stuId);
            },
            error: function () {

            }
        });
    }
}

function findStudentById(data)
{
    var student = {};
    student.stuId = data;
    $.ajax({
        catch: false,
        async: false,
        type: 'post',
        url: 'http://localhost:8080/findStudentById',
        datatype: 'application/json; charset=UTF-8',
        data: student,
        success: function (result) {
            $("#hide-name").val(result.stuName);
            $("#hide-gender").val(result.stuGender);
            $("#hide-gradeYear").val(result.gradeYear);
            $("#hide-email").val(result.stuEmail);
        },
        error: function () {

        }
    });
}