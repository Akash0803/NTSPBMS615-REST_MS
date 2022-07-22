<%@ page isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

 
<h1 style="color:blue;text-align:center">Actor Information Updation Form</h1>
<frm:form action="actor_edit" modelAttribute="artist" method="POST">
	<table bgcolor="pink" align="center">
				<tr>
    						<td>Actor ID :: </td>
    						<td><frm:input path="actorId" readonly="true"/></td>
    			</tr>
    			<tr>
    						<td>Actor Name :: </td>
    						<td><frm:input path="actorname"/></td>
    			</tr>
    			<tr>
    						<td>Actor Category :: </td>
    						<td><frm:input path="category"/></td>
    			</tr>
    			
  				<tr>
    						<td>Actor MobileNo :: </td>
    						<td><frm:input path="mobileNo"/></td>
    			</tr>
    			<tr>
    						<td colspan="2"><input type="submit" value="update Actor"></td>
    			</tr>
    			</table>


</frm:form>