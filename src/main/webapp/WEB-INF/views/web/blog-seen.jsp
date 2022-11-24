<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Blog ${blog.title }</title>

<body>
	<div class="main-body py-5">
		<div class="blog-main">
			<h4 class="text-center">${blog.title }</h4>
			<p class="time text-center">Posted by demo on ${blog.createdTime }</p>
			<p class="cotent text-center">${blog.content }</p>
			<p class="text-tag">
				Tags: <a href="" class="">${blog.tags }</a>
			</p>
		</div>

		<hr />

		<div class="comment-main">
			<form action="<c:url value='/blog/comment/${blog.id }'/>"
				method="POST" class="mb-4">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" name="content" placeholder="Write Comment Of You"></textarea>
				<button type="submit" class="btn btn-primary">Send</button>
			</form>

			<ul class="list-comment">
				<c:forEach var="item" items="${blog.comments}">
					<li class="p-2 rouned bg-light text-dark mb-4">
						<p>${item.author.username }</p>
						<p>${item.content }</p>
					</li>
				</c:forEach>
			</ul>

		</div>
	</div>
</body>