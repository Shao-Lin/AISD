import java.util.Objects;

public class Card  {
    private final String suit;
    private final String value;

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }
    public boolean equals(Object o){
        Card card = (Card) o;
        return Objects.equals(suit, card.suit) || Objects.equals(value,card.value);
    }
    public String toString(){
        return value + " " + "of" + " " + suit;
    }
}
