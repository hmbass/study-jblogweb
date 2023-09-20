<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/header.jsp"%>

<br><br>
<div class="container border">
    <br>
    <div>
        <h3>${post.title}</h3>
    </div>
    <br>
    <div>
        <div>${post.content}</div>
    </div>

    <br>
    <div>
        Post Number : <span id="id"><i>${post.id}</i></span>
        Author : <span><i>${post.user.username}</i></span>
    </div>

    <hr>
    <button class="btn btn-secondary" onclick="history.back()">back</button>

    <c:if test="${post.user.username == principal.username}">
        <a href="/post/updatePost/${post.id}" class="btn btn-warning">modify</a>
        <button id="btn-delete" class="btn btn-danger">Delete</button>
    </c:if>

    <br><br>
</div>

<script src="/js/post.js"></script>
<%@include file="../layout/footer.jsp" %>