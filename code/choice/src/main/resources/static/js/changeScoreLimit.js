$(document).ready(function () {
    $("button").click(function () {
        var value = $("input[type='number']").val();
        if (value > 99 || value < 0) {
            $("#hint-div").html("<span style='color: red;'>学分上限应小于99，且非负数！</span>");
        }
        else {
            var changeScoreLimit = {};
            var v = $("#list").find('td').eq(0).text();
            changeScoreLimit.scoreLimitBefore = v;
            changeScoreLimit.scoreLimitAfter = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeScoreLimit',
                datatype: 'application/json; charset=UTF-8',
                data: changeScoreLimit,
                success: function (result) {
                    if (result == 1) {
                        $("#list").html("<tr style=\"font-size: 16px;font-family: \'Comic Sans MS\';height: 30px;\"><td>"+value+"</td></tr>");
                        $("#hint-div").html("<span>添加学分上限成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>添加学分上限失败！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});