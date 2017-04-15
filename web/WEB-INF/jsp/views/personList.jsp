<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <div style="margin: 10px;">
            <h4>List of Persons</h4>
            <table style="width: 600px" class="reference">
                <tbody>
                    <tr>
                        <th>Sr. No.</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach var="person" items="${requestScope.persons}"
                               varStatus="loopCounter">
                        <tr>
                            <td><c:out value="${loopCounter.count}" /></td>
                            <td><c:out value="${person.nome}" /></td>
                            <td><c:out value="${person.email}" /></td>
                            <td><c:out value="${person.idade}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>