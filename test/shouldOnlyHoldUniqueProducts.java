//import com.alxndr.printshop.backend.models.main.models.Prints.model.PrintCatalogue;
//import org.junit.jupiter.api.Test;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsInAnyOrder;
//
//
//class PrintCatalogueTest {
//
//    @Test
//    public void shouldOnlyHoldUniqueProducts() throws Exception {
//
//        PrintCatalogue printCatalogue = new PrintCatalogue();
//
//        printCatalogue.isCreatedBy(PrintFixtures.alex);
//        printCatalogue.isCreatedBy(PrintFixtures.david);
//
//        assertThat(printCatalogue, containsInAnyOrder(PrintFixtures.alex, PrintFixtures.david));
//
//    }
//}
//
//
//{
//    @Test
//    public void shouldOnlyHoldUniqueProducts() throws Exception
//    {
//        ProductCatalogue catalogue = new ProductCatalogue();
//
//        catalogue.isSuppliedBy(bobs);
//        catalogue.isSuppliedBy(kates);
//
//        assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
//    }
//
//    @Test
//    public void treeShouldOnlyHoldUniqueProducts() throws Exception
//    {
//        TreeProductCatalogue catalogue = new TreeProductCatalogue();
//
//        catalogue.isSuppliedBy(bobs);
//        catalogue.isSuppliedBy(kates);
//
//        assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
//    }
//
//    @Test
//    public void shouldFindLightVanProducts() throws Exception
//    {
//        TreeProductCatalogue catalogue = new TreeProductCatalogue();
//
//        catalogue.isSuppliedBy(bobs);
//        catalogue.isSuppliedBy(kates);
//
//        assertThat(catalogue.lightVanProducts(), containsInAnyOrder(window));
//    }
//
//
//    @Test
//    public void shouldFindHeavyVanProducts() throws Exception
//    {
//        TreeProductCatalogue catalogue = new TreeProductCatalogue();
//
//        catalogue.isSuppliedBy(bobs);
//        catalogue.isSuppliedBy(kates);
//
//        assertThat(catalogue.heavyVanProducts(), containsInAnyOrder(door, floorPanel));
//    }
//}
