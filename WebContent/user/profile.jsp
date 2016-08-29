<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container">
	<div class="card editprofile">
		<h2 class="text-center"> Edit Profile </h2>
		<p id="profile-name" class="profile-name-card"></p>
		<form action="editProfile" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-md-4 text-right" > Email Address : </label> 
				<div class="col-md-8">
					<input type="text" id="inputEmail" class="form-control" name="email"
					 value="<s:property value="user.email"/>" required autofocus>
				</div>
			</div>
			<div class="form-group row"> 
				<label class="col-md-4 text-right"> User Name : </label>
				<div class="col-md-8"> 
					<input type="text" id="inputUsername" class="form-control" name="username"
					 value="<s:property value="user.username"/>" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4 text-right"> Upload Your Avatar : </label>
				<div class="col-md-8" >
					 <input type="file" name="myFile"/>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-offset-4 col-md-8">
				<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit"> Update profile </button>
				<!-- <input type="submit" value="Upload"/> -->
				</div>
			</div>
		</form>
	</div>
</div>