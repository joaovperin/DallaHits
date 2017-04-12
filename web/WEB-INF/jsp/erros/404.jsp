<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <h1>OPA!!!</h1>
        <br><br><br>
        <h2>A pagina que você está requisitando não existe!!</h2>
        <br>
        <p>Tente voltar ao início e procurar outra página</p>
    </tiles:putAttribute>
</tiles:insertDefinition>