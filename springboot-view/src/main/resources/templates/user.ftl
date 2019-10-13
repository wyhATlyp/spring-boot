<html>
	<head>
		</title>账户</title>
		<meta charset="utf-8"/>
	</head>
	<body>
		<table border="1" align="center" width="50%">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
			</tr>
			<#list users as user>
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
				</tr>
			</#list>
		</table>		
	</body>
</html>