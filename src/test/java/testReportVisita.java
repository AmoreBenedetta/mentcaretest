import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

public class testReportVisita {

    private WebTester tester;

    @Before
    public void prepare(){
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080");

    }

    @Test
    public void testInsertPrescrizioneFromSchedaVisita(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.clickLinkWithText("Nuova prescrizione");

        tester.selectOption("farmaco", "Antiepilettico");
        tester.setTextField("descrizione","frequenza farmaco");
        tester.submit();

        tester.clickLinkWithText("Nuova prescrizione");
        tester.assertTitleEquals("Nuova prescrizione");
    }

    @Test
    public void testHomeFromSchedaVisita(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.clickLinkWithText("Nuova prescrizione");

        tester.selectOption("farmaco", "Antiepilettico");
        tester.setTextField("descrizione","frequenza farmaco");
        tester.submit();

        tester.clickLinkWithText("Home");
        tester.assertTitleEquals("Home medico");
    }

    @Test
    public void testCartellaClinicaFromSchedaVisita(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.clickLinkWithText("Nuova prescrizione");

        tester.selectOption("farmaco", "Antiepilettico");
        tester.setTextField("descrizione","frequenza farmaco");
        tester.submit();

        tester.clickLinkWithText("Cartella clinica paziente");
        tester.assertTitleEquals("CartellaClinica");
    }

    @Test
    public void testOpenReportFromCartellaClinica(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Nuova visita");
        tester.setTextField("note", "noteVisita");
        tester.submit();

        tester.clickLinkWithText("Nuova prescrizione");

        tester.selectOption("farmaco", "Antiepilettico");
        tester.setTextField("descrizione","frequenza farmaco");
        tester.submit();

        tester.clickLinkWithText("Cartella clinica paziente");
        tester.assertTitleEquals("CartellaClinica");

        tester.clickLinkWithText("Report", 0);
        tester.assertTitleEquals("Scheda visita");
        tester.assertTextNotPresent("Nuova prescrizione");
    }
}
