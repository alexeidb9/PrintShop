package models.Shop;

import models.Prints.Print;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Print>
{

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    public static final int PRODUCT_NOT_PRESENT = -1;

    private final List<Print> prints = new ArrayList<>();

    private List<Print> lightVanProducts;
    private List<Print> heavyVanProducts;

    public void add(Print print)
    {
        prints.add(print);
    }

    public void replace(Print oldPrint, Print newPrint)
    {
        final int index = prints.indexOf(oldPrint);
        if (index != PRODUCT_NOT_PRESENT)
        {
            prints.set(index, newPrint);
        }
    }

    public void prepare()
    {
        // sort our list of products by weight
        //Collections.sort(products, Product.BY_WEIGHT);
        prints.sort(Print.BY_WEIGHT);

        // find the product index that needs the heavy van
        int splitPoint = findSplitPoint();

        // assign views of the product list for heavy and light vans
        lightVanProducts = prints.subList(0, splitPoint);
        heavyVanProducts = prints.subList(splitPoint, prints.size());
    }

    private int findSplitPoint()
    {
        for (int i = 0; i < prints.size(); i++)
        {
            final Print product = prints.get(i);
            if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT)
            {
                return i;
            }
        }

        return 0;
    }

    public List<Print> getHeavyVanProducts()
    {
        return heavyVanProducts;
    }

    public List<Print> getLightVanProducts()
    {
        return lightVanProducts;
    }

    public Iterator<Print> iterator()
    {
        return prints.iterator();
    }
}
