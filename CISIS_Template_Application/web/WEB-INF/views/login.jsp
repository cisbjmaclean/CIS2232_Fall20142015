<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html:html lang="true">
    <spring:nestedPath path="login">
        <form action="" method="post">
            <body>
            <center>
                <h2>Please provide your login details</h2>
                <table>
                    <tr>
                        <td>Action:</td>
                        <td><form:input path="username" />
                        </td>

                    </tr>          
                    <tr>
                        <td>Password:</td>
                        <td><form:input path="password" />
                        </td>

                    </tr>          


                    <tr>
                        <td>
                            <input type="submit" value="Login"/>
                        </td>
                    </tr>
                </table>
            </center>
            </body>
        </form>
    </spring:nestedPath>

</html:html>