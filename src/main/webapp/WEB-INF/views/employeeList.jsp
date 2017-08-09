<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>员工列表</title>
    <base href="<%=basePath%>">
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row">
            <h1>SSM-CRUD</h1>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-8" style="margin-bottom: 20px">
                <button class="btn btn-primary">新增</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="emp">
                        <tr>
                            <th>${emp.empId}</th>
                            <th>${emp.empName}</th>
                            <th>${emp.gender=="M"?"男":"女"}</th>
                            <th>${emp.email}</th>
                            <th>${emp.tblDept.deptName}</th>
                            <th>
                                <button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-pencil"></span>编辑</button>
                                <button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>删除</button>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                当前第${pageInfo.pageNum}页，总${pageInfo.pages}页，总${pageInfo.total}条
            </div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li><a href="emps?pn=1">首页</a></li>
                        <li>
                            <c:if test="${pageInfo.hasPreviousPage}">
                                <a href="emps?pn=${pageInfo.pageNum - 1}" aria-label="Previous">
                                    <span>&laquo;</span>
                                </a>
                            </c:if>
                        </li>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                            <c:if test="${pageNum == pageInfo.pageNum}">
                                <li class="active"><a href="#">${pageNum}</a></li>
                            </c:if>
                            <c:if test="${pageNum != pageInfo.pageNum}">
                                <li><a href="emps?pn=${pageNum}">${pageNum}</a></li>
                            </c:if>
                        </c:forEach>
                        <li>
                            <c:if test="${pageInfo.hasNextPage}">
                                <a href="emps?pn=${pageInfo.pageNum + 1}" aria-label="Next">
                                    <span>&raquo;</span>
                                </a>
                            </c:if>
                        </li>
                        <li><a href="emps?pn=${pageInfo.pages}">末页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <script href="static/bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript" />
    <script href="static/js/jquery.min.js" type="text/javascript" />
</body>
</html>
