<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Authentification</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <style>
        body {
            background-image: url('images/OLC.png');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

      
        .logo {
            position: absolute; /* Positionnement absolu par rapport au contenant (.container) */
            top: 0; /* En haut de la page */
            left: 0;
            height: 200px;
            width: 300px/* À gauche de la page */
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="images/R.png" class="logo" alt="Votre Logo">
        <div class="regbox box">
            <h1>Authentification</h1>
            <form action="connexion" method="post">
                <p>login:</p>
                <input type="text" placeholder="CIN" name="id" required>
                <p>Mot de passe:</p>
                <input type="password" placeholder="Password" name="password" required>
                <input type="submit" value="Connecter">
                <%--<a href="index.jsp">Already have Account?</a>--%>
            </form>
        </div>
    </div>
</body>
</html>
