<%@ include file="/common/taglib.jsp"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>Create Blog</title>

<body>
  <div class="main-body py-5">
    <h4>Create Blog</h4>

    <form>
      <div class="form-group">
        <label for="titleImput">Title</label>
        <input type="text" class="form-control" id="titleImput" />
      </div>
      <div class="form-group">
        <label for="contentInput">Content</label>
        <textarea class="form-control" id="contentInput" rows="3"></textarea>
        <small id="emailHelp" class="form-text text-muted"
          >Please separate different tags with commas
        </small>
      </div>
      <div class="form-group">
        <label for="statusImput">Status</label>
        <select class="form-control" id="statusImput">
          <option>Draft</option>
          <option>Published</option>
          <option>Unpublished</option>
        </select>
      </div>

      <button type="submit" class="btn btn-primary">Create</button>
    </form>
  </div>
</body>
