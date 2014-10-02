<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pin Validation</title>
        <html:base/>
    </head>
    <body style="background-color: white">

        <h1>Enter information</h1>
        <spring:nestedPath path="studentInformation">
    <form action="" method="post">
        Name:
        <spring:bind path="name">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        Course name:
        <spring:bind path="courseName">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        PIN:
        <spring:bind path="pin">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <input type="submit" value="OK">
    </form>
</spring:nestedPath>

<!--        <html:form action="/EnterPin">
        <center>

            <label class="alignCenter" for="studentId">name:</label><html:text property="name" /><br>
            <label class="alignCenter" for="firstName">course name:</label><html:text property="courseName" /><br>
            <label class="alignCenter" for="lastName">pin</label><html:text property="pin" /><br>

            <html:submit>Check PIN</html:submit>
            </center>
    </html:form>-->
    
        
        
    </body>
</html:html>
