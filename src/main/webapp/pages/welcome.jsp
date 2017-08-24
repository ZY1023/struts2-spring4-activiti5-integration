<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>

<s:form action="addTask.action">
<s:submit value="Add Task"></s:submit>
</s:form>

<s:form action="viewPendingTasks.action">
<s:submit  value="View Pending Tasks"></s:submit>
</s:form>

</body>
</html>