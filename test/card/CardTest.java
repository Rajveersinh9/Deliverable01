/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package card;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rajvi
 */
public class CardTest {

    private Card card1;
    private Card card2;
    private Card card3;

    @BeforeClass
    public static void setUpClass() {
        // Code to run before all tests (if needed)
    }

    @AfterClass
    public static void tearDownClass() {
        // Code to run after all tests (if needed)
    }

    @Before
    public void setUp() {
        card1 = new Card("Ace", "Spades");
        card2 = new Card("10", "Hearts");
        card3 = new Card("Ace", "Spades");
    }

    @After
    public void tearDown() {
        // Code to run after each test (if needed)
    }

    /**
     * Test of getRank method, of class Card.
    
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Card instance = null;
        String expResult = "";
        String result = instance.getRank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    
    /**
     * Test of toString method, of class Card.
     */
     @Test
    public void testGetRankGood() {
        System.out.println("getRank Good");
        String expected = "Ace";
        String result = card1.getRank();
        assertEquals(expected, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetRankBad() {
        System.out.println("getRank Bad");
        String expected = "King";
        String result = card1.getRank();
        assertNotEquals(expected, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetRankBoundary() {
        System.out.println("getRank Boundary");
        String expected = "";
        Card emptyRankCard = new Card("", "Spades");
        String result = emptyRankCard.getRank();
        assertEquals(expected, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    // Testing getSuit method
    @Test
    public void testGetSuitGood() {
        System.out.println("getSuit Good");
        String expected = "Spades";
        String result = card1.getSuit();
        assertEquals(expected, result);
// TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetSuitBad() {
        System.out.println("getSuit Bad");
        String expected = "Clubs";
        String result = card1.getSuit();
        assertNotEquals(expected, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetSuitBoundary() {
        System.out.println("getSuit Boundary");
        String expected = "";
        Card emptySuitCard = new Card("Ace", "");
        String result = emptySuitCard.getSuit();
        assertEquals(expected, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    // Testing equals method
    @Test
    public void testEqualsGood() {
        System.out.println("equals Good");
        boolean result = card1.equals(card3);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testEqualsBad() {
        System.out.println("equals Bad");
        boolean result = card1.equals(card2);
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testEqualsBoundary() {
        System.out.println("equals Boundary");
        boolean result = card1.equals(null);
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
