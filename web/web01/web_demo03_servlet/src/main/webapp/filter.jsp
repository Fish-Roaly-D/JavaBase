<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/filterServlet" id="form" method="post">
    测试过滤器：<input type="text" name="keyWorld" id="keyWorld"/>
    <input type="submit" value="提交">
</form>

</body>
</html>
