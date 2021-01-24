import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testDiagnosi {

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
        tester.clickLinkWithText("Inserimento diagnosi");

        tester.setTextField("nomediagnosi", "Anoressia");
        tester.setTextField("note", "-");
        tester.clickRadioOption("pericolo", "No");
        tester.submit();

        tester.assertTitleEquals("CartellaClinica");
        tester.assertTablePresent("tabellaDiagnosi");
        tester.assertTextInTable("tabellaDiagnosi","Anoressia");

    }


    @Test
    public void testWrongInsertNome() {

        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0);
        tester.clickLinkWithText("Inserimento diagnosi");

        tester.setTextField("note", "-");
        tester.clickRadioOption("pericolo", "No");
        tester.submit();

        tester.assertTitleEquals("Inserimento diagnosi");
        tester.assertTextPresent("Inserire nome diagnosi");
    }


    @Test
    public void testReturnHome(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Inserimento diagnosi");
        tester.clickLinkWithText("Home");
        tester.assertTitleEquals("Home medico");
    }

    @Test
    public void testReturnCartellaClinica(){
        tester.beginAt("/");
        tester.clickLinkWithText("Cartella clinica", 0 );
        tester.clickLinkWithText("Inserimento diagnosi");
        tester.clickLinkWithText("Cartella clinica paziente");
        tester.assertTitleEquals("CartellaClinica");
    }

}
