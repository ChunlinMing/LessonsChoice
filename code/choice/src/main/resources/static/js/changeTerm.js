$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("input[type='number']").val();
        if (value.length != 5 || !(/^(\+|-)?\d+$/.test(value)) || value <= 0) {
            $("#hint-div").html("<span style='color: red;'>学期应为5位数正整数！</span>");
        }
        else {
            var changeTerm = {};
            var v = $("#bs3Select").val();
            changeTerm.termBefore = v;
            changeTerm.termAfter = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeTerm',
                datatype: 'application/json; charset=UTF-8',
                data: changeTerm,
                success: function (result) {
                    if (result == 1) {
                        $("#bs3Select option").each(function () {
                            if (v == $(this).val())
                            {
                                $(this).remove();
                                $("#bs3Select").append("<option>"+value+"</option>");
                            }
                        });
                        $("#hint-div").html("<span>更改学期成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>更改学期失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>学期已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });
});