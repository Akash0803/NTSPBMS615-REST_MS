
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>

<h1 style="color:red;text-align:center">Account Balance Page</h1>

<br>
<b>Hello Mr. <%=SecurityContextHolder.getContext().getAuthentication().getName() %></b>

<br><br>
<h3>Approved Loan Amount :: <%=new java.util.Random().nextInt(100000) %></h3>
<a href="./">Home</a><br><br>


<!-- <a href="logout">Logout</a> -->
<a href="signout">Logout</a>