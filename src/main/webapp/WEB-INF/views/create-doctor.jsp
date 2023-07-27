<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Doctor</title>
</head>
<body>
    <h1>Create Doctor</h1>
    <form method="post" action="/api/v1/doctor">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" required><br>

        <label for="secondLastName">Second Last Name:</label>
        <input type="text" name="secondLastName" required><br>

        <label for="professionalId">Professional ID:</label>
        <input type="text" name="professionalId" required><br>

        <input type="submit" value="Create">
    </form>
</body>
</html>