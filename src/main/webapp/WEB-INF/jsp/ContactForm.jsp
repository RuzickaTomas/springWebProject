<%-- 
    Document   : ContactForm
    Created on : 2.8.2016, 14:42:41
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form action="saveContact.htm" method="post"  modelAttribute="contactEdit">
        <table>
            <tr>
             <td>Id:</td>   
             <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname" /></td>
            </tr>
            <tr>
                <td>Student id:</td>
                <td><form:input path="studid" /></td>
            </tr>
            <tr>
                <td>Class id:</td>
                <td><form:input path="classid" /></td>
            </tr>
             <tr>
                <td>Password:</td>
                <td><form:input  path="password" /></td>
            </tr>
             <tr>
                
                 <td><form:hidden  path="enabled" value="true" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>

    </body>
</html>
