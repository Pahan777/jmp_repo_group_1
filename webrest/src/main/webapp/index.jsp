<%--
  Created by IntelliJ IDEA.
  User: Yauheni_Kuzmianok
  Date: 4/3/2016
  Time: 6:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>File Upload with Jersey</h1>

<form action="rest/upload" method="post" enctype="multipart/form-data">

  <p>
    Select a file : <input type="file" name="file" size="45" />
  </p>
  <input type="text" name="login" size="45" />
  <input type="submit" value="Upload It" />
</form>

</body>
</html>
