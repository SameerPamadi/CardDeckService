package cardGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

	@Autowired
	private DeckService deckService;
	
	private final String SIMPLE_HAND = "simpleHand";
	private final String SPLIT = "split";
	private final String RANDOM = "random";
	
	private Map<String, List<String>> cards = new HashMap<String, List<String>>();
	
	public Map<String, List<String>> getCards() {
		if (cards == null) {
			cards = new HashMap<String, List<String>>();
		}
		return cards;
	}
	
	public void setCards(Map<String, List<String>> cards) {
		this.cards = cards;
	}

	void addDeck(String deckName) {
		cards.put(deckName, deckService.getNewDeck());
	}
	
	void removeDeck(String deckName) {
		cards.remove(deckName);
	}
	
	List<String> getDeck(String deckName) {
		List<String> aDeck;
		aDeck = cards.get(deckName);
		return aDeck;
	}
	
	List<String> shuffle(String deckName, String shuffleType, Integer shuffleCount) {

		List<String> deck = cards.get(deckName);
		while (shuffleCount != 0 && deck !=null) {
			switch(shuffleType) {
				case SIMPLE_HAND: 	deck = deckService.simpleHandShuffle(deck);
								  	break;
				case SPLIT: 	  	deck = deckService.splitShuffle(deck);
								  	break;
				case RANDOM:		Collections.shuffle(deck);
									break;
				default: 			return null;
			}
			shuffleCount--;
		}
		return deck;
	}
	
}
