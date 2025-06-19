public class StudentTest {
    public static void main(String[] args) {

        // Parameterized constructor
        Student s1 = new Student("John", "CS", 3.5);

        // No-arg constructor
        Student s2 = new Student();
        s2.setName("Mary Ann");
        s2.setMajor("CE");
        s2.setGpa(3.3);

        // Student's toString() method is called when printLn executed
        System.out.println(s1);
        System.out.println(s2);

    }
}