<%-- 
    Document   : confirm
    Created on : Feb 10, 2022, 3:25:37 PM
    Author     : ADMIN
--%>
<div class="row page-header">
    <div class="col">
        Delete Confirmation
    </div>
</div>
<div class="row page-body mb-3">
    <div class="col">
        <form action="delete.do"> <%--${pageContext.request.contextPath}/toy/delete.do--%>
            <br/>
            <h5>Do you want to delete the record with id = ${id}?</h5>
            <br/>
            <input type="hidden" name="id" value="${id}" />
            <button type="submit" class="btn btn-sm btn-outline-success" name="op" value="yes"><i class="bi bi-check-circle"></i> Yes</button>
            <button type="submit" class="btn btn-sm btn-outline-danger" name="op" value="no"><i class="bi bi-x-circle"></i> No</button>
        </form>
        <div style="font-style: italic; color: red">${errorMessage}</div>
    </div>

    </div>
</div>