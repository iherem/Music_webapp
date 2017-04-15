<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${empty newsong}">
    <script>
        window.location = "Home";
    </script>
</c:if>
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
            <div class="col-xs-12 col-sm-9">
                <div class="slide">
                    <div><img src="assets/images/ban1.jpg" style="width:100%;opacity:1;"></div>
                    <div><img src="assets/images/ban2.jpg" style="width:100%;opacity:1;"></div>
                </div>
                <div class="row"></div>
                <div class="songs">
                    <h3>เพลงใหม่ <i class="fa fa-music" aria-hidden="true"></i> <span><a href="AllSong?tag=all">ทั้งหมด <i class="fa fa-sort" aria-hidden="true"></i></a></span></h3>

                    <c:choose>
                        <c:when test="${!empty newsong}">
                            <c:forEach items="${newsong}" var="song" varStatus="Mycount">

                                <div class="col-xs-6 col-sm-3 box">
                                    <div class="post">
                                        <div class="post_img">
                                            <div class="playbg"> </div>
                                            <img src="${song.songPic}"/>
                                            <div class="play">
                                                <a class="musicplay" data-pic="${song.songPic}" data-songname="${song.songName}" data-songartist="${song.songArtist}" data-song="${song.songId}"><i class="fa fa-4x fa-play-circle-o" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <p class="songname"><a href="#">${song.songName}</a></p>
                                        <p class="songartist"><a href="#">${song.songArtist}</a></p>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                </div>
                <div class="row"></div>
                <div class="songs">
                    <h3>Top 50 เพลงไทย <i class="fa fa-music" aria-hidden="true"></i> <span><a href="AllSong?tag=allthai">ทั้งหมด <i class="fa fa-sort" aria-hidden="true"></i></a></span></h3>
                                <c:choose>
                                    <c:when test="${!empty top50thai}">
                                        <c:forEach items="${top50thai}" var="song" varStatus="Mycount">

                                <div class="col-xs-6 col-sm-3 box">
                                    <div class="post">
                                        <div class="post_img">
                                            <div class="playbg"> </div>
                                            <img src="${song.songPic}"/>
                                            <div class="play">
                                                <a class="musicplay" data-pic="${song.songPic}" data-songname="${song.songName}" data-songartist="${song.songArtist}" data-song="${song.songId}"><i class="fa fa-4x fa-play-circle-o" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <p class="songname"><a href="#">${song.songName}</a></p>
                                        <p class="songartist"><a href="#">${song.songArtist}</a></p>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                </div>
                <div class="row"></div>
                <div class="songs">
                    <h3>Top 50 เพลงสากล <i class="fa fa-music" aria-hidden="true"></i> <span><a href="AllSong?tag=inter">ทั้งหมด <i class="fa fa-sort" aria-hidden="true"></i></a></span></h3>
                                <c:choose>
                                    <c:when test="${!empty top50inter}">
                                        <c:forEach items="${top50inter}" var="song" varStatus="Mycount">
                                <div class="col-xs-6 col-sm-3 box">
                                    <div class="post">
                                        <div class="post_img">
                                            <div class="playbg"> </div>
                                            <img src="${song.songPic}"/>
                                            <div class="play">
                                                <a class="musicplay" data-pic="${song.songPic}" data-songname="${song.songName}" data-songartist="${song.songArtist}" data-song="${song.songId}"><i class="fa fa-4x fa-play-circle-o" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <p class="songname"><a href="#">${song.songName}</a></p>
                                        <p class="songartist"><a href="#">${song.songArtist}</a></p>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                </div>
                <div class="row"></div>
                <div class="songs">
                    <h3>Top 50 เพลงลูกทุ่ง <i class="fa fa-music" aria-hidden="true"></i> <span><a href="AllSong?tag=alllooktung">ทั้งหมด <i class="fa fa-sort" aria-hidden="true"></i></a></span></h3>
                                <c:choose>
                                    <c:when test="${!empty top50looktung}">
                                        <c:forEach items="${top50looktung}" var="song" varStatus="Mycount">
                                <div class="col-xs-6 col-sm-3 box">
                                    <div class="post">
                                        <div class="post_img">
                                            <div class="playbg"> </div>
                                            <img src="${song.songPic}"/>
                                            <div class="play">
                                                <a class="musicplay" data-pic="${song.songPic}" data-songname="${song.songName}" data-songartist="${song.songArtist}" data-song="${song.songId}"><i class="fa fa-4x fa-play-circle-o" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <p class="songname"><a href="#">${song.songName}</a></p>
                                        <p class="songartist"><a href="#">${song.songArtist}</a></p>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                </div>
                <div class="row"></div>
                <div class="songs">
                    <h3>Top 50 เพลงอินดี้ <i class="fa fa-music" aria-hidden="true"></i> <span><a href="AllSong?tag=allindy">ทั้งหมด <i class="fa fa-sort" aria-hidden="true"></i></a></span></h3>
                                <c:choose>
                                    <c:when test="${!empty top50indy}">
                                        <c:forEach items="${top50indy}" var="song" varStatus="Mycount">
                                <div class="col-xs-6 col-sm-3 box">
                                    <div class="post">
                                        <div class="post_img">
                                            <div class="playbg"> </div>
                                            <img src="${song.songPic}"/>
                                            <div class="play">
                                                <a class="musicplay" data-pic="${song.songPic}" data-songname="${song.songName}" data-songartist="${song.songArtist}" data-song="${song.songId}"><i class="fa fa-4x fa-play-circle-o" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <p class="songname"><a href="#">${song.songName}</a></p>
                                        <p class="songartist"><a href="#">${song.songArtist}</a></p>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                </div>
            </div>
            <div class="col-xs-12 col-sm-3">
                <div class="panel-anny">
                    <h3 class="panel-anny-title">Top 100 Chart <span><a href="AllSong?tag=all">ทั้งหมด <i class="fa fa-sort" aria-hidden="true"></i></a></span></h3>
                    <ul class="panel-anny-list">
                        <c:choose>
                            <c:when test="${top100song!=null}">
                                <c:forEach items="${top100song}" var="song" varStatus="Mycount">
                                    <li class="item musicplay${fn:length(top100song) == Mycount.count ? "itemlast" : ""}" data-pic="${song.songPic}" data-songname="${song.songName}" data-songartist="${song.songArtist}" data-song="${song.songId}">
                                        <span class="label ${Mycount.count <= 3 ? "label-danger" : "label-default"}">${Mycount.count}</span>
                                        <div class="info">
                                            <a class="songname" href="#">${song.songName}</a>
                                            <br>
                                            <a href="#" class="songartist">${song.songArtist}</a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </ul>
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
        $(".musicplay").click(function() {
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