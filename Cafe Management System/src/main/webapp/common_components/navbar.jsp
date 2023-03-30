<%@page import="com.object.*"%>
<%User navUser=(User)session.getAttribute("activeUser"); %>
<nav class="navbar navbar-expand-lg navbar-light"
	style="background-color: #493240;">
	<button type="button" class="navbar-toggler" data-toggle="collapse"
		data-target="#nav-items">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a href="index.jsp" class="navbar-brand" style="color: #f1dee3;"><i><b>The
				Friendly Bean Cafe</b></i> <i class="fa fa-coffee"></i></a>

	<!--  -->
	<div class="collapse navbar-collapse" id="nav-items">

		<ul class="navbar-nav ml-auto px-4">
			<%if(navUser==null){ %>
			<li class="nav-item active px-3"><a href="#loginModal"
				data-toggle="modal" data-target="#loginModal" class="nav-link"
				style="color: #f1dee3;"><i class="fa fa-sign-in"></i> Login</a></li>
			<li class="nav-item active px-3"><a href="#registerModal"
				data-toggle="modal" data-target="#registerModal" class="nav-link"
				style="color: #f1dee3;"><i class="fa fa-female"></i> Signup</a></li>
			<li class="nav-item active px-3"><a href="#forgotPasswordModal"
				data-toggle="modal" data-target="#forgotPasswordModal"
				class="nav-link" style="color: #f1dee3;"><i
					class="fa fa-question-circle-o"></i> Forgot Password ?</a></li>
			<%}else{ %>
			<li class="nav-item active px-3"><a href="#YourOrdersModal"
				data-toggle="modal" data-target="#YourOrdersModal" class="nav-link"
				style="color: #f1dee3;">Waiting Orders</a></li>
			<%@include file="YourOrdersModal.jsp"%>
			<li class="nav-item active px-3">
				<div class="dropdown">
					<a href="#" class="nav-link active dropdown-toggle"
						data-toggle="dropdown" id="dropdownMenuButton"
						style="color: #f1dee3;"><i class="fa fa-user-circle-o"
						aria-hidden="true"></i> <%=navUser.getName().toUpperCase() %></a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a href="dashboard.jsp" class="dropdown-item">Dashboard</a> <a
							href="#editProfileModal" data-toggle="modal"
							data-target="#editProfileModal" class="dropdown-item">Edit
							Profile</a> <a href="#viewProfileModal" data-toggle="modal"
							data-target="#viewProfileModal" class="dropdown-item">View
							Profile</a> <a href="Logout.jsp" class="dropdown-item">Logout</a>
					</div>
				</div>

			</li>

			<%@include file="editProfileModal.jsp"%>
			<%@include file="viewProfileModal.jsp"%>
			<%} %>
		</ul>
	</div>

</nav>
<%@include file="loginModal.jsp"%>
<%@include file="registerModal.jsp"%>
<%@include file="forgotPasswordModal.jsp"%>
