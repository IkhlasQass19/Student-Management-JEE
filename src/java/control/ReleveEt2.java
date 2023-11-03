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

@WebServlet(name = "ReleveEt2", urlPatterns = {"/ReleveEt2"})
public class ReleveEt2 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        doPost(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession maSession = request.getSession();
        String cne = (String) request.getParameter("etud");
        String sem = (String) request.getParameter("sem");
        String nom = (String) request.getParameter("nom");
        String prenom = (String) request.getParameter("prenom");
        if (!cne.equalsIgnoreCase("") && !sem.equalsIgnoreCase("") && cne != null && sem != null) {

            String p2 = getServletContext().getRealPath("/WEB-INF/BDSW.xml");

            String p = getServletContext().getRealPath("/releveNoteEtudiant.xml");
            Trai f = new Trai();

            try {
                f.enrgNoteSemestre(p, sem, cne, p2, nom, prenom);
            } catch (JDOMException ex) {
                Logger.getLogger(ReleveEt2.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/releveNoteEtudiant.xml");
            rd.forward(request, response);

        }

    }
}
