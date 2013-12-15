<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/resources/tld/filmplanningtaglib.tld" %>
<c:set var="currentFilmProject" value="${f:getCurrentFilmProject()}" />
<nav id="navigation" class="span2">
	<ul class="nav nav-pills">
		<li id="menuitem_myprojects">
			<a href="<s:url value="/" />" title="<s:message code="myprojects.user.linktitle" />" title="<s:message code="myprojects.user.linktitle" />" ><s:message code="myprojects.user" /></a>
		</li>
		<c:if test="${not empty currentFilmProject}">
			<li id="listitem_screenplay">
				<a href="<s:url value="/filmprojects/${currentFilmProject.id}/screenplay" />" title="<s:message code="screenplay.filmproject" />"><s:message code="screenplay.filmproject" /></a>
			</li>
			<li id="listitem_addmembertoproject">
				<a href="<s:url value="/filmprojects/${currentFilmProject.id}/crewmembers/add" />" title="<s:message code="add.crewmember.linktitle" />"><s:message code="add.crewmember" /></a>
			</li>
			<li id="listitem_calendar">
				<a href="<s:url value="/filmprojects/${currentFilmProject.id}/calendar" />" title="<s:message code="calendar.filmproject.linktitle" />"><s:message code="calendar.filmproject" /></a>
			</li>
			<li id="listitem_items" class="dropdown-submenu">
				<a tabindex="-1" href="#"><s:message code="items" /></a>
				<ul class="dropdown-menu">
					<li><a href="<s:url value="/" />"><s:message code="characters" /></a></li>
					<li><a href="<s:url value="/" />"><s:message code="camcorders" /></a></li>
					<li><a href="<s:url value="/" />"><s:message code="properties" /></a></li>
					<li><a href="<s:url value="/" />"><s:message code="microphones" /></a></li>
				</ul>
			</li>
		</c:if>
	</ul>
</nav>
<script type="text/javascript">
	// označení prvku jako active
	// prozatimní řešení vzhledem k časové tísni
	$(document).ready(function() {
		var url = document.URL;
		if (url.indexOf("screenplay") > -1)
			$("#listitem_screenplay").addClass("active");
		else if (url.indexOf("crewmembers/add") > -1)
			$("#listitem_addmembertoproject").addClass("active");
		else if (url.indexOf("calendar") > -1)
			$("#listitem_calendar").addClass("active");
		else
			$("#listitem_items").addClass("dropdown-menu active");
	});
</script>