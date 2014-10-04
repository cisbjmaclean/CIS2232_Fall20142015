<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
        
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        
        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>
        
        <html:form action="/EnterPin">
        <center>

            <label class="alignCenter" for="studentId">name:</label><html:text property="name" /><br>
            <label class="alignCenter" for="firstName">course name:</label><html:text property="courseName" /><br>
            <label class="alignCenter" for="lastName">pin</label><html:text property="pin" /><br>

            <html:submit>Check PIN</html:submit>
            </center>
    </html:form>

        
        
    </body>
</html:html>
