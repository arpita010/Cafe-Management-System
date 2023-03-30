
<%String message=(String)session.getAttribute("message"); %>
<%if(message!=null){ %>
<div
	class="alert alert-primary alert-dismissible fade show text-center mt-2"
	style="width: 40%; margin-left: 30%;">
	<strong><%=message %></strong>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<%}
session.removeAttribute("message");
%>