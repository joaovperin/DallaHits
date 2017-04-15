<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<c:url value="/resources/third/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/datatable.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/functions.js" />"></script>
<footer class="navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">
                    <li>
                        <%--<spring:url value="/index" var="homeUrl" htmlEscape="true" />--%>
                        <!--<a href="${homeUrl}">Início</a>-->
                        <a href="#">Home</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="#about">About</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="#services">Services</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="#contact">Contact</a>
                    </li>
                </ul>
                <p class="copyright text-muted small">Copyright &copy; João Victor Perin 2017. All Rights Reserved</p>
            </div>
        </div>
    </div>
</footer>