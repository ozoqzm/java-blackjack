package domain;

import java.util.List;

public class Dealer {
    private List<Card> cards;

    public Dealer() {}
    public Dealer(List<Card> cards) {}

    public List<Card> getCards() {
        return cards;
    }
}
