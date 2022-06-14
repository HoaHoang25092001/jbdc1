<%-- 
    Document   : main
    Created on : Jan 18, 2022, 4:19:26 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap 5 & Layouts</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    </head>
    <body>
        <!--Header-->
        <div class="container p-5 bg-warning text-white text-center">
            <h1>Jdbc1 Example</h1>
        </div>
        <!--Navigation-->
        <div class="container mt-1">
            <nav class="navbar navbar-expand-sm bg-light navbar-light">
                <div class="container-fluid">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/toy/index.do">Toy</a>
                        </li>  
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/brand/index.do">Brand</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <!--Content-->  
        <div class="container my-5">
            <div class="row">
                <div class="col">
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
                </div>
            </div>
        </div>

        <!--Footer-->
        <div class="container p-2 bg-warning text-white text-center">
            Copyright 2021-2022 by PRJ. All Rights Reserved.
        </div>
    </body>
</html>

