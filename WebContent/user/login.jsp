<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <div>
	<s:form action="logIn">
		<s:textfield name="user.username" label="Username"></s:textfield>
		<s:password name="user.password" label="Password"></s:password>
		<s:submit value="Log In" align="center" />
	</s:form>
</div> --%>
<div class="container">
	<div class="card card-container">
		<img id="profile-img" class="profile-img-card"
			src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" />
		<p id="profile-name" class="profile-name-card"></p>

		<form class="form-signin" action="logIn" method="post">
			<input type="text" id="inputUsername" name="user.username"
				class="form-control" placeholder="Username" required autofocus>
			<input type="password" id="inputPassword" name="user.password"
				class="form-control" placeholder="Password" required>
			<div id="remember" class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Sign in</button>
		</form>

		<div class="row text-center">
			<a href="#" class="forgot-password">Forgot the password?</a> <br>
		</div>
	</div>
</div>