package control;

import Model.Admin;
import Model.Etudiants;
import Model.Module;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author kh
 */
@WebServlet(name = "connexion", urlPatterns = {"/connexion"})
public class connexion extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            control.Trai fonction = new control.Trai();
            String login = (String) request.getParameter("id");
            String pass = (String) request.getParameter("password");
            SAXBuilder builder = new SAXBuilder();
            String p = getServletContext().getRealPath("/WEB-INF/BDSW.xml");
            Etudiants et;
            Admin ad;
            Document document = builder.build(new File(p));
            boolean test = false;
            boolean test2 = false;
            List<Element> t = document.getRootElement().getChild("Etudiants").getChildren("Etudiant");

            List<Element> t2 = document.getRootElement().getChild("Admin").getChildren("Admin");
            for (Element table : t) {
                System.out.println("la taille du t" + t.size());
                if (table.getAttributeValue("CIN").toString().equalsIgnoreCase(login) && table.getAttributeValue("password").toString().equalsIgnoreCase(pass)) {
                    test = true;

                    et = new Etudiants(table.getAttributeValue("CNE").toString(), Integer.parseInt(table.getAttributeValue("Apogee").toString()), table.getAttributeValue("Nom").toString(), table.getAttributeValue("Prenom").toString(), table.getAttributeValue("CIN").toString(), pass, table.getAttributeValue("sexe").toString(), table.getAttributeValue("DateN").toString());
                    HttpSession maSession = request.getSession();
                    Map<String, String[][]> map = fonction.getModSem(p, et);
                    maSession.setAttribute("et", et);
                    maSession.setAttribute("map", map);
                    break;
                }
            }
            for (Element table : t2) {
                System.out.println("la taille du t2" + t2.size());
                if (table.getAttributeValue("CIN").toString().equalsIgnoreCase(login) && table.getAttributeValue("Password").toString().equalsIgnoreCase(pass)) {
                    test2 = true;
                    ad = new Admin(Integer.parseInt(table.getAttributeValue("SOM").toString()), table.getAttributeValue("Nom").toString(), table.getAttributeValue("Prenom").toString(), table.getAttributeValue("Password").toString(), table.getAttributeValue("CIN").toString());
                    HttpSession maSession = request.getSession();
                    List<Module> l = fonction.getModules(p);
                    maSession.setAttribute("ad", ad);
                    maSession.setAttribute("l", l);
                    break;
                }
            }

            if (test) {

                getServletContext().getRequestDispatcher("/page.jsp").forward(request, response);
            }
            if (test2) {

                getServletContext().getRequestDispatcher("/pageAd2.jsp").forward(request, response);
            }
            else
            {
                System.out.println("incorect"+ t2.size());
            }
        } catch (JDOMException ex) {
            Logger.getLogger(control.NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
