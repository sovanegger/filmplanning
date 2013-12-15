<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="no-menu">
	<div class="row-fluid">
		<div class="row clearfix">
			<a class="btn btn-white pull-right" href="<s:url value="/filmprojects/add" />"><s:message code="add.filmproject" /></a>
		</div>
		<c:set var="divClass" value="project-box project-box-first" scope="page" />
		<c:set var="first" value="1" scope="page" />
		<c:forEach items="${filmProjects}" var="filmProject">
			<s:url value="/filmprojects/${filmProject.id}/delete" var="deleteFilmProjectUrl" />
			<div class="${divClass}">
				<div class="pull-right project-box-editation">
					<i class="icon-pencil icon-white"></i> <a href="<s:url value="/filmprojects/${filmProject.id}/screenplay" />"><s:message code="open" /></a>
					&nbsp;&nbsp; 
					<i class="icon-trash icon-white"></i>
					<sf:form action="${deleteFilmProjectUrl}" method="DELETE" class="inline">
						<input type="submit" class="button link" value="<s:message code="delete" />" />
					</sf:form>
				</div>
				<h2>${filmProject.title}</h2>
				<p>Director</p>
			</div>
			<c:if test="${first == 1}">
				<c:set var="divClass" value="project-box" scope="page" />
				<c:set var="first" value="1" scope="page" />
			</c:if>
		</c:forEach>
	</div>
</div>