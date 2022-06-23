<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form  action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
    <%--<form  action="<c:url value='/save'/>" method='POST'>--%>
    <table>
        <tr>
            <td>Название:</td>
            <td><input type="text" name="name" value="${accident.name}"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td>
                <textarea name="text"
                          style="padding-bottom:250px;
                            font-size:16px;
                            height: 300px;
                            width: 500px;">
                    ${accident.text}
                </textarea>
            </td>
<%--            <td><input type="text" name="text" value="${accident.text}"></td>--%>
        </tr>
        <tr>
            <td>Адрес:</td>
            <td><input type="text" name="address" value="${accident.address}"></td>
        </tr>
        <tr>
            <td>ид:</td>
            <td><input type="text" name="idString" value="${accident.id}"></td>
        </tr>
        <tr>
            <td>Тип:</td>
            <td>
                <select name="type.id">
                    <c:forEach var="type" items="${types}">
                        <c:set var="x" scope="session" value="${type.id}" />
                        <c:set var="y" scope="session" value="${accident.type.id}" />
                        <c:if test="${x eq y}">
                            <option selected value="${type.id}">${type.name}</option>
                        </c:if>
                        <c:if test="${x ne y}">
                            <option value="${type.id}">${type.name}</option>
                        </c:if>

                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Статьи:</td>
            <td>
                <select name="rIds" multiple>
                    <c:forEach var="rule" items="${rules}">
                        <option value="${rule.id}">${rule.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>