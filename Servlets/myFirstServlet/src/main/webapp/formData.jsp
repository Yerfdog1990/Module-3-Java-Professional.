<%--
  Created by IntelliJ IDEA.
  User: godfrey
  Date: 8/3/2025 AD
  Time: 05:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Enter Your Details:</h2>
<form action="readAllParameters" method="get">
    <label for="username">Name:</label>
    <input type="text" id="username" name="username"><br><br>

    <label>Gender:</label>
    <input type="radio" name="gender" value="male"> Male
    <input type="radio" name="gender" value="female"> Female<br><br><br>

    <label>Marital Status:</label><br>
    <input type="radio" name="marital_status" value="single"> Single<br>
    <input type="radio" name="marital_status" value="married"> Married<br>
    <input type="radio" name="marital_status" value="widow"> Widow<br>
    <input type="radio" name="marital_status" value="prefer_not_to_say"> Prefer not to say<br><br><br>

    <label>Do you have a medical history of diabetes?</label><br>
    <input type="radio" name="diabetes" value="yes"> Yes<br>
    <input type="radio" name="diabetes" value="no"> No<br><br><br>

    <label for="feedback">Your Feedback:</label><br>
    <textarea id="feedback" name="feedback" rows="4" cols="50"></textarea><br><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
