package domain;

import java.util.List;

public class Dealer {
    private List<Card> cards;

    public Dealer() {}
    public Dealer(List<Card> cards) {}

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getCardValue() {
        // 카드 값 계산
    }
    public List<Card> getCards() {
        return cards;
    }
    public void showCard() {
        System.out.println("딜러 카드: " + cards + " - 결과: " + getCardValue());
    }
}
