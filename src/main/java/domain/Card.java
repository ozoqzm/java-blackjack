package domain;

public class Card {
    private Denomination denomination;

    // 카드 생성자
    public Card(Denomination denomination) {
        this.denomination = denomination;
    }

    public int getValue() {
        return denomination.getScore();
    }

    // Ace 인지 여부
    public boolean isAce() {
        return denomination.isAce();
    }

}
