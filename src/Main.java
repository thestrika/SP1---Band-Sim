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
    void gainFans(int fansToAdd){
        fans += fansToAdd;
        System.out.println("Gained " + fansToAdd + " fans. New total: " + fans);
    }

    //LOSE FANS
    void loseFans(int fansToRemove){
        fans -= fansToRemove;
        System.out.println("Lost " + fansToRemove + "fans. New total: " + fans);
    }

    //EARN MONEY
    void earnMoney(double amount){
        cash += amount;
        System.out.println("Earned: " + amount + "$. New cash balance: " + cash);
        return;
    }

    //SPEND MONEY --------------------- MANGLER RETURN --------------------- note til mig selv: vender tilbage til senere
    void spendMoney(double amount) {
        if (amount <= cash) {
            cash -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // ADD XP
    void addXP(int amount){
        xp += amount;
        System.out.println(amount + "XP gained. Checking for level up...");
        if(xp > (2000 * fameLevel)){
            System.out.println("Ready to level up!");
            levelUp();
        }
        else{
            System.out.println("Not ready for level up...");
        }
    }

    // LEVEL UP
    void levelUp(){
        if(fameLevel != 5){
            fameLevel += 1;
            xp = 0;
            increaseMaxFans();
            System.out.println("==============================");
            System.out.println("Leveled up! Your new level is:");
            levelChecker();
            System.out.println("Max fans limit is now: " + maxFans);
            System.out.println("==============================");
        }
    }

    //MAX FANS INCREASER
    void increaseMaxFans(){
        switch (fameLevel){
            case 1:
                maxFans = 5000;
                break;
            case 2:
                maxFans = 15000;
                break;
            case 3:
                maxFans = 50000;
                break;
            case 4:
                maxFans = 200000;
                break;
            case 5:
                maxFans = 1000000000;
                break;
            default:
                System.out.println("Error");
                break;
        }
    }


    //LEVEL CHECKER
    void levelChecker(){
        switch(fameLevel){
            case 1:
                System.out.println("Level 1: Unknown - Producing music in your bedroom");
                break;
            case 2:
                System.out.println("Level 2: Local DJ - Playing small club gigs");
                break;
            case 3:
                System.out.println("Level 3: Rising star - Festival invitations coming in");
                break;
            case 4:
                System.out.println("Level 4: Mainstream - Tomorrowland is calling");
                break;
            case 5:
                System.out.println("Level 5: Most respected DJ - Even David Guetta looks up to you");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    // RELEVANCE CHECK
    boolean isLosingRelevance(){
        System.out.println("=== STATUS CHECK ===");
        if(fans < (maxFans * 0.75)){
            System.out.println("WARNING: Losing relevance! Consider a comeback strategy");
            return true;
        }
        else{
            System.out.println("Healthy! Everything is running smoothly");
            return false;
        }
    }


    // ACTIVITY CHECK
    boolean isActive(){
        if(fans <= 0){
            System.out.println("The band has broken up…");
            return false;
        }
        else{
            return true;
        }

    }

    // REPERTOIRE
    void printRepertoire(){
        int songCounter = 0;
        System.out.println("=== REPERTOIRE ===");
        for(int i = 0; i < repertoire.length; i++){
            System.out.println("- " + repertoire[i]);
            songCounter++;
        }
        System.out.println();
        System.out.println("=== TOTAL SONGS ===");
        System.out.println(songCounter);
        System.out.println();
    }


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







        printBandProfile();









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
