<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%!
static String Static_var ="this is static variable";

String non_static = "this is a non varaible";

public static String staticMessage(){
	return "greeting from static member";
}
String staticMessage1(){
	return "greeting from non static member";
}
%>


<%

String local= "local var";
out.print(local);
out.print(Static_var);
out.print(non_static);
out.print(staticMessage());
%>

<h1>
<%= local %>
</h1>
<h1>
<%= Static_var %>
</h1>
<h1>
<%= non_static %>
</h1>
<h1>
<%= staticMessage() %>
</h1>


</body>
</html>