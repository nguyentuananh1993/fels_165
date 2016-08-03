<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
	<s:form action="logIn">
		<s:textfield name="user.username" label="Username"></s:textfield>
		<s:password name="user.password" label="Password"></s:password>
		<s:submit value="Log In" align="center" />
	</s:form>
</div>