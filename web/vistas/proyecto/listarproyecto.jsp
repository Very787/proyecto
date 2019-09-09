<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Proyecto"%>
<%@page import="java.util.List"%>
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
            <h1>Proyectos</h1>
            <a class="btn btn-success" href="ProyectoControlador?accion=addproyecto">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">DESCRIPCION</th>
                        <th class="text-center">USUARIO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ProyectoDAO dao=new ProyectoDAO();
                    List<Proyecto>list=dao.listar();
                    Iterator<Proyecto>iter=list.iterator();
                    Proyecto pro=null;
                    int aux=1;
                    while(iter.hasNext()){
                        pro=iter.next();
                      
                        aux=pro.getId();
                        PersonaDAO daoper=new PersonaDAO();
                        int idper=aux;
                        Persona per=(Persona)daoper.list(idper);
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= pro.getIdpro()%></td>
                        <td class="text-center"><%= pro.getDesc()%></td>
                       
                        <td class="text-center"><%= per.getNom()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ProyectoControlador?accion=editar&id=<%= pro.getIdpro()%>">Editar</a>
                            <a class="btn btn-danger" href="ProyectoControlador?accion=eliminar&id=<%= pro.getIdpro()%>">Remove</a>
                        </td>
                    </tr>
                    
                    <% 
                       }
                    
                    
          
                %>
              
               
                    
                    
                   
                </tbody>
            </table>
                
                
                
                 <a class="btn btn-danger" href="Controlador?accion=inicio">Salir</a>
        </div>
    </body>
</html>