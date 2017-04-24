$(document).ready(function () {
    $("#changeBtn").click(function () {
        var value = $("#selectBuilding").val();
        var v = $("#selectClassroom").val();
        $("#bs3Select option").each(function () {
            if (value == $(this).val())
            {
                $("#bs3Select").val(value);
            }
        });
        $("input[type='text']").val(v);
    });

    $("#confirmBtn").click(function () {
        var value = $("input[type='text']").val();
        if (value.length > 10) {
            $("#hint-div").html("<span style='color: red;'>教室名称过长！</span>");
        }
        else {
            var changeClassroom = {};
            var building = $("#bs3Select").val();
            var v = $("#selectClassroom").val();
            changeClassroom.buildingAfter = building;
            changeClassroom.classroomBefore = v;
            changeClassroom.classroomAfter = value;
            changeClassroom.flag = 1;
            $.ajax({
                type: 'post',
                url: 'http://localhost:8080/changeClassroom',
                datatype: 'application/json; charset=UTF-8',
                data: changeClassroom,
                success: function (result) {
                    if (result == 1) {
                        $("#selectBuilding").val(building);
                        findClassroomByBuilding();
                        $("#selectClassroom").val(value);
                        $("#hint-div").html("<span>更改教室名称成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>更改教室名称失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>教室名称已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });

    $("#deleteBtn").click(function () {
        var changeClassroom = {};
        var v = $("#selectClassroom").val();
        changeClassroom.classroomBefore = v;
        changeClassroom.flag = 0;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/changeClassroom',
            datatype: 'application/json; charset=UTF-8',
            data: changeClassroom,
            success: function (result) {
                if (result == 1) {
                    $("#selectClassroom option").each(function () {
                        if (v == $(this).val())
                        {
                            $(this).remove();
                        }
                    });
                    $("#hint-delete").html("<span>删除教室成功！</span>");
                }
                else if (result == 0) {
                    $("#hint-delete").html("<span style='color: red;'>删除教室失败！</span>");
                }
                else if (result == -200)
                {
                    $("#hint-delete").html("<span style='color: red;'>要删除的教室不存在！</span>");
                }
            },
            error: function () {

            }
        });
    });
});

function findClassroomByBuilding()
{
    var buildingValue = $("#selectBuilding").val();
    if (null != buildingValue && "" != buildingValue.trim())
    {
        var building = {};
        building.building = buildingValue;
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/findClassroomByBuilding',
            datatype: 'application/json; charset=UTF-8',
            data: building,
            success: function (result) {
                var html = "";
                for(var i=0;i<result.length;i++){
                    html += "<option>"+result[i].classroom+"</option>";
                }
                $("#selectClassroom").html(html);
            },
            error: function () {

            }
        });
    }
}