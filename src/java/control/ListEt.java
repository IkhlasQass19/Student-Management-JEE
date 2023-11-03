
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
 * @author kh
 */
@WebServlet(name = "ListEt", urlPatterns = {"/ListEt"})
public class ListEt extends HttpServlet {
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
       String sem = (String)request.getParameter("sem");
       String p2 = getServletContext().getRealPath("/WEB-INF/BDSW.xml"); 
       String p = getServletContext().getRealPath("/listeEtudiants.json");
       Trai f = new Trai();
        try {
            f.getEtListesSemestre(p, p2, sem);
        } catch (JDOMException ex) {
            Logger.getLogger(ListEt.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listeEtudiants.json");
               rd.forward(request, response);
    }


}
