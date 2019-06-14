<%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 6/14/2019
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Phone</title>
</head>
<body>
<a href="/list">List Phone</a>
<form action="/add" method="post">
    Name: <input type="text" name="name" required><br>
    Brand:  <select name="brand" required>
                <option value="">Select brand</option>
                <option value="Apple">Apple</option>
                <option value="Samsung">Samsung</option>
                <option value="Nokia">Nokia</option>
                <option value="Others">Others</option>
            </select><br>
    Price: <input type="number" name="price" min="0" required><br>
    Description: <input type="text" name="description" required><br>
    <button type="submit">Submit</button>
    <button type="reset">Reset</button>
</form>
</body>
</html>
