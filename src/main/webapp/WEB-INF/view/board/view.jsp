<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/12/01
  Time: 5:29 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="../include/header.jsp"/>
<body>
    <h3>제목 : <c:out value="${boardDTO.title}"/></h3>
    <p>내용 : <c:out value="${boardDTO.content}"/></p>
    <div>
        작성자 : <c:out value="${boardDTO.writer}"/>
    </div>
    <div>
        작성날짜 : <c:out value="${boardDTO.toStringDateTime(boardDTO.createdAt)}" />
    </div>
    <c:choose>
        <c:when test="${not empty boardDTO.updatedAt}">
            <div>
                최근 수정날짜 : <c:out value="${boardDTO.toStringDateTime(boardDTO.updatedAt)}" />
            </div>
        </c:when>
    </c:choose>
    <jsp:include page="../include/footer.jsp" />
</body>
</html>
