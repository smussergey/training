package training.model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Entry> entries = new ArrayList<>();

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
