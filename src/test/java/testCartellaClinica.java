import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

public class testCartellaClinica {

    private WebTester tester;

    @Before
    public void prepare(){
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080");

    }

    @Test
    public void testOpenHome(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 1 );
        tester.assertTitleEquals("CartellaClinica");
        tester.clickLinkWithText("Home");
        tester.assertTitleEquals("Home medico");
    }


    @Test
    public void testOpenNuovaDiagnosi(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Inserimento diagnosi");
        tester.assertTitleEquals("Inserimento diagnosi");
    }

    @Test
    public void testOpenNuovaVisita(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.assertTitleEquals("Inserimento visita");
    }

    @Test
    public void testOpenSegnalazione(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("SEGNALA PROBLEMA URGENTE");
        tester.assertTitleEquals("Pagina segnalazione");
        tester.clickLinkWithText("Home");
        tester.assertTitleEquals("Home medico");
    }

}
