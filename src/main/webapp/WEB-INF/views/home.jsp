<%@page import="java.util.List"%>
<%@page import="com.flamenco.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="GBK">
<title>Home</title>

<script type="text/javascript">
	
</script>

</head>
<body>
	
	<div>
		<table>
			<thead>
				<th>No.</th>
				<th>Admin Name</th>
				<th>Admin Password</th>
				<th>Options</th>
			</thead>
			<c:forEach items="${adminList}" var="admin">
				<tbody>
					<td>${admin.getAdminId()}</td>
					<td>${admin.getAdmin()}</td>
					<td>${admin.getPassWord()}</td>
					<td><input type="button" value="delete" /><input type="button"
						value="modify" /></td>
				</tbody>
			</c:forEach>
		</table>
		
		<table>
			<thead>
				<th>No.</th>
				<th>ResGroup Name</th>
				<th>ResGroup Description</th>
				<th>Options</th>
			</thead>
			<c:forEach items="${resGroupList}" var="resGroup">
				<tbody>
					<td>${resGroup.getId()}</td>
					<td>${resGroup.getName()}</td>
					<td>${resGroup.getDescription()}</td>
					<td><input type="button" value="delete" /><input type="button"
						value="modify" /></td>
				</tbody>
			</c:forEach>
		</table>
		
		
		<table>
			<thead>
				<th>No.</th>
				<th>User Name</th>
				<th>User Password</th>
				<th>Options</th>
			</thead>
			<c:forEach items="${userList}" var="user">
				<tbody>
					<td>${user.getId()}</td>
					<td>${user.getName()}</td>
					<td>${user.getPassWord()}</td>
					<td><input type="button" value="delete" /><input type="button"
						value="modify" /></td>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>
