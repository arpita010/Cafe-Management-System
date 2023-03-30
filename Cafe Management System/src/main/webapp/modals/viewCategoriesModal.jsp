<%@page import="com.dao.*,com.object.*,java.util.*"%>
<div class="modal fade" id="viewCategoriesModal">
	<div class="modal-dialog modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-body">
				<table
					class="table table-hover table-responsive-sm table-striped text-center">
					<tr>
						<th>Category Name</th>
					</tr>
					<%
List<Category> list=CategoryDao.getAllCategories();
for(Category cat:list)
{
%>
					<tr>
						<td><%=cat.getcName() %></td>
					</tr>
					<%} %>
				</table>

			</div>
		</div>
	</div>
</div>