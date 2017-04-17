<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Ícone da página --%>
<link rel="shortcut icon" href="<c:url value="/favicon.ico" />" type="image/x-icon">
<link rel="icon" href="<c:url value="/favicon.ico" />" type="image/x-icon">
<%-- http://www.favicon-generator.org/editor/ --%>
<%-- Scripts e Link Rels --%>
<link href="<c:url value="/resources/third/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/third/css/datatables.css" />" rel="stylesheet" type="text/css" /> 

<!--<link href="<c:url value="/resources/third/css/dataTables.bootstrap.css" />" rel="stylesheet" type="text/css" />--> 
<!--<link href="<c:url value="/resources/third/css/keyTable.bootstrap.css" />" rel="stylesheet" type="text/css" />--> 
<link href="<c:url value="/resources/third/css/responsive.bootstrap.css" />" rel="stylesheet" type="text/css" /> 
<!--<link href="<c:url value="/resources/third/css/colReorder.bootstrap.css" />" rel="stylesheet" type="text/css" />--> 
<link href="<c:url value="/resources/third/css/buttons.bootstrap.css" />" rel="stylesheet" type="text/css" /> 
<link href="<c:url value="/resources/css/layout.css" />" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/third/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/third/js/datatables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/third/js/bootstrap.min.js" />"></script>

<!--<script type="text/javascript" src="<c:url value="/resources/third/js/dataTables.bootstrap.js" />"></script>-->
<script type="text/javascript" src="<c:url value="/resources/third/js/dataTables.responsive.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/third/js/dataTables.keyTable.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/third/js/dataTables.buttons.js" />"></script>
<!--<script type="text/javascript" src="<c:url value="/resources/third/js/dataTables.colReorder.js" />"></script>-->
<script type="text/javascript" src="<c:url value="/resources/third/js/buttons.bootstrap.js" />"></script>