
package control;

import Model.Etudiants;
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

@WebServlet(name = "RelvenoteET", urlPatterns = {"/RelvenoteET"})
public class RelvenoteET extends HttpServlet {

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
        String cne = (String) request.getParameter("cne");
        String sem = (String) request.getParameter("sem");
        String nom = "";
        String prenom = "";
        Trai f = new Trai();

        if (!cne.equalsIgnoreCase("") && !sem.equalsIgnoreCase("") && cne != null && sem != null) {

            String p = getServletContext().getRealPath("/releveNoteEtudiant.xml");

            String p2 = getServletContext().getRealPath("/WEB-INF/BDSW.xml");
            try {
                Etudiants etudiant = f.getEtudiant(p2, cne);
                nom = etudiant.getNom();
                prenom = etudiant.getPrenom();
                f.enrgNoteSemestre(p, sem, cne, p2, nom, prenom);
            } catch (JDOMException ex) {
                Logger.getLogger(RelvenoteET.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/releveNoteEtudiant.xml");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pageAd2.jsp");
            rd.forward(request, response);
        }

    }

}
