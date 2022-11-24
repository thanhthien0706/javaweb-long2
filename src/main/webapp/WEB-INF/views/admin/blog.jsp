<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Manage Blog</title>

<body>
	<div class="main-body py-5">
		<div class="d-flex justify-content-between align-items-center mb-2">
			<h4 class="mb-3">MANAGE POSTS</h4>
			<a class="btn btn-outline-secondary btn-sm"
				href="<c:url value='/admin/blog/create'/>">Create Blog</a>
		</div>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Title</th>
					<th scope="col">Status</th>
					<th scope="col">Create Time</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${blogs}">
					<tr>
						<td>${item.title}</td>
						<td>${item.status}</td>
						<td>${item.createdTime}</td>
						<td><a href="<c:url value='/blog/${item.id}'/>">Xem</a> / <a
							href="<c:url value='/admin/blog/edit/${item.id}'/>">Sửa</a> / <a
							href="<c:url value='/admin/blog/remove/${item.id}'/>">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
