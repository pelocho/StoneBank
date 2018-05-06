/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stonebank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import stonebank.ejb.TusuarioFacade;

/**
 *
 * @author Victor
 * 
 * Este Servlet sólo sirve para filtrar usuarios desde la vista principal de empleado.
 * No tiene nada que ver con ServletBusqueda creado por Edu
 */
//@WebServlet(name = "ServletBuscarUsuarioEmpleado", urlPatterns = {"/empleado/ServletBuscarUsuarioEmpleado"})
public class ServletBuscarUsuarioEmpleado extends HttpServlet {

    @EJB
    private TusuarioFacade tusuarioFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    //Filtra por nombre y reasigna la lista para enviarla al jsp y que la pinte
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession(); 
            session.setAttribute("listaUsuarios", tusuarioFacade.buscarTUsuarioPorNombre(request.getParameter("nombre")));
            RequestDispatcher rd  = request.getServletContext().getRequestDispatcher("/empleado/indexEmpleadoBusqueda.jsp");
            rd.forward(request, response);
        
            /*
       try (PrintWriter out = response.getWriter()) {
            out.println("hola");
        
        
        
        }
            */
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
        processRequest(request, response);
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
