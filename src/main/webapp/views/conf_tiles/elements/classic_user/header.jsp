<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<div class="navbar">
  		<div class="navbar-inner">
			<ul class="nav pull-left">
				<li><a href="<s:url value="/" />" title="<s:message code="webtitle" />" class="brand"><s:message code="webtitle" /></a></li>
				<li><a href="<s:url value="?lang=en" />" title="<s:message code="english.linktitle" />">en</a></li>
				<li><a href="<s:url value="?lang=cz" />" title="<s:message code="czech.linktitle" />">cz</a></li>
			</ul>
			<ul class="nav pull-right">
				<sec:authorize access="isAuthenticated()">
					<sec:authentication var="currentUsername" property="principal.username" />
					<li>
						<a href="<s:url value="/users/${currentUsername}" />" title="<s:message code="show.user.linktitle" />" >
							${currentUsername}
						</a>
					</li>
					<li>
						<a href="<s:url value="/users/logout" />" title="<s:message code="logout.user.linktitle" />" >
							<s:message code="logout.user" />
						</a>
					</li>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<li>
						<a href="<s:url value="/users/login" />" title="<s:message code="login.user.linktitle" />">
							<s:message code="login.user" />
						</a>
					</li>
					<li>
						<a href="<s:url value="/users/add" />" title="<s:message code="add.user.linktitle" />">
							<s:message code="add.user" />
						</a>
					</li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</header>