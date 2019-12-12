<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <jsp:include page="../include/header.jsp"/>
    <div class="main-search" align="center">
        <form class="search-form form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" id="searchInput" type="search" placeholder="캐릭터 명을 입력하세요 !" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0 btn-search" type="button">검색</button>
        </form>
    </div>

        <div class="content">
        </div>
        <div class="loader" align="center" style="display: none;">
            <button class="btn btn-primary" type="button" disabled>
                <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>
                Loading...
            </button>
        </div>

        <jsp:include page="../include/footer.jsp"/>
    <script type="text/javascript">
      $(document).ready(function () {
          var content = $(".content");
          var loading = $(".loader");
          var jsonData;

          function serverIdChange(myKey) {
              var kvArray = [
                  ["anton", "안톤"],
                  ["bakal", "바칼"],
                  ["cain", "카인"],
                  ["casillas", "카시야스"],
                  ["diregie", "디레지에"],
                  ["hilder", "힐더"],
                  ["prey", "프레이"],
                  ["siroco", "시로코"]];

              var myMap = new Map(kvArray);
              return myMap.get(myKey);
          }

          $(".btn-search").on("click", function(event) {
              // event.preventDefault();
              var searchInput = $("#searchInput").val().trim();
              if (searchInput === "" || searchInput.length == 0) {
                  alert("캐릭터 명을 입력해주세요 ! ");
                  return false;
              }

              content.hide();
              loading.show();

              $.ajax({
                  url: "/search?characterName=" + searchInput,
                  method: "GET",
                  dataType: "json",
                  success: function(data) {
                      $(".content > div").remove();
                      // console.log(data);
                      // console.log(data.rows[0].jobGrowName);

                      jsonData = data;
                      // i : index / v : value
                      $.each(jsonData.rows, function (i, v) {
                          console.log(v.serverId);
                          var str = '<div class="character"><div class="character-img"><img src="https://img-api.neople.co.kr/df/servers/' + v.serverId + '/characters/' + v.characterId + '?zoom=1" alt="" srcset=""></div>';
                          str += '<div>Level:' + v.level + "<br>" + serverIdChange(v.serverId) + " - " + '<a href="/view?serverId=' + v.serverId + '&characterId=' + v.characterId + '">' + v.characterName +'</a></div>';
                          str += '<div>' + v.jobGrowName +'</div></div>';

                          content.append(str);
                          loading.hide();
                          content.show();
                      });
                  }
              });
          });


      });
    </script>
  </body>
</html>