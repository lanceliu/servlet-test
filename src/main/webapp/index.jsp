<html>
<script src="//cdn.bootcss.com/jquery/3.0.0-beta1/jquery.min.js"></script>
<body>
<h2>Hello World!</h2>
<div id="hello1"></div>
<div id="hello2"></div>
<script>
    $.ajax({
        type: "get",
        url: '/LongRunningServlet',
        success: function (data) {
            $("#hello1").text(data);
        }
    });

    $.ajax({
        type: "get",
        url: '/AsyncLongRunningServlet',
        success: function (data) {
            $("#hello2").text(data);
        }
    });

</script>
</body>
</html>
