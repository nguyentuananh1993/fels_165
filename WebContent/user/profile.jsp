<%@ taglib uri="/struts-tags" prefix="s"%>
<div>
	<s:form action="editProfile" method="post" enctype="multipart/form-data">
		<s:textfield name="email" label="Email"></s:textfield>
		<s:textfield name="username" label="Username"></s:textfield>
		<label for="myFile">Upload your image</label>
		<s:file name="myFile" label="Browse"/>
		<input type="submit" value="Save" />
	</s:form>
</div>