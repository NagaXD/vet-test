<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor Details</title>
</head>
<body>
    <h1>Doctor Details</h1>
    <p>ID: ${doctor.id}</p>
    <p>Name: ${doctor.name}</p>
    <p>Last Name: ${doctor.lastName}</p>
    <p>Second Last Name: ${doctor.secondLastName}</p>
    <p>Professional ID: ${doctor.professionalId}</p>

    <a href="/doctor/${doctor.id}/edit">Edit</a>
    <a href="/doctor/${doctor.id}/delete">Delete</a>
</body>
</html>