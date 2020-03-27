/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serviciosweb.Receta;
import serviciosweb.Receta.Ingrediente;
import serviciosweb.ServicioWebRecetario;
import serviciosweb.ServicioWebRecetario_Service;

/**
 *
 * @author darth
 */
@WebServlet(name = "crearRecetaServlet", urlPatterns = {"/crearRecetaServlet"})
public class crearRecetaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
        // No se si va aqui o fuera 
        ServicioWebRecetario_Service servicioWebRecetario_Service = new ServicioWebRecetario_Service();
        ServicioWebRecetario SWRPort = servicioWebRecetario_Service.getServicioWebRecetarioPort();
        
        Receta receta = new Receta();
        ArrayList<String> ingrediente = new ArrayList<>();
        
        String nombre = request.getParameter("nombre");
        String dificultad = request.getParameter("dificultad");
        Ingrediente ing = new Ingrediente();
        ing.ingrediente = ingrediente;
        //String ingrediente = request.getParameter("ingrediente");
        ingrediente.add(request.getParameter("ingrediente"));
        
        Double precio = Double.parseDouble(request.getParameter("precio"));
        
        receta.setNombre(nombre);
        receta.setDificultad(dificultad);
        receta.setPrecio(precio);
        
        
        SWRPort.addReceta(receta);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet crearRecetaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletCrear Receta at " + request.getContextPath() + "</h1>");
            
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
