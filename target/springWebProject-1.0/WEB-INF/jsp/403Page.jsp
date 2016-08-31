<%-- 
    Document   : 403Page
    Created on : 27.7.2016, 9:39:10
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/403Css.css" />" />
        <title>JSP Page</title>
    </head>
    <body>
        <div id="outerLayer">
          <div id="innerLayer">
             <div id="contentLayer">
                <h1>Ooops!</h1>
                <h3>${message}</h3>
                <h4><a href="index.htm">Click here to get back</a></h4>
                <h5><a href="user.htm">Click here if you are user</a></h5>
             </div>
          </div>
        </div>
   </body>
</html>
