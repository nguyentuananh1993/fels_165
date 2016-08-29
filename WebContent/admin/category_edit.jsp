<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<h2>CATEGORY</h2>
			<br> <br>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-sm-3">
			<div class="menu-bar">
				<ul>
					<li class="menu-title">MENU</li>
					<li class="menu-item"><a href="<s:url value="/admin/"/>">Home</a></li>
					<li class="menu-item"><a
						href="<s:url value="/admin/word"/>">Words</a></li>
					<li class="menu-item menu-selected"><a
						href="<s:url value="/admin/category"/>">Category</a></li>
					<li class="menu-item"><a href="<s:url value="/admin/user"/>">Users</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9 col-sm-9 user-wrapper">
			<div class="description">
				<div class="row">
					<h2>Edit category:</h2>
					<hr>
					<form class="form-signin" action="actionCategoryEdit" method="post">
						<input type="hidden" name="category.category_id"
							value="<s:property value="category.category_id"/>"/>
						<input type="hidden" name="category.created_at"
							value="<s:property value="category.created_at"/>"/> 
						<input type="hidden" name="categpru.updated_at"
							value="<s:property value="category.updated_at"/>"/>
						<table class="col-md-12 col-sm-12">
							<tbody>
								<tr>
									<td>Category name</td>
									<td><input id="inputEmail" name="category.name"
										class="form-control" type="text" autofocus="" required=""
										placeholder="Category name"
										value="<s:property value="category.name"/>"></td>
								</tr>
							</tbody>
						</table>
						<div class="col-sm-12 col-md-12">
							<div class="col-sm-9 col-md-9"></div>
							<div class="col-sm-3 col-md-3">
								<button
									class="col-sm-3 col-md-3 btn btn-lg btn-primary btn-block btn-signin"
									type="submit">Edit</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- USER PROFILE ROW END-->
</div>