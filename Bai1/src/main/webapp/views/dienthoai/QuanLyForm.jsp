<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huu Thai
  Date: 9/22/2025
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>

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
        button {
            padding: 3px 15px;
            border-radius: 5px;
            background-color: red;
            color: white;
            border: none;
            font-weight: bold;
            cursor: pointer;
        }
        input {
            text-align: center;
            border: none;
            font-size: 16px;
            outline: none;
        }
    </style>
</head>
<body>
<h1 style="text-align: center; margin: 50px 0">Danh sách điện thoại</h1>
<h2 style="margin-bottom: 20px"><a href="views/home.jsp">Trang chu</a></h2>
<table border="1">

    <c:if test="${empty dienThoais}">
        <h2 style="text-align: center">Nhà cung cấp này hiện chưa có sản phẩm nào</h2>
    </c:if>
    <c:if test="${not empty dienThoais}">
        <tr>
            <th>Mã điện thoại</th>
            <th>Hình ảnh</th>
            <th>Tên điện thoại</th>
            <th>Năm sản xuất</th>
            <th>Cấu hình</th>
            <th>
                Lựa chọn
            </th>
        </tr>
        <c:forEach var="dienThoai" items="${dienThoais}">
          <form method="post" action="manage">
              <tr>
                  <td><input name="maDienThoai" value="${dienThoai.maDienThoai}" readonly></td>
                  <td>
                      <img src="${pageContext.request.contextPath}/images/${dienThoai.hinhAnh}"
                           alt="${dienThoai.tenDienThoai}"
                           width="50">
                  </td>
                  <td>${dienThoai.tenDienThoai}</td>
                  <td>${dienThoai.namSanXuat}</td>
                  <td>${dienThoai.cauHinh}</td>
                  <td >
                      <button onclick="return confirm('Ban có chắc muốn xóa')"
                              type="submit" name="action" value="delete">Xóa
                      </button>
                      <button style="background-color: darkgrey" type="submit" name="action" value="update-form">Cập nhật
                      </button>
                  </td>
              </tr>
          </form>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
</body>
</html>
