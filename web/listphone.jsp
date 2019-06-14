<%@ page import="entity.Phone" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 6/14/2019
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Phone> phones = (ArrayList<Phone>)request.getAttribute("phones");
    if (phones == null) {
        phones = new ArrayList<>();
    }
%>
<html>
<head>
    <title>List Phone</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<a href="/add">Add Phone</a>
<h2>List Phone</h2>

<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Brand</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <%if (phones.size() > 0) {%>
    <%for (Phone phone: phones) {%>
        <tr>
            <th><%=phone.getId()%></th>
            <td><%=phone.getName()%></td>
            <td><%=phone.getBrand()%></td>
            <td><%=phone.getPrice()%></td>
            <td><%=phone.getDescription()%></td>
        </tr>
    <%}%>
    <%}%>
</table>
</body>
</html>
