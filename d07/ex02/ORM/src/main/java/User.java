@OrmEntity(table = "simple_use")
public class User {
    @OrmColumnId
    private Long Id;

    @OrmColumn(name = "first_name", lenght = 10)
    private String FirstName;

    @OrmColumn(name = "last_name", lenght = 10)
    private String LastName;

    @OrmColumn(name = "age")
    private Integer Age;

    public User() {
    }

    public User(Long id, String firstName, String lastName, Integer age) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + Id +
                ", firstName='" + FirstName + '\'' +
                ", lastName='" + LastName + '\'' +
                ", age=" + Age +
                '}';
    }
}
