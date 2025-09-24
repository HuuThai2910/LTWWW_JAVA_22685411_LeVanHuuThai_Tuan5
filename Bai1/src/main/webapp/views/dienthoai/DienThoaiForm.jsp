<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huu Thai
  Date: 9/20/2025
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            box-sizing: border-box;
        }

        body {
            width: 1140px;
            margin: 0 auto;
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            padding-top: 50px;
        }

        .container {
            background-color: white;
            padding: 25px 30px;
            margin: 0 auto;
            width: 50%;
        }

        form {
            margin-top: 20px;
        }

        form div {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-bottom: 10px;
        }

        label {
            font-weight: bold;
            font-size: 15px;
        }

        input, select {
            padding: 10px;
            border: 1px solid black;
            border-radius: 6px;
            outline: none;
        }

        input[type="file"] {
            border: none;
        }

        button {
            margin-top: 10px;
            width: 100%;
            padding: 12px;
            border: none;
            background: #007bff;
            color: white;
            border-radius: 6px;
            font-size: 15px;
            cursor: pointer;
        }

    </style>
</head>
<body>
<div class="container">
    <h1 style="text-align: center; font-size: 30px">Thêm điện thoại</h1>
    <form action="add-dt" method="post" enctype="multipart/form-data">
        <div>
            <label>Mã điện thoại</label>
            <input name="maDienThoai" placeholder="Nhập mã điện thoại"
                   value="${newDienThoai.maDienThoai}"/>
            <c:forEach var="err" items="${errors}">
                <c:if test="${err.propertyPath == 'maDienThoai'}">
                    <span style="color: red">${err.message}</span>
                </c:if>
            </c:forEach>
        </div>
        <div>
            <label>Tên điện thoại</label>
            <input name="tenDienThoai" placeholder="Nhập tên điện thoại "
                   value="${newDienThoai.tenDienThoai}"/>
            <c:forEach var="err" items="${errors}">
                <c:if test="${err.propertyPath == 'tenDienThoai'}">
                    <span style="color: red">${err.message}</span>
                </c:if>
            </c:forEach>
        </div>
        <div>
            <label>Năm sản xuất</label>
            <input name="namSanXuat" placeholder="Nhập năm sản xuất"
                   value="${newDienThoai.namSanXuat == 0 ? '' : newDienThoai.namSanXuat}"/>
            <c:forEach var="err" items="${errors}">
                <c:if test="${err.propertyPath == 'namSanXuat'}">
                    <span style="color: red">${err.message}</span>
                </c:if>
            </c:forEach>
        </div>
        <div>
            <label>Cấu hình</label>
            <input name="cauHinh" placeholder="Nhập cấu hình"
                   value="${newDienThoai.tenDienThoai}"/>
            <c:forEach var="err" items="${errors}">
                <c:if test="${err.propertyPath == 'cauHinh'}">
                    <span style="color: red">${err.message}</span>
                </c:if>
            </c:forEach>
        </div>
        <div>
            <label>Hình ảnh</label>
            <input type="file" name="hinhAnh"/>
            <c:forEach var="err" items="${errors}">
                <c:if test="${err.propertyPath == 'hinhAnh'}">
                    <span style="color: red">${err.message}</span>
                </c:if>
            </c:forEach>
        </div>

        <div>
            <label>Nhà cung cấp</label>
            <select name="maNhaCungCap">
                <c:forEach var="nhaCungCap" items="${nhaCungCaps}">
                    <option value="${nhaCungCap.maNhaCungCap}">${nhaCungCap.tenNhaCungCap}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Them</button>
    </form>
</div>
</body>
</html>
