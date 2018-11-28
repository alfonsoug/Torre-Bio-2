 
<%@page import="integracion.VO.LinkedInProfile"%>
<%@page import="integracion.VO.Achievements"%>
<%@page import="integracion.util.LinkedInApi"%>
<%@page import="integracion.control.TorreBio"%>
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
        <form class="login" style="width: 700px; padding: 20px"/>
        <h1>Profile data</h1>
        <h1>_______________</h1>
        <%
            String code = (String) request.getParameter("code");
            String state = (String) request.getParameter("state");

            LinkedInApi obj_Post = new LinkedInApi();
            LinkedInProfile OBJ_LinkedInProfile = obj_Post.sendPost(code);

            TorreBio obj_TorreBio = new TorreBio();
            Achievements OBJ_Achievements = obj_TorreBio.consultarLogros(state);
        %>

        <h1>LinkedIn Bio</h1>
        <h3>
            Fist Name : <%=OBJ_LinkedInProfile.getFirstName()%><br>
            Last Name:<%=OBJ_LinkedInProfile.getLastName()%><br>
            Head Line: <%=OBJ_LinkedInProfile.getHeadline()%><br>
            ID : <%=OBJ_LinkedInProfile.getId()%><br>
            
            
        </h3>
        <h1>TorreBio Profile</h1>
        <h3>

            Id: <%=OBJ_Achievements.getId()%><br>
            Name:<%=OBJ_Achievements.getName()%><br>
            category: <%=OBJ_Achievements.getCategory()%><br>
            contributions : <%=OBJ_Achievements.getContributions()%><br>
        </h3>

    </form>
</body>
</html>