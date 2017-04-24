<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring Hr</title>
</head>

<body>
	<form:form commandName="request">
		<form:label path="">from: </form:label>
		<form:input readonly="true" path="sender.name" />
		<br>
		<form:label path="">to: </form:label>
		<form:input readonly="true" path="receiverDepartment.departmentName" />
		<br>
		<form:label path="">CC: </form:label>
		<form:input readonly="true" path="notifiedEmployee.name" />
		<br>
		<form:label path="">subject: </form:label>
		<form:input readonly="true" path="subject" />
		<br>
		<form:label path="">body: </form:label>
		<form:input readonly="true" path="body" />
		<br>

		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<input type="submit" name="_eventId_finish" value="Done" />
	</form:form>
</body>
</html>