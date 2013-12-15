<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!-- variables -->
<s:url var="authUrl" value="/users/j_spring_security_check" />
<h3><s:message code="login.user" /></h3>
<div class="row">
	<div class="span3 offset5">
		<form method="post" action="${authUrl}">
			<fieldset>
				<div>
					<label for="username"><s:message code="user.username" />:</label>
					<input id="username" name="j_username" type="text" autofocus="autofocus" />
				</div>
				<div>
					<label for="password"><s:message code="user.password" />:</label>
					<input id="password" name="j_password" type="password" />
				</div>
				<div class="submit">
					<input name="commit" type="submit" class="btn" value="<s:message code="login.user" />" />
				</div>
			</fieldset>
		</form>
		<s:message code="notregistered.user" /> 
		<a href="<s:url value="/users/add" />" title="<s:message code="add.user.linktitle" />">
			<s:message code="add.user" />
		</a>
	</div>
</div>