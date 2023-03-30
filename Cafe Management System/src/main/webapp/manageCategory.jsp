<%@page import="com.dao.*,com.object.*,java.util.*"%>
<%@include file="common_components/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Category</title>
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
					<h4 class="card-title float-left">Add Category</h4>
					<a href="#addCategoryModal" data-toggle="modal"
						data-target="#addCategoryModal"
						class="btn btn-primary float-right">Add Category</a>
				</div>
			</div>
			<div class="card mt-2">
				<div class="card-body">
					<table class="table table-striped">
						<tr>
							<th>Name</th>
							<th>Action</th>
						</tr>
						<!-- Category List according to our record. -->
						<%List<Category> categoryList=CategoryDao.getAllCategories();
	for(Category c:categoryList){%>
						<tr>
							<td><%=c.getcName() %></td>
							<td>
								<button type="button" data-toggle="modal" id="btn1"
									data-target="#editCategoryModal" class="btn actionButton"
									onclick='getOldCategoryName("<%=c.getcName() %>")'
									style="background-color: transparent;">
									<i class="fa fa-pencil" style="padding-right: 2%"></i>
								</button>
								<form action="editCategory" method="post" hidden
									id="deleteCategoryForm">
									<input type="hidden" name="operation" value="deleteCategory">
									<input type="hidden" name="catID" id="catID" value="">
								</form>
								<button type="button" class="btn actionButton"
									onclick='submitForm("<%=c.getcID()%>")'
									style="background-color: transparent;">
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
	<%@include file="modals/addCategoryModal.jsp"%>
	<%@include file="modals/editCategoryModal.jsp"%>
</body>
</html>