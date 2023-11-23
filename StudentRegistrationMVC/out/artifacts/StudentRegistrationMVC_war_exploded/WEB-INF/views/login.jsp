<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../assets/test.css">
    <title> Student Registration LGN001 </title>
</head>
<body class="login-page-body">

<div class="login-page">
    <div class="form">
        <div class="login">
            <div class="login-header">
                <h1>Welcome!</h1>

            </div>
        </div>
        <form class="login-form" action="home" method="post" name="confirm">
            <input type="text" placeholder="User ID" value="Harry"/>
            <input type="password" placeholder="Password" value="123456"/>
            <button>login</button>
            <p class="message">Not registered? <a href="/createAccount">Create an account</a></p>
        </form>
    </div>
</div>
</body>

</html>