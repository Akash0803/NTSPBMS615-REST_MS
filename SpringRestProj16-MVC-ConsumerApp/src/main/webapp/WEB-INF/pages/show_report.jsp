<%@page isELIgnored="false"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <h1 style="color:red;text-align:center">Actor Information Report</h1>
 <c:choose>
 	<c:when test="${!empty actorsInfo}">
 		<table border="1" align="center" bgcolor="yellow">
  			<tr bgcolor="green">
    				<th>ActorId</th>
    				<th>Actor Name</th>
    				<th>Category</th>
    				<th>MobileNo</th>
    				<th>Operation</th>
  			</tr>
  			<c:forEach var="artist" items="${actorsInfo}">
  				<tr>
    					<td>${artist.actorId} </td> 
    					<td>${artist.actorname} </td> 
    					<td>${artist.category} </td> 
    					<td>${artist.mobileNo} </td>
    					<td>
    							<a href="actor_edit?aid=${artist.actorId }"><b>Edit</b><img src="images/edit-icon.png" width="30px" height="30px"></a>
    							<a href="actor_delete?aid=${artist.actorId }" onclick="return confirm('do u want to delete...?')"><b>Delete</b><img src="images/delete-icon.jpg" size="30px" height="30px"></a>
    					
    					</td> 
  			    </tr>
  			</c:forEach>
		</table>
		<h1 style="color:green;text-align:center">${resultMsg}</h1>
 		<center><a href="actor_add">Register<img src="images/add-icon.jpg" size="30px" height="30px"></a></center>
 		<br><br>
 		<center><a href="./">Home<img src="images/home-icon.jpg" size="30px" height="30px"></a></center>
 	</c:when>
 	<c:otherwise>
 		<h1 style="color:red;text-align:center">Actor Not Found</h1>
 	</c:otherwise>
 </c:choose>