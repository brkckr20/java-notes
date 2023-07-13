
package maceraOyunu;

import java.util.Scanner;


public class Game {
    Player player;
    Location location;
    
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Macera oyununa hoşgeldiniz.");
        System.out.print("Oyuna başlamadan önce ismininizi giriniz : ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectChar();
    }
}
