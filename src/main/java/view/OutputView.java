package view;

import domain.Card;
import domain.Dealer;
import domain.Player;

import java.util.List;

public class OutputView {
    // 해당 플레이어가 가지고 있는 카드 출력
    public List<Card> playerCard(Player player) {
        return player.getCards();
    }

    // 딜러가 가지고 있는 카드 출력
//    public List<Card> dealerCard(Dealer dealer) {
//        return dealer.getCards();
//    }
//

}
