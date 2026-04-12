package task1;

public class Passenger {
    private static int counter =1;
    private String name;
    private String email;
    private String phone;
    private int passengerId;
    private int age;

    public Passenger(String name, String email, String phone, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.passengerId = counter++;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPassengerId() {
        return passengerId;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return passengerId + " - " + name + " (" + age + " tahun)";
    }

    public void displayInfo() {
        System.out.println("ID: " + passengerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Age: " + age);
        System.out.println("----------------------");
    }
}
