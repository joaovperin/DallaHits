<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Se não há nenhum usuário logado
    if (request.getSession().getAttribute("usuarioLogado") == null) {
        // Redireciona à pagina de login
        response.sendRedirect("login");
    } else {
        // Otherwise, vai pra página inicial
        response.sendRedirect("index");
    }
%>