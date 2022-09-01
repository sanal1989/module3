
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta CHARSET="UTF-8"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <link rel="stylesheet" href="style.css">
    <title>Title</title>
    <style>
        .maindiv{
            margin-top:200px;
            text-align: center;
            top: 50%;
        }
        .divbottom{
            top: 90%;
            left:10px;
        }
        table{
            margin-left: 300px;
            width: 800px;
            height: 300px;
        }
        table, tr, td{
            border: black 2px solid;
        }
    </style>
</head>

<body>
<div class="maindiv">
    <h1>Game Over</h1>
    <button onclick="restart('CORE')">Restart</button>
    <div class = "divbottom">
        <h2>statistica</h2>
        <p>Address:<c:out value="${address}" /></p>
        <p>name:<c:out value="${name}" /></p>
    </div>
</div>
<script>
    function restart(){
        document.cookie = encodeURIComponent("stage") + '=' + encodeURIComponent("CORE");
        $.get("/", function (data){
            location.reload();
        });
    }

</script>
</body>

</html>
