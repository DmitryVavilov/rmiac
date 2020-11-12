<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Количество врачей без записи</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/style/style.css">
</head>
<body>
<h2>Врачи без записей</h2>
<form method="post">
    <label>Больница:
        <input type="text" name="hospital"><br />
    </label>
    <label>Дата 1:
        <input type="text" name="date1"><br />
    </label>
    <label>Дата 2:
        <input type="text" name="date2"><br />
    </label>
    <button type="submit">Результат</button>
</form>
<div>
    <button onclick="location.href='/'">Вернуться на главную страницу</button>
</div>
</body>
</html>