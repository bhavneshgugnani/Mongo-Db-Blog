package action;

import com.mongodb.*;
import initialisation.InitialisationServlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ViewPostsListByTagName extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private DB database;

    public void init()
    {
        database = InitialisationServlet.database;
    }

    public ViewPostsListByTagName()
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
        String tag = request.getParameter("tag");
        DBCollection posts = database.getCollection("posts");
        BasicDBObject query = new BasicDBObject();
        BasicDBObject obj = new BasicDBObject();
        ArrayList list = new ArrayList();
        list.add(tag);
        obj.put("$in", list);
        query.put("tags", obj);
        DBCursor cursor = posts.find(query, new BasicDBObject());
        ArrayList postsList = new ArrayList();
        com.mongodb.DBObject post;
        for(; cursor.hasNext(); postsList.add(post))
        {
            post = cursor.next();
        }

        request.setAttribute("postsListByTagName", postsList);
        RequestDispatcher view = request.getRequestDispatcher("postslistbytagname.jsp");
        view.forward(request, response);
    }
}