<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <tiles:insertAttribute name="header"/>
    </head>
    <body>
        <div class="container" style="border: #C1C1C1 solid 1px; border-radius:10px;">
            <div id="divMenu" class="menu span-5  border" style="height:400px;background-color:#FCFCFC;">
                <tiles:insertAttribute name="menu"/>
            </div>
            <div id="divContent" class="container span-19 last " >
                <tiles:insertAttribute name="body"/>
            </div>
            <div id="divFooter" class="footer">
                <tiles:insertAttribute name="footer"/>
            </div>
        </div>
    </body>
</html>