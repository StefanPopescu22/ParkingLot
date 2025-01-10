<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">

  <form method="POST" action="${pageContext.request.contextPath}/Users">
    <table>
      <tr>
        <th>Select</th>
        <th>Username</th>
      </tr>
      <c:forEach var="user" items="${users}">
        <tr>
          <td><input type="checkbox" name="user_ids" value="${user.id}" /></td>
          <td>${user.name}</td>
        </tr>
      </c:forEach>
    </table>
    <button type="submit">Invoice</button>
  </form>

  <h2>Selected Users for Invoices</h2>
  <c:if test="${!empty userIds}">
    <ul>
      <c:forEach var="userId" items="${userIds}">
        <li>User ID: ${userId}</li>
      </c:forEach>
    </ul>
  </c:if>

</t:pageTemplate>
