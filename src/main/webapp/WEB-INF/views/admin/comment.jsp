<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Manage Comment</title>

<body>
	<div class="main-body py-5">
		<div class="d-flex justify-content-between align-items-center mb-2">
			<h4 class="mb-3">MANAGE COMMENTS</h4>
		</div>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Author</th>
					<th scope="col">Content</th>
					<th scope="col">Status</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${comments}">
					<tr>
						<td>${item.author.username}</td>
						<td>${item.content}</td>
						<td>${item.status}</td>
						<td><c:choose>
								<c:when test="${ item.status == 'APPROVED'}">
									<a
										href="<c:url value='/admin/comment/${item.id}?status=unapproved'/>">Unapproved</a>
								</c:when>
								<c:otherwise>
									<a
										href="<c:url value='/admin/comment/${item.id}?status=approved'/>">Approved</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
