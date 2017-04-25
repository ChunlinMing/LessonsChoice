$(document).ready(function () {
    $("#changeBtn").click(function () {
        var v1 = $("#input-id").val();
        var v2 = $("#input-name").val();
        var v3 = $("#selectGender").val();
        var v4 = $("#selectGradeYear").val();
        var v5 = $("#selectSchool").val();
        var v6 = $("#selectClass").val();
        var v7 = $("#input-email").val();

        $("#id").html("学号:"+v1);
        $("#name").html("姓名："+v2);
        $("#gender").html("性别："+v3);
        $("#gradeYear").html("年级："+v4);
        $("#school").html("学院："+v5);
        $("#stuClass").html("班级："+v6);
        $("#email").html("邮箱："+v7);
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
            var student = {};
            var v3 = $("#selectGender").val();
            var v4 = $("#selectGradeYear").val();
            var v5 = $("#selectSchool").val();
            var v6 = $("#selectClass").val();
            student.stuId = v1;
            student.stuName = v2;
            student.stuGender = v3;
            student.gradeYear = v4;
            student.stuSchool = v5;
            student.stuClass = v6;
            student.stuEmail = v7;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addStudent',
                datatype: 'application/json; charset=UTF-8',
                data: student,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-email").html("<span>添加学生成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-email").html("<span style='color: red;'>添加学生失败！</span>");
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
});

function findClassBySchool()
{
    var schoolValue = $("#selectSchool").val();
    if (null != schoolValue && "" != schoolValue.trim())
    {
        var school = {};
        school.school = schoolValue;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/findClassBySchool',
            datatype: 'application/json; charset=UTF-8',
            data: school,
            success: function (result) {
                var html = "";
                for(var i=0;i<result.length;i++){
                    html += "<option>"+result[i].stuClass+"</option>";
                }
                $("#selectClass").html(html);
            },
            error: function () {

            }
        });
    }
}