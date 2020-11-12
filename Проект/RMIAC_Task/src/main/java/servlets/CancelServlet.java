package servlets;

import entities.DB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cancel")
public class CancelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/cancel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        try {
            int policy = Integer.parseInt(req.getParameter("policy"));
            String date = req.getParameter("date");
            String time = req.getParameter("time");
            String hospital = req.getParameter("hospital");
            String doctorName = req.getParameter("doctorName");
            if (DB.cancelAppointment(policy, date, time, hospital, doctorName) > 0){
                resp.sendRedirect(req.getContextPath() + "/views/success.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/views/error.jsp");
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
}