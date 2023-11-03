<%-- 
    Document   : pageAd2
    Created on : 2 nov. 2021, 15:55:17
    Author     : kh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Cache-Control" content="no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />      
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">


        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <style>



            .logo {
                position: absolute; /* Positionnement absolu par rapport au contenant (.container) */
                top: 0; /* En haut de la page */
                left: 0;
                height: 100px;
                width: 300px/* À gauche de la page */
            }

        </style>
        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/style3.css"/>
    </head>
    <body id="page-top"style="margin-bottom: 0px">

        <div style="display: grid; grid-template-columns: 1fr auto 1fr; align-items: center;">
            <div style="margin-top: 30px; text-align: left;">
                 </div>
            <div style="text-align: center;">
                <img src="images/R.png" class="logo" alt="Votre Logo">
                <h1>Espace Admin</h1>
            </div>
            <div style="margin-top: 10px; text-align: right; align-items: flex-start;">
                   <a href="login.jsp"><img style="width: 50px" src="images/12.png" /></a>
        
            </div>
        </div>
        <!-- Page Wrapper -->
        <div id="wrapper">




            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->

                    <!-- End of Topbar -->



                    <div class="container-fluid bg-gradient p-5">
                        <div class="row m-auto text-center w-80">

                            <div class="col-4 princing-item brown">
                                <div class="pricing-divider ">
                                    <h3 class="text-light">Étudiants inscrits<br><br>par semestre :<br><br></h3>
                                    <svg class='pricing-divider-img' enable-background='new 0 0 300 100' height='100px' id='Layer_1' preserveAspectRatio='none' version='1.1' viewBox='0 0 300 100' width='300px' x='0px' xml:space='preserve' xmlns:xlink='http://www.w3.org/1999/xlink' xmlns='http://www.w3.org/2000/svg' y='0px'>
                                    <path class='deco-layer deco-layer--1' d='M30.913,43.944c0,0,42.911-34.464,87.51-14.191c77.31,35.14,113.304-1.952,146.638-4.729
                                          c48.654-4.056,69.94,16.218,69.94,16.218v54.396H30.913V43.944z' fill='#FFFFFF' opacity='0.6'></path>
                                    <path class='deco-layer deco-layer--2' d='M-35.667,44.628c0,0,42.91-34.463,87.51-14.191c77.31,35.141,113.304-1.952,146.639-4.729
                                          c48.653-4.055,69.939,16.218,69.939,16.218v54.396H-35.667V44.628z' fill='#FFFFFF' opacity='0.6'></path>
                                    <path class='deco-layer deco-layer--3' d='M43.415,98.342c0,0,48.283-68.927,109.133-68.927c65.886,0,97.983,67.914,97.983,67.914v3.716
                                          H42.401L43.415,98.342z' fill='#FFFFFF' opacity='0.7'></path>
                                    <path class='deco-layer deco-layer--4' d='M-34.667,62.998c0,0,56-45.667,120.316-27.839C167.484,57.842,197,41.332,232.286,30.428
                                          c53.07-16.399,104.047,36.903,104.047,36.903l1.333,36.667l-372-2.954L-34.667,62.998z' fill='#FFFFFF'></path>
                                    </svg>
                                </div>
                                <div class="card-body bg-white mt-0 shadow"  >
                                    <form class="user" action="ListEt" method="POST"  >
                                        <br>
                                        <b>Sélectionner une semestre </B><br><br>
                                        <select class="selectCommande" name="sem"  style="background-color:#8B4513">

                                            <option value="1"  >Semestre 1</option>
                                            <option value="2" >Semestre 2</option>
                                            <option value="3" >Semestre 3</option>
                                            <option value="4" >Semestre 4</option>

                                        </select>
                                        <br><br><br>
                                        <button type="submit"  class="btn btn-lg btn-block  btn-custom " style=" background-color: #ADD8E6 ">Envoyer</button>

                                    </form>
                                </div>
                            </div>




                            <div class="col-4 princing-item ">
                                <div class="pricing-divider ">
                                    <h3 class="text-light">Relevé des notes<br><br> pour l'étudiant: <br><br></h3>
                                    <svg class='pricing-divider-img' enable-background='new 0 0 300 100' height='100px' id='Layer_1' preserveAspectRatio='none' version='1.1' viewBox='0 0 300 100' width='300px' x='0px' xml:space='preserve' xmlns:xlink='http://www.w3.org/1999/xlink' xmlns='http://www.w3.org/2000/svg' y='0px'>
                                    <path class='deco-layer deco-layer--1' d='M30.913,43.944c0,0,42.911-34.464,87.51-14.191c77.31,35.14,113.304-1.952,146.638-4.729
                                          c48.654-4.056,69.94,16.218,69.94,16.218v54.396H30.913V43.944z' fill='#FFFFFF' opacity='0.6'></path>
                                    <path class='deco-layer deco-layer--2' d='M-35.667,44.628c0,0,42.91-34.463,87.51-14.191c77.31,35.141,113.304-1.952,146.639-4.729
                                          c48.653-4.055,69.939,16.218,69.939,16.218v54.396H-35.667V44.628z' fill='#FFFFFF' opacity='0.6'></path>
                                    <path class='deco-layer deco-layer--3' d='M43.415,98.342c0,0,48.283-68.927,109.133-68.927c65.886,0,97.983,67.914,97.983,67.914v3.716
                                          H42.401L43.415,98.342z' fill='#FFFFFF' opacity='0.7'></path>
                                    <path class='deco-layer deco-layer--4' d='M-34.667,62.998c0,0,56-45.667,120.316-27.839C167.484,57.842,197,41.332,232.286,30.428
                                          c53.07-16.399,104.047,36.903,104.047,36.903l1.333,36.667l-372-2.954L-34.667,62.998z' fill='#FFFFFF'></path>
                                    </svg>
                                </div>

                                <div class="card-body bg-white mt-0 shadow">
                                    <form class="user" action="RelvenoteET" method="POST">
                                        <b>Entrer un CNE</b><br><br>
                                        <input type="text" name="cne" class="form-control form-control-user" id="exampleFirstName" placeholder="CNE">
                                        <br>
                                        <b>Sélectionner une semestre </B><br><br>
                                        <select class="selectCommande" name="sem" style="background-color:#8B4513">

                                            <option value="1">Semestre 1</option>
                                            <option value="2">Semestre 2</option>
                                            <option value="3">Semestre 3</option>
                                            <option value="4">Semestre 4</option>

                                        </select>
                                        <br><br><br>
                                        <button type="submit"  class="btn btn-lg btn-block  btn-custom " style=" background-color:#ADD8E6">Envoyer</button>

                                    </form>
                                </div>
                            </div>






                            <div class="col-4 princing-item ">
                                <div class="pricing-divider ">
                                    <h3 class="text-light">Relevé des notes<br><br> par module: <br><br></h3>
                                    <svg class='pricing-divider-img' enable-background='new 0 0 300 100' height='100px' id='Layer_1' preserveAspectRatio='none' version='1.1' viewBox='0 0 300 100' width='300px' x='0px' xml:space='preserve' xmlns:xlink='http://www.w3.org/1999/xlink' xmlns='http://www.w3.org/2000/svg' y='0px'>
                                    <path class='deco-layer deco-layer--1' d='M30.913,43.944c0,0,42.911-34.464,87.51-14.191c77.31,35.14,113.304-1.952,146.638-4.729
                                          c48.654-4.056,69.94,16.218,69.94,16.218v54.396H30.913V43.944z' fill='#FFFFFF' opacity='0.6'></path>
                                    <path class='deco-layer deco-layer--2' d='M-35.667,44.628c0,0,42.91-34.463,87.51-14.191c77.31,35.141,113.304-1.952,146.639-4.729
                                          c48.653-4.055,69.939,16.218,69.939,16.218v54.396H-35.667V44.628z' fill='#FFFFFF' opacity='0.6'></path>
                                    <path class='deco-layer deco-layer--3' d='M43.415,98.342c0,0,48.283-68.927,109.133-68.927c65.886,0,97.983,67.914,97.983,67.914v3.716
                                          H42.401L43.415,98.342z' fill='#FFFFFF' opacity='0.7'></path>
                                    <path class='deco-layer deco-layer--4' d='M-34.667,62.998c0,0,56-45.667,120.316-27.839C167.484,57.842,197,41.332,232.286,30.428
                                          c53.07-16.399,104.047,36.903,104.047,36.903l1.333,36.667l-372-2.954L-34.667,62.998z' fill='#FFFFFF'></path>
                                    </svg>
                                </div>

                                <div class="card-body bg-white mt-0 shadow">
                                    <form class="user" action="NoteParModule" method="POST">

                                        <b>Sélectionner un module </B><br><br>
                                        <select class="selectCommande" name="id" style="background-color: #8B4513">
                                            <c:forEach var="type" items="${sessionScope.l}">
                                                <option value="${type.getId_module()}">${type.getIntitule()}</option>
                                            </c:forEach>   


                                        </select>
                                        <br><br><br>
                                        <button type="submit"  class="btn btn-lg btn-block  btn-custom " style=" background-color:#ADD8E6">Envoyer</button>

                                    </form>

                                </div>
                            </div>






                        </div>
                    </div>          



                </div>

                <!-- End of Main Content -->

                <!-- Footer -->

                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>



        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/chart-area-demo.js"></script>
        <script src="js/demo/chart-pie-demo.js"></script>

    </body>
    <footer><c:import url="footer.jsp" /></footer>
</html>
