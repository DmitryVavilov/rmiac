package servlets;

import entities.DB;
import entities.Patient;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/check.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        try {
            String surname = req.getParameter("surname");
            int policy = Integer.parseInt(req.getParameter("policy"));
            Patient patient = DB.checkPatient(surname, policy);
            if (patient != null){
                resp.sendRedirect(req.getContextPath() + "/appointment");
            }
            else {
                resp.sendRedirect(req.getContextPath() + "/views/error.jsp");
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
}