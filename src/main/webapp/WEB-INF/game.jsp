<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.08.2022
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
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
        <h1>Game</h1>
        <table>
            <tr>
                <td id="question" rowspan="5">
                    <c:out value="${question}" />
                </td>
            </tr>
            <tr>
                <td id="answer1" onclick="sendAnswer(`${answer1}`,`${questionNumber}`)"><c:out value="${answer1}" /></td>
            </tr>
            <tr>
                <td id="answer2" onclick="sendAnswer(`${answer2}`,`${questionNumber}`)"><c:out value="${answer2}" /></td>
            </tr>
            <tr>
                <td id="answer3" onclick="sendAnswer(`${answer3}`,`${questionNumber}`)"><c:out value="${answer3}" /></td>
            </tr>
            <tr>
                <td id="answer4" onclick="sendAnswer(`${answer4}`,`${questionNumber}`)"><c:out value="${answer4}" /></td>
            </tr>
        </table>
        <button onclick="stageFunction('CORE')">CORE</button>
        <button onclick="stageFunction('COLLECTION')">COLLECTION</button>
        <button onclick="stageFunction('EXCEPTION')">EXCEPTION</button>
        <button onclick="stageFunction('FLOW')">THREAD</button>


        <div class = "divbottom">
            <h2>statistica</h2>
            <p>Address:<c:out value="${address}" /></p>
            <p>Score:<c:out value="${score}" /></p>
            <p>life:<c:out value="${life}" /></p>
            <p>name:<c:out value="${name}" /></p>
        </div>
    </div>

    <script>
        function sendAnswer(answer,questionNumber){
            console.log(answer + " " + questionNumber);
            $.get("/?answer="+answer + "&questionNumber="+questionNumber, function (data){
                location.reload();
            });

        }

        function stageFunction(stage){
            document.cookie = encodeURIComponent("stage") + '=' + encodeURIComponent(stage);
            $.get("/", function (data){
                location.reload();
            });
        }
    </script>
</body>

</html>
