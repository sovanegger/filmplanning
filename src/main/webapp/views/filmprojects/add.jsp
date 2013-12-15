<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:url var="urlSave" value="/filmprojects/save" />
<div class="row">
	<div id="backtolist" class="span4">
		<a href="<s:url value="/" />" title="<s:message code="backtolist.filmproject.linktitle" />">
			&lsaquo;&lsaquo; <s:message code="backtolist.filmproject" />
		</a>
	</div>
</div>

<h3><s:message code="add.filmproject" /></h3>
<div class="row">
	<div class="span3 offset5">
		<sf:form method="POST" modelAttribute="filmProject" action="${urlSave}">
			<fieldset>
				<div id="filmtitle" class="field">
					<label for="inp_filmtitle" class="required"><s:message code="filmproject.title" />:</label>
					<sf:input id="inp_filmtitle" autofocus="autofocus" path="title" />
				</div>
				<sf:errors path="title" cssClass="errors" />
				<div class="submit field">
					<input type="submit" class="btn" name="save" value="<s:message code="save"/>" />
				</div>
			</fieldset>
		</sf:form>
	</div>
</div>