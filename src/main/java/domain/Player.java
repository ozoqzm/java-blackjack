package domain;

import java.util.List;

public class Player {
    private List<Card> cards;

    public Player() {}

    public Player(List<Card> cards) {}

    public List<Card> getCards() {
        return cards;
    }
}
