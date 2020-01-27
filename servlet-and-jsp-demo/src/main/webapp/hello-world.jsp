<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>

<h1>Hello World from html</h1>

<h1>
    <%
        int a = 1 * 8;
        out.write("Hello World from skryptlet" + a);
        out.println("printline");
        for (int i = 0 ; i< 10; i++){
            out.write("Hello World from skryptlet" + i + "</br>");
        }
    %>
</h1>
</body>
</html>
