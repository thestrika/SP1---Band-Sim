import java.util.ArrayList;

public class Band {

    private String bandName;
    private int fans;
    private int maxFans;
    private int fameLevel;
    private int xp;
    private double cash;
    private boolean isActive;
    private char genre;
    private ArrayList<Song> songs;
    private ArrayList<Venue> venues;

    public Band(String bandName, char genre){
        this.bandName = bandName;
        this.fans = 0;
        this.maxFans = 0;
        this.fameLevel = 1;
        this.xp = 0;
        this.cash = 1000;
        this.isActive = true;
        this.genre = genre;
        this.songs = new ArrayList<>();
        this.venues = new ArrayList<>();
    }

    //Getters
    public String getBandName(){
        return bandName;
    }
    public int getFans(){
        return fans;
    }
    public int getMaxFans(){
        return maxFans;
    }
    public int getFameLevel(){
        return fameLevel;
    }
    public int getXp(){
        return xp;
    }
    public double getCash(){
        return cash;
    }
    public boolean getActiveStatus(){
        return isActive;
    }
    public char getGenre(){
        return genre;
    }

    //Metoder
    public void printBandProfile(){
        System.out.println("===" + bandName + "===");
        System.out.println("Name: " + bandName);
        System.out.println("Genre: " + genre);
        System.out.println("Fame Level: " + fameLevel);
        System.out.println("Fans: " + fans + "/" + maxFans);
        System.out.println("XP: " + xp);
        System.out.println("Money: " + cash);
        System.out.println("Active: " + isActive);
        System.out.println();
    }

    public void gainFans(int fansToAdd){
        fans += fansToAdd;
        System.out.println("( ++ ) Gained " + fansToAdd + " fans");
    }

    public void loseFans(int fansToRemove){
        fans -= fansToRemove;
        System.out.println("( -- ) Lost " + fansToRemove + " fans");
    }

    public void earnMoney(double amount){
        cash += amount;
        System.out.println("( ++ ) Earned " + amount + "$");
        return;
    }

    public boolean spendMoney(double amount) {
        if (amount <= cash) {
            cash -= amount;
            System.out.println("( -- ) Spent " + amount + "$");
            return true;
        } else {
            System.out.println("( XX ) Insufficient balance");
            return false;
        }
    }

    public void addXP(int amount){
        xp += amount;
        System.out.println("( ++ ) Gained XP amount " + xp + ". Checking for level up...");
        if(xp > (2000 * fameLevel)){
            System.out.println("( || )Ready to level up!");
            levelUp();
        }
        else{
            System.out.println("( XX ) Not ready for level up...");
        }
    }

    public void levelUp(){
        if(fameLevel != 5){
            fameLevel += 1;
            xp = 0;
            increaseMaxFans();
            System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
            System.out.println("Leveled up! Your new level is:");
            levelChecker();
            System.out.println("Max fans limit is now: " + maxFans);
            System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        }
    }

    public void increaseMaxFans(){
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
                System.out.println("( XX ) Error");
                break;
        }
    }

    public void levelChecker(){
        switch(fameLevel){
            case 1:
                System.out.println("( || ) Level 1: Unknown - Producing music in your bedroom");
                break;
            case 2:
                System.out.println("( || ) Level 2: Local DJ - Playing small club gigs");
                break;
            case 3:
                System.out.println("( || ) Level 3: Rising star - Festival invitations coming in");
                break;
            case 4:
                System.out.println("( || ) Level 4: Mainstream - Tomorrowland is calling");
                break;
            case 5:
                System.out.println("( || ) Level 5: Most respected DJ - Even David Guetta looks up to you");
                break;
            default:
                System.out.println("( XX ) Error");
                break;
        }
    }

    public boolean isLosingRelevance(){
        System.out.println("=== STATUS CHECK ===");
        if(fans < (maxFans * 0.75)){
            System.out.println("( XX ) WARNING: Losing relevance! Consider a comeback strategy");
            return true;
        }
        else{
            System.out.println("( !! ) Healthy! Everything is running smoothly");
            return false;
        }
    }

    public boolean isActive(){
        if(fans <= 0){
            System.out.println("( XX ) The band has broken up…");
            return false;
        }
        else{
            return true;
        }
    }



    //Sange metoder
    public void releaseSingle(String title, int duration, int streams){
        songs.add(new Song(title, duration, streams));
        addXP(500);
        gainFans(1000);
        System.out.println("( ++ ) A new single was released!");
    }

    public void removeSong(String songQuery){
        for(Song song : songs){
            if(song != null){
                if(song.getTitle().equalsIgnoreCase(songQuery)){
                    System.out.println(" ( !! ) " + song.getTitle() + " removed from repertoire");
                    songs.remove(song);
                }
                else{
                    System.out.println("( XX ) Found no songs named " + song.getTitle());
                }
            }
        }
    }
    public boolean hasSong(String songQuery){
        for(Song song : songs){
            if(song != null){
                if(song.getTitle().equalsIgnoreCase(songQuery)){
                    return true;
                }
            }
        }
        return false;
    }
    public void printRepertoire(){
        for(Song song : songs){
            if(song != null){
                System.out.println("( -- ) " + song);
            }
        }
        System.out.println("( -- ) Total songs in repertoire: " + songs.size());
    }



    // Gig metoder

    public void playGig(String venueName){
        for(Venue venue : venues){
            if(venue != null){
                if(venue.getName().equalsIgnoreCase(venueName)){
                    int capacity = venue.getCapacity();
                    int minCapacity = capacity / 2; // dividerer med 2 her fordi så jeg sikrer mig at der altid er min 50% attendance
                    double payment = venue.getPayAmount();
                    int attendance = (int) (Math.random() * (capacity - minCapacity));
                    System.out.println("=== ( !! ) CONCERT SUMMARY ( !! ) ===");
                        if(attendance >= capacity * 0.80){
                            System.out.println("( ++ ) Attendance over 80%");
                            gainFans(1000);
                            earnMoney(payment);
                        }
                        else{
                            System.out.println("( XX ) Bummer! Attendance under 80%");
                            gainFans(200);
                            earnMoney(payment);
                        }
                    System.out.println("=== ( XX ) END OF SUMMARY ( XX ) ===");
                }
                else {
                    System.out.println("( XX ) No venue named " + venueName + " found");
                }
            }
        }
    }





}
