<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Enter Your Details:</h2>
<form action="readCookies" method="get">
    <label for="userName">Name:</label>
    <input type="text" id="userName" name="userName"><br><br>

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