<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%-- Layout Tiles 
  This layout render a header, left menu, body and footer.
  @param title String use in page title
  @param header Header tile (jsp url or definition name)
  @param menu Menu 
  @param body Body
  @param footer Footer
--%>

<html>
    <head><link rel="stylesheet" type="text/css" href="http://bjmac.hccis.info:8080/styles/styles.css"></head>

    <body> 
        <table>
            <tr>
                <td>start<fmt:message key="NotEmpty.productList.product_price"/>end</td>
                <td align="center"><tiles:insertAttribute name="header"  /></td>
            </tr>
            <tr>
                <td width="10%" valign="top">
                    
                </td>
                <td width="90%" valign="top"  align="center">
                    <tiles:insertAttribute name='body' />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><tiles:insertAttribute name="footer" /></td>
            </tr>
        </table>
    </body>
</html>