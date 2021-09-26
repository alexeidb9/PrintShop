package backend.Shop.domain;

import backend.Prints.Print;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class Shipment implements Iterable<Print> {

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int PRINT_NOT_PRESENT = -1;

    private final List<Print> prints = new ArrayList<>();

    private List<Print> lightVanPrints;
    private List<Print> heavyVanPrints;

    public void add(Print print) throws IOException {
//        throw new IOException("something bad happen");
        prints.add(print);
    }

    public void replace(Print oldPrint, Print newPrint) {
        final int index = prints.indexOf(oldPrint);
        if (index != PRINT_NOT_PRESENT) {
            prints.set(index, newPrint);
        }
    }

    public void prepare() {
        // sort our list of prints by weight
        //  Collections.sort(prints, Print.BY_WEIGHT); - in case of Java 7
        prints.sort(Print.BY_WEIGHT);

        // find the print that needs a heavy van
        int splitPoint = findSplitPoint();

        // assign view of the print lists for hevy and light vans
        lightVanPrints = prints.subList(0, splitPoint);
        heavyVanPrints = prints.subList(splitPoint, prints.size());
    }

    private int findSplitPoint() {
        for (int i = 0; i < prints.size(); i++) {
            final Print print = prints.get(i);
            if (prints.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }

        return 0;
    }

    public List<Print> getLightVanPrints() {
        return lightVanPrints
    }

    public List<Print> getHeavyVanPrints() {
        return heavyVanPrints
    }


    @Override
    public Iterator<Print> iterator() {
        return prints.iterator();
    }

    @Override
    public void forEach(Consumer<? super Print> action) {
    }

    @Override
    public Spliterator<Print> spliterator() {
        return null;
    }
}
