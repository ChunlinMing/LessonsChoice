$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("input[type='number']").val();
        if (value.length != 4 || !(/^(\+|-)?\d+$/.test(value)) || value <= 0) {
            $("#hint-div").html("<span style='color: red;'>学期应为4位数正整数！</span>");
        }
        else {
            var changeGradeYear = {};
            var v = $("#bs3Select").val();
            changeGradeYear.gradeYearBefore = v;
            changeGradeYear.gradeYearAfter = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeGradeYear',
                datatype: 'application/json; charset=UTF-8',
                data: changeGradeYear,
                success: function (result) {
                    if (result == 1) {
                        $("#bs3Select option").each(function () {
                            if (v == $(this).val())
                            {
                                $(this).remove();
                                $("#bs3Select").append("<option>"+value+"</option>");
                            }
                        });
                        $("#hint-div").html("<span>更改年级成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>更改年级失败！</span>");
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