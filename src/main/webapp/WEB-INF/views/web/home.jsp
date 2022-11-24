<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Trang Chủ</title>
<body>
	<div class="main-body py-5">
		<div class="row">
			<div class="col-md-9">
				<div class="inner-content">
					<c:forEach var="item" items="${blogs}">
						<div class="blog-child mb-4">
							<h5 class="title">${item.title }</h5>
							<p class="time">Posted by demo on ${item.createdTime }</p>
							<p class="cotent">${item.content }</p>
							<a href="<c:url value='/blog/${item.id }'/>">Xem Tiep</a>
							<div class="rounded p-3 bg-light text-dark">
								<p class="text-tag">
									Tags: <a href="" class="">${item.tags }</a>
								</p>

								<div>
									<a href="" class="">Permalink</a> | <a href="" class="">Comment
										(${item.comments.size() })</a> | Last updated on
									${item.updatedTime }
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-3">
				<div class="inner-content">
					<div class="mb-3">
						<div class="p-2 bg-primary text-white rounded">Tags</div>
						<p>
							<a href="">blog</a>, <a href="">test</a>
						</p>
					</div>

					<div class="mb-3">
						<div class="p-2 bg-primary text-white rounded">Recent
							comments</div>
						<ul>
							<li>Tester on <a href="">A Test Post</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
