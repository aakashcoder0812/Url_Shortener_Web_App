<%--
  Created by IntelliJ IDEA.
  User: AAKASH MUNJAL
  Date: 07-08-2018
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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

<div class="container">
    <h4>Welcome to my tinyurl project</h4>
    <div class="row">

        <form name="redirect" method="POST">
            <div class="form-group">
                <label>URL:</label> <input type='text' style="width: 900px;" class="form-control input-large"
                                           name='input_string' required/></br>
            </div>
            <div class="form-group">
                <label>No of minutes - Enter 0 for indefinite time</label> <input type='text' style="width: 900px;"
                                                                                  class="form-control col"
                                                                                  name='input_time' value="0"
                                                                                  required/></br>
            </div>
            <div class="form-group">
                <label>Custom Url(Optional)</label><input type='text' style="width: 900px;" class="form-control col"
                                                          name="input_custom_url" value=""/></br>
            </div>
            <div class="form-group">
                <label>&nbsp;</label> <input type="submit" value="Submit" class="btn btn-primary"/>
            </div>

        </form>
    </div>
    <div class="row">
        <c:if test="${!empty custom_already_present}">
            <h4>This custom url is already present for ${custom_already_present}</h4>
        </c:if>
        <c:if test="${!empty url_already_present}">
            <h4>The short link of ${url_already_present} has not expired yet, thus returning old shorturl</h4>
        </c:if>
        <c:if test="${!empty shortUrl}">
            <h6> the short url is :</h6>
            <input type="text" class="form-control" style="width: 500px;" value="${shortUrl}" id="myInput" readonly>
            <button onclick="myFunction()">Copy text</button>

        </c:if>
    </div>
</div>
</body>
</html>
