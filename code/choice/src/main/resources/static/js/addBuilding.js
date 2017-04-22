$(document).ready(function () {
    $("button").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 10) {
            $("#hint-div").html("<span style='color: red;'>教学楼名称过长！</span>");
        }
        else {
            var building = {};
            building.building = value;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/addBuilding',
                datatype: 'application/json; charset=UTF-8',
                data: building,
                success: function (result) {
                    if (result == 1) {
                        $("#list").append("<tr style=\"font-size: 16px;font-family: \'Comic Sans MS\';height: 30px;\"><td>"+value+"</td></tr>");
                        $("#hint-div").html("<span>添加教学楼成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>添加教学楼失败！</span>");
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
});