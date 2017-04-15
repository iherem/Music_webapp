<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--footer-->
<div class="footer">
    Anny Music :: ฟังเพลงออนไลน์ 24 ชม.
</div>
</div>
<script src="https://code.jquery.com/jquery-2.2.0.min.js" integrity="sha256-ihAoc6M/JPfrIiIeayPE9xjin4UWjsx2mjW/rtmxLM4=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="http://cdn.jsdelivr.net/jquery.slick/1.6.0/slick.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.slide').slick({
            arrows: false,
            autoplay: true,
            autoplaySpeed: 2000
        });
    });
    $(document).ready(function () {
        $('tr.listsong').click(function () {
            location.href = 'url';
        });
    });
</script>
</body>

</html>
