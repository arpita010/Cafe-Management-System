
<div class="modal fade" id="loginModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<h4 class="text-center m-2">Login</h4>
			<div class="modal-body">
				<form action="login" method="post" onsubmit="return validateLogin()">
					<div class="col-md-12">
						<label for="email">Email Address</label><br> <input
							type="text" id="email" name="email"
							placeholder="Enter Your Email"> <small id="emailWarning"
							style="color: red;"></small>
					</div>
					<div class="col-md-12 mt-3">
						<label for="password">Password</label><br> <input
							type="password" id="password" name="password"
							placeholder="Enter Your Password"> <small
							id="passwordWarning" style="color: red;"></small>
					</div>
					<div class="col-md-12 text-center mt-3">
						<button type="submit" class="btn btn-danger">Login</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>
