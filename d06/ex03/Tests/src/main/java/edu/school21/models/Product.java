package edu.school21.models;

public class Product
{
    private Long Id;
    private String Name;
    private Integer Price;
    public Product(){}
    public Product(Long id,String name,Integer price)
    {
        Id = id;Name = name;Price = price;
    }
    public Long getId()
    {
        return Id;
    }
    public String getName()
    {
        return Name;
    }
    public Integer getPrice(){return Price;}
    public void setId(Long id){Id = id;}
    public void setName(String name){Name = name;}
    public void setPrice(Integer price){Price = price;}
    public String toString()
    {
        return "id="+ Id +" name="+Name+" price="+Price;
    }
}
