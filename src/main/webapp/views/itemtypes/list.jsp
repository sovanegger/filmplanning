<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="notindent">
	<h3><s:message code="list.itemtype" /></h3>
	<div id="links">
		<a href="<s:url value="/admin/itemtypes/add" />"><s:message code="add.itemtype" /></a>
	</div>
	<div id="list">
		<table border="1">
			<tr>
				<th><s:message code="name" /></th>
				<th colspan="3"><s:message code="actions" /></th>
			</tr>
			<c:forEach items="${itemTypes}" var="itemType">
		  		<s:url value="/admin/itemtypes/${itemType.id}/show" var="showItemTypeUrl" />
				<s:url value="/admin/itemtypes/${itemType.id}/edit" var="editItemTypeUrl" />
				<s:url value="/admin/itemtypes/${itemType.id}/delete" var="deleteItemTypeUrl" />
				<tr>
					<td>${itemType.name}</td>
					<td>
						<a href="${showItemTypeUrl}"><s:message code="show" /></a>
					</td>
					<td>
						<a href="${editItemTypeUrl}"><s:message code="edit" /></a>
					</td>
					<td>
						<sf:form action="${deleteItemTypeUrl}" method="DELETE">
							<input type="submit" class="btn link" value="<s:message code="delete" />" />
						</sf:form>
					</td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</div>