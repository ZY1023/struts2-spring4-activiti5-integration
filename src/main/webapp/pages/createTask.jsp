<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">
.errorMsg{
color:red;
}
</style>
</head>
<body>
add the following fields:<br/>
 <s:form  namespace="/" action="createTask.action">
	<s:textfield name="person.userName" label="Username"/>
	<s:textfield name="person.age" label="Age"/>
	<s:textfield name="person.email" label="email"/>
	<s:actionerror cssClass="errorMsg"/>
	<s:submit value="Save Task"/>
</s:form>
</body>
</html>