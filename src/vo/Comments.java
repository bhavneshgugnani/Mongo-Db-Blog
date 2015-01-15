package vo;


public class Comments
{

    private String Name;
    private String EMail;
    private String Body;

    public Comments(String name, String email, String body)
    {
        Body = body;
        EMail = email;
        Name = name;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getEMail()
    {
        return EMail;
    }

    public void setEMail(String eMail)
    {
        EMail = eMail;
    }

    public String getBody()
    {
        return Body;
    }

    public void setBody(String body)
    {
        Body = body;
    }
}