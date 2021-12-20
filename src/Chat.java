import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {

        String[] illegalReplies1 = { "say I LOVE MARVEL!", "I don't understand you. "+ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER+"?",
                                        "say what? " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "? what's " +ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "?",
                                        ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER+ "?! This Is Why Superman Works Alone."};
        String[] illegalReplies2 = { "say Holy Hole in a Doughnut!","Tell me what is "+ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER+"and I'll kiss you.",
                                    "whaaat "+ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER};
        String[] legalReplies1 = { "You want me to say " +ChatterBot.REQUESTED_PHRASE_PLACEHOLDER+" do you? alright: "+ChatterBot.REQUESTED_PHRASE_PLACEHOLDER, 
                                    "okay, here goes: "+ChatterBot.REQUESTED_PHRASE_PLACEHOLDER};
        String[] legalReplies2 = { "say "+ChatterBot.REQUESTED_PHRASE_PLACEHOLDER+"? okay: "+ChatterBot.REQUESTED_PHRASE_PLACEHOLDER ,
                                 "OH MY GOD okay! here: "+ChatterBot.REQUESTED_PHRASE_PLACEHOLDER+". Happy?" };
        ChatterBot[] bots = {new ChatterBot("Batman", legalReplies1,illegalReplies1),new ChatterBot("Robin", legalReplies2,illegalReplies2)};
        String statement = "";        
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; ; i++) {
            statement = bots[ i % bots.length ].replyTo(statement);
            System.out.println(bots[ i% bots.length].getName() + ": "+ statement);
            scanner.nextLine();
        }

    }
    
}
