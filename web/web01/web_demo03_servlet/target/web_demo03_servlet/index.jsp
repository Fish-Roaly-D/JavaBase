<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%
    final Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        out.write("cookie name   " + cookie.getName());
        out.write("cookie value  " + cookie.getValue() + "<br>");
        out.flush();
    }
    //关闭jspWriter内置对象，下面内容输出不了
    // out.close();
    // request	javax.servlet.http.HttpServletRequest	获取用户请求信息
    // response	javax.servlet.http.HttpServletResponse	响应客户端请求，并将处理信息返回到客户端
    // out	javax.servlet.jsp.JspWriter	输出内容到 HTML 中
    // session	javax.servlet.http.HttpSession	用来保存用户信息
    // application	javax.servlet.ServletContext	所有用户共享信息
    // config	javax.servlet.ServletConfig	这是一个 Servlet 配置对象，用于 Servlet 和页面的初始化参数
    // pageContext	javax.servlet.jsp.PageContext	JSP 的页面容器，用于访问 page、request、application 和 session 的属性
    // page	javax.servlet.jsp.HttpJspPage	类似于 Java 类的 this 关键字，表示当前 JSP 页面
    // exception	java.lang.Throwable	该对象用于处理 JSP 文件执行时发生的错误和异常；只有在 JSP 页面的 page 指令中指定 isErrorPage 的取值 true 时，才可以在本页面使用 exception 对象。

    final AtomicInteger onlineNum = (AtomicInteger)pageContext.getAttribute("onlineNum");
    out.println(onlineNum.get());

%>

${cookie.name.name}
<br>
${cookie.name.value}

${pageContext.session.getAttribute("browser")}

<form action="${pageContext.request.contextPath}/sessionApi" id="form" method="post">
    浏览器名称：<input type="text" name="browser" id="browser"/>
    <input type="submit" value="提交">
    <input type="button" onclick="submit()" value="提交">
</form>

${pageContext.getAttribute("onlineNum")}

<script>
    function submit() {
        document.getElementById("form").submit();
    }
</script>
</body>
</html>
