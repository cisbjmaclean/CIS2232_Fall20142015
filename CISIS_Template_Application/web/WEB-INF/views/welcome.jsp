<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html:html lang="true">
    <spring:nestedPath path="menu">
    <form action="welcome" method="post">
        <body>
            <h2>Welcome to CISIS</h2>
            <table>
                     
                <tr>
                    <td>        <input type="submit" name="action" value="Submit">
                    </td>
                </tr>
            </table>
        </body>
    </form>
    </spring:nestedPath>

</html:html>