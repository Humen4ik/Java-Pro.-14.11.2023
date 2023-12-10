package phonebook;

public class Record {

    private String name;
    private String phone;

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Record(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
