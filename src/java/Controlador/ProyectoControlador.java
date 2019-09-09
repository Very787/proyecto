/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proyecto;
import ModeloDAO.ProyectoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Verito
 */
public class ProyectoControlador extends HttpServlet {

    String listar="vistas/proyecto/listarproyecto.jsp";
    String add="vistas/proyecto/addproyecto.jsp";
    String edit="vistas/proyecto/editproyecto.jsp";
    Proyecto p=new Proyecto();
    ProyectoDAO dao=new ProyectoDAO();
    int idpro;
    int id;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProyectoControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProyectoControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listarproyecto")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("addproyecto")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String desc=request.getParameter("txtDesc");
            int idusua=Integer.parseInt(request.getParameter("txtId"));
            p.setDesc(desc);
            p.setId(idusua);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idpro",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            idpro=Integer.parseInt(request.getParameter("txtIdpro"));
            String desc=request.getParameter("txtDesc");
            id=Integer.parseInt(request.getParameter("txtId"));
            p.setIdpro(idpro);
            p.setDesc(desc);
            p.setId(id);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            idpro=Integer.parseInt(request.getParameter("id"));
            p.setIdpro(idpro);
            dao.eliminar(idpro);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
