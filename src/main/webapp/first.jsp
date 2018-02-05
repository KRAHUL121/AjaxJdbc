<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
    $(document).ready(function(){
        $("#mybutton").click(function(){
            var id1=$('#myid').val();
            var name1=$('#myname').val();
            var desc1=$('#mydesc').val();
            var price1=$('#myprice').val();
            $.post("My",{id1:id1,name1:name1,desc1:desc1,price1:price1},function(data,status){
                alert("Data: " + data+ " Status: "+status);
            });
        });
    });
    </script>
    
</head>
<body>

        Id:<input type="text" name="id" id="myid" /><br/>
        Name:<input type="text" name="name" id="myname"/><br/>
        Description:<input type="text" name="description" id="mydesc" /><br/>
        Price:<input type="text" name="price" id="myprice"/><br/>
        <input type="button" id="mybutton" value="register" />

</body>
</html>