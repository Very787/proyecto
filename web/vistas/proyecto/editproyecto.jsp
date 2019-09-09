
<%@page import="Modelo.Proyecto"%>
<%@page import="ModeloDAO.ProyectoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              ProyectoDAO dao=new ProyectoDAO();
              int id=Integer.parseInt((String)request.getAttribute("idpro"));
              Proyecto p=(Proyecto)dao.list(id);
          %>
            <h1>Modificar Proyecto</h1>
            <form action="Controlador">
                DNI:<br>
                <input class="form-control" type="text" name="txtDesc" value="<%= p.getDesc()%>"><br>
                Nombres: <br>
                <input class="form-control" type="text" name="txtId" value="<%= p.getId()%>"><br>
                
                <input type="hidden" name="txtIdpro" value="<%= p.getIdpro()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ProyectoControlador?accion=listarproyecto">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>