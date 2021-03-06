import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

public class Program {
    private static final String PACKAGE_NAME = "";
    private EmbeddedDatabase dataSourse;
    private OrmManager manager;


    public static void main(String[] args) {
        Program program = new Program();
        program.dataSourse = new EmbeddedDatabaseBuilder().build();
        program.manager = new OrmManager(PACKAGE_NAME, program.dataSourse);
        program.manager.init();
        program.manager.init();
        program.testSave();
        program.testFind();
        program.testUpdate();;
        program.dataSourse.shutdown();
    }


    private void testSave(){
        System.out.println("-------------------SAVE TEST----------------------");
        User user = new User(1L, "Alex", "Ermakov", 27);
        User user2 = new User(2L, "Ermaley", "Alekov", 27);
        manager.save(user);
        manager.save(user2);

        Car car = new Car(1L, "LADA2107", 50000.25, 100, true);
        Car car2 = new Car(2L, "LADA2110", 100000.55, 120, false);
        manager.save(car);
        manager.save(car2);
    }

    private void testFind() {
        System.out.println("------------------FIND TEST------------------------");
        User user;
        if ((user = manager.findById(2L, User.class)) != null) {
            System.out.println(user);
        }
        Car car;
        if ((car = manager.findById(1L, Car.class)) != null) {
            System.out.println(car);
        }
    }

    private void testUpdate() {
        System.out.println("--------------------UPDATE TEST-------------------");
        User user;
        if ((user = manager.findById(1L, User.class)) != null) {
            System.out.println("Before update:" + user);
        }
        user = new User(1L, "Ermaley", "Alekov", 27);
        manager.update(user);

        if ((user = manager.findById(1L, User.class)) != null) {
            System.out.println("After update:" + user);
        }

        Car car;
        if ((car = manager.findById(2L, Car.class)) != null) {
            System.out.println("Before update:" + car);
        }
        car = new Car(2L, "MarussiaB2", 3000000.55, 340, true);
        manager.update(car);

        if ((car = manager.findById(2L, Car.class)) != null) {
            System.out.println("After update:" + car);
        }
    }
}