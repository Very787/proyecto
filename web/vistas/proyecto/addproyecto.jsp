
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
                <h1>Agregar Proyecto</h1>
                <form action="ProyectoControlador">
                    DESCRIPCION:<br>
                    <input class="form-control" type="text" name="txtDesc"><br>
                    USUARIO: <br>
                    <input class="form-control" type="text" name="txtId"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ProyectoControlador?accion=listarproyecto">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
