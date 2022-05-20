package edu.school21.models;

public class User
{
    private long Id;
    private String Login;
    private String Pass;
    private boolean Status;
    public User(){}
    public User(long id,String log,String pass,boolean status)
    {
        Id = id;Login = log;Pass = pass;Status = status;
    }
    public long getId() {return Id;}
    public boolean equals(User u)
    {
        if (Id == u.getId() && Login.equals(u.getLogin()) && Pass.equals(u.getPass()))
            return true;
        else
            return false;
    }
    public String getLogin() {return Login;}
    public String getPass(){return Pass;}
    public boolean getStatus(){return Status;}
    public void setId(long id){Id=id;}
    public void setLogin(String log){Login = log;}
    public void setPass(String pass){Pass = pass;}
    public void setStatus(boolean st){Status=st;}
    public String toString()
    {
        return "id="+Id+", login= "+Login+", password= "+Pass+", status= "+Status;
    }
}
