<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/12/05
  Time: 2:07 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/header.jsp" />
<body>
<form action="/member/register" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">이메일 주소</label>
        <input type="email" class="form-control" id="exampleInputEmail1" name="account" aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted">이메일 주소를 입력해주세요 ! </small>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">닉네임</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="nickname" aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted">커뮤니티에서 사용할 닉네임(별명)을 입력해주세요 !</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">비밀번호</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password">
    </div>
    <button type="submit" class="btn btn-primary">가입하기</button>
</form>


<jsp:include page="../include/footer.jsp" />
</body>
</html>
