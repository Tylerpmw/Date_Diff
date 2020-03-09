<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Date Assessment</title>
		
		<style> 
		input[type=date]
		{
		  text-align:center;
		}
		
		input[type=date]:focus 
		{
		  background-color: lightblue;
		}
		</style>
	</head>
	
	<body> 	
    	<form method="post">
    		<p><%= "Pick two dates to find the number of days between them..." %></p>
  			<label for="date1">Date 1:</label>
    		<input type="date" name="input1" required pattern="\d{4}-\d{2}-\d{2}" value="1990-01-01">
    			<span class="validity"></span>
    		<label for="date2">Date 2:</label>
    		<input type="date" name="input2" required pattern="\d{4}-\d{2}-\d{2}" value="2020-03-09">
    			<span class="validity"></span>
  			<p><button>Submit</button></p>
  			<c:if test="${not empty total}">
    			<p><% String total = (String)request.getAttribute("total"); %>
				<%= total%></p>
			</c:if>
		</form>
	</body>
</html>