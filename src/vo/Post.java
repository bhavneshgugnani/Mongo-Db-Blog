package vo;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import java.util.ArrayList;
import org.bson.types.ObjectId;

// Referenced classes of package vo:
//            Comments

public class Post
{

    private String Title;
    private String Body;
    private String author;
    private String Date;
    private ArrayList Comments;
    private BasicDBList Tags;
    private ObjectId _id;

    public Post(DBObject post)
    {
        setAuthor(post.get("author").toString());
        setBody(post.get("body").toString());
        setComments((ArrayList)post.get("comments"));
        setDate((String)post.get("date"));
        setTags((BasicDBList)post.get("tags"));
        setTitle(post.get("title").toString());
        set_id((ObjectId)post.get("_id"));
    }

    public ObjectId get_id()
    {
        return _id;
    }

    public void set_id(ObjectId _id)
    {
        this._id = _id;
    }

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title)
    {
        Title = title;
    }

    public String getBody()
    {
        return Body;
    }

    public void setBody(String body)
    {
        Body = body;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getDate()
    {
        return Date;
    }

    public void setDate(String date)
    {
        Date = date;
    }

    public ArrayList getComments()
    {
        return Comments;
    }

    public void setComments(ArrayList comments)
    {
        Comments = comments;
    }

    public BasicDBList getTags()
    {
        return Tags;
    }

    public void setTags(BasicDBList tags)
    {
        Tags = tags;
    }

    public void addComments(Comments comment)
    {
        Comments.add(comment);
    }
}