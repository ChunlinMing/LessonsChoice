$(document).ready(function () {
    $("#changeBtn").click(function () {
        var value = $("#selectSchool").val();
        var v = $("#selectClass").val();
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
            $("#hint-div").html("<span style='color: red;'>教学班班号过长！</span>");
        }
        else {
            var changeClass = {};
            var school = $("#bs3Select").val();
            var v = $("#selectClass").val();
            changeClass.schoolAfter = school;
            changeClass.stuClassBefore = v;
            changeClass.stuClassAfter = value;
            changeClass.flag = 1;
            $.ajax({
                catch: false,
                async: false,
                type: 'post',
                url: 'http://localhost:8080/changeClass',
                datatype: 'application/json; charset=UTF-8',
                data: changeClass,
                success: function (result) {
                    if (result == 1) {
                        $("#selectSchool").val(school);
                        findClassBySchool();
                        $("#selectClass").val(value);
                        $("#hint-div").html("<span>更改教学班班号成功！</span>");
                    }
                    else if (result == 0) {
                        $("#hint-div").html("<span style='color: red;'>更改教学班班号失败！</span>");
                    }
                    else if (result == -100) {
                        $("#hint-div").html("<span style='color: red;'>教学班班号已存在！</span>");
                    }
                },
                error: function () {

                }
            });

        }
    });

    $("#deleteBtn").click(function () {
        var changeClass = {};
        var v = $("#selectClass").val();
        changeClass.stuClassBefore = v;
        changeClass.flag = 0;
        $.ajax({
            catch: false,
            async: false,
            type: 'post',
            url: 'http://localhost:8080/changeClass',
            datatype: 'application/json; charset=UTF-8',
            data: changeClass,
            success: function (result) {
                if (result == 1) {
                    $("#selectClass option").each(function () {
                        if (v == $(this).val())
                        {
                            $(this).remove();
                        }
                    });
                    $("#hint-delete").html("<span>删除教学班成功！</span>");
                }
                else if (result == 0) {
                    $("#hint-delete").html("<span style='color: red;'>删除教学班失败！</span>");
                }
                else if (result == -200)
                {
                    $("#hint-delete").html("<span style='color: red;'>要删除的教学班不存在！</span>");
                }
            },
            error: function () {

            }
        });
    });
});

function findClassBySchool()
{
    var schoolValue = $("#selectSchool").val();
    if (null != schoolValue && "" != schoolValue.trim())
    {
        var school = {};
        school.school = schoolValue;
        $.ajax({
            catch: false,
            async: false,
            type: 'post',
            url: 'http://localhost:8080/findClassBySchool',
            datatype: 'application/json; charset=UTF-8',
            data: school,
            success: function (result) {
                var html = "";
                for(var i=0;i<result.length;i++){
                    html += "<option>"+result[i].stuClass+"</option>";
                }
                $("#selectClass").html(html);
            },
            error: function () {

            }
        });
    }
}