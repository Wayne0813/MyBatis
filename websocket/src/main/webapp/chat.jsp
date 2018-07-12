<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h4>Hello, java!</h4>

    <ul id="ul">
        <li>XXX进入了聊天室</li>
        <li>XXX进入了聊天室</li>
        <li>XXX进入了聊天室</li>
    </ul>

    <input id="chat" class="chat" type="text" name="chat" />

    <button id="btn" class="btn">submit</button>


    <!-- jQuery 3 -->
    <script src="/static/jquery.js"></script>
</body>
<script>
    $(function(){
        var ws = null;

        if(WebSocket){
            ws = new WebSocket("ws://localhost/weChat")
        } else {
            alert("您的浏览器不支持WebSocket!")
        }

        ws.onopen = function(){
            ws.send("这是一条信息")

        }

        ws.onmessage = function (even) {
            console.log("even : " + even);
            showMessage(even.data);

        }

        function showMessage(msg){
            console.log("message : " + msg);
            var html = $("#ul").html();
            html = html + "<li>" + msg + "<li>";
            $("#ul").html(html);
        }

        $("#btn").click(function(){
            console.log("按钮被点击了");
            var neirong = $("#chat").val();
            ws.send("neirong : " + neirong);
            $("#chat").val("");
        });




    });
</script>
</html>
