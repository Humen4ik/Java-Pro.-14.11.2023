<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Car Registration Form</title>
    </head>

    <body>
        <form method = "post" action = "/car">
            <div>
                <h1>Car Registration Form</h1>
                <hr>
                <label for = "model">Model:</label>
                <input type = "text" id ="model" name = "model"><br>
                <label for = "power">Power:</label>
                <input type = "text" id ="power" name = "power"><br>
                <label for = "year">Year:</label>
                <input type = "number" id ="year" name = "year"><br>
                <label for = "price">Price:</label>
                <input type = "text" id ="price" name = "price"><br>

                <button type = "submit">Register Car</button>
            </div>
        </form>
    </body>
</html>