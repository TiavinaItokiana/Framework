<%@ page language="java" contentType="text/html" import="java.util.*,model.*" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List</title>
</head>
<body>
    <h1>Liste des emplpoyee</h1>
    <%
        List<Emp> data = (List<Emp>) request.getAttribute("list");
        for(Emp d : data)
        {
            %>
            <p> Employer : <%out.println (d.getId());%> </p>
            <p> Nom : <%out.println (d.getNom());%> </p>
            <%
        }
    %>
</body>
</html>