<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA. User: user Date: 2019/11/28 Time: 2:12 오후 To
change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <jsp:include page="../include/header.jsp"/>
        <section class="section" align="center">
            <div style="font-weight: bold">캐릭터 정보</div>
            <div class="character-view">
            </div>
        </section>

        <jsp:include page="../include/footer.jsp"/>

    <script type="text/javascript">
      $(document).ready(function () {
          var content = $(".character-view");
          var jsonData = ${detail.body};

          console.log(jsonData.characterId);

          var serverId = '${serverId}';
          var characterId = jsonData.characterId;
          var characterName = jsonData.characterName;
          var level = jsonData.level;
          var jobGrowName = jsonData.jobGrowName;
          var adventureName = function() {
              if (jsonData.adventureName != null) {
                  return jsonData.adventureName;
              } else {
                  return "없음";
              }
          }

          var detail_view = '<div class="character"><div class="character-img"><img style="width:220px;height:290px; background-image: URL(\'http://cdn.df.nexon.com/img/web/char/bg_char.jpg\');" src="https://img-api.neople.co.kr/df/servers/' + serverId + '/characters/' + characterId + '?zoom=1" alt="" srcset=""></div>';
          detail_view += '<div>' + level + " / " + characterName +' / ';
          detail_view +=  jobGrowName +'</div>' + '<div> 모험단 - ' + adventureName() + '</div></div>';

          content.html(detail_view);


          $("#searchForm").on("submit", function(event) {
              event.preventDefault();
              var searchInput = $("#searchInput").val();

              $.ajax({
                  url: "/search?characterName=" + searchInput,
                  method: "GET",
                  dataType: "json",
                  success: function(data) {
                      $(".content > div").remove();
                      console.log(data);
                      console.log(data.rows[0].jobGrowName);
                      jsonData = data;
                      // i : index / v : value
                      $.each(jsonData.rows, function (i, v) {
                          console.log(v.characterId);
                          var str = '<div class="character"><div class="character-img"><img src="https://img-api.neople.co.kr/df/servers/' + v.serverId + '/characters/' + v.characterId + '?zoom=1" alt="" srcset=""></div>';
                          str += '<div>Level:' + v.level + "<br>" + v.characterName +'</div>';
                          str += '<div>' + v.jobGrowName +'</div></div>';

                          content.append(str);

                      });
                  }
              });
          });





      });
    </script>
  </body>
</html>