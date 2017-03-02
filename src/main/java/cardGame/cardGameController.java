package cardGame;

import java.util.List;
import java.util.Map;
//import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cardGameController {
	
	@Autowired
	private CardService cardService;

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/test")
//    public Greeting test(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }

	// retrieve all Cards - all named decks.
    @RequestMapping("/cards/decks")
    public Map<String, List<String>> getCards() {
    	return cardService.getCards();
    }

    // retrieve one named Deck.
    @RequestMapping("/cards/decks/{deckName}")
    public List<String> getDeck(@PathVariable String deckName) {
    	return cardService.getDeck(deckName);
    }

    // Delete a named Deck.
    @RequestMapping(method=RequestMethod.DELETE, path="/cards/decks/{deckName}")
    public void deleteDeck(@PathVariable String deckName) {
    	cardService.removeDeck(deckName);
    }

    // Ideally POST should  be used here, for creation of new Resource.
    @RequestMapping(method=RequestMethod.POST, path="/cards/decks/{deckName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addDeck(@PathVariable String deckName) {
    	cardService.addDeck(deckName);
    }

    // Ideally this should be PUT (update a resource; resource reference is shared as pathParam).
    @RequestMapping(method=RequestMethod.PUT, path="/cards/decks/{deckName}/shuffle/{shuffleType}")
    public List<String> shuffleDeck(@PathVariable String deckName, @PathVariable String shuffleType,
    		@RequestParam(value="shuffleCount", defaultValue="10") String shuffleCount, HttpServletResponse response) {
    	List<String> deck = cardService.shuffle(deckName, shuffleType, Integer.valueOf(shuffleCount));
    	
    	if (deck == null) {
    		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    	}
    	return deck;
    	
    }

}