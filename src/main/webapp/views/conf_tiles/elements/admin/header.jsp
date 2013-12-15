<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<div class="header left">
		<h2 id="webtitle">
			<a href="<s:url value="/admin" />" title="<s:message code="admin.webtitle" />"><s:message code="admin.webtitle" /></a>
		</h2>
	</div>
	<div class="header right">
		<sec:authorize access="isAuthenticated() AND hasRole('ROLE_ADMIN')">
			<a href="<s:url value="/admin/logout" />" title="<s:message code="logout.user.linktitle" />" >
				<s:message code="logout.user" />
			</a>
		</sec:authorize>
	</div>
</div>