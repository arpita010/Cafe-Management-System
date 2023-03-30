
<%
session.removeAttribute("activeUser");
response.sendRedirect("index.jsp");
return;
%>