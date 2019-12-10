<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/11/25
  Time: 11:04 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>

<body>
<div class="table-boardList">
    <table class="table table-striped">
        <tbody>
            <thead>
            <tr>
                <th scope="col" colspan="2">제목</th>
                <th scope="col" colspan="1">작성자</th>
                <th scope="col" colspan="1">작성날짜</th>
            </tr>
            </thead>
    <c:forEach var="boardDTO" items="${boardList}">
        <tr>
            <td colspan="2"><a href="/board/view?bno=<c:out value="${boardDTO.bno}"/>"><c:out value="${boardDTO.title}"/></a></td>
            <td><c:out value="${boardDTO.writer}"/></td>
            <td><c:out value="${boardDTO.toStringDateTime(boardDTO.createdAt)}"/></td>
        </tr>
    </c:forEach>
    </table>
    <div class="btn-write" align="right">
        <button type="button" class="btn btn-primary"><a href="/board/write">글작성</a></button>
    </div>
    <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <c:if test="${pageMaker.prev}">
                    <li class="page-item"><a class="page-link" href="/board?page=${pageMaker.startPage - 1}">이전</a> </li>
                </c:if>
                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                    <li class="page-item" <c:out value="${pageMaker.criteria.page == idx ? 'active' : ''}" />>
                        <a class="page-link" href="/board?page=${idx}">${idx}</a>
                    </li>
                </c:forEach>
                <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                    <li class="page-item"><a class="page-link" href="/board?page=${pageMaker.endPage + 1}">다음</a></li>
                </c:if>
            </ul>
    </nav>
</div>
    <c:if test="${empty boardList}">
        ${"No data from controller "}
    </c:if>
    <jsp:include page="../include/footer.jsp"/>
</body>
</html>
