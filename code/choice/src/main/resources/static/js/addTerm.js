$(document).ready(function () {
    $("button").click(function () {
        var value = $("input[type='number']").val();
        if (value.length != 5 || !(/^(\+|-)?\d+$/.test(value)) || value <= 0) {
            $("#hint-div").html("<span style='color: red;'>学期应为5位数正整数！</span>");
        }
        else {
            var term = {};
            term.term = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addTerm',
                datatype: 'application/json; charset=UTF-8',
                data: term,
                success: function (result) {
                    if (result == 1) {
                        $("#hint-div").html("<span>添加学期成功！</span>");
                    }
                    else if (result == -1) {
                        $("#hint-div").html("<span style='color: red;'>添加学期失败！</span>");
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