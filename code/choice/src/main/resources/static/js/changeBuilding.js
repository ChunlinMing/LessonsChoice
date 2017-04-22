$(document).ready(function () {
    $("#confirmBtn").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 10) {
            $("#hint-div").html("<span style='color: red;'>教学楼名称过长！</span>");
        }
        else {
            var changeBuilding = {};
            var v = $("#bs3Select").val();
            changeBuilding.buildingBefore = v;
            changeBuilding.buildingAfter = value;
            changeBuilding.flag = 1;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeBuilding',
                datatype: 'application/json; charset=UTF-8',
                data: changeBuilding,
                success: function (result) {
                    if (result == 1) {
                        $("#bs3Select option").each(function () {
                            if (v == $(this).val())
                            {
                                $(this).remove();
                                $("#bs3Select").append("<option>"+value+"</option>");
                            }
                        });
                        $("#hint-div").html("<span>更改教学楼名称成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>更改教学楼名称失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>教学楼名称已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });

    $("#deleteBtn").click(function () {
        var changeBuilding = {};
        var v = $("#bs3Select").val();
        changeBuilding.buildingBefore = v;
        changeBuilding.flag = 0;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/changeBuilding',
            datatype: 'application/json; charset=UTF-8',
            data: changeBuilding,
            success: function (result) {
                if (result == 1) {
                    $("#bs3Select option").each(function () {
                        if (v == $(this).val())
                        {
                            $(this).remove();
                        }
                    });
                    $("#hint-delete").html("<span>删除教学楼成功！</span>");
                }
                else if (result == 0) {
                    $("#hint-delete").html("<span style='color: red;'>删除教学楼失败！</span>");
                }
            },
            error: function () {

            }
        });
    });
});