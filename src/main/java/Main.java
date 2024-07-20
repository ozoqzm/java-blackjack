import domain.Card;
import domain.Dealer;
import domain.Denomination;
import domain.Player;
import view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 제일 초반에 2개씩 나눠주기
        // 반복문으로 이름 리스트에서...
        InputView iv = new InputView();
        List<Player> players = createPlayers(iv.names());
        Dealer dealer = new Dealer();
        List<Card> deck = createDeck();
        Collections.shuffle(deck); // 요소 무작위 섞기

        for (Player player : players) {
            player.addCard(deck.remove(0));
            player.addCard(deck.remove(0));
        }
        dealer.addCard(deck.remove(0));
        dealer.addCard(deck.remove(0));

        // 플레이어들 카드 받기 여부 & 받기 반복
        // 마지막에 딜러 카드 추가 가능 여부 확인 후 받기
        // 받은 후엔 해당 플레이어 전체 카드 리스트 출력
        for (Player player : players) {
            while(true) {
                String answer = iv.whether(player.getName());
                if (answer.equals("y")) {
                    player.addCard(deck.remove(0));
                    player.onlyShowCard();
                    if (player.getCardValue() > 21)
                        break; // 초과 시 break
                }
                else
                    break;
            }
        }
        if (dealer.getCardValue() < 17) {// 딜러 카드값 16 이하일 때만 카드 받기
            dealer.addCard(deck.remove(0));
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }

        // 전체 카드 개수 출력 - 플레이어 리스트, 딜러 하나 받아와서

        // 플레이어와 딜러 중
        // 1. 21이거나 2. 21을 넘은 게 있으면 게임 종료

        // 최종 승패 결과 출력


    }
    private static List<Player> createPlayers(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name.trim()));
        }
        return players;
    }
    private static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>(); // 전체 카드들 리스트
        for (Denomination denomination : Denomination.values()) {
            for (int i = 0; i < 4; i++) { // 각 문양당 4장의 카드
                deck.add(new Card(denomination));
            }
        }
        return deck;
    }
}
