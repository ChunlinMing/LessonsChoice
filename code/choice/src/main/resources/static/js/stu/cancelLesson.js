function cancelLesson(data) {
    var lessonChoice = {};
    lessonChoice.stuId = $("#userId").text();
    lessonChoice.lessonId = $(data).attr("data-id");
    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/cancelLesson',
        datatype: 'application/json; charset=UTF-8',
        data: lessonChoice,
        success: function (result) {
            if (result == 1 || -200) {
                //移除该行
                $(data).parent().parent().remove();

                var scoreAmount = parseFloat($("#scoreAmount").text().substring(5,$("#scoreAmount").text().length - 0));
                var score = $(data).attr("data-score");
                $("#scoreAmount").text("已选学分：" + Math.round((scoreAmount - score) * 10) / 10);
            }
            else if (result == 0) {
                alert("退课失败，请稍后再试！");
            }
        },
        error: function () {

        }
    });
}