import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

public class testVisita {
    private WebTester tester;

    @Before
    public void prepare(){
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080");
    }

    @Test
    public void testCorrectInput(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.assertTitleEquals("Scheda visita");
        tester.assertTextPresent("noteVisita");

    }

    @Test
    public void testOpenHome(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.clickLinkWithText("Home");
        tester.assertTitleEquals("Home medico");

    }

    @Test
    public void testOpenCartellaClinica(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.clickLinkWithText("Cartella clinica paziente");
        tester.assertTitleEquals("CartellaClinica");

    }


}
