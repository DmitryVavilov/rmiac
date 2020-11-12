package servlets;

import entities.Number;
import entities.DB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/schedule")
public class ScheduleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Number> schedule = DB.getSchedule();
        req.setAttribute("schedule", schedule);
        getServletContext().getRequestDispatcher("/views/schedule.jsp").forward(req, resp);
    }
}