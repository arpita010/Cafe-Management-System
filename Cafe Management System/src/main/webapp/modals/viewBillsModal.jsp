<%@page import="java.util.*,com.dao.*,com.object.*"%>
<%User mUser=(User)session.getAttribute("activeUser");
if(mUser==null)
{
	return;
}
%>
<div class="modal fade" id="viewBillsModal">
	<div class="modal-dialog modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-body">
				<table class="table table-striped table-hover table-responsive-sm">
					<tr>
						<th>Name</th>
						<th>Items</th>
						<th>Total</th>
					</tr>
					<%List<Bill> billList=new ArrayList<Bill>();
if(mUser.getUserType().equals("admin"))
{
	billList=BillDao.getAllBillList();
}
else if(mUser.getUserType().equals("normal"))
{
	billList=BillDao.specficUserBillList(mUser.getUserID());
}
for(Bill b:billList)
{
%>
					<tr>
						<td><%=b.getCustomerName() %></td>
						<td><%=b.getItems() %></td>
						<td><%=b.getTotal() %></td>
					</tr>
					<%} %>
				</table>
			</div>
		</div>
	</div>
</div>