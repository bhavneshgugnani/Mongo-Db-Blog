package action;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddNewPost extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public void init()
    {
        database = InitialisationServlet.database;
    }

    public AddNewPost()
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
        DBCollection posts = database.getCollection("posts");
        String userName = request.getSession().getAttribute("userName").toString();
        BasicDBObject query = new BasicDBObject();
        BasicDBList tags = new BasicDBList();
        String taglist[] = request.getParameter("tags").split(",");
        for(int i = 0; i < taglist.length; i++)
        {
            tags.add(taglist[i]);
        }

        query.put("author", userName);
        query.put("body", request.getParameter("body"));
        query.put("tags", tags);
        query.put("title", request.getParameter("title"));
        query.put("time", (new Date()).toString());
        com.mongodb.WriteResult coll = posts.insert(new DBObject[] {
            query
        });
        System.out.println("Post submitted successfully in Database!");
        response.sendRedirect("index.jsp");
    }
}