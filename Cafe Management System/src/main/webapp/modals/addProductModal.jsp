<%@page import="com.dao.*,com.object.*,java.util.*"%>
<div class="modal fade" id="addProductModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body">
				<form action="product" method="post">

					<div class="row mt-4">
						<div class="col-12">
							<input type="text" name="name" placeholder="Product Name*">
						</div>
					</div>
					<div class="form-row mt-4">
						<div class="col">
							<select class="select-margin-input" name="category">
								<option value="" selected disabled hidden>Category*</option>
								<% List<Category> catList=CategoryDao.getAllCategories();
	for(Category cat:catList){
	%>
								<option value="<%=cat.getcName() %>"><%=cat.getcName() %></option>
								<%} %>
							</select>
						</div>
						<div class="col">
							<input type="number" name="price" placeholder="Price*">
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-12">
							<input type="text" name="description" placeholder="Description*">
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-12 text-center">
							<button type="submit" class="btn btn-warning">Add</button>
							<button type="button" data-dismiss="modal" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>