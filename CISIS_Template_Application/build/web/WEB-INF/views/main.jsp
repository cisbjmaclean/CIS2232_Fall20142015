<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<spring:nestedPath path="menu">
    <form action="" method="post">
            <h2>Welcome to CISIS</h2>
            <table>
                <tr>
                    <td>Welcome to the application!
                    </td>
                </tr>
                <tr>
                    <td>
                ${message}
                
                    </td>
                </tr>
                <c:forEach var="province" items="${sessionScope.provinces}"
			varStatus="loopCounter">
		<tr>
                    <td><c:out value="${loopCounter.count}" /></td>
                    <td><a href="http://localhost:8080/CISIS_Summerside/welcome?province=${province.codeValueSequence}"><c:out value="${province.description}" /></a></td>
		</tr>
		</c:forEach>

                
                
                
            </table>
    </form>
    </spring:nestedPath>
