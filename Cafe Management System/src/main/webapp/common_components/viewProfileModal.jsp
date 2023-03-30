<%@page import="com.dao.*,com.object.*,java.util.*"%>
<%User viewUser=(User)session.getAttribute("activeUser"); %>
<div class="modal fade show" id="viewProfileModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h3>User Details</h3>
			</div>
			<div class="modal-body">
				<table class="table table-striped table-responsive-sm text-center">
					<tr>
						<th>Username</th>
						<td><%=viewUser.getName() %></td>
					</tr>
					<tr>
						<th>Contact Number</th>
						<td><%=viewUser.getContactNumber() %></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><%=viewUser.getEmail() %></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><%=viewUser.getPassword() %></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

