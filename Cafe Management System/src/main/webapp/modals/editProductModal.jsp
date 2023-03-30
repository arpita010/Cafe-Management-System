<div class="modal fade show" id="editProductModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3>Edit Product Details</h3>
			</div>
			<div class="modal-body">
				<form action="editProduct" method="post">
					<div class="form-row">
						<div class="col">
							<input type="hidden" name="productID" value="" id="productID">
							<input type="hidden" name="operation" value="editProduct">
							<input type="text" name="newName" placeholder="New Product Name">
						</div>
						<div class="col">
							<input type="number" name="newPrice" placeholder="New Price">
						</div>
					</div>
					<div class="form-row mt-3">
						<div class="col-12">
							<input type="text" name="newDescription"
								placeholder="New Description">
						</div>
					</div>
					<div class="row">
						<div class="col-12 text-center mt-3">
							<button type="submit" class="btn btn-success">Save
								Changes</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>