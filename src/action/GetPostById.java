package action;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.bson.types.ObjectId;
import vo.Post;

public class GetPostById extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public void init()
    {
        database = InitialisationServlet.database;
    }

    public GetPostById()
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
        ObjectId id = new ObjectId(request.getParameter("id"));
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        DBCollection posts = database.getCollection("posts");
        DBCursor cursor = posts.find(query, new BasicDBObject());
        System.out.println((new StringBuilder("count : ")).append(cursor.count()).toString());
        if(cursor.hasNext())
        {
            Post post = new Post(cursor.next());
            request.getSession().setAttribute("post", post);
            response.sendRedirect("viewpost.jsp");
        } else
        {
            System.out.println("Could not find post in the Database.");
            response.sendRedirect("failure.jsp");
        }
    }
}