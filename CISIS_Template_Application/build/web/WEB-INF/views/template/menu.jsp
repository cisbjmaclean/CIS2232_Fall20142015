<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- 
    Document   : main
    Created on : Nov 13, 2013, 2:51:24 PM
    Author     : bjmaclean
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head></head>
<html:form action="">
<table>
<tr>
    <td>
        <h2>Menu</h2>
  </td>
</tr>

<%-- This will filter the member button for the member user types 
<logic:notEqual name="user" property="userType" value="1" scope="session">
<tr>
  <td width="120" valign="top">
      <font size="-1"> <input type="submit" name="action" value="Future"/></font>
  </td>
</tr>
</logic:notEqual>
--%>

<tr>
  <td>
      <h3>Member Details</h3>
  </td>
</tr>
<tr>
  <td>
      <input type="submit" name="action" value="Basic" />
  </td>
</tr>
<tr>
  <td>
      <h3>Tools</h3>
  </td>
</tr>
<tr>
  <td>
    <input type="submit" name="action" value="Reports"/>
  </td>
</tr>
<tr>
  <td>
    <input type="submit" name="action" value="Password"/>
  </td>
</tr>
<tr>
  <td>
    <input type="submit" name="action"  value="Notifications"/>
  </td>
</tr>
<tr>
  <td>
    <input type="submit" name="action" value="Logout"/>
  </td>
</tr>

<logic:equal name="user_type" scope="session" value="1">
<tr>
  <td>
      <h3>Administration</h3>
  </td>
</tr>
<tr>
  <td>
    <input type="submit" name="action" value="Add user"/>
  </td>
</tr>
</logic:equal>

</table>
</html:form>
</html>