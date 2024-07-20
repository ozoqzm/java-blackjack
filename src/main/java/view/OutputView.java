package view;

import domain.Card;
import domain.Dealer;
import domain.Player;

import java.util.List;

public class OutputView {
    // 해당 플레이어가 가지고 있는 카드 출력

    public void showResult(List<Player> players, Dealer dealer) {
        for (Player player : players) {
            player.showCard();
        }
        dealer.showCard();
    }

    public void showWinner(List<Dealer> dealers, List<Player> players) {

    }
}
