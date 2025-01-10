<form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">

    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="license_plate">License Plate:</label>
            <input type="text" class="form-control" id="license_plate" name="license_plate" placeholder="" value="" required>
            <div class="invalid-feedback">
                License Plate is required.
            </div>
        </div>
    </div>

</form>
</div>