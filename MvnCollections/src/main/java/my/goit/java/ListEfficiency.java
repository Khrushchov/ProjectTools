package my.goit.java;

import java.util.*;

public class ListEfficiency {
    private ArrayList arrayList;
    private LinkedList linkedList;
    private int elementNumber;

    public ListEfficiency(int elementNumber) {
        arrayList = new ArrayList();
        linkedList = new LinkedList();
        this.elementNumber = elementNumber;
    }

    public String execute() {
        StringBuilder sb = new StringBuilder("");
        return sb.append(output(arrayList)).append(output(linkedList)).toString();
    }

    protected String output(List list) {
        long timePopulate = populate(list);
        long timeGet1000 = get1000(list);
        long timeContains1000 = contains1000(list);
        long timeAdd1000 = add1000(list);
        long timeRemove1000 = remove1000(list);
        long timeLiterAdd1000 = literAdd1000(list);
        long timeLiterRemove1000 = literRemove1000(list);

        return list.getClass().getSimpleName() + "\t|\t" + timeAdd1000 + "\t|\t" + timeGet1000
                + "\t|\t" + timeRemove1000 + "\t\t|\t" + timeContains1000 + "\t\t|\t" +
                timePopulate + "\t\t|\t" + timeLiterAdd1000 + "\t\t|\t" + timeLiterRemove1000 + "\t\t|\n";

    }

    private long populate(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < elementNumber; i++) {
            list.add(i);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long add1000(List list) {
        Random rand = new Random(47);
        int index = rand.nextInt(elementNumber);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.add(index, i);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long get1000(List list) {
        Random rand = new Random(47);
        int index = rand.nextInt(elementNumber);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.get(index);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long contains1000(List list) {
        Random rand = new Random(47);
        int element = rand.nextInt(elementNumber);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.contains(element);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long remove1000(List list) {
        Random rand = new Random(47);
        int index = rand.nextInt(elementNumber);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.remove(index);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    private long literAdd1000(List list) {
        ListIterator liter = list.listIterator();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            liter.add(i);
        }
        long finish = System.nanoTime();

        return finish - start;
    }

    private long literRemove1000(List list) {
        ListIterator liter = list.listIterator();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++)
            if (liter.hasNext()) {
                liter.next();
                liter.remove();
            }
        long finish = System.nanoTime();
        return finish - start;
    }
}

