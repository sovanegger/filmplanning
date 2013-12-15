<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!-- variables -->
<s:url var="urlSave" value="/users/save" />
<h3><s:message code="add.user" /></h3>
<div class="row">
	<div id="backtolist" class="span4">
		<a href="<s:url value="/users/login" />" title="<s:message code="backtologin.user" />">
			&lsaquo;&lsaquo; <s:message code="backtologin.user" />
		</a>
	</div>
</div>
<div class="row">
	<div class="span3 offset5">
		<sf:form method="POST" modelAttribute="user" action="${urlSave}">
			<fieldset>
				<div id="username">
					<label for="inp_username" class="required"><s:message code="user.username" />:</label>
					<sf:input id="inp_username" autofocus="autofocus" path="username" />
				</div>
				<sf:errors path="username" cssClass="errors" />		
				
				<div id="password">
					<label for="inp_password" class="required"><s:message code="user.password" />:</label>
					<sf:password id="inp_password" path="password" showPassword="false" />
				</div>
				<sf:errors path="password" cssClass="errors" />			
				
				<div id="password_confirm">
					<label for="inp_password_confirm" class="required"><s:message code="user.passwordconfirm" />:</label>
					<sf:password id="inp_password_confirm" path="passwordConfirm" showPassword="false" />
				</div>
				<sf:errors path="passwordConfirm" cssClass="errors" />
				
				<div id="firstname">
					<label for="inp_firstname"><s:message code="user.firstname" />:</label>
					<sf:input id="inp_firstname" path="firstname" />
				</div>
				<sf:errors path="firstname" cssClass="errors" />
				
				<div id="surname">
					<label for="inp_surname"><s:message code="user.surname" />:</label>
					<sf:input id="inp_surname" path="surname" />
				</div>
				<sf:errors path="surname" cssClass="errors" />
				
				<div id="email">
					<label for="inp_email" class="required"><s:message code="user.email" />:</label>
					<sf:input type="email" id="inp_email" path="email" />
				</div>
				<sf:errors path="email" cssClass="errors" />
				
				<div id="phonenumber">
					<label for="inp_phonenumber" class="required"><s:message code="user.phonenumber" />:</label>
					<sf:input type="tel" id="inp_phonenumber" path="phoneNumber" />
				</div>
				<sf:errors path="phoneNumber" cssClass="errors" />
				<div class="submit">
					<input type="submit" class="btn" name="save" value="<s:message code="save"/>" />
				</div>
			</fieldset>
		</sf:form>
	</div>
</div>