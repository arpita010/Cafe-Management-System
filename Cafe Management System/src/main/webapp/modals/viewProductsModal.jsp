<%@page import="java.util.*,com.dao.*,com.object.*"%>
<div class="modal fade" id="viewProductsModal">
	<div class="modal-dialog modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-body">
				<table
					class="table table-hover table-responsive-sm table-striped text-center">
					<tr>
						<th>Name</th>
						<th>Category</th>
						<th>Price</th>
						<th>Description</th>
					</tr>
					<%
List<Product> plist=ProductDao.getAllProducts();
for(Product p:plist)
{
%>
					<tr>
						<td><%=p.getName() %></td>
						<td><%=p.getCategory() %></td>
						<td><%=p.getPrice() %></td>
						<td><%=p.getDescription() %></td>
					</tr>

					<%} %>
				</table>



			</div>
		</div>
	</div>
</div>