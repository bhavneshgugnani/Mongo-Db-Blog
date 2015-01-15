package logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogOut extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    public LogOut()
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
        request.getSession().removeAttribute("userName");
        request.getSession().removeAttribute("isUserAuthenticated");
        response.sendRedirect("index.jsp");
    }
}