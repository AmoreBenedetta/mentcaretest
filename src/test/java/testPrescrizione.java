import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

public class testPrescrizione {


    private WebTester tester;

    @Before
    public void prepare(){
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080");

    }

    @Test
    public void testInsertPrescrizione(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.assertTitleEquals("Scheda visita");
        tester.clickLinkWithText("Nuova prescrizione");

        tester.assertTitleEquals("Nuova prescrizione");
        tester.selectOption("farmaco", "Antiepilettico");
        tester.setTextField("descrizione","frequenza farmaco");
        tester.submit();

        tester.assertTitleEquals("Scheda visita");
        tester.assertTextPresent("Antiepilettico");
        tester.assertLinkPresentWithText("Nuova prescrizione");
    }

    @Test
    public void testInsertPrescrizioneResetButton(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.assertTitleEquals("Scheda visita");
        tester.clickLinkWithText("Nuova prescrizione");

        tester.assertTitleEquals("Nuova prescrizione");
        tester.selectOption("farmaco", "Antiepilettico");
        tester.setTextField("descrizione","frequenza farmaco");
        tester.reset();

        tester.assertTitleEquals("Nuova prescrizione");
        tester.assertTextFieldEquals("descrizione", "");

    }

    @Test
    public void testWrongInsertPrescrizione(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.assertTitleEquals("Scheda visita");
        tester.clickLinkWithText("Nuova prescrizione");

        tester.assertTitleEquals("Nuova prescrizione");
        tester.selectOption("farmaco", "Antiepilettico");
        //No inserimento note
        tester.submit();

        tester.assertTitleEquals("Nuova prescrizione");
        tester.assertTextPresent("Compilare il campo note/frequenza");
    }

    @Test
    public void testOpenCartellaClinica(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.assertTitleEquals("Scheda visita");
        tester.clickLinkWithText("Nuova prescrizione");

        tester.assertTitleEquals("Nuova prescrizione");
        tester.clickLinkWithText("Cartella clinica paziente");
        tester.assertTitleEquals("CartellaClinica");
    }

    @Test
    public void testOpenHome(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.assertTitleEquals("Scheda visita");
        tester.clickLinkWithText("Nuova prescrizione");

        tester.assertTitleEquals("Nuova prescrizione");
        tester.clickLinkWithText("Home");
        tester.assertTitleEquals("Home medico");
    }


}
