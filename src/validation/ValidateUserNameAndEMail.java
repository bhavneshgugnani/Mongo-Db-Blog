package validation;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ValidateUserNameAndEMail extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public void init()
    {
        database = InitialisationServlet.database;
    }

    public ValidateUserNameAndEMail()
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
        String Username = request.getParameter("username");
        String Email = request.getParameter("email");
        DBCollection authors = database.getCollection("authors");
        ArrayList query = new ArrayList();
        query.add((new BasicDBObject()).append("_id", Username));
        query.add((new BasicDBObject()).append("email", Email));
        DBCursor cursor = authors.find((new BasicDBObject()).append("$or", query));
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter writer = response.getWriter();
        if(!cursor.hasNext())
        {
            writer.write("valid");
        } else
        {
            writer.write("invalid");
        }
        writer.flush();
        writer.close();
    }
}