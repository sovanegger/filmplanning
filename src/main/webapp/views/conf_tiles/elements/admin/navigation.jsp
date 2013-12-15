<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<nav id="navigation">
	<ul class="menu">
		<li><a href="<s:url value="/admin/authorities" />"><s:message code="list.authority" /></a></li>
		<li><a href="<s:url value="/admin/crewroles" />"><s:message code="list.crewrole" /></a></li>
		<li><a href="<s:url value="/admin/scenetypes" />"><s:message code="list.scenetype" /></a></li>
		<li><a href="<s:url value="/admin/shottypes" />"><s:message code="list.shottype" /></a></li>
		<li><a href="<s:url value="/admin/itemtypes" />"><s:message code="list.itemtype" /></a></li>
		<li><span class="menuexplorer"></span></li>
	</ul>
</nav>