<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>PhraseApp - i18n</title>
</head>
<body>
<h2>
    <fmt:message key="label.welcome"/>
</h2>
<a href="requestLocale.jsp?lang=en">to request Locale<a/>
    <br/>
    <a href="sessionLocale.jsp?lang=en">to session Locale<a/>
        <br/>
        <a href="cookieLocale.jsp?lang=en">to cookieLocale Locale<a/>
            <br/>
            <a href="changeLocale.jsp?lang=en">to changeLocale Locale<a/>
</body>
</html>