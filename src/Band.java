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
        this.fans = 1000;
        this.maxFans = 5000;
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

    public ArrayList<Venue> getVenues(){
        return venues;
    }

    //Metoder
    public void printBandProfile(){
        System.out.println("============ | " + bandName + " | ============");
        System.out.println("Name: " + bandName);
        System.out.println("Genre: " + genre);
        System.out.println("Fame Level: " + fameLevel);
        System.out.println("Fans: " + fans + "/" + maxFans);
        System.out.println("Fan percentage: " + getFanPercentage() + "%");
        System.out.println("XP: " + xp);
        System.out.println("Money: " + cash);
        System.out.println("Active: " + isActive());
        System.out.println();
    }

    public void gainFans(int fansToAdd){
        fans += fansToAdd;
        System.out.println("( ++ ) Gained " + fansToAdd + " fans");
        if(fans > maxFans){
            fans = maxFans;
        }
        if(fans > 0){
            isActive = true;
        }
    }

    public double getFanPercentage(){
        return (((double) fans / maxFans) * 100);
    }

    public void loseFans(int fansToRemove){
        fans -= fansToRemove;

        if(fans <= 0){
            fans = 0;
            isActive = false;
            System.out.println("( XX ) The band has broken up…");
        }

        System.out.println("( -- ) Lost " + fansToRemove + " fans");
        System.out.println();
    }

    public void earnMoney(double amount){
        cash += amount;
        System.out.println("( ++ ) Earned " + amount + "$");
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
            System.out.println();
            System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
            System.out.println("Leveled up! Your new level is:");
            System.out.println(getStatusTitle());
            System.out.println("Max fans limit is now: " + maxFans);
            System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
            System.out.println();
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
                maxFans = 1000000;
                break;
            default:
                System.out.println("( XX ) Error");
                break;
        }
    }

    public String getStatusTitle(){
        switch(fameLevel){
            case 1:
                return "( || ) Level 1: Unknown - Producing music in your bedroom";
            case 2:
                return "( || ) Level 2: Local DJ - Playing small club gigs";
            case 3:
                return "( || ) Level 3: Rising star - Festival invitations coming in";
            case 4:
                return "( || ) Level 4: Mainstream - Tomorrowland is calling";
            case 5:
                return "( || ) Level 5: Most respected DJ - Even David Guetta looks up to you";
            default:
                return "( XX ) Error";
        }
    }

    public boolean isLosingRelevance(){
        System.out.println("=========== | RELEVANCE CHECK | ===========");
        if(fans < (maxFans * 0.25)){
            System.out.println("( XX ) WARNING: Losing relevance! Consider a comeback strategy");
            return true;
        }
        else{
            System.out.println("( !! ) Healthy! Everything is running smoothly");
            return false;
        }
    }

    public boolean isActive(){
        return isActive;
    }



    //Sange metoder
    public void releaseSingle(String title, int duration, int streams){
        if(cash >= 1000){
            songs.add(new Song(title, duration, streams));
            System.out.println();
            System.out.println("======== | NEW MUSIC ALERT | ========");
            gainFans(1000);
            addXP(500);
            spendMoney(1000);
        }
        else{
            System.out.println("( XX ) Not enough money to release a single");
        }
        System.out.println();

    }

    public void removeSong(String songQuery){
        for(int i = 0; i < songs.size(); i++){
            Song song = songs.get(i);
            if(song.getTitle().equalsIgnoreCase(songQuery)){
                System.out.println(" ( !! ) " + song.getTitle() + " removed from repertoire");
                songs.remove(song);
                return;
            }
        }
        System.out.println("( XX ) Found no songs named " + songQuery);
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



    // Gig og venue metoder

    public void initiateVenue(Venue venue){
        venues.add(venue);
    }

    public void printVenues(){
        System.out.println("=========== | VENUES | ===========");
        for(Venue venue : venues){
            System.out.println("( -- ) " + venue);
        }
        System.out.println("=========== | END OF LIST | ===========");
    }


    public int playGig(String venueName){
        for(Venue venue : venues){
            if(venue != null){
                if(venue.getName().equalsIgnoreCase(venueName)){
                    int capacity = venue.getCapacity();
                    int minCapacity = capacity / 2; // dividerer med 2 her fordi så jeg sikrer mig at der altid er min 50% attendance
                    double payment = venue.getPayAmount();
                    int attendance = minCapacity + (int) (Math.random() * (capacity - minCapacity));
                    System.out.println();
                    System.out.println("=========== | " + bandName + " CONCERT SUMMARY | ===========");
                        if(attendance >= (capacity * 0.80)){
                            System.out.println("( ++ ) Attendance over 80%");
                            gainFans(1000);
                            earnMoney(payment);
                            addXP(1000);
                        }
                        else{
                            System.out.println("( XX ) Bummer! Attendance under 80%");
                            loseFans(500);
                            earnMoney(payment);
                        }
                    System.out.println("=========== | END OF SUMMARY | ===========");
                    System.out.println();
                    return attendance;
                }
            }
        }
        System.out.println("( XX ) No venue named " + venueName + " found");
        return 0;
    }
}
