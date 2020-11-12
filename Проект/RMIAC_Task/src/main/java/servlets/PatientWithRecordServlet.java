package servlets;

import entities.DB;
import entities.PatientWithRecord;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/patientwithrecord")
public class PatientWithRecordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/patientwithrecord.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        ArrayList<PatientWithRecord> patientList = new ArrayList<>();
        try {
            String date = req.getParameter("date");
            patientList = DB.listPatientRecordOnDate(date);
            writer.println("<table style=border-color: black; border=1>" +
                            "<tr>" + "<td>Фамилия</td>" +
                            "<td>Имя</td>" +
                            "<td>Отчество</td>" +
                            "<td>Номер полиса</td>" +
                            "<td>Больница</td>" +
                            "<td>Дата</td>" +
                            "<td>Время</td>" + "</tr>");
            if (patientList != null && !patientList.isEmpty()) {
                for (PatientWithRecord s : patientList) {
                    writer.println("<tr>" + "<td>" + s.getSurname() + "</td>"
                            + "<td>" + s.getName() + "</td>"
                            + "<td>" + s.getPatronymic() + "</td>"
                            + "<td>" + s.getPolicy() + "</td>"
                            + "<td>" + s.getHospital() + "</td>"
                            + "<td>" + s.getDate() + "</td>"
                            + "<td>" + s.getTime() + "</td>" + "</tr>");
                }
                writer.println("</table>");
            } else {
                writer.println("<p>На данный момент нет записанных пациентов!</p>");
            }
            writer.println("<button onclick=location.href='/'>Вернуться на главную страницу" + "</button>");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
}