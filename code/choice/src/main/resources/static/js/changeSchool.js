$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 20) {
            $("#hint-div").html("<span style='color: red;'>学院名称过长！</span>");
        }
        else {
            var changeSchool = {};
            var v = $("#bs3Select").val();
            changeSchool.schoolBefore = v;
            changeSchool.schoolAfter = value;
            changeSchool.flag = 1;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeSchool',
                datatype: 'application/json; charset=UTF-8',
                data: changeSchool,
                success: function (result) {
                    if (result == 1) {
                        $("#bs3Select option").each(function () {
                            if (v == $(this).val())
                            {
                                $(this).remove();
                                $("#bs3Select").append("<option>"+value+"</option>");
                            }
                        });
                        $("#hint-div").html("<span>更改学院名称成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>更改学院名称失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>学院名称已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });

    $("#deleteBtn").click(function () {
        var changeSchool = {};
        var v = $("#bs3Select").val();
        changeSchool.schoolBefore = v;
        changeSchool.flag = 0;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/changeSchool',
            datatype: 'application/json; charset=UTF-8',
            data: changeSchool,
            success: function (result) {
                if (result == 1) {
                    $("#bs3Select option").each(function () {
                        if (v == $(this).val())
                        {
                            $(this).remove();
                        }
                    });
                    $("#hint-delete").html("<span>删除学院成功！</span>");
                }
                else if (result == 0) {
                    $("#hint-delete").html("<span style='color: red;'>删除学院失败！</span>");
                }
            },
            error: function () {

            }
        });
    });
});