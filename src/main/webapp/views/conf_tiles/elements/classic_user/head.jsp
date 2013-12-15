<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<head>
	<s:url var="js" value="/resources/js/" />
	<s:url var="css" value="/resources/css/" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${css}main.css" rel="stylesheet" type="text/css" />
	<script src="${js}jquery-1.9.1.min.js"></script>
	<script src="${js}bootstrap.js"></script>
	<script src="${js}bootstrap.min.js"></script>
	<title><s:message code="webtitle" /></title>
</head>