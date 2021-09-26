import backend.Shop.domain.Shipment;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShipmentsTest {


    }

    private Shipment shipment = new Shipment();

    @Test
    public void shouldAddItems() throws Exception {
        shipment.add(PrintFixtures.canvas);
        shipment.add(PrintFixtures.woodprint);

        assertThat(shipment, contains(PrintFixtures.canvas, PrintFixtures.woodprint));
    }

    @Test
    public void shouldReplaceItems () throws Exception {
        shipment.add(PrintFixtures.canvas);
        shipment.add(PrintFixtures.woodprint);

        shipment.replace(PrintFixtures.canvas, PrintFixtures.regularPrint);
    }

    @Test
    public void shouldIdentifyVanRequirements() throws Exception{
        shipment.add(PrintFixtures.canvas);
        shipment.add(PrintFixtures.woodprint);
        shipment.add(PrintFixtures.regularPrint);

        shipment.prepare();

        assertThat(shipment.getLightVanPrints(), contains(PrintFixtures.canvas));
        assertThat(shipment.getHeavyVanPrints(), contains(PrintFixtures.regularPrint, PrintFixtures.woodprint));
    }



}
