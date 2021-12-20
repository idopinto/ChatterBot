import java.util.*;

/**

 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns 
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after 
 * the selected reply (coin toss).
 * @author Ido Pinto
 */

class ChatterBot {
	/**
 	* constant (static final strings) which contains the prefix for legal request.
 	*/
	static final String REQUEST_PREFIX = "say ";
	/**
 	* constant (static final strings) which contain placeholders for legal and illegel requests.
 	*/
	static final String REQUESTED_PHRASE_PLACEHOLDER = "<phrase>";
	static final String ILLEGAL_REQUEST_PLACEHOLDER = "<request>";

	Random rand = new Random();
	/**
	 * Instance attributes. (Bot)
	 */
	String[] repliesToIllegalRequest; 
	String[] repliesToLegalRequest; 
    String name = ""; 


	/**
	 * Constructor
	 * @param name - The name of the "bot"
	 * @param repliesToLegalRequest -  Array of strings of possible replies for legal request
	 * @param repliesToIllegalRequest -  Array of strings of possible replies for illegal request
	 */
	ChatterBot(String name, String[] repliesToLegalRequest, String[] repliesToIllegalRequest) {
		this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
		this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
		this.name = name;
		for(int i = 0 ; i < repliesToIllegalRequest.length ; i = i+1) {
			this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
		}
		for(int j = 0 ; j < repliesToLegalRequest.length ; j = j+1) {
			this.repliesToLegalRequest[j] = repliesToLegalRequest[j];
		}
	}

	/**
	 * Accessor Method. 
	 * @return name (of the bot)
	 */
	String getName(){
		return this.name;
	}
	
	/**
	 * Class Method.
	 * this method wheter the given statement legal or not returns compatible replay (string) 
	 * @param statement - String , request from the bot.
	 * @return reply to statement
	 */
	String replyTo(String statement) {
		if(statement.startsWith(REQUEST_PREFIX)) {
			String phrase = statement.replaceFirst(REQUEST_PREFIX, "");
			return replacePlaceholderInARandomPattern(repliesToLegalRequest,REQUESTED_PHRASE_PLACEHOLDER, phrase);
			// return respondToLegalRequest(phrase);
		}
		return replacePlaceholderInARandomPattern(repliesToIllegalRequest,ILLEGAL_REQUEST_PLACEHOLDER, statement);
	}

	/**
	 * Class Function.
	 * this function return random string from the given replies array.
	 * In addition, the function replaces every 'placeHolder' with 'phrase'
	 * @param repliesArray - Legal or Ilegal replies array 
	 * @param placeHolder - REQUESTED_PHRASE_PLACEHOLDER or ILLEGAL_REQUEST_PLACEHOLDER
	 * @param phrase - the pharse to subtitute with placeHolder
	 * @return Fixed random string from repliesArray 
	 */
	String replacePlaceholderInARandomPattern(String[] repliesArray,String placeHolder,String phrase) {
		int randomIndex = rand.nextInt(repliesArray.length);
		String replay = repliesArray[randomIndex].replaceAll(placeHolder, phrase);
	 	return replay;

	}
}
