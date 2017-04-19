<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <tiles:insertAttribute name="header"/>
        <title><tiles:insertAttribute name="titulo"/></title>
    </head>
    <body>
        <div class="container tpContainer">
            <div id="divMenu" class="container tpMenu">
                <tiles:insertAttribute name="menu"/>
            </div>
            <div id="divContent" class="container tpContent" >
                <tiles:insertAttribute name="body"/>
            </div>
            <div id="divFooter" class="container tpFooter">
                <tiles:insertAttribute name="footer"/>
            </div>
        </div>
    </body>
</html>