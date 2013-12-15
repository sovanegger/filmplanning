<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="indent">
	<h3>${shotType.name}</h3>
	<div class="backtolist">
		<a href="<s:url value="/admin/shottypes" />" title="<s:message code="backtolist.shottype" />">
			&lsaquo;&lsaquo; <s:message code="backtolist.shottype" />
		</a>
	</div>
	<div id="show_domain">
		<div id="name">
			<strong><s:message code="name" />:</strong> ${shotType.name}
		</div>
		<div id="description">
			<strong><s:message code="description" />:</strong> ${shotType.description}
		</div>
		<div class="submit">
			<a href="<s:url value="/admin/shottypes/${shotType.id}/edit" />"><s:message code="edit" /></a>
		</div>
	</div>
</div>