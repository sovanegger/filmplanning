<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<t:insertAttribute name="doctype" />

<html>
	<t:insertAttribute name="head" />
	<body>
		<div id="container">
			<t:insertAttribute name="header" />
			<t:insertAttribute name="navigation" />
			<div id="content">
				<t:insertAttribute name="messages" />
				<t:insertAttribute name="content" />
			</div>
			<t:insertAttribute name="footer" />
			<hr />
		</div>
	</body>
</html>