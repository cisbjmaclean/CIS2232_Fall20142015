<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- 
    Document   : main
    Created on : Nov 13, 2013, 2:51:24 PM
    Author     : bjmaclean
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head></head>
    <body>
        <spring:nestedPath path="login">
            <form action="/login" method="post">


                <table>
                    <tr>
                        <td>
                            <h2>Menu</h2>
                        </td>
                    </tr>

                    <%-- This will filter the member button for the member user types 
                    <logic:notEqual name="user" property="userType" value="1" scope="session">
                    <tr>
                      <td width="120" valign="top">
                          <font size="-1"> <input type="submit" name="action" value="Future"/></font>
                      </td>
                    </tr>
                    </logic:notEqual>
                    --%>

                    <tr>
                        <td>
                            <h3>Member Details</h3>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Login"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3>Tools</h3>
                        </td>
                    </tr>

                </table>
            </html:form>
        </spring:nestedPath>
</body>
</html>