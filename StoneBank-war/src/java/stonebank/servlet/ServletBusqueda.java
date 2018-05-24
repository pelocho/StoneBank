/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stonebank.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import stonebank.ejb.TmovimientoFacade;
import stonebank.entity.Tmovimiento;
import stonebank.entity.Tusuario;

/**
 *
 * @author Eduardo Pertierra Puche
 */
//@WebServlet(name = "ServletBusqueda", urlPatterns = {"/usuario/ServletBusqueda"})
public class ServletBusqueda extends HttpServlet {

    @EJB
    private TmovimientoFacade tmovimientoFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String concepto = request.getParameter("parametrobusqueda");
        Tusuario usuario = (Tusuario) session.getAttribute("usuarioLogin");
        Integer dni = usuario.getDniUsuario();
        String mensaje = "Busqueda por el usuario con DNI: " + dni + " con el concepto: " + concepto;
        request.setAttribute("mensaje", mensaje);
        List<Tmovimiento> listamov = tmovimientoFacade.buscarMovimientoPorConceptoYDNI(concepto, dni);

        request.setAttribute("listaMovimientos", listamov);
        //Esto deberia dispatchear a listamovimientos 
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/usuario/historialMovimientos.jsp");
        rd.forward(request, response);
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
