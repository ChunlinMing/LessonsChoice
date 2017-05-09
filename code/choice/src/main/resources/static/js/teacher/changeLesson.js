$(document).ready(function () {
    $("#deleteBtn").click(function () {
        var value = $("#id").text();
        var lessonId = value.substring(4,value.length);
        if (null != lessonId && "" != lessonId.trim())
        {
            var lesson = {};
            lesson.lessonId = lessonId;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/deleteLesson',
                datatype: 'application/json; charset=UTF-8',
                data: lesson,
                success: function (result) {
                    if (result == 1 || result == -200) {
                        //移除该行
                        $("a[data-id="+lessonId+"]").parent().parent().remove();
                    }
                    else if (result == 0) {
                        alert("删除课程失败，请稍后再试！");
                    }
                },
                error: function () {

                }
            });
        }
    });

    $("#three").click(function () {
        $("#four").prop("checked",false);
    });

    $("#four").click(function () {
        $("#three").prop("checked",false);
    });

    //更改课程
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
        else
        {
            if (i == j)
            {
                v5 = i+"周";
            }
            var updateLesson = {};
            updateLesson.lessonIdAfter = v1;
            updateLesson.lessonNameAfter = v2;
            updateLesson.classroomAfter = v3;
            updateLesson.lessonTimeAfter = v4;
            updateLesson.lessonWeeksAfter = v5;
            updateLesson.lessonTypeAfter = v6;
            updateLesson.lessonScoreAfter = v7;
            updateLesson.gradeYearAfter = v9;
            updateLesson.schoolAfter = v10;
            updateLesson.lessonOptionalStuAfter = v11;
            updateLesson.lessonIdBefore = $("#beforeId").val();
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeLesson',
                datatype: 'application/json; charset=UTF-8',
                data: updateLesson,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-div").html("<span>更改课程成功！</span>");
                        window.location.reload();
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>更改课程失败！</span>");
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

function deleteLesson(data)
{
    $("#id").html("课程号："+$(data).attr("data-id"));
    $("#name").html("课程名："+$(data).attr("data-name"));
}

function findClassroomByBuilding()
{
    var data = $("#select-building").val();
    if (null != data && "" != data.trim())
    {
        var building = {};
        building.building = data;
        $.ajax({
            catch: false,
            async: false,
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

function changeDialog(data) {
    var classroom = {};
    classroom.classroom = $(data).attr("data-classroom");
    $.ajax({
        catch: false,
        async: false,
        type: 'post',
        url: 'http://localhost:8080/findBuildingByClassroom',
        datatype: 'application/json; charset=UTF-8',
        data: classroom,
        success: function (result) {
            if (null != result){
                $("#select-building").val(result);
                findClassroomByBuilding();
                $("#select-classroom").val($(data).attr("data-classroom"));
            }

        },
        error: function () {

        }
    });

    $("#input-id").val($(data).attr("data-id"));
    $("#input-name").val($(data).attr("data-name"));
    var time = $(data).attr("data-time");
    var times = time.split("，");
    $("#select-day").val(times[0].substring(0,2));
    $("#select-time").val(times[0].substring(2,time.length));

    if (undefined != times[1]){
        if ("三节连上" == times[1])
        {
            $("#three").prop("checked",true);
            $("#four").prop("checked",false);
        }
        else
        {
            $("#four").prop("checked",true);
            $("#three").prop("checked",false);
        }
    }
    else
    {
        $("#three").prop("checked",false);
        $("#four").prop("checked",false);
    }
    var week = $(data).attr("data-weeks");
    var weeks = week.split("~");
    $("#select-week-start").val(weeks[0]);
    if (undefined != weeks[1])
    {
        $("#select-week-end").val(weeks[1]);
    }
    else
    {
        $("#select-week-end").val(weeks[0]);
    }
    $("#select-lessonType").val($(data).attr("data-type"));

    var score = parseFloat($(data).attr("data-score"));
    $("#select-lessonScore-one").val(parseInt(score));
    $("#select-lessonScore-two").val(score-parseInt(score));


    if ("0" == $(data).attr("data-year"))
    {
        $("#gradeYear-chooseAll").prop("checked",true);
    }
    else
    {
        $("#select-gradeYear").val($(data).attr("data-year"));
        $("#gradeYear-chooseAll").prop("checked",false);
    }

    if ("All" == $(data).attr("data-school"))
    {
        $("#school-chooseAll").prop("checked",true);
    }
    else
    {
        $("#select-school").val($(data).attr("data-school"));
        $("#school-chooseAll").prop("checked",false);
    }
    $("#input-unm").val($(data).attr("data-optionalstu"));
    $("#beforeId").val($(data).attr("data-id"));
}