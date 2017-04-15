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
                <div class="playmusic">
                    <p class="playmysic_songname">${songname}</p>
                    <p class="playmysic_songartist">${songartist}</p>
                    <img class="img-responsive" src="${songimg}"/>
                    <div id="myMusic">Loading the player...</div>
                </div>
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
    <script type="text/javascript">
        var playerInstance = jwplayer("myMusic");
        playerInstance.setup({
            file: "${songm4a}",
            width: "700px",
            height: "40px",
            autostart: false
        });
    </script>
</body>

</html>

