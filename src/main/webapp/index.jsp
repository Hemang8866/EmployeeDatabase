<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

*{
font-family: 'Staatliches', cursive;
margin:0;
}

h1{
color:#fff;
}
input[type="text"]{
width:300px;
height:30px;
border:1px solid brown;
border-radius:5px;
}
input[id="name1"]{
width:150px;
height:30px;
border:1px solid brown;
border-radius:5px;
}
::placeholder{
text-align:center;
color:brown;
}

input[type="submit"]{
margin-top:2%;
width:120px;
height:34px;
color:#fff;
border:none;
border-radius:5px;
background-color:black;
cursor:pointer;
}

input[type="submit"]:hover, a:hover {
color:brown;
}

.btn {
display:block;
padding:10px;
text-decoration:none;
background-color:#000;
color:#fff;
border-radius:5px;
cursor:pointer;

}

#emp_table td, #emp_table th {
  border: 1px solid #ddd;
  padding: 7px 14px;
  text-align:center;
}

#emp_table tr:nth-child(even){background-color: #f2f2f2;}

#emp_table tr:hover {background-color: #ddd;}

#emp_table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: brown;
  color: white;
}

#sm_table td, #sm_table th {
  border: 1px solid #ddd;
  border-radius:5px;
  padding: 4px 8px;
  text-align:center;
}

#sm_table tr:nth-child(even){background-color: #f2f2f2;}

#sm_table tr:hover {background-color: #ddd;}

#sm_table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align:center;
  background-color: #192a51;
  color: white;
}

</style>
<script type="text/javascript">
function success(){
	return alert("Your DATA added Successfully!");
}

function prevent(){
	var emp = document.getElementById("add").value;
	if(emp == "" || null){
		alert("Please enter employee name");
		return false;
	}else{
		return true;
	}
}
</script>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap" rel="stylesheet">
</head>
<body>
<div style="text-align:center; background-color:brown; padding:25px;">
 <div style="clear:both;"></div>
<div style="float:right;">
	<form action="<%=request.getContextPath()%>/Employees/searchEmployees" method="GET">
		<input type="text" name="name" id="name1" placeholder="Search Name"/>
		<input type="submit" value="Search"/>
	</form>
	</div><br/><br/><br/>
<form action="<%=request.getContextPath()%>/Employees/add_Employee" method="POST" onsubmit="prevent()">
		<h1>Employee's Database</h1>
		<br/>
		 <input type="text" name="name" id="add" placeholder="Enter your name"><br/>
		<input type="submit" value="Add employee" onclick="alert('Successfully added Employee!');">
		
	</form>
	
	
	<br>
	</div>
	<br/>
	<div>
	<font color="brown">
	<h2 align="center" style="display:block; background-color:#000; color:#fff; padding:10px;">Display Employee Data</h2></font>
	<br/>
	<center><table align="center" id="emp_table">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Smartphones </th>
			<th>Add Smartphones </th>
			<th>Update Employee</th>
			<th>Delete Employee</th>
	
		</tr>
		<c:forEach items="${emp_list}" var="Employee">
		<tr>
			<td>
				${Employee.emp_id} .
			</td>
			<td>
				${Employee.emp_name}
			</td>
			<td>
			<table id="sm_table"><tr>
					<th>ID</th>
					<th>Name</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach items = "${Employee.sm}" var="Smarts">
				<tr>
					<td>${Smarts.sm_id}</td>
					<td>${Smarts.sm_name}</td>
					<td><a class="btn"  href="../smartUpdate.jsp?sid=${Smarts.sm_id}&name=${Smarts.sm_name}">Update</a></td>
					<td><a class="btn" href="<%=request.getContextPath()%>/Smartphones/deleteSmart?action=delete&sid=${Smarts.sm_id}" onclick="window.confirm('Are you sure to delete Smartphone ?');">Delete</a></td>
				</tr>
				</c:forEach>
				</table>
			</td>
			<td><a class="btn" href = "../smartAdd.jsp?sid=${Employee.emp_id}">Add</a> </td>
			<td>
			<a class="btn" href="../updateEmpl.jsp?eid=${Employee.emp_id}&name=${Employee.emp_name}">Update</a></td>
			<td><a class="btn" href="<%=request.getContextPath()%>/Employees/delt_Employee?eid=${Employee.emp_id}" onclick="window.confirm('Are you sure to delete Employee ?');">Delete</a></td>
			</td>
		</tr>
		</c:forEach>
		
	
	
	</table>
	</center>
</div>

</body>
</html>