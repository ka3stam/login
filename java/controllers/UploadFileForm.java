/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author matina
 */
@WebServlet(name = "UploadFileForm", urlPatterns = {"/uploadfileform"})
@MultipartConfig( fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadFileForm extends HttpServlet {

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
        
        final Part filepart = request.getPart("myfile"); //i klasi pou dexetai ta panta apo uploads
        final String filename = filepart.getSubmittedFileName(); //pairnei tin onomasia mazi me tin katali3i
        
        filepart.write("/Users/matina/NetBeansProjects/ListWithCRUDoptions/web/uploads/" + filename);//an 8eloume na to apo8ikeusoume se ena arxeio ston upologisti
        //to antikeimeno pou anebazei o xristis apo8ikeutai se ena antikeimeno Part, to eixa se antikeimeno Part k twra t exw se antikeimeno File
        File f = new File("/Users/matina/NetBeansProjects/ListWithCRUDoptions/web/uploads/" + filename);
        //pinakas me pedio blob - kalutera Long Blob
//        prepareStatement stm=null;
//        stm = con.prepareStament(sql);
//        stm.setBlob(1,filepart.getInputStream());//an 8eloume na to apo8ikeusoume sti basi
//        stm.setString(2,filename);
//        stm.executeUpadate();
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadFileForm</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadFileForm at " + request.getContextPath() + "</h1>");
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
    
}
