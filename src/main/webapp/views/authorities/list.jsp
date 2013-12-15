<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="notindent">
	<h3><s:message code="list.authority" /></h3>
	<div id="links">
		<a href="<s:url value="/admin/authorities/add" />"><s:message code="add.authority" /></a>
	</div>
	<div id="list">
		<table border="1">
			<tr>
				<th><s:message code="name" /></th>
				<th colspan="3"><s:message code="actions" /></th>
			</tr>
			<c:forEach items="${authorities}" var="authority">
		  		<s:url value="/admin/authorities/${authority.id}/show" var="showAuthorityUrl" />
				<s:url value="/admin/authorities/${authority.id}/edit" var="editAuthorityUrl" />
				<s:url value="/admin/authorities/${authority.id}/delete" var="deleteAuthorityUrl" />
				<tr>
					<td>${authority.authority}</td>
					<td>
						<a href="${showAuthorityUrl}"><s:message code="show" /></a>
					</td>
					<td>
						<a href="${editAuthorityUrl}"><s:message code="edit" /></a>
					</td>
					<td>
						<sf:form action="${deleteAuthorityUrl}" method="DELETE">
							<input type="submit" class="btn link" value="<s:message code="delete" />" />
						</sf:form>
					</td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</div>