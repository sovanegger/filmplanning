<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<div class="indent">
	<h3>${itemType.name}</h3>
	<div class="backtolist">
		<a href="<s:url value="/admin/itemtypes" />" title="<s:message code="backtolist.itemtype" />">
			&lsaquo;&lsaquo; <s:message code="backtolist.itemtype" />
		</a>
	</div>
	<div id="show_domain">
		<div id="name">
			<strong><s:message code="name" />:</strong> ${itemType.name}
		</div>
		<div id="description">
			<strong><s:message code="description" />:</strong> ${itemType.description}
		</div>
		<div class="submit">
			<a href="<s:url value="/admin/itemtypes/${itemType.id}/edit" />"><s:message code="edit" /></a>
		</div>
	</div>
</div>