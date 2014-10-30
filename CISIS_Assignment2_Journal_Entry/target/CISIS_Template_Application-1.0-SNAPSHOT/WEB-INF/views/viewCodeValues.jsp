<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:nestedPath path="menu">
    <form action="menu" method="post">
        <table>
            <tr>
                <td>Here are the code values for that code type.
                </td>
            </tr>
            <tr>
                <td>
                    ${message}

                </td>
            </tr>
            <c:forEach var="thisCode" items="${theCollection}"
                       varStatus="loopCounter">
                <tr>
                    <td><c:out value="${loopCounter.count}" /></td>
                    <td><c:out value="${thisCode.description}" /></td>
                </tr>
            </c:forEach>

            <tr>
                <td>
                    <form:select path="action">
                        <form:options items="${theCollection}" itemLabel="description" itemValue="codeValueSequence"/>
                    </form:select>
                </td>
            </tr>





        </table>
    </form>
</spring:nestedPath>
