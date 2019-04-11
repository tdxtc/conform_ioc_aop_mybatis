$(function () {
    init(1, 5);
})

function goNormal(n) {
    $("#dataTable tr:not(:first)").empty("");
    $("#btns").find("button").remove();
    init(n, 5);
}

function init(currentPage, pageSize) {
    $.ajax({
        type: 'POST',
        url: 'select',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            "currentPage": currentPage,
            "pageSize": pageSize
        }),
        success: function (responseText) {
            console.log(responseText)
            //给表格添加数据
            for (var i = 0; i < responseText.list.length; i++) {
                var tr = $("<tr>"+
                    "<td>"+responseText.list[i].userId+"</td>"+
                    "<td><input type=\"checkbox\" class='ids' value="+responseText.list[i].userId+"></td>"+
                    "<td>"+responseText.list[i].username+"</td>"+
                    "<td>"+responseText.list[i].name+"</td>"+
                    "<td>"+responseText.list[i].email+"</td>"+
                    "<td>"+
                    "<button type=\"button\" onclick='jumpToRole("+responseText.list[i].userId+")' class=\"btn btn-success btn-xs\"><i class=\" glyphicon glyphicon-check\"></i></button>&nbsp;"+
                    "<button type=\"button\" onclick='jumpToEdit("+responseText.list[i].userId+")' class=\"btn btn-primary btn-xs\"><i class=\" glyphicon glyphicon-pencil\"></i></button>&nbsp;"+
                    "<button type=\"button\" onclick='deleteBtn("+responseText.list[i].userId+")' class=\"btn btn-danger btn-xs\"><i class=\" glyphicon glyphicon-remove\"></i></button>"+
                    "</td>"+
                    "</tr>").insertAfter($("#dataTable tbody tr:last"));
                $("#dataTable").append(tr);
            }

            //动态生成页数
            for (var i = 0; i < responseText.lastPage; i++) {
                if (i == 0) {
                    //首页
                    var buttonFirst = $("<button onclick='goNormal(" + responseText.firstPage + ")' class='btn-primary'>首页</button>");
                    //是否存有上页
                    if (responseText.pageNum == 1) {
                        var buttonPrep = $("<button onclick='goNormal(" + responseText.prePage + ")' class=\"btn-primary\" disabled='disabled'>上一页</button>")
                    } else {
                        var buttonPrep = $("<button onclick='goNormal(" + responseText.prePage + ")' class=\"btn-primary\">上一页</button>")
                    }
                    $("#btns").append(buttonFirst);
                    $("#btns").append(buttonPrep);
                }
                if (i == responseText.pageNum - 1) {
                    var button = $("<button onclick='goNormal(" + (i + 1) + ")' class=\"btn-success\">" + (i + 1) + "</button>")
                } else {
                    var button = $("<button onclick='goNormal(" + (i + 1) + ")' class=\"btn-primary\">" + (i + 1) + "</button>")
                }
                $("#btns").append(button);
                if (i == responseText.lastPage - 1) {
                    //尾页
                    var buttonEnd = $("<button onclick='goNormal(" + responseText.lastPage + ")' class=\"btn-primary\">尾页</button>");
                    if (responseText.pageNum == responseText.lastPage) {
                        var buttonNext = $("<button onclick='goNormal(" + responseText.nextPage + ")' class=\"btn-primary\" disabled='disabled'>下一页</button>")
                    } else {
                        var buttonNext = $("<button onclick='goNormal(" + responseText.nextPage + ")' class=\"btn-primary\">下一页</button>")
                    }
                    $("#btns").append(buttonNext);
                    $("#btns").append(buttonEnd);
                }

            }
            //当前页数
            $("#currentPage").html(responseText.pageNum);
            //总页数
            $("#totalPage").html(responseText.lastPage);
            //总记录数
            $("#totalNums").html(responseText.total);

            var count = 0;
            $("#idFlag").click(function () {
                var flag = $(this).prop("checked");
                if(flag){
                    count = $(".ids").length;
                }else{
                    count = 0;
                }
                //根据全选框来决定下面的框是否勾选
                $(".ids").prop("checked",flag);

            });
            //获取用户勾选框选中状态
            $(".ids").each(function () {
                $(this).click(function () {
                    if($(this).prop("checked")){
                        count++;
                        if(count == $(".ids").length){
                            $("#idFlag").prop("checked",true);
                        }
                    }else{
                        count--;
                        $("#idFlag").prop("checked",false);
                    }
                });
            });
        },
        error: function (message) {
            console.log(message);
        },
        dataType: 'json'
    });
}

function goto() {
    $("#dataTable tr:not(:first)").empty("");
    $("#btns").find("button").remove();
    init($("#t").val(), 5);
}