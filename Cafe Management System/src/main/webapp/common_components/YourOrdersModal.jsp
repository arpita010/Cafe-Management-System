
<%@page import="java.util.*,com.dao.*,com.object.*"%>
<%User orderUser=(User)session.getAttribute("activeUser"); 
if(orderUser==null)
{
	out.println("user does not exist");
	return;
}
%>

<div class="modal fade" id="YourOrdersModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="text-center">Your orders</h4>
			</div>
			<div class="modal-body">

				<%List<Order> olist=OrderDao.getSpecificUserOrderList(orderUser.getUserID());
if(olist.size()==0){
%>
				<h5 class="text-center" style="color: red;">You haven't place
					any order yet..</h5>
				<%}else{ %>
				<table
					class="table table-striped table-responsive-sm table-hover text-center">
					<tr>
						<th>Customer Name</th>
						<th>Contact Number</th>
						<th>Items</th>
						<th>Total</th>
					</tr>
					<%
for(Order o:olist)
{
%>
					<tr>
						<td><%=o.getCustomerName() %></td>
						<td><%=o.getContactNumber() %></td>
						<td><%=o.getItems() %></td>
						<td><%=o.getTotal() %></td>
					</tr>
					<%} %>
				</table>
				<%} %>
			</div>
		</div>
	</div>
</div>