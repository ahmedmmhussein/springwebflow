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
			value="${flowExecutionKey}" /> <label>Select employee you
			want to notify </label> <select id="notifiedId" name="notifiedId">
			<c:forEach items="${employeesList}" var="employee">
				<option value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</select> <br /> <input type="submit" name="_eventId_doneSelect" value="Next" />
	</form>
</body>
</html>