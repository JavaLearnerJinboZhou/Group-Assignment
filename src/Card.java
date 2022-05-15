public class Card {
    private String description;
    private final String UNKNOWN = "Unknown";
    private static String shorthand;

    public Card(String shorthand) {
        Card.shorthand = shorthand;
        setDescription();
    }

    private void setDescription() {
        if (shorthand.length() < 2 || shorthand.length() > 3){
            description = UNKNOWN;
            return;
        }
        String rank = getRank();
        Character suit = getSuit();
        if(rank.equals(UNKNOWN)) description = UNKNOWN;
        else description = rank + " of " + suit;
    }

    public String getDescription() {
        return description;
    }

    public String getRank(){
        return shorthand.substring(0,shorthand.length() - 1);
    }
    public Character getSuit(){
        return shorthand.charAt(shorthand.length()-1);
    }

    /**
     * @param rank Card's rank (A,2,3,5,5,6,7,8,9,10,J,Q,K)
     * @param suit Card's suit (clubs, diamonds, hearts, spades)
     * @return image path
     */
    //get the image file path method.
    public static String imagePath(String rank, Character suit){
        return   "./Poker Card/"+ rank + suit + ".png";
    }
}
