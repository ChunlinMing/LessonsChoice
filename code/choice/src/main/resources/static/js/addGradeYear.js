$(document).ready(function () {
    $("button").click(function () {
        var value = $("input[type='number']").val();
        if (value.length != 4 || !(/^(\+|-)?\d+$/.test(value)) || value <= 0) {
            $("#hint-div").html("<span style='color: red;'>年级应为4位数正整数！</span>");
        }
        else {
            var gradeYear = {};
            gradeYear.gradeYear = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addGradeYear',
                datatype: 'application/json; charset=UTF-8',
                data: gradeYear,
                success: function (result) {
                    if (result == 1) {
                        $("#list").append("<tr style=\"font-size: 16px;font-family: \'Comic Sans MS\';height: 30px;\"><td>"+value+"</td></tr>");
                        $("#hint-div").html("<span>添加年级成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>添加年级失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>年级已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});