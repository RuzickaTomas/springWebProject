<%-- 
    Document   : index
    Created on : 21.7.2016, 15:45:51
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/IndexCss.css" />" />
        <title>JSP Page - index</title>
    </head>
    <body>
        
   
       
        <div id="menu">
            <a id="logo" href="#">Pecinovský OOP</a>
            <a href="#cont">Konzultace</a>
            <a href="#cont2">Cvičení</a>
            <a href="#cont3">Domácí úkoly</a>
            <a href="#cont4">Ke stažení</a>
            <a href="#cont5">Ke studiu</a>
            <a id="login" href="login.htm">Login</a>
        </div>
         <div class="space">&nbsp;</div>
         <div id="wrap">
            <div id="cont">  
            <h2>Řádné termíny</h2>
              <p>Ve zkouškovém termíny žádné pravidelné termíny nejsou.
                 Možnosti konzultací jsou poměrně široké, ale je potřeba se objednat.</p>
            <h2>Možnosti objednání</h2>    
            <ul>
                 <li><p>Osobně (např.: na cvičeních)</p></li>
                 <li><p>Telefonicky: +420 603 330 090 nebo +420 224 094 308 </p></li>
                 <li><p>
                     E-mailem:  rudolf@pecinovsky.cz s předmětem škola_KONZULTACE,
                        kde za škola dosadíte název své školy (VSE, FJFI, VSPP, VOSIS, FIT, ...)
                        včetně velikosti písmen.
                        Při jiné podobě předmětu mailu hrozí, že mail skončí ve spamovém koši.
                        </p>
                 <p>
                 PS: Objednávku mailem je vhodné zaslat několik dnů předem,
                protože ve dnech intenzivního pracovního vytížení (což je skoro pořád)
                čtu maily jednou týdně, protože na víc nemám čas.
                Buďte proto připraveni na to, že na mail odpovím tak do týdne,
                ale někdy při větší várce mailů i později.
                Spěcháte-li, použijte telefon, ale telefonujte pouze v dále uvedených časech. 
                </p>
                 </li>
            </ul>
             <h2>Kdy volat:</h2> 
             <table>
                 <tr>
                     <td>30.5&nbsp;Po:</td>
                     <td>07:30 – 10:00</td>
                     <td>15:00 – 19:00</td>
                 </tr>
                   <tr>
                     <td>31.5&nbsp;Út:</td>
                     <td></td>
                     <td>15:00 – 19:00</td>
                 </tr>
                   <tr>
                     <td>7.6&nbsp;Čt:</td>
                     <td>07:30 – 10:00</td>
                     <td></td>
                 </tr>
                   <tr>
                     <td>9.6&nbsp;Pá:</td>
                     <td>07:30 – 10:00</td>
                     <td></td>
                 </tr>
                   <tr>
                     <td>20.6&nbsp;Po:</td>
                     <td>07:30 – 10:00</td>
                     <td>15:00 – 19:00</td>
                 </tr>
             </table>
             <h2>Kam na konzultaci:</h2>
             <p>
             Protože o konzultace žádají i studenti z jiných škol, 
             kteří nemusejí vědět, kde sídlím, tak pro jistotu ještě adresy:
             </p>
             <p>
            NB 417 označuje kancelář v nové budově na Žižkově, nám. W. Churchilla 4
            Počítejte ale s tím, že se zde vyskytuji spíše výjimečně.
             </p>
             <p>
            JM 371 označuje kancelář 371 v areálu na Jižním Městě
            Vysoká škola ekonomická
            Ekonomická 957
            140 00 Praha 4 - Jižní Město
            GPS: 50°1'12.936"N, 14°29'33.304"
            Zastávka Volha autobusů 177 a 193.
             </p>
             <p>
            K mé kanceláři se dostanete tak, že po vstupu do budovy zahnete vlevo,
            dojdete k šatně, před šatnou opět vlevo do uličky, projdete dveřmi
            pak proskleným průchodem a druhými dveřmi do druhé budovy,
            tam výtahem po levé straně do 3. patra, kde po vystoupení uděláte čelem vzad.
            Kdo opovrhne výtahem (např. proto, že u něj bude velká fronta),
            tak dole u výtahu zabočí vpravo, kde jsou naproti prodejním automatům
            dvoje dveřen na schodiště (oboje dveře vedou na stejné schodiště).
            Po schodech vyjdete dvě patra, vyjdete dveřmi na chodbu a dáte se vlevo.
             </p>
             <p>
            Ve třetím patře dojdete chodbou až k oddělovacím požárním dveřím.
            Moje kancelář je druhá místnost po levé straně za těmito dveřmi.
            </p>
            <p>
            Přijdete-li dřív nebo se z nějakého důvodu zpozdím,
            můžete počkat na sedačkách, u nichž jsou připraveny zásuvky,
            abyste mohli strávit čas prací na počítači či dobíjením telefonů. 
             </p>
            </div>
            <div id="cont2">
                <h2>Cvičení a další soubory ke stažení:</h2>
                <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
                <p><i>To display a different welcome page for this project, modify</i>
                <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
                <c:forEach var="work" items="${list}" varStatus="status">
                   <li>
                       <a href="downloadInd.htm?id=${work.id}">${work.name}</a>
                   </li> 
             </c:forEach>
                
            </div>
             <div id="cont3">
                <h2>Header of third content box</h2>
                <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
                <p><i>To display a different welcome page for this project, modify</i>
                <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
             <ul>
           
              </ul>
            </div>
        </div>
             
            
   
    </body>
</html>
