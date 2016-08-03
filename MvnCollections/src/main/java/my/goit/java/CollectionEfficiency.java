package my.goit.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CollectionEfficiency {
    public static void main(String[] args) {
        int[] elements = {10000, 100000, 1000000};
        for (int i = 0; i < elements.length; i++) {
            new CollectionEfficiency().writeToFile(elements[i]);
        }
    }

    public void writeToFile(int elementNumber) {
        final File result = new File
                ("C:\\Users\\Кондратий\\IdeaProjects\\ProjectTools\\MvnCollections\\src\\main" +
                        "\\resources\\result.txt");
        ListEfficiency le = new ListEfficiency(elementNumber);
        SetEfficiency se = new SetEfficiency(elementNumber);
        try (FileWriter fw = new FileWriter(result, true)) {
            String header = "\n\t 1000 measures \n " + elementNumber + " els\t|" + "add(ms)|"
                    + "get(ms)|" + "remove(ms)|" + "contains(ms)|" + "populate(ms)|" + "iterator" +
                    ".add(ns)|" + "iterator.remove(ns)| \n";

            String listResult = le.execute();
            String setResult = se.execute();

            fw.write(header);
            fw.write(listResult);
            fw.write(setResult);
            fw.flush();
            System.out.println(header + listResult + setResult);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

