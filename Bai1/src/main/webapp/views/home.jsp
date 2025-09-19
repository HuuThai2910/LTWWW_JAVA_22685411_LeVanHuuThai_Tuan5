<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        * {
            margin: 0;
        }
        header {
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            border: 2px solid black;

        }
        a {
            font-size: 20px;
            color: black;
            border-right: 1px solid black;
            padding: 0 30px;
        }
        a:last-child {
            border-right: none;
        }
    </style>
</head>
<body>
<img src="../images/home.jpg" alt="" style="width: 100%; height: 150px">
<header>
    <a href="${pageContext.request.contextPath}/dienthoais?action=list&maNCC=-1">Danh sách sản phẩm</a>
    <a href="${pageContext.request.contextPath}/dienthoais?action=form-add">Thêm mới sản phẩm</a>
    <a href="${pageContext.request.contextPath}/dienthoais?action=manage">Chức năng quản lý</a>
</header>
</body>
</html>