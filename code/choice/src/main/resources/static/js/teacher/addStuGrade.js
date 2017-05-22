$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("#stuGrade").val();
        if (value > 100 || !(/^(\+|-)?\d+$/.test(value)) || value < 0) {
            $("#hint-div").html("<span style='color: red;'>成绩应为小于100的正数！</span>");
        }
        else
        {
            var stuGrade = {};
            stuGrade.stuId = $("#stuId").val();
            stuGrade.stuName = $("#stuName").val();
            stuGrade.stuClass = $("#stuClass").val();
            stuGrade.term = $("#lessonTerm").val();
            stuGrade.lessonType = $("#lessonType").val();
            stuGrade.lessonId = $("#lessonId").val();
            stuGrade.lessonName = $("#lessonName").val();
            stuGrade.examType = $("#examType").val();
            stuGrade.stuGrade = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addStuGrade',
                datatype: 'application/json; charset=UTF-8',
                data: stuGrade,
                success: function (result) {
                    if (result == 0) {
                        alert("添加成绩失败，请稍后重试！");
                    }
                },
                error: function () {

                }
            });
        }
    });
});

function addStuGrade(data) {
    $("#stuId").val($(data).attr("data-stuId"));
    $("#stuName").val($(data).attr("data-stuName"));
    $("#stuClass").val($(data).attr("data-stuClass"));
    $("#lessonId").val($(data).attr("data-lessonId"));
    $("#lessonName").val($(data).attr("data-lessonName"));
    $("#lessonType").val($(data).attr("data-lessonType"));
    $("#lessonTerm").val($(data).attr("data-lessonTerm"));
}

function dialog() {
    alert("注意：添加成绩后不可更改，请仔细检查成绩正确性！！！");
}