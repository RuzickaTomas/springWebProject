<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/LoginCss.css" />" />
        <title>JSP Page - welcome</title>
    </head>
         
    <body>
       
        <span class="word"><a href="index.htm"><h1>!Login</h1></a></span>
               <div class="messageBox">
                <c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
               </div>         
        <!-- form -->
        <form name='formLogin' 
              action="<c:url value='/j_spring_security_check' />" 
              method='POST'>     
            <label>User:</label>
            <input id="username" type='text' name='username' value=''/>
            <label>Password:</label>
            <input id="password" type='password' name='password' />
            <input name="submit" type="submit" value="submit" />
        
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>

    </body>
</html>
