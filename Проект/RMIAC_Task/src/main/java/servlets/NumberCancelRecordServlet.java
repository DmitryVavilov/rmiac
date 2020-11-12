package servlets;

import entities.DB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cancelrecord")
public class NumberCancelRecordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/numbercancelrecord.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        try {
            String hospital = req.getParameter("hospital");
            String date1 = req.getParameter("date1");
            String date2 = req.getParameter("date2");
            int[]  mass = DB.numberCancelRecord(hospital, date1, date2);
            writer.println("<p>Число записей: " + mass[0] + "</p>");
            writer.println("<p>Число отмен: "+ mass[1] + "</p>");
            writer.println("<button onclick=location.href='/'>Вернуться на главную страницу" + "</button>");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
}