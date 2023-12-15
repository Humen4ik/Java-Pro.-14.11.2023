import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> filesMap;

    public FileNavigator() {
        this.filesMap = new HashMap<>();
    }

    public void add(String path, FileData newFileData) {
        if (path.equals(newFileData.getPath())) {
            List<FileData> fileDataList = filesMap.get(path);
            if (fileDataList != null)
                fileDataList.add(newFileData);
            else
                filesMap.put(path, new ArrayList<>(List.of(newFileData)));
        }
        else
            System.out.println("Це повний цуцванг. Значення шляху не відповідає шляху-ключу!");
    }

    public List<FileData> find(String path) {
        return filesMap.get(path);
    }

    public List<FileData> filterBySize(double size) {
        List<FileData> res = new ArrayList<>();
        for (Map.Entry<String, List<FileData>> entry : filesMap.entrySet()) {
            for (FileData fd : entry.getValue())
                if (fd.getSize() <= size)
                    res.add(fd);
        }
        return res;
    }

    public void remove(String path) {
        filesMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> fd = new ArrayList<>();
        for (Map.Entry<String, List<FileData>> entry : filesMap.entrySet())
            fd.addAll(entry.getValue());
        Collections.sort(fd);
        return fd;
    }

    public void showAllFiles() {
        for (Map.Entry<String, List<FileData>> entry : filesMap.entrySet()) {
            for (FileData fd : entry.getValue())
                System.out.println(fd);
        }
    }
}
