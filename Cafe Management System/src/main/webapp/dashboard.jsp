<%@page import="com.object.User"%>
<%User dashUser=(User)session.getAttribute("activeUser");%>
<%if(dashUser==null)
	{
	out.println("you are not allowed to access this page... login first");
	return;
	}%>
<%@include file="common_components/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<style>
.card {
	background-color: #e2e2e2;
}
</style>
</head>
<body>
	<%@include file="common_components/navbar.jsp"%>
	<div class="row" style="max-width: 100%;">
		<%@include file="common_components/sidebar.jsp"%>
		<%@include file="common_components/message.jsp"%>
		<div class="col-md-3" style="margin-top: 10%;">
			<div class="card">
				<div class="card-body text-center">
					<h3 class="p-4">Total Category</h3>
					<h4 class="p-2"><%=CategoryDao.getTotalCategories() %></h4>
					<a href="#viewCategoriesModal" data-toggle="modal"
						data-target="#viewCategoriesModal"
						class=" btn container-fluid text-center mt-5"
						style="background-color: #CFD9DF; color: black;">View
						Categories</a>
				</div>
			</div>
		</div>
		<div class="col-md-3" style="margin-top: 10%;">
			<div class="card">
				<div class="card-body text-center">
					<h3 class="p-4">Total Product</h3>
					<h4 class="p-2"><%=ProductDao.getTotalProducts() %></h4>
					<a href="#viewProductsModal" data-toggle="modal"
						data-target="#viewProductsModal"
						class=" btn container-fluid text-center mt-5"
						style="background-color: #CFD9DF; color: black;">View Products</a>
				</div>
			</div>
		</div>
		<div class="col-md-3" style="margin-top: 10%;">
			<div class="card">
				<div class="card-body text-center">
					<h3 class="p-4">Paid Bills</h3>
					<h4 class="p-2">
						<%if(dashUser.getUserType().equals("admin")) {%>
						<%=BillDao.getTotalBills() %>
						<%}else if(dashUser.getUserType().equals("normal")) {%>
						<%=BillDao.countSpecificUserBills(dashUser.getUserID()) %>
						<%} %>
					</h4>
					<a href="#viewBillsModal" data-toggle="modal"
						data-target="#viewBillsModal"
						class=" btn container-fluid text-center mt-5"
						style="background-color: #CFD9DF; color: black;">View Bills</a>
				</div>
			</div>
		</div>

	</div>
	<!-- row ends -->
	<%@include file="modals/viewCategoriesModal.jsp"%>
	<%@include file="modals/viewProductsModal.jsp"%>
	<%@include file="modals/viewBillsModal.jsp"%>
</body>
</html>