package cardGame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CardServiceTest {

	@Mock
	private DeckService deckServiceMock;
	
	private CardService cardService;
	
	private List<String> mockDeck;
	
	private Map<String, List<String>> cards;
	
	@Before
	public void setUp() {
		deckServiceMock = Mockito.mock(DeckService.class);

		cardService = new CardService();
		cards = new HashMap<String, List<String>>();

		mockDeck = new ArrayList<String>();
		Whitebox.setInternalState(cardService, "deckService", deckServiceMock);
		Whitebox.setInternalState(cardService, "cards", cards);
	}
	
	@Test
	public void testAdd() {
		String deckName = "first";
		when(deckServiceMock.getNewDeck()).thenReturn(mockDeck);
		cardService.addDeck(deckName);
		assertNotNull(cardService.getDeck(deckName));
	}
	
	@Test
	public void testRemove() {
		String deckName = "first";
		when(deckServiceMock.getNewDeck()).thenReturn(mockDeck);
		cardService.removeDeck(deckName);
		assertNull(cardService.getDeck(deckName));
	}
	
	@Test
	public void testShuffle() {
		String deckName = "first";
		String shuffleType = "split";
		Integer shuffleCount = Integer.valueOf(5);
		when(deckServiceMock.simpleHandShuffle(mockDeck)).thenReturn(mockDeck);
		when(deckServiceMock.splitShuffle(mockDeck)).thenReturn(mockDeck);
		cardService.addDeck(deckName);

		List<String> d1 = cardService.shuffle(deckName, shuffleType, shuffleCount);
		assertEquals(mockDeck, d1);
		
		List<String> d2 = cardService.shuffle(deckName, "simpleHand", shuffleCount);
		assertEquals(mockDeck, d2);
		
		List<String> d3 = cardService.shuffle(deckName, "random", shuffleCount);
		assertEquals(mockDeck, d3);
		
		List<String> d4 = cardService.shuffle(deckName, "abc", shuffleCount);
		assertNull(d4);
	}
	
}
