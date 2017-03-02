package cardGame;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class DeckServiceTest {

	private DeckService deckService;
	
	@Before
	public void setUp() {
		deckService = new DeckService();
	}

	@Test
	public void testCreate() {
		List<String> deck = deckService.getNewDeck();
		List<String> expectedDeck = new ArrayList<String>();
		
		// Now building the Deck manually and comparing with the program built deck
		// (both scenario - deck with missing card and complete 52 card deck)
		expectedDeck.add("A-spade");
		expectedDeck.add("2-spade");
		expectedDeck.add("3-spade");
		expectedDeck.add("4-spade");
		expectedDeck.add("5-spade");
		expectedDeck.add("6-spade");
		expectedDeck.add("7-spade");
		expectedDeck.add("8-spade");
		expectedDeck.add("9-spade");
		expectedDeck.add("10-spade");
		expectedDeck.add("J-spade");
		expectedDeck.add("Q-spade");
		expectedDeck.add("K-spade");
		expectedDeck.add("A-club");
		expectedDeck.add("2-club");
		expectedDeck.add("3-club");
		expectedDeck.add("4-club");
		expectedDeck.add("5-club");
		expectedDeck.add("6-club");
		expectedDeck.add("7-club");
		expectedDeck.add("8-club");
		expectedDeck.add("9-club");
		expectedDeck.add("10-club");
		expectedDeck.add("J-club");
		expectedDeck.add("Q-club");
		expectedDeck.add("K-club");
		expectedDeck.add("A-diamond");
		expectedDeck.add("2-diamond");
		expectedDeck.add("3-diamond");
		expectedDeck.add("4-diamond");
		expectedDeck.add("5-diamond");
		expectedDeck.add("6-diamond");
		expectedDeck.add("7-diamond");
		expectedDeck.add("8-diamond");
		expectedDeck.add("9-diamond");
		expectedDeck.add("10-diamond");
		expectedDeck.add("J-diamond");
		expectedDeck.add("Q-diamond");
		expectedDeck.add("K-diamond");
		expectedDeck.add("A-heart");
		expectedDeck.add("2-heart");
		expectedDeck.add("3-heart");
		expectedDeck.add("4-heart");
		expectedDeck.add("5-heart");
		expectedDeck.add("6-heart");
		expectedDeck.add("7-heart");
		expectedDeck.add("8-heart");
		expectedDeck.add("9-heart");
		expectedDeck.add("10-heart");
		expectedDeck.add("J-heart");
		expectedDeck.add("Q-heart");
		// not adding the last card of deck yet.

		// expected and built deck are not equal
		assertNotEquals(expectedDeck, deck);
		
		// now adding all the cards to the deck.
		expectedDeck.add("K-heart");
		assertEquals(expectedDeck, deck);
		
		
	}
}
