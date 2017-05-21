function choose(data)
{
    var lessonChoice = {};
    lessonChoice.stuId = $("#userId").text();
    lessonChoice.lessonId = $(data).attr("data-id");
    lessonChoice.lessonName = $(data).attr("data-name");
    lessonChoice.lessonType = $(data).attr("data-type");
    lessonChoice.lessonScore = $(data).attr("data-score");
    lessonChoice.lessonTime = $(data).attr("data-time");
    lessonChoice.lessonWeeks = $(data).attr("data-weeks");
    lessonChoice.term = $(data).attr("data-term");
    lessonChoice.classroom = $(data).attr("data-classroom");
    lessonChoice.teacherId = $(data).attr("data-teacherId");
    lessonChoice.teacherName = $(data).attr("data-teacherName");
    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/chooseLesson',
        datatype: 'application/json; charset=UTF-8',
        data: lessonChoice,
        timeout: 15000, //超时时间：15秒
        success: function (result) {
            if (result == 1 || result == -100 || result == -200) {
                //移除该行
                $(data).parent().parent().remove();
            }
            else if (result == 0) {
                alert("选课失败，请稍后再试！");
            }
            else if (result == -10000)
            {
                alert("此课程人数已满！");
                $(data).parent().html("<span>已满</span>");
            }
            else if (result == -20000)
            {
                alert("已达选课学分上限！");
            }
        },
        error: function () {

        }
    });
}