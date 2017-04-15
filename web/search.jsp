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

                <form style="text-align: center;" method="post">
                    <div class="form-group col-xs-9">
                        <input type="text" class="form-control" name="keyword" placeholder="ค้นหา" value="${param.keyword}"/>
                    </div>
                    <div class="form-group col-xs-3">
                        <button type="submit" class="form-control btn btn-primary" style="padding: 10px 0px;">ค้นหา</button>
                    </div>
                </form>

            </div>
            <div class="row"></div>
            <div class="songs">
                <c:choose>
                    <c:when test="${!empty listsong}">
                        <c:forEach items="${listsong}" var="song" varStatus="Mycount">

                            <div class="col-xs-6 col-sm-2 box">
                                <div class="post">
                                    <div class="post_img">
                                        <div class="playbg"> </div>
                                        <img src="${song.songPic}"/>
                                        <div class="play">
                                            <a href="#" id="asong${Mycount.count}"><i class="fa fa-4x fa-play-circle-o" aria-hidden="true"></i></a>
                                        </div>
                                    </div>
                                    <p class="songname"><a href="#">${song.songName}</a></p>
                                    <p class="songartist"><a href="#">${song.songArtist}</a></p>
                                </div>
                            </div>
                            <form id="song${Mycount.count}" action="Music" method="post" accept-charset="utf-8">
                                <input type="hidden" name="songname" value="${song.songName}"/>
                                <input type="hidden" name="songartist" value="${song.songArtist}"/>
                                <input type="hidden" name="songid" value="${song.songId}"/>
                            </form>
                            <script type="text/javascript">
                                $('a#asong${Mycount.count}').click(function () {
                                    $('form#song${Mycount.count}').submit();
                                });
                            </script>
                        </c:forEach>
                    </c:when>
                            <c:when test="${param.keyword != null}">
                                <div class="col-xs-12" style="text-align: center;">
                                    <span style="font-size: 25px;">ไม่เจออะไรเลย <i class="fa fa-frown-o" aria-hidden="true"></i></span>
                                </div>
                            </c:when>
                </c:choose>
            </div>
        </div>

        <!--footer-->
        <div class="footer">
            Anny Music :: ฟังเพลงออนไลน์ 24 ชม.
        </div>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="http://cdn.jsdelivr.net/jquery.slick/1.6.0/slick.min.js"></script>
    <script type="text/javascript" src="https://content.jwplatform.com/libraries/t9gWOAS0.js"></script>
    <script type="text/javascript">
                                $(document).ready(function () {
                                    $('.slide').slick({
                                        arrows: false,
                                        autoplay: true,
                                        autoplaySpeed: 2000
                                    });
                                });

    </script>
</body>

</html>

