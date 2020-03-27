/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Recetario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serviciosweb.Receta;
import serviciosweb.ServicioWebRecetario;
import serviciosweb.ServicioWebRecetario_Service;

/**
 *
 * @author darth
 */
@WebServlet(name="obtenerReceta", urlPatterns={"/obtenerReceta"})
public class obtenerRecetaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // no se si va dentro o fuera del try
        ServicioWebRecetario_Service servicioWebRecetario_Service = new ServicioWebRecetario_Service();
        
        //mal
        ServicioWebRecetario SWRPort = (ServicioWebRecetario) servicioWebRecetario_Service.getServicioWebRecetarioPort().obtenerReceta("Lasanna");
        
        Receta receta = new Receta();
        String nombre = request.getParameter("nombre");
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Obtener Receta</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<ul>");
            out.println("<li><b>Nombre:</b> " + receta.getNombre() + "</li>");
            out.println("<li><b>Tipo:</b> " + receta.getDificultad() + "</li>");
            out.println("<li><b>Equipos:</b> " + receta.getIngrediente() + "</li>");
            out.println("<li><b>Tamaño equipo:</b> " + receta.getPrecio() + "</li>");
            out.println("</ul>");
            
            // poner aqui lo de a href.. para volver al menu
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
