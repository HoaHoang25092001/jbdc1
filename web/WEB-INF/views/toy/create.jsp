<%-- 
    Document   : create
    Created on : Feb 10, 2022, 10:55:56 AM
    Author     : ADMIN
--%>

<h2>Create toy</h2>
<hr>
<div class="row">
    <div class="col">
        <form action="save.do">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">ID:</label>
                <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <input type="number" class="form-control" step="0.01" id="price" placeholder="Enter price" name="price">
            </div>
            <div class="mb-3">
                <label for="expDate" class="form-label">Expired date:</label>
                <input type="date" class="form-control" id="expDate" placeholder="Enter expired date" name="expDate">
            </div>
            <div class="mb-3">
                <label for="brandId" class="form-label">Brand Id:</label>
                <input type="text" class="form-control" id="brandId" placeholder="Enter Brand ID" name="brandId">
            </div>
            <button type="submit" class="btn btn-sm btn-outline-success" name="op" value="save">Save <i class="bi bi-download"></i></button>
            <button type="submit" class="btn btn-sm btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-circle"></i></button>
        </form>
        <div class="text-danger" style="font-style: italic;">${errorMessage}</div>
    </div>
    <div class="col">

    </div>
</div>
