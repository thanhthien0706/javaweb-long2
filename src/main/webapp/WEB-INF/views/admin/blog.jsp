<%@ include file="/common/taglib.jsp"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>Manage Blog</title>

<body>
  <div class="main-body py-5">
    <div class="d-flex justify-content-between align-items-center mb-2">
      <h4 class="mb-3">MANAGE POSTS</h4>
      <button class="btn btn-outline-secondary btn-sm">Create Blog</button>
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
        <tr>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
          <td><a href="">Xem</a> / <a href="">Sửa</a> / <a href="">Xóa</a></td>
        </tr>
        <tr>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
          <td><a href="">Xem</a> / <a href="">Sửa</a> / <a href="">Xóa</a></td>
        </tr>
        <tr>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
          <td><a href="">Xem</a> / <a href="">Sửa</a> / <a href="">Xóa</a></td>
        </tr>
      </tbody>
    </table>
  </div>
</body>
