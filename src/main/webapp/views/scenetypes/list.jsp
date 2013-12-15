<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="notindent">
	<h3><s:message code="list.scenetype" /></h3>
	<div id="links">
		<a href="<s:url value="/admin/scenetypes/add" />"><s:message code="add.scenetype" /></a>
	</div>
	<div id="list">
		<table border="1">
			<tr>
				<th><s:message code="name" /></th>
				<th colspan="3"><s:message code="actions" /></th>
			</tr>
			<c:forEach items="${sceneTypes}" var="sceneType">
		  		<s:url value="/admin/scenetypes/${sceneType.id}/show" var="showSceneTypeUrl" />
				<s:url value="/admin/scenetypes/${sceneType.id}/edit" var="editSceneTypeUrl" />
				<s:url value="/admin/scenetypes/${sceneType.id}/delete" var="deleteSceneTypeUrl" />
				<tr>
					<td>${sceneType.name}</td>
					<td>
						<a href="${showSceneTypeUrl}"><s:message code="show" /></a>
					</td>
					<td>
						<a href="${editSceneTypeUrl}"><s:message code="edit" /></a>
					</td>
					<td>
						<sf:form action="${deleteSceneTypeUrl}" method="DELETE">
							<input type="submit" class="btn link" value="<s:message code="delete" />" />
						</sf:form>
					</td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</div>