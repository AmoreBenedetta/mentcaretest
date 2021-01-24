import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

public class testHomepage {

    private WebTester tester;

    @Before
    public void prepare(){
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080");
    }

    @Test
    public void testHome(){
        tester.beginAt("/");
        tester.assertTitleEquals("Home medico");
        tester.assertTablePresent("Pazienti");
        tester.assertLinkPresentWithText("Cartella clinica");
    }


    @Test
    public void testOpenCartellaClinica(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.assertTitleEquals("CartellaClinica");
    }



}
