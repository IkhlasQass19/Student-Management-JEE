/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom2.JDOMException;

/**
 *
 * @author ikhlas
 */
@WebServlet(name = "NoteParModule", urlPatterns = {"/NoteParModule"})
public class NoteParModule extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
       HttpSession  maSession = request.getSession();
       String id = (String)request.getParameter("id");
       Trai f = new Trai();
       String p = getServletContext().getRealPath("/moduleNote.xml");
       String p2 = getServletContext().getRealPath("/WEB-INF/BDSW.xml");
        try {
            f.enrgModuleNote(id, p, p2);
        } catch (JDOMException ex) {
            Logger.getLogger(NoteParModule.class.getName()).log(Level.SEVERE, null, ex);
        }
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/moduleNote.xml");
               rd.forward(request, response);     
    }

}
