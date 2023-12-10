package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {
    List<Record> recordList;

    public PhoneDirectory() {
        this.recordList = new ArrayList<>();
    }

    public void add(Record record) {
        recordList.add(record);
    }

    public Record find(String name) {
        for (Record r : recordList) {
            if (name.equals(r.getName()))
                return r;
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> res = new ArrayList<>();
        for (Record r : recordList) {
            if (name.equals(r.getName()))
                res.add(r);
        }
        return res;
    }
}
