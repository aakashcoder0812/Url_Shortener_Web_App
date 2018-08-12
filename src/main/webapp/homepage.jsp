<%--
  Created by IntelliJ IDEA.
  User: AAKASH MUNJAL
  Date: 07-08-2018
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <script>
        function myFunction() {
            var copyText = document.getElementById("myInput");
            copyText.select();

            document.execCommand("copy");


            alert("Copied the text: " + copyText.value);
        }
    </script>
</head>

<body>
hello world

<form name="redirect"  method="POST" >

        <label>URL:</label> <input type='text' name='input_string' />
        <label>No of minutes (Optional)</label> <input type='text' name='input_time' value="0" />
        <label>&nbsp;</label> <input type="submit" value="OK" class="btn">


</form>

<c:if test="${!empty shortUrl}">
    <h6> the short url is :</h6>
    <input type="text" value="${shortUrl}"  id="myInput">
    <button onclick="myFunction()">Copy text</button>

</c:if>
<c:if test="${!empty flag}">
    <h6>Either you have entered wrong url or it has been expired, please use this service to create a new short url</h6>
</c:if>

</body>
</html>
