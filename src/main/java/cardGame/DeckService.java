package cardGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import cardGame.model.CardSpecials;
import cardGame.model.Suite;

@Service
public class DeckService {

	List<String> getNewDeck() {

		// List will help to have initial sorted Deck, against SET. 
	List<String> deck = new ArrayList<String>();
	int deckSize = 13;
		for (Suite s : Suite.values()) {
			for (int i=1; i<=deckSize; i++) {
				if ((i == 1 || i > 10)) {
					deck.add(CardSpecials.getCode(i) + "-" + s.getCode());
				}
				else deck.add(i + "-" + s.getCode());
			}
		}
		return deck;
	}
	
	// Simple Hand shuffle. taking out one set of cards and placing them on top of the deck.
		// repeat this process for few times. (minimum is set as 10, above)
		List<String> simpleHandShuffle(List<String> deck) {
			int max = deck.size(); // always 52
			int i = (int) (Math.random() * max);		
			int j = (int) (Math.random() * i);			
//			System.out.println(j + " " + i);
			
			List<String> temp = deck.subList(j, i);
			int s = temp.size();
			deck.addAll(0, temp);
			deck.subList(j+s, i+s).clear();
			
			return deck;
		}
		
		// splitting the deck in half and interleaving the two halves
		List<String> splitShuffle(List<String> deck) {
			List<String> temp1 = deck.subList(0, deck.size()/2);
			List<String> temp2 = deck.subList( deck.size()/2, deck.size());
			List<String> shuffled = new LinkedList<String>();
			for (int i=0; i<temp1.size(); i++) {
				shuffled.add(temp1.get(i));
				shuffled.add(temp2.get(i));
			}
			return shuffled;
			
			
		}
	
}
