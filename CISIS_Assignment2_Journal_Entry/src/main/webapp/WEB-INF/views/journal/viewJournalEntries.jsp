<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td colspan="3">
                    <b>${message}</b>
                </td>
            </tr>
            <tr>
                <td>Date</td>
                <td>Weight</td>
                <td>Description</td>
            </tr>
            <c:forEach var="thisEntry" items="${journal}"
                       varStatus="loopCounter">

                <tr>
                    <td><c:out value="${thisEntry.dateOfEntry}" /></td>
                    <td><c:out value="${thisEntry.weight}" /></td>
                    <td><c:out value="${thisEntry.entry}" /></td>
                </tr>
            </c:forEach>




        </table>
    </form>
</spring:nestedPath>
