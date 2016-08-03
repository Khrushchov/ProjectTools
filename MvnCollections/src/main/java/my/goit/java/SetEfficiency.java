package my.goit.java;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetEfficiency {
    private HashSet hashSet;
    private TreeSet treeSet;
    private int elementNumber;

    public SetEfficiency(int elementNumber) {
        hashSet = new HashSet();
        treeSet = new TreeSet();
        this.elementNumber = elementNumber;
    }


    public String execute(){
        StringBuilder sb = new StringBuilder("");
        return sb.append(output(hashSet)).append(output(treeSet)).toString();
    }

    private String output(Set set) {

        long timePopulate = populate(set);
        long timeContains1000 = contains1000(set);
        long timeAdd1000 = add1000(set);
        long timeRemove1000 = remove1000(set);

        return set.getClass().getSimpleName() + "\t\t|\t" + timeAdd1000 + "\t|\t--\t|\t" +
                timeRemove1000 + "\t\t|\t" + timeContains1000 + "\t\t|\t" + timePopulate +
                "\t\t|\t" + "\t----\t|" + "\t----\t\t|\n";
    }


    private long populate(Set set) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < elementNumber; i++) {
            set.add(i);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long add1000(Set set) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            set.add(i);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long contains1000(Set set) {
        Random rand = new Random(47);
        int element = rand.nextInt(elementNumber);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            set.contains(element);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long remove1000(Set set) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            set.remove(i);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

}
