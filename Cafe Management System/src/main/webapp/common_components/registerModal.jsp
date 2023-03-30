
<div class="modal fade" id="registerModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<h4 class="text-center m-3">Register</h4>
			<div class="modal-body">
				<span id="area"></span>
				<form action="register" method="post">
					<div class="form-row mt-2">
						<div class="col">
							<input type="text" placeholder="Name*" name="name">
						</div>
						<div class="col ml-4">
							<input type="text" placeholder="Contact Number*"
								name="contactNumber">
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-12">
							<input type="text" placeholder="Email Address*" name="email">
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-12">
							<select class="select-margin-input" id="userType"
								oninput="adminField()" name="userType">
								<option value="" selected hidden disabled>Choose User
									Type*</option>
								<option value="admin">Admin User</option>
								<option value="normal">Normal User</option>
							</select>
						</div>
					</div>
					<div class="row mt-4" hidden id="adminDiv">
						<div class="col">
							<input type="text" name="adminCard" placeholder="Card Number*">
						</div>
						<div class="col">
							<input type="text" name="adminPayment" value="500000" disabled>
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-12">
							<input type="password" placeholder="Password*" name="password">
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-12">
							<input type="password" placeholder="Confirm Password*">
						</div>
					</div>
					<div class="col-12 mt-4 text-center">
						<button type="submit" class="btn btn-warning">Register</button>
						<button type="button" data-dismiss="modal"
							class="btn btn-danger ml-3">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>