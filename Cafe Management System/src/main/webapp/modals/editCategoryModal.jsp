<div class="modal" id="editCategoryModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4>Edit Category</h4>
			</div>
			<div class="modal-body">
				<form action="editCategory" method="post">
					<div class="col-12">
						<input type="text" name="newName" placeholder="New Category Name">
						<input type="hidden" name="operation" value="editCategory">
						<input type="hidden" name="oldCatName" id="oldCatName" value="">
						<button type="submit" class="btn btn-success mt-4">Save
							Changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>