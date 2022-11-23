<%@ include file="/common/taglib.jsp"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>About</title>

<body>
  <div class="main-body py-5">
    <h4>CONTACT</h4>
    <p>
      If you have business inpuiries or other questions, please fill out the
      followng form to contact us. Thank you
    </p>

    <form>
      <div class="form-group">
        <label for="nameImput">Name</label>
        <input type="text" class="form-control" id="nameImput" />
      </div>
      <div class="form-group">
        <label for="emailImput">Email</label>
        <input type="email" class="form-control" id="emailImput" />
      </div>
      <div class="form-group">
        <label for="subjectImput">Subject</label>
        <input type="text" class="form-control" id="subjectImput" />
      </div>
      <div class="form-group">
        <label for="bodyInput">Body</label>
        <textarea class="form-control" id="bodyInput" rows="3"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</body>
