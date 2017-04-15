<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp"/>
<script src="https://code.jquery.com/jquery-2.2.0.min.js" integrity="sha256-ihAoc6M/JPfrIiIeayPE9xjin4UWjsx2mjW/rtmxLM4=" crossorigin="anonymous"></script>

<body>
    <img src="assets/images/bg.jpg" style="position:fixed;top:0;left:0;z-index:-5000;">
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a href="Home" class="navbar-brand"><span style="color: #ff0039;">Anny</span>MUSIC <i class="fa fa-headphones" aria-hidden="true"></i></a>
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse" id="navbar-main">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="AllSong">ฟังเพลง</a>
                    </li>
                    <li>
                        <a href="Search">ค้นหาเพลง</a>
                    </li>
                </ul>

            </div>
        </div>
    </div>
    <div class="container" style="margin-top:70px;">
        <div class="row">
            <div class="col-xs-12 col-sm-12">
                <div class="menutopsong">
                    <a class="${page == "all" ? "active" : ""}" href="AllSong?tag=all">Top 100 Chart</a>
                    <a class="${page == "allthai" ? "active" : ""}" href="AllSong?tag=allthai">Top 50 เพลงไทย</a>
                    <a class="${page == "allinter" ? "active" : ""}" href="AllSong?tag=allinter">Top 50 เพลงสากล</a>
                    <a class="${page == "alllooktung" ? "active" : ""}" href="AllSong?tag=alllooktung">Top 50 เพลงลูกทุ่ง</a>
                    <a class="${page == "allindy" ? "active" : ""}" href="AllSong?tag=allindy">Top 50 เพลงอินดี้</a>
                </div>
            </div>
            <div class="row"></div>
            <div class="col-sm-12">
                <div class="songs">
                    <h3>รายชื่อเพลง <span style="font-size: 11px; float:none;color: rgba(255, 255, 255, 0.77);">${fn:length(listsong)} เพลง </span><i class="fa fa-music" aria-hidden="true"></i></h3>
                    <div class="col-xs-12 col-sm-12">
                        <div class="post-allsong">
                            <table class="table table-borderless" align="center">
                                <tbody>
                                    <c:choose>
                                        <c:when test="${!empty listsong}">
                                            <c:forEach items="${listsong}" var="song" varStatus="Mycount">
                                                <tr class="listsong" data-pic="${song.songPic}" data-songname="${song.songName}" data-songartist="${song.songArtist}" data-song="${song.songId}">
                                                    <td><span class="label ${Mycount.count <= 3 ? "label-danger" : "label-default"}">${Mycount.count}</span></td>
                                                    <td>${song.songName}</td>
                                                    <td>${song.songArtist}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                    </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row"></div>

        <!--footer-->
        <div class="footer">
            <div class="song">
                <img class="img-circle" src="" id="imgsong" width="50px" height="50px"/>
                <p id="psongname"></p>
                <p id="psongartist"></p>
            </div>
            <div id="myMusic"><a href="Home" class="navbar-brand"><span style="color: #ff0039;">Anny</span>MUSIC <i class="fa fa-headphones" aria-hidden="true"></i></a>
                ฟังเพลงออนไลน์ 24 ชม.</div>

        </div>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="http://cdn.jsdelivr.net/jquery.slick/1.6.0/slick.min.js"></script>
    <script type="text/javascript" src="https://content.jwplatform.com/libraries/t9gWOAS0.js"></script>
    <script type="text/javascript" src="assets/js/jQueryRotate.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('.slide').slick({
                arrows: false,
                autoplay: true,
                autoplaySpeed: 2000
            });
        });

    </script>
    <script type="text/javascript">
        $("tr").click(function() {
            var idsong = $(this).data("song");
            var songname = $(this).data("songname");
            var songartist = $(this).data("songartist");
            var songpic = $(this).data("pic");
            //alert(idsong);
            $.ajax({url: "Testz", data: {id: idsong}, success: function(result) {
                    //$("#data").html(result);
                    //console.log(result);
                    var playerInstance = jwplayer("myMusic");
                    playerInstance.setup({
                        file: result,
                        width: "auto",
                        height: "40px",
                        autostart: true
                    });
                    $('#psongname').text(songname);
                    $('#psongartist').text(songartist);
                    $('#imgsong').attr('src', songpic);
                    $('#imgsong').css('display', 'inline');
                    var angle = 0;
                    setInterval(function() {
                        angle += 3;
                        $("#imgsong").rotate(angle);
                    }, 50);
                }});

        });
    </script>
</body>

</html>

