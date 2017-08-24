<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">
.topnav {
    background-color: #333;
    overflow: hidden;
    width:100%;
    height:100%;
}

/* Style the links inside the navigation bar */
.topnav a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
    background-color: #ddd;
    color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
<div class="topnav" id="myTopnav">
<table>
	<tr><td><a href="<s:url action="welcome.action" namespace="/"/>"><b>Home</b></a></td></tr>
	<tr><td><a href="<s:url action="addTask.action" namespace="/"/>"><b>Create Task</b></a></td></tr>
	<tr><td><a href="<s:url action="viewPendingTasks.action" namespace="/"/>"><b>View Tasks</b></a></td></tr>
	<tr><td><a href="#about"><b>About</b></a></td></tr>
</table>
</div>
</body>
</html>
