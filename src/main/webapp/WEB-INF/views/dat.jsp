<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <h2>List of notable developers:</h2>
        <table border="1">

            <th>Dev id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Title</th>
            <th>Salary</th>
            <th>Location</th>

            <c:forEach var="dev" items="${listDev}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${dev.fname}</td>
                    <td>${dev.lname}</td>
                    <td>${dev.title}</td>
                    <td>${dev.salary}</td>
                    <td>${dev.location}</td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="/signup">Add a new developer</a></p>
        <p><a href="/">Return to Home</a></p>
    </body>
</html>
