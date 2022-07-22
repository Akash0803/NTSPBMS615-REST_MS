<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:blue;text-align:center">Actor Registration Form</h1>
<frm:form action="actor_add" modelAttribute="performer" method="POST">
	<table bgcolor="cyan" align="center">
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
    						<td colspan="2"><input type="submit" value="register"></td>
    			</tr>
    			</table>


</frm:form>