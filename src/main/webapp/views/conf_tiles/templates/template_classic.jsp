<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<t:insertAttribute name="doctype" />

<html>
	<t:insertAttribute name="head" />
	<body>
		<t:insertAttribute name="header" />
		<div class="container">
			<t:insertAttribute name="messages" />
			<t:insertAttribute name="content" />
		</div>
	</body>
	<t:insertAttribute name="footer" />
</html>