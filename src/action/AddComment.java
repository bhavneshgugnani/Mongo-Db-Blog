package action;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.bson.types.ObjectId;

public class AddComment extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public void init()
    {
        database = InitialisationServlet.database;
    }

    public AddComment()
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
        BasicDBObject query = new BasicDBObject();
        ObjectId id = new ObjectId(request.getParameter("postId"));
        query.put("_id", id);
        BasicDBObject comment = new BasicDBObject();
        comment.put("name", request.getParameter("name"));
        comment.put("email", request.getParameter("email"));
        comment.put("body", request.getParameter("body"));
        BasicDBObject update = new BasicDBObject();
        update.put("$push", (new BasicDBObject()).append("comments", comment));
        posts.update(query, update);
        System.out.println("Comment added.Redirecting request.");
        RequestDispatcher view = request.getRequestDispatcher((new StringBuilder("GetPostById?id=")).append(request.getParameter("postId")).toString());
        view.forward(request, response);
    }
}
