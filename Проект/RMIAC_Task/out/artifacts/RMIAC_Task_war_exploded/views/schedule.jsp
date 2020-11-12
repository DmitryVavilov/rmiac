<%@ page import="entities.Number" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расписание приемов</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/style/style.css">
</head>
<body>
    <h2>Расписание приемов</h2>
    <div>
        <p>Ниже вы можете видеть расписание приемов в больницах и их статус.</p>
    </div>
    <div>
        <table>
            <tr>
                <td>Дата</td>
                <td>Время</td>
                <td>Больница</td>
                <td>Доктор</td>
                <td>Статус</td>
            </tr>
            <%
                List<Number> schedule = (List<Number>) request.getAttribute("schedule");
                if (schedule != null && !schedule.isEmpty()) {
                    for (Number s : schedule) {
                        out.println("<tr>" + "<td>" + s.getDate() + "</td>"
                                + "<td>" + s.getTime() + "</td>"
                                + "<td>" + s.getHospital() + "</td>"
                                + "<td>" + s.getDoctorName() + "</td>"
                                + "<td>" + s.getStatus() + "</td>" + "</tr>");
                    }
                } else out.println("<p>На данный момент никаких приемов не запланировано!</p>");
            %>
        </table>
    </div>
    <div>
        <button onclick="location.href='/check'">Записаться на прием</button>
    </div>
    <div>
        <button onclick="location.href='/'">Вернуться на главную страницу</button>
    </div>
</body>
</html>