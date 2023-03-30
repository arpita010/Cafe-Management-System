<%@page import="com.object.User"%>
<%User sidebarUser=(User)session.getAttribute("activeUser"); 
if(sidebarUser==null)
{	return;}
%>

<style>
.list-group-item {
	background-color: #493240;
	color: white;
	text-align: center;
}

.list-group-item:hover {
	background-color: white;
	color: black;
}

body {
	background-image: linear-gradient(135deg, #FF0099 10%, #493240 100%);
}
</style>
<div class="col-md-2 mx-4" style="margin-top: 5%;">
	<div class="list-group ">
		<a href="dashboard.jsp"
			class="list-group-item list-group-item-actions"><i
			class="fa fa-address-card-o"></i> Dashboard</a>
		<%if(sidebarUser.getUserType().equals("admin")){ %>
		<a href="manageCategory.jsp"
			class="list-group-item list-group-item-actions"><i
			class="fa fa-th-list"></i> Manage Category</a> <a
			href="manageProduct.jsp"
			class="list-group-item list-group-item-actions"><i
			class="fa fa-th-large"></i> Manage Product</a> <a
			href="manageOrderAdmin.jsp"
			class="list-group-item list-group-item-actions"><i
			class="fa fa-th-large"></i> Manage Order</a>

		<%} %>
		<%--<a href="#YourOrdersModal" data-toggle="modal" data-target="#YourOrdersModal" class="list-group-item list-group-item-actions">Your Waiting Orders</a>
	 --%>
		<a href="manageOrder.jsp"
			class="list-group-item list-group-item-actions"><i
			class="fa fa-shopping-basket"></i> Place Order</a> <a href="viewBill.jsp"
			class="list-group-item list-group-item-actions"><i
			class="fa fa-eye"></i> View Paid Bills</a>
		<%if(sidebarUser.getUserType().equals("admin")){ %>
		<a href="manageUser.jsp"
			class="list-group-item list-group-item-actions"><i
			class="fa fa-users"></i> Manage Users</a>
		<%} %>
	</div>
	<!--list-group ends-->
</div>
<!-- col-ends -->
