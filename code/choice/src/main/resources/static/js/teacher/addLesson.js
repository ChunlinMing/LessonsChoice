$(document).ready(function () {
    $("#three").click(function () {
        $("#four").prop("checked",false);
    });

    $("#four").click(function () {
        $("#three").prop("checked",false);
    });

    $("#addBtn").click(function () {
        var v1 = $("#input-id").val();
        var v2 = $("#input-name").val();
        var v3 = $("#select-classroom").val();
        var v4 = $("#select-day").val();
        v4 += $("#select-time").val();
        if ($("#three").prop("checked"))
        {
            v4 += "，";
            v4 += $.trim($("#three").val());
        }
        else if ($("#four").prop("checked"))
        {
            v4 += "，";
            v4 += $.trim($("#four").val());
        }

        var v5 = $("#select-week-start").val() + "~" + $("#select-week-end").val();
        var v6 = $("#select-lessonType").val();
        var v7 = Number($("#select-lessonScore-one").val()) + Number($("#select-lessonScore-two").val());
        var v8 = $("#select-term").val();
        var v9 = $("#select-gradeYear").val();
        if ($("#gradeYear-chooseAll").prop("checked"))
        {
            v9 = 0;
        }
        var v10 = $("#select-school").val();
        if ($("#school-chooseAll").prop("checked"))
        {
            v10 = "All";
        }
        var v11 = $("#input-unm").val();

        $("#id").html("课&ensp;程&ensp;号："+v1);
        $("#name").html("课&ensp;程&ensp;名："+v2);
        $("#classroom").html("上课地点："+v3);
        $("#time").html("上课时间："+v4);
        $("#week").html("上课时段："+v5);
        $("#lessonType").html("课程类型："+v6);
        $("#lessonScore").html("课程学分："+v7);
        $("#term").html("上课学期："+v8);
        $("#gradeYear").html("可选年级："+v9);
        $("#school").html("可选学院："+v10);
        $("#num").html("可选人数："+v11);
    });

    $("#confirmBtn").click(function () {
        var v1 = $("#input-id").val();
        var v2 = $("#input-name").val();
        var v3 = $("#select-classroom").val();
        var v4 = $("#select-day").val();
        v4 += $("#select-time").val();
        if ($("#three").prop("checked"))
        {
            v4 += "，";
            v4 += $.trim($("#three").val());
        }
        else if ($("#four").prop("checked"))
        {
            v4 += "，";
            v4 += $.trim($("#four").val());
        }
        var i = parseInt($("#select-week-start").val().substring(0,$("#select-week-start").val().length - 1));
        var j = parseInt($("#select-week-end").val().substring(0,$("#select-week-end").val().length - 1));
        var v5 = $("#select-week-start").val() + "~" + $("#select-week-end").val();
        var v6 = $("#select-lessonType").val();
        var v7 = Number($("#select-lessonScore-one").val()) + Number($("#select-lessonScore-two").val());
        var v8 = $("#select-term").val();
        var v9 = $("#select-gradeYear").val();
        if ($("#gradeYear-chooseAll").prop("checked"))
        {
            v9 = 0;
        }
        var v10 = $("#select-school").val();
        if ($("#school-chooseAll").prop("checked"))
        {
            v10 = "All";
        }
        var v11 = $("#input-unm").val();

        if (null == v1 || "" == $.trim(v1))
        {
            $("#hint-div").html("<span style='color: red;'>课程号不能为空或全空格！</span>");
        }
        else if (v1.length > 15)
        {
            $("#hint-div").html("<span style='color: red;'>课程号过长！</span>");
        }
        else if (null == v2 || "" == $.trim(v2))
        {
            $("#hint-div").html("<span style='color: red;'>课程名称不能为空或全空格！</span>");
        }
        else if (v2.length > 50)
        {
            $("#hint-div").html("<span style='color: red;'>课程名称过长！</span>");
        }
        else if (v11.length > 4 || !(/^(\+|-)?\d+$/.test(v11)) || v11 <= 0)
        {
            $("#hint-div").html("<span style='color: red;'>可选人数应为正整数，且小于3位数！</span>");
        }
        else if (i > j)
        {
            $("#hint-div").html("<span style='color: red;'>上课时段开始周不能大于结束周！</span>");
        }
        else if (i == j)
        {
            v5 = i;
        }
        else
        {
            var lessonInfo = {};
            lessonInfo.lessonId = v1;
            lessonInfo.lessonName = v2;
            lessonInfo.teacherId = $("#teacherId").val();
            lessonInfo.teacherName = $("#teacherName").val();
            lessonInfo.classroom = v3;
            lessonInfo.lessonTime = v4;
            lessonInfo.lessonWeeks = v5;
            lessonInfo.lessonType = v6;
            lessonInfo.lessonScore = v7;
            lessonInfo.term = v8;
            lessonInfo.gradeYear = v9;
            lessonInfo.school = v10;
            lessonInfo.lessonOptionalStu = v11;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addLesson',
                datatype: 'application/json; charset=UTF-8',
                data: lessonInfo,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-div").html("<span>添加课程成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>添加课程失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>该课程已存在！</span>");
                    }
                },
                error: function () {

                }
            });
        }

    });
});

function findClassroomByBuilding()
{
    var data = $("#select-building").val();
    if (null != data && "" != data.trim())
    {
        var building = {};
        building.building = data;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/findClassroomByBuilding',
            datatype: 'application/json; charset=UTF-8',
            data: building,
            success: function (result) {
                var html = "";
                for (var i = 0; i < result.length; i++) {
                    html += "<option>" + result[i].classroom + "</option>";
                }
                $("#select-classroom").html(html);
            },
            error: function () {

            }
        });
    }
}
