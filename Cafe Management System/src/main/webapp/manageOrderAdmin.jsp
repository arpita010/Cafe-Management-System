<%@page import="com.dao.*,com.object.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="common_components/common.jsp"%>
</head>
<body>
	<%@include file="common_components/navbar.jsp"%>
	<%@include file="common_components/message.jsp"%>
	<div class="row" style="max-width: 100%;">
		<%@include file="common_components/sidebar.jsp"%>
		<div class="col-md-9 mx-2" style="margin-top: 5%;">
			<div class="card mt-2">
				<div class="card-body">
					<h4 class="card-title float-left">Manage Orders</h4>
				</div>
			</div>
			<!-- card-1 -->
			<div class="card mt-2">
				<div class="card-body">
					<table
						class="table table-responsive-sm table-hover table-striped text-center">
						<tr>
							<th>User ID</th>
							<th>Order ID</th>
							<th>Customer Name</th>
							<th>Contact Number</th>
							<th>Items</th>
							<th>Total</th>
							<th>Action</th>
						</tr>
						<%List<Order> orderList=OrderDao.getOrderList();
	for(Order order:orderList)
	{
	%>
						<tr>
							<td><%=order.getUserID() %></td>
							<td><%=order.getOrderID() %></td>
							<td><%=order.getCustomerName() %></td>
							<td><%=order.getContactNumber() %></td>
							<td><%=order.getItems() %></td>
							<td><%=order.getTotal() %></td>
							<td>
								<form action="approveOrder" method="post">
									<input type="hidden" name="orderId"
										value=<%=order.getOrderID() %>>
									<button type="submit" class="btn"
										style="bakcground-color: white; color: black;">
										<i class="fa fa-check" ></i>
									</button>
								</form>
							</td>
						</tr>
						<%} %>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 
	<button type="button" class="btn" style="background-color:white;color:black;">
	</button>
	 -->
</body>
</html>