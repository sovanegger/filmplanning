<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com" %>
<s:url var="urlUpdateScreenplay" value="/filmprojects/updatescreenplay" />
<s:url var="ckeditor" value="/resources/ckeditor/" />
<h3>${filmProject.title}</h3>
<div class="span8 offset1">
	<sf:form cssClass="form screenplay" method="PUT" modelAttribute="filmProject" action="${urlUpdateScreenplay}">
		<sf:hidden path="id" />
		<sf:textarea path="screenplay" />
		<ckeditor:replace replace="screenplay" basePath="${ckeditor}" config="${settings}" />
		<div class="submit notwidth">
			<input type="submit" class="btn" name="save" value="<s:message code="save"/>" />
		</div>
	</sf:form>
</div>