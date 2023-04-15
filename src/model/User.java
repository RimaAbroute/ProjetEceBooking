package model;

public class User {

    private int id;
    private String fname;
    private String lname;
    private int age;
    private int reduction;

    public User(int Id,String Fname,String Lname,int Age, int Reduction)
    {
        this.id = Id;
        this.fname = Fname;
        this.lname = Lname;
        this.age = Age;
        this.reduction = Reduction;
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
    public int getReduction()
    {
        return reduction;
    }
}