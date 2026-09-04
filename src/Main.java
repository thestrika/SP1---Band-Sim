public class Main {

    void main(){

        // DELCLERATIONS
        String[] levelDescription = {"Level 1: Unknown - Producing on a cheap laptop in your bedroom", "Level 2: Beginner - Showing off your noob songs on SoundCloud", "Level 3: Intermediate - Slowly building a fanbase", "Level 4: Established - You have a small, but supportive fanbase", "Level 5: Rising - Indie record labels are now starting to take notice", "Level 6: Signed artist - You are now signed at a small record label", "Level 7: High momentum - Your songs are performing well on Spotify", "Level 8: Viral artist - One of your songs went viral on TikTok", "Level 9: Bigger and better - A major record label noticed your potential", "Level 10: Rising star - the label offered a contract", "Level 11: Tomorrowland - You played on a smaller stage at Tomorrowland", "Level 12: Managed artist - Label hired you a manager", "Level 13: Mainstage beginner - You are now playing mainstage at festivals", "Level 14: Mainstage intermediate - More people appear at your shows", "Level 15: Mainstage prodigy - People now show up at festivals specifically for you", "Level 16: God status - Your name now appears alongside artists who used to be your idols", "Level 17: B2B - You are playing B2B with names like David Guetta", "Level 18: Billboard Top 1: Your song hits #1 on Billboard", "Level 19: Spotify Top 1 - Your song sits at #1 on Spotify for 5 concurrent months", "Level 20: International - 99% of the world knows your face, even in rural towns", "Level 21: Best DJ/Producer - You are considered the best musician in recorded time, and manage to win every single award in every single category", "Level 22: - Final level. An unreal amount of fame. You are considered a god in most peoples eyes. Even aliens in distant galaxies consider you their god. Your music is discovered to heal every illness. you are chosen to rule the entire universe. Even Donald Trump bows down when he sees you."};




        // Band: Talvo
        String bandName = "Talvo";
        int fans = 40000;
        int maxFans = 50000;
        int fameLevel = 4;
        int xp = 400;
        double cash = 2500.0;
        boolean isActive = true;
        char genre = 'E';

        String[] songs = {"REACT", "Low", "Sweet Dreams", "Freestyler"};

        System.out.println("/// BAND PROFILE TALVO ///");
        System.out.println("Name: " + bandName);
        System.out.println("Genre: " + genre);
        System.out.println("Fame Level: " + fameLevel);
        System.out.println("Fans: " + fans + "/" + maxFans);
        System.out.println(xp);
        System.out.println("Money: " + cash);
        System.out.println("Active: " + isActive);

        System.out.println(" ");

        System.out.println("Repertoire: (4 songs)");
        System.out.println("- " + songs[0]);
        System.out.println("- " + songs[1]);
        System.out.println("- " + songs[2]);
        System.out.println("- " + songs[3]);
        System.out.println(" ");






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


        // STATUS CHECK LOGIC

        //ROCK
        if(fans < maxFans * 0.25 & genre == 'R'){
            System.out.println("WARNING: Rock band losing relevance! Consider a comeback strategy.");
        }

        if(fans <= 0 & genre == 'R'){
            isActive = false;
            System.out.println("The rock band has broken up...");
        }

        //ELECTRONIC
        if(fans < maxFans * 0.25 & genre == 'E'){
            System.out.println("WARNING: Electronic band losing relevance! Consider a comeback strategy.");
        }

        if(fans <= 0 & genre == 'E'){
            isActive = false;
            System.out.println("The electronic band has broken up...");
        }


        //HIP HOP
        if(fans < maxFans * 0.25 & genre == 'H'){
            System.out.println("WARNING: Hip Hop band losing relevance! Consider a comeback strategy.");
        }

        if(fans <= 0 & genre == 'H'){
            isActive = false;
            System.out.println("The Hip Hop band has broken up...");
        }

        //POP
        if(fans < maxFans * 0.25 & genre == 'P'){
            System.out.println("WARNING: Hip Hop band losing relevance! Consider a comeback strategy.");
        }

        if(fans <= 0 & genre == 'P'){
            isActive = false;
            System.out.println("The Hip Hop band has broken up...");
        }


        // FAME SYSTEM

        if(xp > 1000 * fameLevel){
            System.out.println("Ready to level up!");
        }


        if(fameLevel == 1){
            System.out.println(levelDescription[0]);
        }
        else if(fameLevel == 2){
            System.out.println(levelDescription[1]);
        }
        else if(fameLevel == 3){
            System.out.println(levelDescription[2]);
        }
        else if(fameLevel == 4){
            System.out.println(levelDescription[3]);
        }
        else if(fameLevel == 5){
            System.out.println(levelDescription[4]);
        }
        else if(fameLevel == 6){
            System.out.println(levelDescription[5]);
        }
        else if(fameLevel == 7){
            System.out.println(levelDescription[6]);
        }
        else if(fameLevel == 8){
            System.out.println(levelDescription[7]);
        }
        else if(fameLevel == 9){
            System.out.println(levelDescription[8]);
        }
        else if(fameLevel == 10){
            System.out.println(levelDescription[9]);
        }
        else if(fameLevel == 11){
            System.out.println(levelDescription[10]);
        }
        else if(fameLevel == 12){
            System.out.println(levelDescription[11]);
        }
        else if(fameLevel == 13){
            System.out.println(levelDescription[12]);
        }
        else if(fameLevel == 14){
            System.out.println(levelDescription[13]);
        }
        else if(fameLevel == 15){
            System.out.println(levelDescription[14]);
        }
        else if(fameLevel == 16){
            System.out.println(levelDescription[15]);
        }
        else if(fameLevel == 17){
            System.out.println(levelDescription[16]);
        }
        else if(fameLevel == 18){
            System.out.println(levelDescription[17]);
        }
        else if(fameLevel == 19){
            System.out.println(levelDescription[18]);
        }
        else if(fameLevel == 20){
            System.out.println(levelDescription[19]);
        }
        else if(fameLevel == 21){
            System.out.println(levelDescription[20]);
        }
        else if(fameLevel == 22){
            System.out.println(levelDescription[21]);
        }
        else{
            System.out.println("An error occured...");
        }

        // REPERTOIRE SYSTEM
        System.out.println(" ");
        System.out.println("Repertoire:");
        for (int i = 0; i < songs.length; i++){
            System.out.println(songs[i]);
        }
        System.out.println("Total songs: " + songs.length);


        // GIG SIMULATION
        int venueCapacity = 500;
        int attendance = 420;
        double attendancePercent = venueCapacity / attendance;
        System.out.println((double)attendancePercent);












    }

}
