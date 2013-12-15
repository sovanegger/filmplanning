<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:url value="filmprojects/sendmembershiprequest" var="saveUrl" />
<h3><s:message code="add.crewmember" /></h3>
<sf:form action="${saveUrl}" method="POST" modelAttribute="crewMember">
	<fieldset>
		<div class="row">
			<div class="span5 offset3 withmenu">
				<s:message code="acl.crewmember.filmprojects" />:<br />
				<label class="checkbox acl">
					<input name="read" type="checkbox"> &nbsp;<s:message code="read" />
				</label>
				<label class="checkbox acl">
					<input name="write" type="checkbox"> &nbsp;<s:message code="write" />
				</label>
				<label class="checkbox acl">
					<input name="create" type="checkbox"> &nbsp;<s:message code="create" />
				</label>
				<label class="checkbox acl">
					<input name="delete" type="checkbox"> &nbsp;<s:message code="delete" />
				</label>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="span5 offset3 withmenu">
				<s:message code="acl.crewmember.items" />:<br />
				<label class="checkbox acl">
					<input name="read" type="checkbox"> &nbsp;<s:message code="read" />
				</label>
				<label class="checkbox acl">
					<input name="write" type="checkbox"> &nbsp;<s:message code="write" />
				</label>
				<label class="checkbox acl">
					<input name="create" type="checkbox"> &nbsp;<s:message code="create" />
				</label>
				<label class="checkbox acl">
					<input name="delete" type="checkbox"> &nbsp;<s:message code="delete" />
				</label>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="span5 offset3 withmenu">
				<s:message code="acl.crewmember.filmingdays" />:<br />
				<label class="checkbox acl">
					<input name="read" type="checkbox"> &nbsp;<s:message code="read" />
				</label>
				<label class="checkbox acl">
					<input name="write" type="checkbox"> &nbsp;<s:message code="write" />
				</label>
				<label class="checkbox acl">
					<input name="create" type="checkbox"> &nbsp;<s:message code="create" />
				</label>
				<label class="checkbox acl">
					<input name="delete" type="checkbox"> &nbsp;<s:message code="delete" />
				</label>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="span3 offset4">
				<div>
					<label for="inp_email"><s:message code="crewmember.email" />:</label>
					<input id="inp_email" name="email" type="email" autofocus="autofocus" />
				</div>
				<div class="submit field">
					<input name="commit" type="submit" class="btn" value="<s:message code="sendmembershiprequest.crewmember" />" />
				</div>
			</div>
		</div>
	</fieldset>
</sf:form>