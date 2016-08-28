<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<h2>USER</h2>
			<br> <br>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-sm-3">
			<div class="menu-bar">
				<ul>
					<li class="menu-title">MENU</li>
					<li class="menu-item"><a href="<s:url value="/admin/"/>">Home</a></li>
					<li class="menu-item"><a href="<s:url value="/admin/word"/>">Words</a></li>
					<li class="menu-item"><a
						href="<s:url value="/admin/category"/>">Category</a></li>
					<li class="menu-item menu-selected"><a
						href="<s:url value="/admin/user"/>">Users</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9 col-sm-9 user-wrapper">
			<div class="description">
				<div class="row">
					<h2>Edit user:</h2>
					<hr>
					<form class="form-signin" action="actionUserEdit" method="post">
						<input type="hidden" name="user.user_id" value="<s:property value="user.user_id"/>" />
						<table class="col-md-12 col-sm-12">
							<tbody>
								<tr>
									<td>Email</td>
									<td><input id="inputEmail" name="user.email"
										class="form-control" type="text" autofocus="" required=""
										placeholder="Email Address" value="<s:property value="user.email"/>"></td>
								</tr>
								<tr>
									<td>Username</td>
									<td><input id="inputUsername" name="user.username"
										class="form-control" type="text" autofocus="" required=""
										placeholder="Username" value="<s:property value="user.username"/>"></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input id="inputPassword" name="user.password"
										class="form-control" type="password" autofocus="" required=""
										placeholder="Password"></td>
								</tr>
								<tr>
									<td>Re-enter password</td>
									<td><input id="reinputPassword" name="passwordConfirm"
										class="form-control" type="password" autofocus="" required=""
										placeholder="Re-enter Password"></td>
								</tr>
								<s:checkbox name="user.isAdmin" label="Admin permission"/>
							</tbody>
						</table>
						<div class="col-sm-12 col-md-12">
							<div class="col-sm-9 col-md-9"></div>
							<div class="col-sm-3 col-md-3">
							<button class="col-sm-3 col-md-3 btn btn-lg btn-primary btn-block btn-signin" type="submit">Edit</button>
							</div>
						 	</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- USER PROFILE ROW END-->
</div>