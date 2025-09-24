<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            /*box-sizing: border-box;*/
        }

        body {
            margin: 0 auto;
            width: 1170px;
            height: 100vh;
        }

        select {
            padding: 5px;
            border: 2px solid black
        }

        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 6px;
            border: 2px solid black;
        }

        th, td {
            padding: 10px;
            border: 2px solid black;
            text-align: center;
        }

        form {
            display: flex;
            align-items: center;
            gap: 20px
        }

        input, button {
            padding: 5px 10px;
            border-radius: 6px;
            outline: none;
            border: 1px solid black;
        }

    </style>
</head>
<body>
<h1 style="text-align: center; margin: 50px 0">Danh sách nhà cung cấp</h1>
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px">
    <form action="dienthoais" method="post">
        <input type="text" name="keyword"
               placeholder="Nhập MANCC, Tên, Địa chỉ hoặc SĐT" value="${keyword}">
        <button type="submit">Tìm</button>
        <button type="reset"><a href="dienthoais"
                   style="text-decoration: none; color: black">Reset</a>
        </button>
    </form>
    <h2><a href="views/home.jsp">Trang chủ</a></h2>
</div>

<table border="1">
    <c:if test="${empty nhaCungCaps}">
        <h2 style="text-align: center">Không tim thấy nhà cung cấp</h2>
    </c:if>
    <c:if test="${not empty nhaCungCaps}">
        <tr>
            <th>Mã nhà cung cấp</th>
            <th>Tên nhà cung cấp</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
        </tr>
        <c:forEach var="nhaCungCap" items="${nhaCungCaps}">
            <tr>
                <td>${nhaCungCap.maNhaCungCap}</td>
                <td>${nhaCungCap.tenNhaCungCap}</td>
                <td>${nhaCungCap.diaChi}</td>
                <td>${nhaCungCap.soDienThoai}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>