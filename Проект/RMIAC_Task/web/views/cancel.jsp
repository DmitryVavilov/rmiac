<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отмена записи</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/style/style.css">
</head>
<body>
    <h2>Отмена записи</h2>
    <div>
        <p>Здесь вы можете отменить своб запись на прием.</p>
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
        <label>Болница:
            <input type="text" name="hospital"><br />
        </label>
        <label>Врач:
            <input type="text" name="doctorName"><br />
        </label>
        <button type="submit">Отменить запись</button>
    </form>
    <div>
        <button onclick="location.href='/'">Вернуться на главную страницу</button>
    </div>
</body>
</html>