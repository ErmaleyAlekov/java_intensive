@OrmEntity(table = "myCars")
public class Car {
    @OrmColumnId
    private Long Id;
    @OrmColumn(name = "car_model", lenght = 150)
    private String Model;
    @OrmColumn(name = "car_price")
    private Double Price;
    private int Speed;
    @OrmColumn(name = "car_reserv")
    private Boolean Reserved;

    public Car() {
    }

    public Car(Long id, String model, Double price, int speed, Boolean reserved) {
        Id = id;
        Model = model;
        Price = price;
        Speed = speed;
        Reserved = reserved;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + Id +
                ", model='" + Model + '\'' +
                ", price=" + Price +
                ", speed=" + Speed +
                ", reserved=" + Reserved +
                '}';
    }
}
