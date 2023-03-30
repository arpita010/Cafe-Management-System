<%@page import="java.util.*,com.dao.*,com.object.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Order</title>
<%@include file="common_components/common.jsp"%>
</head>
<body>
	<%@include file="common_components/navbar.jsp"%>
	<%@include file="common_components/message.jsp"%>
	<div class="row" style="max-width: 100%;">
		<%@include file="common_components/sidebar.jsp"%>
		<div class="col-md-9 mx-2" style="margin-top: 5%;">
			<form action="order" method="post" id="orderForm">
				<div class="card mt-2">
					<div class="card-body">
						<h4 class="card-title float-left">Place Order</h4>
						<button type="submit" class="btn btn-primary float-right">Save
							and Get Bill</button>
					</div>
				</div>

				<div class="card mt-2">
					<div class="card-body">
						<h5 class="card-title">Customer Details</h5>
						<div class="form-row mt-4">
							<div class="col">
								<input type="text" name="name" placeholder="Name*" id="name">
							</div>
							<div class="col">
								<input type="text" name="email" placeholder="Email*"
									id="custemail">
							</div>
							<div class="col">
								<input type="text" name="contactNumber"
									placeholder="Contact Number" id="contactNumber">
							</div>
							<div class="col">
								<select class="select-margin-input" name="paymentMode"
									id="paymentMode">
									<option value="" selected disabled hidden>Payment
										Mode*</option>
									<option value="Cash">Cash</option>
									<option value="Credit Card">Credit Card</option>
									<option value="Debit Card">Debit Card</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="card mt-2">
					<div class="card-body">
						<h5 class="card-title">Select Product</h5>
						<div class="form-row mt-4">
							<%--<div class="col">
	<select class="select-margin-input" oninput="getpName()" onclick="reload()" id="cat">
	<%List<String> cName=CategoryDao.getAllCategoriesName();
	for(String name:cName){%>
	<option value="<%=ProductDao.getProductsOfSameCategory(name) %>"><%= name%></option>
	<%} %>
	</select>
	</div> --%>

							<div class="col">
								<select class="select-margin-input" name="ProductName"
									id="product" oninput="productPrice()">
									<option value="" selected disabled hidden>Product*</option>
									<%List<Product> pl=ProductDao.getAllProducts();
	for(Product p:pl){
	%>
									<option value="<%=p.getPrice()%>"><%=p.getName() %></option>

									<%} %>
								</select>
							</div>
							<div class="col">
								<input type="text" name="price" placeholder="Price*" value=""
									id="price" readonly>
								<!-- javascript function -->
							</div>
							<div class="col">
								<input type="text" name="quantity" placeholder="Quantity*"
									id="quantity" oninput="getTotal()">
							</div>
							<div class="col">
								<input type="text" name="total" placeholder="Total" value=""
									readonly id="total">
								<!-- javascript function -->
							</div>
						</div>
						<div class="row mt-4">
							<div class="col-12">
								<button type="button" class="btn btn-warning"
									style="float: left;" onclick="addProducts()">Add</button>
								<button type="button" disabled class="btn btn-danger"
									style="float: right;">
									Total Amount <span id="totalAmountBtn"></span>
								</button>
							</div>
						</div>
					</div>
				</div>
				<input type="hidden" name="allProducts" value="" id="allProducts">
				<!-- for server -->
				<input type="hidden" name="totalBillAmount" id="totalBillAmount"
					value="">

			</form>

			<!-- end -->
			<div class="card mt-2">
				<div class="card-body">
					<table class="table table-striped table-hover text-center"
						id="addedProductsTable">
						<tr>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
							<%--<th>Delete</th> --%>
						</tr>
						<!-- Category List according to our record. -->
						<!-- category list ends -->
					</table>

				</div>
			</div>
		</div>
	</div>
</body>
</html>