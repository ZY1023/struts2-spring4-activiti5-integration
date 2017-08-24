<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center" width="100%" height="100%">
	<tr>

		<td height="30" colspan="2"><tiles:insertAttribute name="header" />
		</td>
	</tr>

	<tr>
		<td height="500px" width="10%"><tiles:insertAttribute name="menu" /></td>
		<td height="100%" width="350"><tiles:insertAttribute name="body" /></td>

	</tr>
	<tr>
		<td height="30" colspan="2"><tiles:insertAttribute name="footer" />

		</td>
	</tr>
</table>
</body>
</html>