<%@page import="integracion.util.commonthings"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Prueba AU</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <form class="login">
            <h1>Torre Bio Login</h1>
            <input type="text" name="userid" id="userid" value="" class="login-input" placeholder="Userid"  />
            
            
            <a  value="Login" class="login-submit" href="https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=<%=commonthings.client_id%>&redirect_uri=<%=commonthings.redirect_url%>&state=alfonso-ug&scope=r_basicprofile">
                <img alt="" src="Linkedin-customized-button.png" style="width: 70%">
            </a>
        </form>
    </body>
</html>