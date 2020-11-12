<%@ page import="entities.Number" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Запись на прием</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/style/style.css">
</head>
<body>
    <h2>Запись на прием</h2>
    <div>
        <p>Здесь вы можете записаться на прием.</p>
    </div>
    <form method="post">
        <label>Номер полиса:
            <input type="text" name="policy"><br />
        </label>
        <label>Дата:
            <input type="text" name="date"><br />
        </label>
        <label>Время:
            <input type="text" name="time"><br />
        </label>
        <label>Больница:
            <input type="text" name="hospital"><br />
        </label>
        <label>Врач:
            <input type="text" name="doctorName"><br />
        </label>
        <button type="submit">Записаться</button>
    </form>
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
        <button onclick="location.href='/'">Вернуться на главную страницу</button>
    </div>
</body>
</html>