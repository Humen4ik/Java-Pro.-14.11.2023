public class WordOccurence {
    private String name;
    private int num;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public WordOccurence(String name) {
        this.name = name;
        num = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
