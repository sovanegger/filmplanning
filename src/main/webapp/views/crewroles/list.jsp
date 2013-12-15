<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="notindent">
	<h3><s:message code="list.crewrole" /></h3>
	<div id="links">
		<a href="<s:url value="/admin/crewroles/add" />"><s:message code="add.crewrole" /></a>
	</div>
	<div id="list">
		<table border="1">
			<tr>
				<th><s:message code="name" /></th>
				<th colspan="3"><s:message code="actions" /></th>
			</tr>
			<c:forEach items="${crewRoles}" var="crewRole">
		  		<s:url value="/admin/crewroles/${crewRole.id}/show" var="showCrewRoleUrl" />
				<s:url value="/admin/crewroles/${crewRole.id}/edit" var="editCrewRoleUrl" />
				<s:url value="/admin/crewroles/${crewRole.id}/delete" var="deleteCrewRoleUrl" />
				<tr>
					<td>${crewRole.name}</td>
					<td>
						<a href="${showCrewRoleUrl}"><s:message code="show" /></a>
					</td>
					<td>
						<a href="${editCrewRoleUrl}"><s:message code="edit" /></a>
					</td>
					<td>
						<sf:form action="${deleteCrewRoleUrl}" method="DELETE">
							<input type="submit" class="btn link" value="<s:message code="delete" />" />
						</sf:form>
					</td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</div>