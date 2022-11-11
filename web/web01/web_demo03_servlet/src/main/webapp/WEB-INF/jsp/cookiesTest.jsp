<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie cookie = null;
    Cookie[] cookies = request.getCookies();
    out.println("java代码片段，内置对象获取session" + "<br>");
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            out.print("参数名 : " + cookie.getName());
            out.print("<br>");
            out.print("参数值: " + URLDecoder.decode(cookie.getValue(), "utf-8") + " <br>");
        }
    }
%>
<hr>
<span>el表达式</span>
<ol>
    <li>
        <p>cookie1: ${cookie.cookie1.name}, ${cookie.cookie1.value}</p>
    </li>
    <li>
        <p>cookie2: ${cookie.cookie2.name}, ${cookie.cookie2.value}</p>
    </li>
</ol>
</body>
</html>
