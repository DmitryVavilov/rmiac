<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Проверка записи на прием</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/style/style.css">
</head>
<body>
    <h2>Запись к врачу</h2>
    <div>
        <p>Для записи на прием введите свои фамилию и номер полиса.</p>
    </div>
    <form method="post">
        <label>Фамилия:
            <input type="text" name="surname"><br />
        </label>
        <label>Номер полиса:
            <input type="text" name="policy"><br />
        </label>
        <button type="submit">Далее</button>
    </form>
    <div>
        <button onclick="location.href='/'">Вернуться на главную страницу</button>
    </div>
</body>
</html>