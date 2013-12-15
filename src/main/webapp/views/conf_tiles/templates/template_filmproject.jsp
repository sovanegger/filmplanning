<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<t:insertAttribute name="doctype" />

<html>
	<t:insertAttribute name="head" />
	<body>
		<div id="container" class="container">
			<t:insertAttribute name="header" />
			<div class="row">
				<t:insertAttribute name="navigation" />
				<div id="content">
					<t:insertAttribute name="messages" />
					<t:insertAttribute name="content" />
				</div>
			</div>
			<t:insertAttribute name="footer" />
		</div>
	</body>
</html>