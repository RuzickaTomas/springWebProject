<%-- 
    Document   : AddClassForm
    Created on : 31.8.2016, 20:03:51
    Author     : Tomáš
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
    <form:form action="insertClass.htm" method="post"  modelAttribute="s_class">
         <table>
            <tr>
             <td>Id:</td>   
             <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><form:input path="title" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
         </table>
                
    </form:form>
    </body>
</html>
