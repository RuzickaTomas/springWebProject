<%-- 
    Document   : admin
    Created on : 27.7.2016, 8:35:04
    Author     : admin
--%>

<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/PagesCss.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/AdminCss.css" />" />
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
            <a href="#cont">Studenti</a>
            <a href="#cont2">Soubory studentů</a>
            <a href="#cont3">Upload</a>
            <a id="login" onclick="formSubmit()">Logout: ${pageContext.request.userPrincipal.name}</a>
         </div>
          <div class="space">&nbsp;</div>
          <div id="wrap">
            <div id="cont">
            <h1>Seznam studentů</h1>
            <h3><a href="newContact.htm">Nový student</a></h3>
            <h3><a href="newClass.htm">Nový předmět</a></h3>
            <table border="1" style="margin: 0 auto 0 auto;">
                    <th>id</th>
                    <th>name</th>
                    <th>surname</th>
                    <th>studid</th>
                    <th>class_id</th>
                    <th>password</th>
                    <th>enabled</th>
                 
                <c:forEach var="contact" items="${listContact}" varStatus="status">
                <tr>
                    <td>${contact.id}</td>
                    <td>${contact.name}</td>
                    <td>${contact.surname}</td>
                    <td>${contact.studid}</td>
                    <td>${contact.classid}</td>
                    <td>${contact.password}</td>
                    <td>${contact.enabled}</td>
                    <td>
                        <a href="editContact.htm?id=${contact.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteContact.htm?id=${contact.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>              
            </table>
   
            </div>
            <div id="cont2">
          
                  <form:form method="post" action="adminSend.htm?${_csrf.parameterName}=${_csrf.token}" 
                              modelAttribute="uploadForm" enctype="multipart/form-data">
                    <input type="file" name="files[0]" />
                    <input type="file" name="files[1]" />
                    <input type="submit" value="upload">
                    </form:form>
              
                  <table border="1" style="margin: 0 auto 0 auto;">   
                    <th>ID</th>
                    <th>Name</th>
                    <th>Author</th>       
                    
                <c:forEach var="work" items="${listHref}" varStatus="status">
                <tr>
                    <td>${work.id}</td>
                    <td>${work.name}</td>
                    <td>${work.studid}</td>
                   
                     <td>
                       <a href="download.htm?id=${work.id}">Download</a>
                     </td>
                    <td>                  
                        <a href="deleteAdminWork.htm?id=${work.id}">Delete</a>
                    </td>
                    
                             
                </tr>
                </c:forEach>  
                </table>
              
              </div>
              <div id="cont3">
                  
                  <table border="1" style="margin: 0 auto 0 auto;">   
                    <th>ID</th>
                    <th>Title</th>
                       
                    
                <c:forEach var="trida" items="${listTrida}" varStatus="status">
                <tr>
                    <td>${trida.id}</td>
                    <td>${trida.title}</td>

                   
                    <td>                  
                        <a href="editClass.htm?id=${trida.id}">Edit</a>
                    </td>
                      <td>                  
                        <a href="deleteClass.htm?id=${trida.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>  
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
