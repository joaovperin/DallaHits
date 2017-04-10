<%@ taglib prefix="spring" uri="/META-INF/tlds/spring.tld" %>
<ul style="list-style:none;line-height:28px;">
    <h1>hello from footer!</h1>
    <li>
        <%--<spring:url value="/index" var="homeUrl" htmlEscape="true" />--%>
        <a href="${homeUrl}">Home</a>
        <p>Footer.</p>
    </li>
</ul>