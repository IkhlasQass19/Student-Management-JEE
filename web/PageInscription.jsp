<%-- 
    Document   : etPage
    Created on : 12 oct. 2019, 16:17:21
    Author     : lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- Site Metas -->
        <title>Gestion des notes</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/fevicon.ico.png" type="image/x-icon" />
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="style.css">
        <!-- Colors CSS -->
        <link rel="stylesheet" href="css/colors.css">
        <!-- ALL VERSION CSS -->
        <link rel="stylesheet" href="css/versions.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Modernizer for Portfolio -->
        <script src="js/modernizer.js"></script>
        <style>



            .logo {
                position: absolute; /* Positionnement absolu par rapport au contenant (.container) */
                top: 0; /* En haut de la page */
                right:  0;
                height: 70px;
                width: 200px/* À gauche de la page */
            }

        </style>
        
        <!-- [if lt IE 9] -->
    </head>
    <body id="page-top">
        <%         response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate,max-stale=0,post-check=0,pre-check=0");
            response.setHeader("Pragma", "no-cache");

            if (session.getAttribute("et") == null) {
                response.sendRedirect("index.html");
            }
        %>







        <header>
            <%         response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate,max-stale=0,post-check=0,pre-check=0");
                response.setHeader("Pragma", "no-cache");

                if (session.getAttribute("et") == null) {
                    response.sendRedirect("index.html");
                }
            %>

            <div class="header-bottom wow fadeIn" >

                <div class="container" >
                    <nav class="main-menu" >
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i class="fa fa-bars" aria-hidden="true"></i></button>
                        </div>

                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a  data-scroll href="page.jsp" href="page.jsp" > Profile</a></li>
                                <li><a  class="active"> Inscriptions</a></li>

                                <c:forEach var="type" items="${sessionScope.map}">
                                    <li>
                                        <a data-scroll href="<c:url value="ReleveEt2"> 
                                               <c:param name="etud" value="${sessionScope.et.getCNE()}"/>
                                               <c:param name="nom" value="${sessionScope.et.getNom()}"/>
                                               <c:param name="prenom" value="${sessionScope.et.getPrenom()}"/>
                                               <c:param name="sem" value="${type.key}" />
                                           </c:url>" target="_blank" >
                                            Relevé des notes S${type.key}
                                        </a>
                                    </li>
                                </c:forEach>

                                <li><a data-scroll href="ServDec" > Déconnexion</a></li>
                                
                            </ul>
                             <img src="images/R.png" class="logo" alt="Votre Logo">
                        </div>
                    </nav>

                </div>
            </div>
        </header>










      
        
       
        <br><br>
        <br><br>


        <div id="wrapper">

 

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column" style="text-align: center;">
        <!-- Main Content -->
      <div id="content-wrapper" class="d-flex flex-column" style="text-align: center;">
        <!-- Main Content -->
        <div id="content">
            <c:forEach var="type" items="${sessionScope.map}">
                <h3><b>Semestre ${type.key}</b></h3>
                <table style="margin: 0 auto; border: 2px solid black; border-collapse: collapse; width: 80%;">
                    <thead>
                        <tr>
                            <th style="background-color: #39b49b; border: 2px solid black; text-align: center; color: black;">Module</th>
                            <th style="background-color: #39b49b; border: 2px solid black; text-align: center; color: black;">Année universitaire</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tab" items="${type.value}">
                            <tr>
                                <td style="border: 2px solid black; text-align: center; color: black;">${tab[0]}</td>
                                <td style="border: 2px solid black; text-align: center; color: black;">${tab[1]}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br>
            </c:forEach>
        </div>
            <!-- End of Content Wrapper -->
        
          </div>
        <!-- Footer -->
        <c:import url="footer.jsp" />
        <!-- End of Footer -->


        <!-- all js files -->
        <script src="js/all.js"></script>
        <!-- all plugins -->
        <script src="js/custom.js"></script>
        <!-- map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCNUPWkb4Cjd7Wxo-T4uoUldFjoiUA1fJc&callback=myMap"></script>

    </body>
</html>
