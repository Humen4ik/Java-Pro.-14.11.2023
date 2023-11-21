public class Employee {
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private String email;
    private String phone;
    private int age;

    public Employee(String firstName, String lastName, String middleName, String position, String email, String phone, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public Employee() {
        this.firstName = "Undefined";
        this.lastName = "Undefined";
        this.middleName = "Undefined";
        this.position = "Undefined";
        this.email = "Undefined";
        this.phone = "Undefined";
        this.age = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
