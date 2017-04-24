<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>Spring Hr</title>
</head>

<body>
	<h2>Welcome to Spring Hr!!!</h2>

	<form:form commandName="request">
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<form:label path="">Subject</form:label>
		<form:input path="subject" cssStyle="width :100%" />
		<br />
		<br />
		<br />
		<form:label path="">Body</form:label>
		<form:textarea path="body" cssStyle="width :100%" />
		<br />
		<form:checkbox path="notify" />
		<form:label path="">notify another employee</form:label>
		<input type="submit" name="_eventId_requestEntered" value="Next" />
	</form:form>
</body>
</html>