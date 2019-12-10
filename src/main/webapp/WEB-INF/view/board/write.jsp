<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/11/30
  Time: 11:05 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="../include/header.jsp"/>
<body>
    <form id="form-write" action="/board/write" method="post">
        <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name="title" id="form-title" aria-describedby="emailHelp">
            <small id="emailHelp" class="text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label>작성자</label>
            <input type="text" class="form-control" name="writer" id="form-writer" aria-describedby="emailHelp" value="<c:out value="${member}"/>" readonly>
        </div>
        <div class="form-group">
            <label>글 내용</label>
            <textarea type="text" class="form-control" name="content" id="form-content" row="3"></textarea>
        </div>
        <button type="button" class="btn btn-danger btn-cancle">취소</button>
        <button type="button" class="btn btn-primary btn-submit">작성하기</button>
    </form>
    <jsp:include page="../include/footer.jsp" />


    <script type="text/javascript">
        $(function () {
            $(".btn-submit").click(function (e) {
                e.preventDefault();
                var title = $("#form-title").val();
                var writer = $("#form-writer").val();
                var content = $("#form-content").val();

                if (title === "" || title.length == 0) {
                    alert("제목을 입력하세요 ! ");
                    $("#form-title").focus();
                    return false;
                } else if (content === "" || content.length == 0) {
                    alert("내용을 입력하세요 ! ");
                    $("#form-content").focus();
                    return false;
                } else if (writer === "" || writer.length == 0) {
                    alert("작성자를 입력하세요 ! ");
                    $("#form-content");
                    return false;
                } else {
                    $("#form-write").submit();
                }
            });

            $(".btn-cancle").click(function () {
               location.href="/board";
            });
        });
    </script>
</body>
</html>
