<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Create Blog</title>

<body>
	<div class="main-body py-5">


		<c:choose>
			<c:when test="${action == 'create'}">
				<h4>Create Blog</h4>
				<form action="<c:url  value='/admin/blog/create' />" method="POST">
					<div class="form-group">
						<label for="titleImput">Title</label> <input type="text"
							class="form-control" id="titleImput" name="title" />
					</div>
					<div class="form-group">
						<label for="contentInput">Content</label>
						<textarea class="form-control" id="contentInput" rows="3"
							name="content"></textarea>

					</div>
					<div class="form-group">
						<label for="tagImput">Tags</label> <input type="text"
							class="form-control" id="tagImput" name="tags" /> <small
							id="emailHelp" class="form-text text-muted">Please
							separate different tags with commas </small>
					</div>
					<div class="form-group">
						<label for="statusImput">Status</label> <select
							class="form-control" id="statusImput" name="status">
							<option value="draft">Draft</option>
							<option value="published">Published</option>
							<option value="unpublished">Unpublished</option>
						</select>
					</div>

					<button type="submit" class="btn btn-primary">Create</button>
				</form>

			</c:when>
			<c:otherwise>
				<h4>Edit Blog</h4>
				<form action="<c:url  value='/admin/blog/edit/${blog.id}' />"
					method="POST">
					<div class="form-group">
						<label for="titleImput">Title</label> <input type="text"
							class="form-control" id="titleImput" name="title"
							value="${blog.title }" />
					</div>
					<div class="form-group">
						<label for="contentInput">Content</label>
						<textarea class="form-control" id="contentInput" rows="3"
							name="content" value="${blog.content }">
							${blog.content }
							</textarea>

					</div>
					<div class="form-group">
						<label for="tagImput">Tags</label> <input type="text"
							class="form-control" id="tagImput" name="tags"
							value="${blog.tags }" /> <small id="emailHelp"
							class="form-text text-muted">Please separate different
							tags with commas </small>
					</div>
					<div class="form-group">
						<label for="statusImput">Status</label> <select
							class="form-control" id="statusImput" name="status">
							<option value="draft" ${blog.status == 'DRAFT' ? 'selected' :'' }>Draft</option>
							<option value="published"
								${blog.status == 'PUBLIC' ? 'selected' :'' }>Published</option>
							<option value="unpublished"
								${blog.status == 'UNPUBLIC' ? 'selected' :'' }>Unpublished</option>
						</select>
					</div>

					<button type="submit" class="btn btn-primary">Edit</button>
				</form>
			</c:otherwise>
		</c:choose>




	</div>
</body>
