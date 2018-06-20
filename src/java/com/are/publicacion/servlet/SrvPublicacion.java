/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.are.publicacion.servlet;

import com.are.publicacion.controlador.ObtenerJSONPublicacion;
import com.are.publicacion.entidades.Publicacion;
import com.are.publicacion.entidades.PublicacionResult;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aimer
 */
@WebServlet(name = "SrvPublicacion", urlPatterns = {"/rest/publicacion"})
public class SrvPublicacion extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            if (request.getParameter("nic") == null) {
                out.print("Parametro NIC no recibido");
                return;
            }
            
            String nic = (String)request.getParameter("nic");
            
            if (nic.equals("")) {
                out.print("Parametro NIC no válido");
                return;
            }
            Gson gson = new Gson();
            ObtenerJSONPublicacion controlador = new ObtenerJSONPublicacion();
            String url = "http://hgielectricaribe.com.co:8080/WsHgi/rest/publicacion?nic=" + nic;
            String json = controlador.getJsonActas(url);
            if (!controlador.isError()) {
                PublicacionResult result = gson.fromJson(json, PublicacionResult.class);
                if (result != null) {
                    if (!result.isError()) {
                        if (result.isEncontrado()) {
                            // Se encontraron publicaciones
                            ArrayList<Publicacion> publicaciones = result.getPublicaciones();
                            if (publicaciones.size() > 0 ) {
                                for (Publicacion pub : publicaciones ) {
                                // construir el HTM de la vista de publicaciones
                                    out.print("<div class=\"panel panel-default\">");
                                    out.print("<div class=\"panel-heading\">Publicacion Expediente No. "+  pub.getActa() + pub.getNic() + "</div>");
                                    out.print("<div class=\"panel-body\">");
                                    out.print("<div class=\"row\">");
                                    
                                    out.print("<div class=\"col-lg-2\">");
                                    out.print("<a href=\"http://hgielectricaribe.com.co:8080/WsHgi/SrvDescargarAll?id=" + pub.getActa() +"\" title=\"Descargar\" alt=\"Descargar\"><img src=\"images/pdf.png\"></a>");
                                    out.print("</div>"); // fin col1
                                    
                                    out.print("<div class=\"col-lg-8\">");
                                    
                                    out.print("<p><strong>RADICADO</strong>: " + pub.getActa() + pub.getNic() +"</p>" );
                                    out.print("<p><strong>DEPARTAMENTO</strong>: " + pub.getDepartamento() +"</p>" );
                                    out.print("<p><strong>MUNICIPIO</strong>: " + pub.getMunicipio() +"</p>" );
                                    out.print("<p><strong>LOCALIDAD</strong>: " + pub.getLocalidad() +"</p>" );
                                    out.print("<p><strong>FECHA INICIO:</strong> " + pub.getFecha() +"</p>" );
                                    out.print("<p><strong>FECHA DEV. MENSAJERIA</strong>: " + pub.getFechaDevolucion() +"</p>" );
                                    
                                    out.print("</div>"); // fin col2
                                    
                                    out.print("</div>"); // fin row
                                    out.print("</div>"); // fin panel body
                                    out.print("</div>"); // fin panel

                                }
                            
                            }else {
                                out.print("No se encontraron publicaciones");
                            }
                            
                        }else {
                            out.print("No se encontraron publicaciones");
                        }
                        
                    }else {
                        out.print(result.getMsgError());
                    }
                
                
                }else {
                    out.print("Respuesta no válida, comunicarse con el administrador del sistema");
                }
            }else {
                out.print("Error: " + controlador.getErrorMsg());
            }
            
            
            
            
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
