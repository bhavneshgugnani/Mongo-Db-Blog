package initialisation;

import com.mongodb.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.UnknownHostException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class InitialisationServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    public static DB database = null;

    public void init()
    {
        MongoClient client = null;
        try
        {
            client = new MongoClient(new ServerAddress("localhost", 27017));
            database = client.getDB("blog");
            System.out.println("Databse connection setup done.");
            System.out.println("#############Application Up and running###########");
        }
        catch(UnknownHostException e)
        {
            System.out.println("#############Connection could not be initialised.#############");
            System.out.println((new StringBuilder("Error : ")).append(e).toString());
            e.printStackTrace();
        }
    }

    public InitialisationServlet()
    {
    }

    protected void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

    protected void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

}