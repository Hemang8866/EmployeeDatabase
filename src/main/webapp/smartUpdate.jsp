<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap" rel="stylesheet">
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
#sm_table td, #sm_table th {
  border: 1px solid #ddd;
  padding: 7px 14px;
  text-align:center;
}

#sm_table tr:nth-child(even){background-color: #f2f2f2;}

#sm_table tr:hover {background-color: #ddd;}

#sm_table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: brown;
  color: white;
}

input[type="number"]{
	border:none;
	background:transparent;
	text-align:center;
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
<meta charset="ISO-8859-1">
<title>Update Smartphone</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Smartphones/updateSmart" method="post">
	
	<h2 align="center" style="color:brown; margin-top:2%">Update Smartphone ID:  &nbsp; [ <%=request.getParameter("sid") %> ]</h2>
	<br/>
	<center>
	<table id="sm_table">
	<th> Smartphone ID </th>
	<th> Smartphone Name </th>
	<tr>
	<td><input type="number" name="sid" value="<%=request.getParameter("sid")%>"></td>
	<td><input type="text" name="name" value="<%=request.getParameter("name")%>"></td>
	</tr>
	</table>
	<input type="submit" onclick="alert('Smartphone Updated Successfully');" value="Update Smartphone">
		</center>
	
	

</form>
</body>
</html>