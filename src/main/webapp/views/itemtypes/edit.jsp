<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:url value="/admin/itemtypes/update" var="updateUrl" />
<div class="notindent">
	<h3><s:message code="edit.itemtype" /></h3>
	<div class="backtolist">
		<a href="<s:url value="/admin/itemtypes" />" title="<s:message code="backtolist.itemtype" />">
			&lsaquo;&lsaquo; <s:message code="backtolist.itemtype" />
		</a>
	</div>
	<div id="form">
		<sf:form action="${updateUrl}" method="PUT" modelAttribute="itemType">
			<fieldset>
				<sf:hidden path="id" />
				<div id="name">
					<label for="inp_name" class="required"><s:message code="name" />:</label>
					<sf:input id="inp_name" autofocus="autofocus" path="name" />
				</div>
				<sf:errors path="name" cssClass="errormessage" />
				<div id="description">
					<label for="txa_description"><s:message code="description" />:</label>
					<sf:textarea id="txa_description" path="description" rows="10" cols="30" />
				</div>
				<sf:errors path="description" cssClass="errormessage" />
				<div class="submit">
					<input type="submit" name="save" value="<s:message code="save"/>" />
				</div>
			</fieldset>
		</sf:form>
	</div>
</div>