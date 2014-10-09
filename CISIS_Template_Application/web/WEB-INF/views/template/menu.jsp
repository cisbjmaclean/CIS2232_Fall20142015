<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html:html lang="true">
    <spring:nestedPath path="menu">
    <form action="login" method="post">
        <body>
            <table>                     
                <tr>
                    <td>        <input type="submit" name="action" value="Logout">
                    </td>
                </tr>
            </table>
        </body>
    </form>
    </spring:nestedPath>

</html:html>