<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jpe" uri="/META-INF/tlds/jpe.tld" %>
<tiles:insertDefinition  name="DefaultTemplate" >
    <tiles:putAttribute name="body">
        <h1>OPA!!!</h1>
        <br><br><br>
        <h2>A pagina que voc� est� requisitando n�o existe!!</h2>
        <br>
        <p>Tente voltar ao in�cio e procurar outra p�gina</p>
    </tiles:putAttribute>
</tiles:insertDefinition>