public class FileData implements Comparable<FileData> {
    private String name;
    private double size;
    private String path;

    public FileData(String name, double size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public int compareTo(FileData o) {
        return (int) (this.size - o.size);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }
}
