//  | Author: Leticia Rossett
//  | Unit test cases to automate testing process in a program developed with agile principles.
//  | June 12th, 2020.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @BeforeEach
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @AfterEach
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("w0w 5ar4h, 7h47’5 4 gr347 p057!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("1 r3411y 10v3 r34d1ng 1h353 1h3yr3 411 50 c001");
        assertEquals(14, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("th15 15 a test15");
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("000000 111111 2222222 3333333 44444444");
        assertEquals(5, mycustomstring.countNumbers());
    }

    @Test
    public void testremoveEveryNthCharacter1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", mycustomstring.removeEveryNthCharacter(3, false));
    }

    @Test
    public void testremoveEveryNthCharacter2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", mycustomstring.removeEveryNthCharacter(3, true));
    }

    @Test
    public void testremoveEveryNthCharacter3() {
        mycustomstring.setString("Têm coisas que tem seu valor\n" +
                "Avaliado em quilates, em cifras e fins\n" +
                "E outras não têm o apreço\n" +
                "Nem pagam o preço que valem pra mim");
        assertEquals("Tê  c is s  ue te  s u  al r\n" +
                " va ia o  m  ui at s, em ci ra  e fi s\n" +
                "  o tr s  ão tê  o ap eç \n" +
                "N m  ag m   p eç  q e  al m  ra mi ", mycustomstring.removeEveryNthCharacter(3, true));
    }

    @Test
    public void testremoveEveryNthCharacter4() {
        mycustomstring.setString("Têm coisas que tem seu valor\n" +
                "Avaliado em quilates, em cifras e fins\n" +
                "E outras não têm o apreço\n" +
                "Nem pagam o preço que valem pra mim");
        assertEquals("Tmcia u e e ao\n" +
                "vlaoe ults mcfa  isEota ã ê  peoNmpgmopeoqevlmpamm", mycustomstring.removeEveryNthCharacter(2, false));
    }

    @Test
    public void testremoveEveryNthCharacter5() {
        mycustomstring.setString("\"I am what I am, an' I'm not ashamed. 'Never be ashamed,' my ol' dad used ter say, 'there's some who'll hold it against you, but they're not worth botherin' with.'\" — Rubeus Hagrid");
        assertEquals("\"I a wha I a, an I'mnot shamd. 'everbe ahame,' m ol'dad sed er sy, 'heres soe wh'll old t aginstyou,but hey'e no worh boheri' wih.'\"— Rueus agri", mycustomstring.removeEveryNthCharacter(5, false));
    }

    @Test
    public void testremoveEveryNthCharacter6() {
        mycustomstring.setString("\"I am what I am, an' I'm not ashamed. 'Never be ashamed,' my ol' dad used ter say, 'there's some who'll hold it against you, but they're not worth botherin' with.'\" — Rubeus Hagrid");
        assertEquals("\"I am what   am, an' I'  not ashame . 'Never be ashamed,' m  ol' dad us d ter say,  there's som  who'll hol  it against you, but th y're not wo th botherin  with.'\" —  ubeus Hagri ", mycustomstring.removeEveryNthCharacter(12, true));
    }

    @Test
    public void testremoveEveryNthCharacter7() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("                                                 ", mycustomstring.removeEveryNthCharacter(1, true));
    }

    @Test
    public void testremoveEveryNthCharacter8() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.removeEveryNthCharacter(1, false));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put szerome done-six1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("1 r3411y 10v3 r34d1ng 1h353 1h3yr3 411 50 c001");
        mycustomstring.convertDigitsToNamesInSubstring(7, 12);
        assertEquals("1 r341oney one-zerov3 r34d1ng 1h353 1h3yr3 411 50 c001", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("1 r3411y 10v3 r34d1ng 1h353 1h3yr3 411 50 c001");
        mycustomstring.convertDigitsToNamesInSubstring(1, 46);
        assertEquals("one rthree-four-one-oney one-zerovthree rthree-fourdoneng onehthree-five-three onehthreeyrthree four-one-one five-zero czero-zero-one", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("1 2 3 4 5 6 7 8 9");
        mycustomstring.convertDigitsToNamesInSubstring(1, 17);
        assertEquals("one two three four five six seven eight nine", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("12345 6789");
        mycustomstring.convertDigitsToNamesInSubstring(1, 5);
        assertEquals("one-two-three-four-five 6789", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("1-dois-3-quatro-5-seis-7-oito-9");
        mycustomstring.convertDigitsToNamesInSubstring(1, 30);
        assertEquals("one-dois-three-quatro-five-seis-seven-oito-9", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("123456789");
        mycustomstring.convertDigitsToNamesInSubstring(3, 5);
        assertEquals("12three-four-five6789", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("1 r3411y 10v3 r34d1ng 1h353 1h3yr3 411 50 c001");
        mycustomstring.convertDigitsToNamesInSubstring(10, 15);
        assertEquals("1 r3411y one-zerovthree r34d1ng 1h353 1h3yr3 411 50 c001", mycustomstring.getString());
    }
}
