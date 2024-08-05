package domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Card> cards = new ArrayList<>();
    private double profit = 0;

    public Dealer() {}
    public Dealer(List<Card> cards) {}

    public void addCard(Card card) {
        cards.add(card);
    }
    public void setProfit(int profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }
    public void win(double amount) {
        profit += amount;
    }

    public void lose(double amount) {
        profit -= amount;
    }
    public int getCardValue() {
        // 카드 값 계산
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.isAce()) {
                aceCount++;
            }
        }
        while (value <= 11 && aceCount > 0) {
            value += 10;
            aceCount--;
        }
        return value;
    }
    public List<Card> getCards() {
        return cards;
    }
    public void showCard() {
        System.out.println("딜러 카드: " + cards + " - 결과: " + getCardValue());
    }
}
