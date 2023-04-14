public class User {

    private int id;
    private String fname;
    private String lname;
    private int age;


    public User(int Id,String Fname,String Lname,int Age)
    {
        this.id = Id;
        this.fname = Fname;
        this.lname = Lname;
        this.age = Age;
    }

    public int getId()
    {
        return id;
    }

    public String getFname()
    {
        return fname;
    }

    public String getLname()
    {
        return lname;
    }

    public int getAge()
    {
        return age;
    }
}