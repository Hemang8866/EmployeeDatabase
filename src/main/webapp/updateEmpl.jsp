<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Update Employee</title>
<style>
*{
font-family: 'Staatliches', cursive;
margin:0;
}
input[type="text"]{
	border:2px solid brown;
	background-color:transparent;
	padding:5px;
}
#emp_table td, #emp_table th {
  border: 1px solid #ddd;
  padding: 7px 14px;
  text-align:center;
}
input[type="number"]{
	border:none;
	background:transparent;
	text-align:center;
	}
#emp_table tr:nth-child(even){background-color: #f2f2f2;}

#emp_table tr:hover {background-color: #ddd;}

#emp_table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: brown;
  color: white;
}

input[type="submit"]{
margin-top:2%;
width:120px;
height:30px;
color:#fff;
border:none;
border-radius:5px;
background-color:black;
cursor:pointer;
}

input[type="submit"]:hover {
color:brown;
}
</style>


</head>
<body>

<form action="<%=request.getContextPath()%>/Employees/upd_Employee" id="emp_form" method="post">
		<h2 align="center" style="color:brown; margin-top:2%">Update Employee ID &nbsp; [ <%=request.getParameter("eid") %> ]</h2>
	<br/>
	<center>
	<table id="emp_table">
	<th> Employee ID </th>
	<th> Employee Name </th>
	<tr>
	<td><input type="number" name="eid" value="<%=request.getParameter("eid")%>"></td>
	<td><input type="text" name="name" placeholder="Enter Employee Name" value="<%=request.getParameter("name")%>"></td>
	</tr>
	</table>

		
		<input type="submit" onclick="alert('Employee Updated Successfully');" value="Update Employee">
		</center>
	</form>
	<br/>
	
	
	

</body>
</html>