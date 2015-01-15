package action;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class NewUser extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public void init()
    {
        database = InitialisationServlet.database;
    }

    public NewUser()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        DBCollection authors = database.getCollection("authors");
        BasicDBObject query = new BasicDBObject();
        query.put("email", request.getParameter("email"));
        query.put("_id", request.getParameter("_id"));
        query.put("password", request.getParameter("password"));
        authors.insert(new DBObject[] {
            query
        });
        System.out.println("New User Credentials updated in database.");
        response.sendRedirect("index.jsp");
    }
}