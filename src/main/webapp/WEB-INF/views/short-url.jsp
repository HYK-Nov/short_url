<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>
            <div class="container">
                <form action="/short_url" method="POST">
                    <input type="text" class="form-control" name="rawURL">
                    <button type="submit" class="btn btn-primary">생성</button>
                </form>
                <input type="hidden" class="form-control" id="encURLText" value="${encURL}" readonly>
                <p id="encURLCount" class="visually-hidden">현재 호출된 횟수: ${requestCount}번</p>
            </div>

            <script>
                const $encURLText = document.querySelector("#encURLText");
                const $encURLCount = document.querySelector("#encURLCount");
                if ($encURLText.getAttribute("value") != "") {
                    $encURLText.setAttribute("type", "text");
                    $encURLCount.setAttribute("class", "");
                };
            </script>
        </body>

        </html>