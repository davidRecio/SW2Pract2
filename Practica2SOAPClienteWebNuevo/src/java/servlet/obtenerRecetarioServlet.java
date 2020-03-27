/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


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
@WebServlet(name="obtenerRecetario", urlPatterns={"/obtenerRecetario"})
public class obtenerRecetarioServlet extends HttpServlet {

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
        
        ServicioWebRecetario_Service servicioWebRecetario_Service = new ServicioWebRecetario_Service();
        ServicioWebRecetario SWRPort = servicioWebRecetario_Service.getServicioWebRecetarioPort();
        
        
        response.setContentType("text/html;charset=UTF-8");
        //Mal
        //Return 1 = servicioWebRecetario_Service.getServicioWebRecetarioPort().obtenerRecetario();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Obtener Recetario</title>");            
            out.println("</head>");
            out.println("<body>");
          
            out.println("<h1>Servlet obtenerRecetarioServlet at " + request.getContextPath() + "</h1>");
            //mal
            //mirar
//            for (Receta receta : ServicioWebRecetario.getRecetas()) {
//                out.println("<h3>Nombre de la receta: " + receta.getNombre() + "</h3>");
//                out.println("<h3>Difucultad de la receta: " + receta.getDificultad()+ "</h3>");
//                out.println("<h3>Ingredientes de la receta: " + receta.getIngrediente() + "</h3>");
//                out.println("<h3>Precio de la receta: " + receta.getPrecio() + "</h3>");
//            }
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
