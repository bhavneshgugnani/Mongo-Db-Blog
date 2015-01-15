package action;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.bson.types.ObjectId;

public class DeletePost extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public void init()
    {
        database = InitialisationServlet.database;
    }

    public DeletePost()
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
        System.out.println((new StringBuilder("id : ")).append(request.getParameter("postId")).toString());
        ObjectId postId = new ObjectId(request.getParameter("postId"));
        BasicDBObject query = new BasicDBObject();
        query.put("_id", postId);
        DBCollection posts = database.getCollection("posts");
        posts.remove(query);
        System.out.println((new StringBuilder("Post(Post Id : ")).append(postId).append(") removed from database.").toString());
        response.sendRedirect("index.jsp");
    }
}