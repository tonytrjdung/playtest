$(document).ready(function(){
    $("#ajaxsample").click(function(){
        $.ajax({
            type :  "GET",
            url  :  "/resultajax",
            contentType: "application/json;charset=utf-8",
            success: function(data){
                $("#div1").html(data.name2 + data.age2);
            }
        });
    });


    $("#ajaxsample1").click(function(){
        $.ajax({
            type :  "GET",
            url  :  "/resultlistobject",
            contentType: "application/json;charset=utf-8",
            success: function(data){
                $("#div2").html(data.email + data.name + data.fullName);
            }
        });
    });


    $("#ajaxsample3").click(function(){
        $.ajax({
            type :  "GET",
            url  :  "/resultlist",
            contentType: "application/json;charset=utf-8",
            success: function(data){
                var test = "";
                for(var i = 0;i < data.length;i++) {
                    test += "<tr>";
                    test += "<td>" +  data[i].email + "</td>";
                    test += "<td>" +  data[i].name + "</td>";
                    test += "<td>" +  data[i].fullName + "</td>";
                    test +="</tr>";
                }
                $("#div3").html(test);
            }
        });
    });

    $("#ajaxsample4").click(function(){
        $.ajax({
            type :  "GET",
            url  :  "/resultParam",
            data: {name: 'idTest'},
            dataType: 'json',
            contentType: "application/json;charset=utf-8",
            success: function(data){
                $("#div4").html(data);
            }
        });
    });


    $("#ajaxsample5").click(function(){
        var data0 = {email: "ptdung0312@gmail.com", name : "dungpt", fullName:"Phan Thanh Dũng"};

        var json1 = JSON.stringify(data0);

        $.ajax({
            type :  "POST",
            url  :  "/resultObject",
            data:json1,
            dataType: 'json',
            contentType: "application/json;charset=utf-8",
            success: function(data){
                $("#div5").html(data.email + "  " + data.name + " " + data.fullName);
            }
        });
    });

});