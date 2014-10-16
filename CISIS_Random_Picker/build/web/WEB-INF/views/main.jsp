<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:nestedPath path="randomPick">
    <form action="enterPickInformation" method="post">
        <table>
            <tr>
                <td>Enter the information to get a random pick
                </td>
            </tr>
            <c:if test="${not empty message}">
            <tr>
                <td>
                    <fmt:message key="label.random.number.picked"/> ${message}                
                </td>
            </tr>
            </c:if>
            <tr>
                <td>
                    <fmt:message key="label.enter.course"/>        
                    <spring:bind path="courseName">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>

                </td>
            </tr>

            <tr>
                <td>
                    <fmt:message key="label.enter.number.students"/>        
                    <spring:bind path="maxNumber">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>

                </td>
            </tr>

            <tr>
                <td>        <input type="submit" name="action" value="Get Random">
                </td>
            </tr>





        </table>
    </form>
</spring:nestedPath>
