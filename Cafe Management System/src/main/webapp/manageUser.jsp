<%@page import="com.dao.*,com.object.*,java.util.*"%>
<%@include file="common_components/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage User</title>
</head>
<body>
	<%@include file="common_components/navbar.jsp"%>

	<%@include file="common_components/message.jsp"%>
	<div class="row" style="max-width: 100%;">
		<%@include file="common_components/sidebar.jsp"%>
		<div class="col-md-9 mx-2" style="margin-top: 5%;">
			<div class="card">
				<div class="card-body">
					<h5>Manage User</h5>
				</div>
			</div>
			<!-- card-1 -->
			<div class="card mt-2">
				<div class="card-body">
					<table
						class="table table-hover table-responsive-sm table-striped text-center">
						<tr>
							<th>User ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Contact Number</th>
							<th>Action</th>
						</tr>
						<%List<User> userList=UserDao.getAllUsers();
	for(User u:userList){
	%>
						<tr>
							<td><%=u.getUserID() %></td>
							<td><%=u.getName() %></td>
							<td><%=u.getEmail() %></td>
							<td><%=u.getContactNumber() %></td>

							<td>
								<form action="deleteUser" method="post" id="deleteUserForm"
									hidden>
									<input type="hidden" name="userID" id="userID" value="">
								</form>
								<button type="button" class="btn"
									onclick='submitUserForm("<%=u.getUserID() %>")'
									style="background-color: transparent;">
									<i class="fa fa-trash"></i>
								</button>
							</td>
						</tr>
						<%} %>
					</table>
				</div>
			</div>
			<!-- card-2 -->
		</div>
	</div>
</body>
</html>