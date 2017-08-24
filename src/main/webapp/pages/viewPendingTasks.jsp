<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags"%>
<html>
<head><sj:head locale="en" jqueryui="true" jquerytheme="redmond"/>
</head>
<body>

<script type="text/javascript"  src="http://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js">
</script>
<script type="text/javascript" src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js">
</script>
<script type="text/javascript" src="http://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js">
</script>
<sjdt:datatables datatablesTheme="redmond" buttons="['colvis','pdf','excel','csv','print','copy']" dom="Blfrtip" lengthMenu="[5,10,15,20]" pageLength="15"
columnDefs="[{targets:[4],render:$.fn.dataTable.render.number(',','.',2)}]"
responsive="true" style="width:100%;" >
    <caption class="ui-widget-header" >Pending Tasks</caption>
    <thead>
        <tr>
            <th>User Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
       <s:iterator value="tasksList" >
            <tr>
                <td style="text-align:center;"><s:property value="person.userName"/></td>
                <td style="text-align:center;"><s:property value="person.age"/></td>
                <td style="text-align:center;"><s:property value="person.email"/></td>
                <td style="text-align:center;">
				<a href="<s:url action="completetask.action">
				    	<s:param name="taskId" value="taskId"></s:param>
					</s:url>">Complete Task</a>
                </td>
					                
            </tr>
       </s:iterator>
    </tbody>
</sjdt:datatables>
</body>
</html>