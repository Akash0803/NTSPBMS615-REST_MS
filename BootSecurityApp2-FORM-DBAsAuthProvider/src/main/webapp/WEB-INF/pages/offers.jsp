

<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>

<h1 style="color:red;text-align:center">Offers Page</h1>

<br>
<b>Hello Mr. <%=SecurityContextHolder.getContext().getAuthentication().getName() %></b>
<br><br>
<h3>
	<b>Max Loan Amt :: 100000</b><br>
	<b>Rate of Intrest :: 7.3%</b><br>
	<b>Min Tenure       :: 10 Years</b><br><br>

</h3>
<a href="./">Home</a><br><br>


<!-- <a href="logout">Logout</a> -->
<a href="signout">Logout</a>