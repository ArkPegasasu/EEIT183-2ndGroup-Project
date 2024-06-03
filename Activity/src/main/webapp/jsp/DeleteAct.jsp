<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>刪除活動</title>
    <link rel="stylesheet" type="text/css" href="/Activity/styles/styledark.css">
  <script type="text/javascript">
        window.onload = function() {
            var message = "<%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>";
            if (message.trim() !== "") {
                alert(message);
            }
        };
    </script>
</head>
<body>
      <!-- 其他功能的連結 -->
      <div class="box">
        <div class="btn-group">
            <a href="/Activity/AddAct">新增活動</a>
            <a href="/Activity/UpdateAct">修改活動</a>
            <a href="/Activity/GetAct">查詢活動</a>
            <a href="/Activity/GetAllAct">查詢所有活動</a>
        </div>
      </div>
    <div class="container">
        <h2 style="animation: pulse 1s infinite alternate;">刪除活動</h2>
        <form action="/Activity/DeleteAct" method="post">
            <input type="text" name="activityno" placeholder="活動編號">
            <br>
            <button type="submit">刪除</button>
        </form>

    </div>
</body>
</html>
