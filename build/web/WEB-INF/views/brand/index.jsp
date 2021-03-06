<%-- 
    Document   : index
    Created on : Jan 20, 2022, 4:03:26 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>List of Brand</h2>
<hr/>
<a class="btn btn-sm btn-outline-primary" href="create.do"><i class="bi bi-plus-circle"></i> Create New</a>
<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Id</th>
            <th>Name</th>
            <th>Operation</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="brand" items="${list}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>
                    <a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/brand/edit.do?id=${brand.id}"><i class="bi bi-pencil-square"></i> Edit</a> 
                    <a class="btn btn-sm btn-outline-danger" href="${pageContext.request.contextPath}/brand/confirm.do?id=${brand.id}"><i class="bi bi-x-circle-fill"></i> Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>