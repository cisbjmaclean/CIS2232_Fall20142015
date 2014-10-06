<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html:html lang="true">

    <spring:nestedPath path="menu">
        <form action="" method="post">
            <body>
            <center>
                <h2>Welcome to CISIS</h2>
                <table>
                    <tr>
                        <td>
                            <spring:bind path="action">
                                <input type="submit" name="${status.expression}" value="${status.value}">
                            </spring:bind>

                        </td>
                    </tr>
                </table>
            </center>
            </body>
            </html:form>
        </spring:nestedPath>
</html:html>