package login;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginProcess extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public LoginProcess()
    {
    }

    public void init()
    {
        database = InitialisationServlet.database;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String UserName = request.getParameter("username");
        String Password = request.getParameter("password");
        BasicDBObject user = new BasicDBObject();
        user.put("username", UserName);
        user.put("password", Password);
        DBCollection authors = database.getCollection("authors");
        DBCursor authorCredentials = authors.find(user, new BasicDBObject());
        if(authorCredentials.hasNext())
        {
            System.out.println("User Login Successful!");
            request.getSession().setAttribute("userName", UserName);
            request.getSession().setAttribute("isUserAuthenticated", Boolean.valueOf(true));
            response.sendRedirect("index.jsp");
        } else
        {
            System.out.println("User Login UnSuccessful!");
            response.sendRedirect("loginfail.jsp");
        }
    }
}