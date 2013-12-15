<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- variables -->
<s:url var="authUrl" value="/admin/j_spring_security_check" />

<div class="notindent">
	<h3><s:message code="login.admin" /></h3>
	<div class="messages spec">
		<c:if test="${param.login_error == 't'}">
		   	<span class="errormessage"><s:message code="error.login.user" /></span>
		</c:if>
	</div>
	
	<div id="login_form">
		<form method="post" action="${authUrl}">
			<fieldset>
				<div id="username_field" class="field">
					<label for="username"><s:message code="user.username" />:</label>
					<input id="username" name="j_username" type="text" autofocus="autofocus" />
				</div>
				<div id="password_field" class="field">
					<label for="password"><s:message code="user.password" />:</label>
					<input id="password" name="j_password" type="password" />
				</div>	
				<div class="submit">
					<input name="commit" type="submit" value="<s:message code="login.user" />" />
				</div>
			</fieldset>
		</form>
	</div>
</div>