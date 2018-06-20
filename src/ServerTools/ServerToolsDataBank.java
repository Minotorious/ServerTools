package ServerTools;

import java.time.LocalDateTime;
import java.util.ArrayList;
import net.risingworld.api.Timer;

public class ServerToolsDataBank {
    
    public static ArrayList<LocalDateTime> restartWarningTimes = new ArrayList<>();
    public static int maxMinuteWarning;
    public static int minSecondWarning;
    public static int yesVotes;
    public static int noVotes;
    public static int NoPlayers;
    public static int[] allWarnings;
    public static Timer restartTimer;
    public static Timer voteDayTimer;
    public static Timer voteDayCoolDownTimer;
    public static String pluginPath;
    
    public static class messagelist{
        private static ArrayList<ServerToolsObjects.message> messages;
        private static ArrayList<ServerToolsObjects.announcement> announcements;
        
        public static ArrayList<ServerToolsObjects.message> getMessages(){
            return messages;
        }
        
        public static void setMessages(ArrayList<ServerToolsObjects.message> M){
            messages = M;
        }
        
        public static ArrayList<ServerToolsObjects.announcement> getAnnouncements(){
            return announcements;
        }
        
        public static void setAnnouncements(ArrayList<ServerToolsObjects.announcement> A){
            announcements = A;
        }
    }
    
    public static class TimerList{
        private static ArrayList<Timer> timers;
        
        public static ArrayList<Timer> getTimers(){
            return timers;
        }
        
        public static void setTimers(ArrayList<Timer> T){
            timers = T;
        }
    }
    
    public static class Autogm1List{
        private static ArrayList<ServerToolsObjects.autoGM1listplayer> players;
        
        public static ArrayList<ServerToolsObjects.autoGM1listplayer> getAutogm1List(){
            return players;
        }
        
        public static void setAutogm1List(ArrayList<ServerToolsObjects.autoGM1listplayer> P){
            players = P;
        }
    }
    
    public static class Ranks{
        private static ArrayList<ServerToolsObjects.rank> ranks = new ArrayList<>();
        
        public static ArrayList<ServerToolsObjects.rank> getRankList(){
            return ranks;
        }
        
        public static void setRankList(ArrayList<ServerToolsObjects.rank> R){
            ranks = R;
        }
    }
    
    public static class Settings{
        private static String[][] settings;
        
        public static String[][] getSettings(){
            return settings;
        }
        
        public static void setSettings(String[][] S){
            settings = S;
        }
    }
    
    public static class BannedLists{
        private static String[] items;
        private static String[] words;
        
        public static String[] getBannedItems(){
            return items;
        }
        
        public static void setBannedItems(String[] I){
            items = I;
        }
        
        public static String[] getBannedWords(){
            return words;
        }
        
        public static void setBannedWords(String[] W){
            words = W;
        }
    }
    
    public static class BlackList{
        private static ArrayList<ServerToolsObjects.blacklistplayer> players;
        
        public static ArrayList<ServerToolsObjects.blacklistplayer> getBlackList(){
            return players;
        }
        
        public static void setBlackList(ArrayList<ServerToolsObjects.blacklistplayer> BLP){
            players = BLP;
        }
    }
    
}
