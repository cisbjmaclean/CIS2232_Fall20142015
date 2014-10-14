<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<spring:nestedPath path="menu">
    <form action="welcome" method="post">
        <h2>start<fmt:message key="NotEmpty.productList.product_price" />end</h2>
            <table>
                     
                <tr>
                    <td>        <input type="submit" name="action" value="Submit">
                    </td>
                </tr>
            </table>
    </form>
    </spring:nestedPath>
