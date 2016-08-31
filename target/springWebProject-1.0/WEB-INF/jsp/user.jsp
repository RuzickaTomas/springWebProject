<%-- 
    Document   : user
    Created on : 29.7.2016, 14:46:53
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/PagesCss.css" />" />
        <title>JSP Page</title>
          <script type="text/javascript">
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
           </script>
    </head>
    <body>
            <div id="menu">
            <a id="logo" href="index.htm">Pecinovský OOP</a>
            <a href="#cont">Upload</a>
            <a href="#cont2">Edit</a>
            <a href="#cont3">Personal</a>
            <a id="login" onclick="formSubmit()">Logout: ${pageContext.request.userPrincipal.name}</a>
         </div>
          <div class="space">&nbsp;</div>
            <div id="wrap">
              <div id="cont">
                <h1>Nahraj soubor!</h1>
                 
                    <form:form method="post" action="send.htm?${_csrf.parameterName}=${_csrf.token}" 
                              modelAttribute="uploadForm" enctype="multipart/form-data">
                    <input type="file" name="files[0]" />
                    <input type="file" name="files[1]" />
                    <input type="submit" value="upload">
                    </form:form>
 
              </div>
               <div id="cont2">
                <h3>Právě nahrané soubory:</h3>   
                <table border="1" style="margin: 0 auto 0 auto;">   
                    <th>ID</th>
                    <th>Name</th>
                    <th>Author</th>       
                    
                <c:forEach var="work" items="${workList}" varStatus="status">
                <tr>
                    <td>${work.id}</td>
                    <td>${work.name}</td>
                    <td>${work.studid}</td>
                   
                    <td>                  
                        <a href="deleteWork.htm?id=${work.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>  
                </table>
                
               </div>
                <div id="cont3">
                       <table border="1" style="margin: 0 auto 0 auto;">
                    <th>id</th>
                    <th>name</th>
                    <th>surname</th>
                    <th>studid</th>
                    <th>class_id</th>
                    <th>password</th>
                    <th>enabled</th>
                 
              
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.surname}</td>
                    <td>${student.studid}</td>
                    <td>${student.classid}</td>
                    <td>${student.password}</td>
                    <td>${student.enabled}</td>
                    <td>
                        <a href="editContact.htm?id=${student.id}">Edit</a>

                    </td>
                             
                </tr>
                       
            </table>
                    
                </div>
            <c:url value="/j_spring_security_logout" var="logoutUrl" />
	
                    
            <form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
                
            </form>
        </div>
    </body>
</html>
