<%@page import="com.dao.*,com.object.*,java.util.*"%>
<%@include file="common_components/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Product</title>
<style>
th, td {
	text-align: center;
	font-size: 20px;
}
</style>
</head>
<body>
	<%@include file="common_components/navbar.jsp"%>
	<%@include file="common_components/message.jsp"%>
	<div class="row" style="max-width: 100%;">
		<%@include file="common_components/sidebar.jsp"%>
		<div class="col-md-9 mx-2" style="margin-top: 5%;">
			<div class="card mt-2">
				<div class="card-body">
					<h4 class="card-title float-left">Add Product</h4>
					<a href="#addProductModal" data-toggle="modal"
						data-target="#addProductModal" class="btn btn-primary float-right">Add
						Product</a>
				</div>
			</div>
			<div class="card mt-2">
				<div class="card-body">
					<table class="table table-striped table-responsive-sm table-hover">
						<tr>
							<th>Name</th>
							<th>Category</th>
							<th>Description</th>
							<th>Price</th>
							<th>Action</th>
						</tr>
						<!-- Product List according to our record. -->
						<%List<Product> productList=ProductDao.getAllProducts();
	for(Product p:productList){
	%>
						<tr>

							<td><%=p.getName() %></td>
							<td><%=p.getCategory() %></td>
							<td><%=p.getDescription() %></td>
							<td><%=p.getPrice() %></td>
							<td>
								<button data-toggle="modal" class="btn"
									data-target="#editProductModal"
									style="background-color: transparent; color: #493240;"
									onclick='getProductID("<%=p.getPID()%>")'>
									<i class="fa fa-pencil" style="padding-right: 5%"></i>
								</button>
								<form action="editProduct" method="post" hidden
									id="deleteProductForm">
									<input type="hidden" name="operation" value="deleteProduct">
									<input type="hidden" name="productID" value="" id="pID">
								</form>
								<button class="btn"
									style="background-color: transparent; color: #493240;"
									onclick='productFormSubmit("<%=p.getPID()%>")'>
									<i class="fa fa-trash"></i>
								</button>
							</td>
						</tr>
						<%} %>
						<!-- category list ends -->
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="modals/addProductModal.jsp"%>
	<%@include file="modals/editProductModal.jsp"%>
</body>
</html>