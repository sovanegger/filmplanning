<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div id="messages">
	<c:choose>
		<c:when test="${not empty successMessage}">
			<span class="alert alert-success"><s:message code="${successMessage}" /></span>
		</c:when>
		<c:when test="${not empty errorMessage}">
		   	<span class="alert alert-error"><s:message code="${errorMessage}" /></span>
		</c:when>
	</c:choose>
</div>