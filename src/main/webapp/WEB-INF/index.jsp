<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <style>
        .maindiv{
        margin-top:200px;

        text-align: center;
        top: 50%;
    }
    .divbottom{
        top: 90%;
        left:10px;
    }</style>
</head>
<body>
<div class="maindiv">
    <h1>Викторина</h1>
    <p style="text-align: left; margin-left: 50px;" >Привет,  тебе предстоит пройти викторину на знание языка программирования JAVA</p>
    <p style="text-align: left; margin-left: 50px;" >Викторна состоит из 4 блоков, в каждом блоке тебе будут заданы по вопроса, за каждый правильный ответ тебе будут начисляться очки</p>
    <p style="text-align: left; margin-left: 50px;">У тебя есть 3 жизни, за каждую ошибку отминается одна жизнь</p>
    <h3 style="text-align: left; margin-left: 50px;" >Блоки</h3>
    <ol style="text-align: left; margin-left: 50px;" >
        <li>Основы языка</li>
        <li>Коллекции</li>
        <li>Исключения</li>
        <li>Многопоточность</li>
    </ol>
    <p>Введи имя для участия и нажми кнопку "START"</p>
    <form method="post" action="<c:url value='/'/>" >
        <label><input type="text" name="name"></label></br>
        <input type="submit" value="START" style="margin: 5px;"><br>
    </form>
    <div class = "divbottom">
        <h2>statistica</h2>
        <p>Address:<c:out value="${address}" /></p>
        <p>Score:<c:out value="${score}" /></p>
        <p>life:<c:out value="${life}" /></p>
        <p>name:<c:out value="${name}" /></p>
    </div>
</div>

</body>
</html>
