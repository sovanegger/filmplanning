<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="notindent">
	<h3><s:message code="list.shottype" /></h3>
	<div id="links">
		<a href="<s:url value="/admin/shottypes/add" />"><s:message code="add.shottype" /></a>
	</div>
	<div id="list">
		<table border="1">
			<tr>
				<th><s:message code="name" /></th>
				<th colspan="3"><s:message code="actions" /></th>
			</tr>
			<c:forEach items="${shotTypes}" var="shotType">
		  		<s:url value="/admin/shottypes/${shotType.id}/show" var="showShotTypeUrl" />
				<s:url value="/admin/shottypes/${shotType.id}/edit" var="editShotTypeUrl" />
				<s:url value="/admin/shottypes/${shotType.id}/delete" var="deleteShotTypeUrl" />
				<tr>
					<td>${shotType.name}</td>
					<td>
						<a href="${showShotTypeUrl}"><s:message code="show" /></a>
					</td>
					<td>
						<a href="${editShotTypeUrl}"><s:message code="edit" /></a>
					</td>
					<td>
						<sf:form action="${deleteShotTypeUrl}" method="DELETE">
							<input type="submit" class="btn link" value="<s:message code="delete" />" />
						</sf:form>
					</td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</div>