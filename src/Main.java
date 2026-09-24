import java.util.Scanner;
public class Main {

    private static boolean running = true;
    private static boolean bandCreated = false;
    private Scanner myScanner = new Scanner(System.in);
    private String name;
    private char genre;


    void main(){


        displayAsci();



        while(bandCreated == false){
            System.out.println("=!=!=!=!=!=! CREATE BAND !=!=!=!=!=!=");
            System.out.print("Enter band name: ");
            name = myScanner.nextLine();
            System.out.println();
            System.out.println("(R) Rock | (E) Electronic | (H) Hip Hop | (P) Pop");
            System.out.print("Enter genre: ");
            genre = myScanner.next().charAt(0);
            bandCreated = true;
        }

        Band band1 = new Band(name, genre);

        while(running){
            clearConsole();
            displayAsci();
            displayMenu();
            int menuInput = myScanner.nextInt();
            myScanner.nextLine();

            if(menuInput >= 1 && menuInput <= 5){
                switch (menuInput){
                    case 1:
                        band1.printBandProfile();
                        break;
                    case 2:
                        //band1.playGig();
                        break;
                    case 3:
                        System.out.println("Enter song name:");
                        String singleTitle = myScanner.nextLine();
                        System.out.println("Enter duration");
                        int singleDuration = myScanner.nextInt();
                        System.out.println("Enter amount of streams");
                        int singleStreams = myScanner.nextInt();
                        band1.releaseSingle(singleTitle, singleDuration, singleStreams);
                        break;
                    case 4:
                        System.out.println("Enter song title to remove");
                        String titleQuery = myScanner.nextLine();
                        band1.removeSong(titleQuery);
                        break;
                    case 5:
                        band1.printRepertoire();
                        break;
                }
            }
            else{
                System.out.println("Invalid input");
            }
            System.out.println("Press enter to continue");
            myScanner.nextLine();

        }
    }




    public void displayMenu(){
        System.out.println("============ | MAIN MENU | ============");
        System.out.println("1) Print band stats");
        System.out.println("2) Play gig");
        System.out.println("3) Release single");
        System.out.println("4) Remove song");
        System.out.println("5) Print repertoire");
        System.out.println("============ | CHOOSE | ============");
    }

    public void assignVenues(){
        switch(genre){
            case 'R':
                break;
            case 'E':
                Venue tomorrowland = new Venue("Tomorrowland", 10000, 2000);
                Venue edc = new Venue("EDC", 5000, 1000);
                Venue defqon = new Venue("Defqon", 20000, 4000);
                break;
            case 'H':
                break;
            case 'P':
                break;
        }
    }












    public void displayAsci(){
        System.out.println(":::::::::      :::     ::::    ::: :::::::::        :::::::: ::::::::::: ::::    ::::  \n" +
                ":+:    :+:   :+: :+:   :+:+:   :+: :+:    :+:      :+:    :+:    :+:     +:+:+: :+:+:+ \n" +
                "+:+    +:+  +:+   +:+  :+:+:+  +:+ +:+    +:+      +:+           +:+     +:+ +:+:+ +:+ \n" +
                "+#++:++#+  +#++:++#++: +#+ +:+ +#+ +#+    +:+      +#++:++#++    +#+     +#+  +:+  +#+ \n" +
                "+#+    +#+ +#+     +#+ +#+  +#+#+# +#+    +#+             +#+    +#+     +#+       +#+ \n" +
                "#+#    #+# #+#     #+# #+#   #+#+# #+#    #+#      #+#    #+#    #+#     #+#       #+# \n" +
                "#########  ###     ### ###    #### #########        ######## ########### ###       ### ");
        System.out.println();
    }

    static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
