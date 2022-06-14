<%-- 
    Document   : create
    Created on : Feb 10, 2022, 10:55:56 AM
    Author     : ADMIN
--%>

<h2>Edit toy</h2>
<hr>
<div class="row">
    <div class="col">
        <form action="update.do" method="post">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">ID:</label>
                <input type="text" class="form-control" id="id" value="${brand.id}" placeholder="Enter id" name="id1" disabled="">
                <input type="hidden" class="form-control" id="id" value="${brand.id}" placeholder="Enter id" name="id" >
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" value="${brand.name}" placeholder="Enter name" name="name">
            </div>
            <button type="submit" class="btn btn-sm btn-outline-success" name="op" value="update">Update</button>
            <button type="submit" class="btn btn-sm btn-outline-danger" name="op" value="cancel">Cancel</button>
        </form>
        <div class="text-danger" style="font-style: italic;">${errorMessage}</div>
    </div>
    <div class="col">

    </div>
</div>
