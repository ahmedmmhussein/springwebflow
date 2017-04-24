<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>Spring Hr</title>
</head>

<body>
	<h2>Welcome to Spring Hr!!!</h2>

	<form method="post" action="">
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" /> <label>Select Employee: </label> <select
			id="id" name="id">
			<c:forEach items="${employeesList}" var="employee">
				<option value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</select> <br /> <br /> <br /> <label>Select Department: </label> <select
			id="departmentId" name="departmentId">
			<c:forEach items="${departmentsList}" var="department">
				<option value="${department.departmentId}">${department.departmentName}</option>
			</c:forEach>
		</select> <br /> <input type="submit" name="_eventId_employeeEntered"
			value="Next" />
	</form>
</body>
</html>