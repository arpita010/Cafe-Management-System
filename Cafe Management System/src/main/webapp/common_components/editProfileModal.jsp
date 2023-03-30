<%@page import="java.util.*,com.object.*,com.dao.*"%>
<%
User editUser=(User)session.getAttribute("activeUser");
if(editUser==null)
{
	out.println("You have not login yet!");
}
%>
<div class="modal fade show" id="editProfileModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h4>Edit Profile</h4>
			</div>
			<div class="modal-body">
				<form action="editProfile" method="post">
					<input type="hidden" name="userID"
						value="<%=editUser.getUserID() %>">
					<div class="col-12 mt-3">
						<input type="text" name="newName" placeholder="New Username*">
					</div>
					<div class="col-12 mt-3">
						<input type="text" name="newContactNumber"
							placeholder="New Contact Number*">
					</div>
					<div class="col-12 mt-3">
						<input type="text" name="newPassword" placeholder="New Password*">
					</div>
					<div class="col-12 mt-3 text-center">
						<button type="submit" class="btn btn-success">Update
							Profile</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>