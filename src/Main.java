import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    private static boolean running = true;
    private static boolean bandCreated = false;
    private Scanner myScanner = new Scanner(System.in);
    private String name;
    private char genre;
    private Band band1;
    private Band opponent;


    void main(){
        displayAsci();

        while(! bandCreated){
            createBand();
        }

        band1 = new Band(name, genre);
        assignVenues(band1);

        while(running){
            clearConsole();
            displayAsci();
            displayMenu();
            int menuInput = myScanner.nextInt();
            myScanner.nextLine();

            if(menuInput >= 1 && menuInput <= 6){
                switch (menuInput){
                    case 1:
                        band1.printBandProfile();
                        break;
                    case 2:
                        band1.printVenues();
                        System.out.println("Pick a stage:");
                        String venue = myScanner.nextLine();
                        band1.playGig(venue);
                        break;
                    case 3:
                        System.out.println("Enter song name:");
                        String singleTitle = myScanner.nextLine();
                        System.out.println("Enter duration");
                        int singleDuration = myScanner.nextInt();
                        System.out.println("Enter amount of streams");
                        int singleStreams = myScanner.nextInt();
                        band1.releaseSingle(singleTitle, singleDuration, singleStreams);
                        myScanner.nextLine();
                        break;
                    case 4:
                        System.out.println("Enter song title to remove");
                        String titleQuery = myScanner.nextLine();
                        band1.removeSong(titleQuery);
                        break;
                    case 5:
                        band1.printRepertoire();
                        break;
                    case 6:
                        createBand();
                        opponent = new Band(name, genre);
                        assignVenues(opponent);
                        battle();
                        myScanner.nextLine();
                        break;
                }
            }
            else{
                System.out.println("Invalid input");
            }
            waitForEnter();
        }
    }




    public void displayMenu(){
        System.out.println("============ | MAIN MENU | ============");
        System.out.println("1) Print band stats");
        System.out.println("2) Play gig");
        System.out.println("3) Release single");
        System.out.println("4) Remove song");
        System.out.println("5) Print repertoire");
        System.out.println("============ | MINIGAMES | ============");
        System.out.println("6) Battle of the bands");
        System.out.println("============ | CHOOSE | ============");
    }

    public void createBand(){
        System.out.println("============ | CREATE BAND | ===========");
        System.out.print("Enter band name: ");
        name = myScanner.nextLine();
        System.out.println();
        System.out.println("(R) Rock | (E) Electronic | (H) Hip Hop | (P) Pop");
        System.out.print("Enter genre: ");
        genre = myScanner.next().charAt(0);
        bandCreated = true;
    }

    public void assignVenues(Band band){
        switch(genre){
            case 'R':
                Venue smallStage = new Venue("Small stage", 1000, 2000);
                Venue mediumStage = new Venue("Medium stage", 5000, 3000);
                Venue arena = new Venue("Arena", 20000, 4000);
                band.initiateVenue(smallStage);
                band.initiateVenue(mediumStage);
                band.initiateVenue(arena);
                break;
            case 'E':
                Venue tomorrowland = new Venue("Tomorrowland", 1000, 2000);
                Venue edc = new Venue("EDC", 5000, 3000);
                Venue defqon = new Venue("Tomorrowland mainstage", 20000, 4000);
                band.initiateVenue(tomorrowland);
                band.initiateVenue(edc);
                band.initiateVenue(defqon);
                break;
            case 'H':

                Venue underground = new Venue("Underground", 1000, 2000);
                Venue rapBattle = new Venue("Rap battle", 5000, 3000);
                Venue stadium = new Venue("Stadium", 20000, 4000);
                band.initiateVenue(underground);
                band.initiateVenue(rapBattle);
                band.initiateVenue(stadium);
                break;
            case 'P':
                Venue localBar = new Venue("Local bar", 1000, 2000);
                Venue festival = new Venue("Festival", 5000, 3000);
                Venue superStadium = new Venue("Super stadium", 20000, 4000);
                band.initiateVenue(localBar);
                band.initiateVenue(festival);
                band.initiateVenue(superStadium);
                break;
        }
    }

    public void battle(){
        ArrayList<Venue> bandVenues = band1.getVenues();
        ArrayList<Venue> opponentVenues = opponent.getVenues();
        int bandScore = 0;
        int opponentScore = 0;

        for(int i = 0; i < bandVenues.size(); i++){
            System.out.println(battleAsci());

            int bandVenueIndex = (int) (Math.random() * bandVenues.size());
            int opponentVenueIndex = (int) (Math.random() * bandVenues.size());

            String mainChosenVenue = bandVenues.get(bandVenueIndex).getName();
            String opponentChosenVenue = opponentVenues.get(opponentVenueIndex).getName();

            opponentScore += opponent.playGig(opponentChosenVenue);
            bandScore += band1.playGig(mainChosenVenue);

        }
        System.out.println(resultAsci());
        System.out.println("======== | " + band1.getBandName() + " TOTAL ATTENDANCE" + " | ========");
        System.out.println(bandScore);
        System.out.println();
        System.out.println("======== | " + opponent.getBandName() + " TOTAL ATTENDANCE" + " | ========");
        System.out.println(opponentScore);

        if(bandScore > opponentScore){
            System.out.println(winAsci());
        }
        else if(bandScore < opponentScore){
            System.out.println(loseAsci());
        }
        else{
            System.out.println(tieAsci());
        }
    }


    static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void waitForEnter(){
        System.out.println("Press enter to continue");
        myScanner.nextLine();
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

    public String winAsci(){
        return "  _  __  _   _ __  _   __ __ _  __\n" +
                " | |/,',' \\ /// / ///7/ // // |/ /\n" +
                " | ,' / o |/ U / | V V // // || / \n" +
                "/_/   |_,' \\_,'  |_n_,'/_//_/|_/  \n" +
                "                                  ";
    }
    public String loseAsci(){
        return "  _  __  _   _ __  __   _    ___  ___\n" +
                " | |/,',' \\ /// / / / ,' \\ ,' _/ / _/\n" +
                " | ,' / o |/ U / / /_/ o |_\\ `. / _/ \n" +
                "/_/   |_,' \\_,' /___/|_,'/___,'/___/ \n" +
                "                                     ";
    }
    public String tieAsci(){
        return " _____  __  ___\n" +
                "/_  _/ / / / _/\n" +
                " / /  / / / _/ \n" +
                "/_/  /_/ /___/ \n" +
                "               ";
    }

    public String battleAsci(){
        return "   ___    _  _____ _____ __   ___\n" +
                "  / o.) .' \\/_  _//_  _// /  / _/\n" +
                " / o \\ / o / / /   / / / /_ / _/ \n" +
                "/___,'/_n_/ /_/   /_/ /___//___/ \n" +
                "                                 ";
    }

    public String resultAsci(){
        return "   ___   ___   ___ _ __ __ _____  ___\n" +
                "  / o | / _/ ,' _//// // //_  _/,' _/\n" +
                " /  ,' / _/ _\\ `./ U // /_ / / _\\ `. \n" +
                "/_/`_\\/___//___,'\\_,'/___//_/ /___,' \n" +
                "                                     ";
    }


}
