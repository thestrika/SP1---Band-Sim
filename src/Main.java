public class Main {


    // VARIABLES / DECLARATIONS
    String bandName = "Talvo";
    int fans = 8500;
    int maxFans = 15000;
    int fameLevel = 2;
    int xp = 3200;
    double cash = 4750.50;
    boolean isActive = true;
    char genre = 'E';
    String[] repertoire = {"REACT", "Low", "Sweet Dreams", "Freestyler"};

    //METHODS
    /*
    void printBandProfile(){
        System.out.println("=== BAND PROFILE: TALVO ===");
        System.out.println("Name: " + bandName);
        System.out.println("Genre: " + genre);
        System.out.println("Fame Level: " + fameLevel);
        System.out.println("Fans: " + fans + "/" + maxFans);
        System.out.println(xp);
        System.out.println("Money: " + cash);
        System.out.println("Active: " + isActive);
        System.out.println();
    }

     */

    // GIG SIMULATION
    void playGig(int venueCapacity, int attendance){
        System.out.println("=== CONCERT ===");
        if(attendance >= venueCapacity * 0.80){
            fans += 200;
            System.out.println("Attendance over 80% of capacity. You gained 200 fans.");
            System.out.println("Your total amount of fans is now: " + fans);
        }
        else{
            fans += 50;
            System.out.println("Attendance under 80% of capacity. You gained 50 fans.");
            System.out.println("Your total amount of fans is now: " + fans);
        }
        cash += 1500.0;
        System.out.println("You were paid +1500$ for the show");
        System.out.println("Your total cash balance is now: " + cash);
        System.out.println();
    }

    //GAIN FANS


    //LOSE FANS


    //EARN MONEY


    //SPEND MONEY







    // RELEVANCE CHECK



    // ACTIVITY CHECK


    // REPERTOIRE



    // GET STATUS --------------------- MANGLER RETURN --------------------- note til mig selv: vender tilbage til senere
    void getStatusTitle(String status){

    }

    // RANDOM EVENT
    void randomEvent(int eventType){
        System.out.println("=== RANDOM EVENT ===");

        if(eventType == 1){
            fans += 500;
            System.out.println("Amazing show in Ibiza!: +500 fans");
            System.out.println("You now have: " + fans + " fans");
        }
        else if(eventType == 2){
            System.out.println("Been sick all week. No progress");
        }
        else{
            fans -= 100;
            System.out.println("Scandal! Speakers disconnected for an entire show: -300 fans");
            System.out.println("You now have: " + fans + " fans");
        }
    }










    void main(){





















        /*
        // Rival band: BEAUZ
        String rivalBand = "BEAUZ";
        int rivalFans = 220000;
        int rivalMaxFans = 230000;
        int rivalFameLevel = 22;
        int rivalXP = 2200;
        double rivalCash = 30000;
        boolean rivalIsActive = true;
        char rivalGenre = 'E';

        String[] rivalSongs = {"Look At Me Now", "Obsessed", "Stereo Dreams", "Ocho"};

        System.out.println("/// BAND PROFILE BEAUZ ///");
        System.out.println("Name: " + rivalBand);
        System.out.println("Genre: " + rivalGenre);
        System.out.println("Fame Level: " + rivalFameLevel);
        System.out.println("Fans: " + rivalFans + "/" + rivalMaxFans);
        System.out.println(rivalXP);
        System.out.println("Money: " + rivalCash);
        System.out.println("Active: " + rivalIsActive);

        System.out.println(" ");

        System.out.println("Repertoire: (4 songs)");
        System.out.println("- " + rivalSongs[0]);
        System.out.println("- " + rivalSongs[1]);
        System.out.println("- " + rivalSongs[2]);
        System.out.println("- " + rivalSongs[3]);
        System.out.println(" ");

         */



    }

}
