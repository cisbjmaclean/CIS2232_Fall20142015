<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Journal Entry</title>
        
        <html:base/>
    </head>
    <spring:nestedPath path="journalEntry">
        <form action="addJournalEntry" method="post">
            <body>

                <h2>Please provide your entry details</h2>
                <table>
                    <tr>
                        <td>Date</td>
                        <td><form:input path="dateOfEntry"/>
                        </td>

                    </tr>          
                    <tr>
                        <td>Weight:</td>
                        <td><form:input path="weight" />
                        </td>

                    </tr>          

                    <tr>
                        <td>Description:</td>
                        <td><form:textarea path="entry" /><form:errors path="entry" cssClass="error" />${message}
                        </td>

                    </tr>          

                    
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Add Entry"/>
                        </td>
                    </tr>
                </table>
            </body>
        </form>
    </spring:nestedPath>

</html:html>