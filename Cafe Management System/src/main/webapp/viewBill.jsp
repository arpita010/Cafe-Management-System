<%@page import="java.util.*,com.dao.*,com.object.*"%>
<%User billUser=(User)session.getAttribute("activeUser");
if(billUser==null)
{
	out.println("you cannot access this page");
	return;
}
%>
<%@include file="common_components/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bill</title>
</head>
<body>
	<%@include file="common_components/navbar.jsp"%>
	<%@include file="common_components/message.jsp"%>
	<div class="row" style="max-width: 100%;">
		<%@include file="common_components/sidebar.jsp"%>
		<div class="col-md-9 mx-2" style="margin-top: 5%;">
			<div class="card">
				<div class="card-body">
					<h5>View Paid Bills</h5>
				</div>
			</div>
			<!-- card-1 -->
			<div class="card mt-2">
				<div class="card-body">
					<%List<Bill> blist=new ArrayList<Bill>();
	if(billUser.getUserType().equals("admin"))
	{
		blist=BillDao.getAllBillList();
	}
	else if(billUser.getUserType().equals("normal"))
	{
		blist=BillDao.specficUserBillList(billUser.getUserID());
	}
	if(blist.size()==0){
	%>
					<h3 class="text-center">No Bills for Now...</h3>
					<%}else{ %>
					<table
						class="table table-hover table-responsive-sm table-striped text-center">
						<tr>
							<th>Bill Number</th>
							<th>Name</th>
							<th>Email</th>
							<th>Contact Number</th>
							<th>Payment Method</th>
							<th>Total</th>
							<th>Action</th>
						</tr>
						<% 
	for(Bill b:blist)
	{
	%>
						<tr>
							<td><%=b.getBillNumber() %></td>
							<td><%=b.getCustomerName() %></td>
							<td><%=b.getEmail() %></td>
							<td><%=b.getContactNumber() %></td>
							<td><%=b.getPaymentMode() %></td>
							<td><%=b.getTotal() %></td>
							<td>
								<form action="deleteBill" method="post" id="deleteBillForm"
									hidden>
									<input type="hidden" name="billNumber" id="billNumber" value="">
								</form>
								<button type="button" class="btn"
									style="background-color: transparent;">
									<i class="fa fa-file-pdf-o"></i>
								</button> <%if(billUser.getUserType().equals("admin")){ %>
								<button type="button" class="btn"
									style="background-color: transparent;"
									onclick='submitBillForm("<%=b.getBillNumber() %>")'>
									<i class="fa fa-trash"></i>
								</button> <%} %>
							</td>
						</tr>
						<%} %>
					</table>
					<%} %>
				</div>
			</div>
			<!-- card-2 -->
		</div>
		<!-- col-2 ends -->
	</div>
	<!-- row ends -->
</body>
</html>