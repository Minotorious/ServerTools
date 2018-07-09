package ServerTools;

import ServerTools.Utils.ServerToolsGeneralUtils;
import ServerTools.Listeners.ServerToolsCommandListener;
import ServerTools.Listeners.ServerToolsPlayerListener;
import ServerTools.Listeners.ServerToolsGUIListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import net.risingworld.api.Plugin;
import net.risingworld.api.Timer;
import net.risingworld.api.database.Database;
import net.risingworld.api.utils.Utils;

public class ServerToolsMain extends Plugin {
    
    ServerToolsObjects STO = new ServerToolsObjects();
    
    @Override
    public void onEnable(){
        
        ServerToolsDataBank.pluginPath = getPath();
        
        ServerToolsCommandListener STComL = new ServerToolsCommandListener();
        ServerToolsPlayerListener STPlaL = new ServerToolsPlayerListener();
        ServerToolsGUIListener STGuiL = new ServerToolsGUIListener();
        
        registerEventListener(STComL);
        registerEventListener(STPlaL);
        registerEventListener(STGuiL);
        
        ServerToolsTimersInit STTI = new ServerToolsTimersInit();
        
        Database mainSQLite = getSQLiteConnection(ServerToolsDataBank.pluginPath + "/assets/database/" + "ServerTools_" + getWorld().getName() + ".db");
        
        ServerToolsDataBase STDB = new ServerToolsDataBase();
        
        STDB.setmainSTDB(mainSQLite);
        STDB.initmainSTDB();
        STDB.initSettingsTable();
        
        ServerToolsDataBank.Autogm1List.setAutogm1List(STDB.getAutoGM1List());
        
        ReadFiles();
        ReadAMFiles();
        STTI.RecurringMessages();
        if (ServerToolsGeneralUtils.SettingbyName("RankingBotMode").equals("on")){
            STTI.RankCheckTimerInit();
        }
        if (ServerToolsGeneralUtils.SettingbyName("RestartWarningsMode").equals("on")){
            readRestartWarnings();
            STTI.initRestartTimer();
        }
        if (ServerToolsGeneralUtils.SettingbyName("VoteDayCommand").equals("on")){
            ServerToolsDataBank.voteDayCoolDownTimer = new Timer(Float.parseFloat(ServerToolsGeneralUtils.SettingbyName("VoteDayTimerDuration")) + Float.parseFloat(ServerToolsGeneralUtils.SettingbyName("VoteDayTimerCoolDown")), 0f, 0, null);
        }
    }
    
    public void ReadFiles(){
        File RankListTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/ranklist.txt");
        ArrayList<ServerToolsObjects.rank> ranks = new ArrayList<>();
        if (RankListTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(RankListTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.split("\r\n|\n|\r");
                for (String line : lines) {
                    String[] cline = line.split(";", 3);
                    if (cline.length >=2 && cline.length <= 3){
                        ServerToolsObjects.rank r = STO.new rank();
                        r.name = cline[0];
                        r.reqtime = Integer.parseInt(cline[1]);
                        if(cline.length == 3){
                            r.message = cline[2];
                        }
                        else{
                            r.message = "";
                        }
                    ranks.add(r);
                    }
                }
            }
        }
        ServerToolsDataBank.Ranks.setRankList(ranks);
        
        File BlackListTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/blacklist.txt");
        ArrayList<ServerToolsObjects.blacklistplayer> blacklistdata = new ArrayList<>();
        if (BlackListTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(BlackListTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.replace("[", "").replace("]", "").split(", ");
                for (String line : lines) {
                    String[] cline = line.split(";", 2);
                    if (cline.length == 2){
                        ServerToolsObjects.blacklistplayer blp = STO.new blacklistplayer();
                        blp.name = cline[0];
                        blp.offence = cline[1];
                        blacklistdata.add(blp);
                    }
                }
            }
        }
        ServerToolsDataBank.BlackList.setBlackList(blacklistdata);
        
        File settingsTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/settings.txt");
        if (settingsTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(settingsTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.split("\r\n|\n|\r");
                String[][] settings = new String[lines.length][2];
                int linecount = 0;
                for (String line : lines) {
                    String[] cline = line.split("=", 2);
                    if (cline.length == 2){
                        settings[linecount][0] = cline[0];
                        settings[linecount][1] = cline[1];
                        linecount += 1;
                    }
                }
                ServerToolsDataBank.Settings.setSettings(settings);
            }
            else{
                String[][] settings = new String[0][0];
                ServerToolsDataBank.Settings.setSettings(settings);
            }
        }
        else{
            String[][] settings = new String[0][0];
            ServerToolsDataBank.Settings.setSettings(settings);
        }
        
        File BannedItemsTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/banneditems.txt");
        if (BannedItemsTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(BannedItemsTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.split("\r\n|\n|\r");
                ServerToolsDataBank.BannedLists.setBannedItems(lines);
            }
            else{
                String[] setdef = new String[0];
                ServerToolsDataBank.BannedLists.setBannedItems(setdef);
            }
        }
        else{
            String[] setdef = new String[0];
            ServerToolsDataBank.BannedLists.setBannedItems(setdef);
        }
        
        File BannedWordsTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/bannedwords.txt");
        if (BannedWordsTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(BannedWordsTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.split("\r\n|\n|\r");
                ServerToolsDataBank.BannedLists.setBannedWords(lines);
            }
            else{
                String[] setdef = new String[0];
                ServerToolsDataBank.BannedLists.setBannedWords(setdef);
            }
        }
        else{
            String[] setdef = new String[0];
            ServerToolsDataBank.BannedLists.setBannedWords(setdef);
        }
    }
    
    public void ReadAMFiles(){
        ArrayList<ServerToolsObjects.message> messages =  new ArrayList<>();
        int count  = 1;
        File MessageTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/messages.txt");
        if (MessageTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(MessageTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.split("\r\n|\n|\r");
                for (String line : lines){
                    String[] cline = line.split(";");
                    if (cline.length == 3){
                        ServerToolsObjects.message Mes = STO.new message();
                        Mes.number = count;
                        Mes.name = cline[0];
                        Mes.colourcode = cline[1];
                        Mes.text = cline[2];
                        messages.add(Mes);
                        count += 1;
                    }
                }    
            }
        }
        ServerToolsDataBank.messagelist.setMessages(messages);
        
        ArrayList<ServerToolsObjects.announcement> announcements =  new ArrayList<>();
        File AnnouncementTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/announcements.txt");
        if (AnnouncementTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(AnnouncementTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.split("\r\n|\n|\r");
                for (String line : lines){
                    String[] cline = line.split(";");
                    if (cline.length >= 4 && cline.length <= 5){
                        ServerToolsObjects.announcement Ann = STO.new announcement();
                        Ann.type = cline[0];
                        Ann.name = cline[1];
                        Ann.colourcode = cline[2];
                        if (cline[0].equals("recurring")){
                            Ann.recur = Float.parseFloat(cline[3]);
                            Ann.text = cline[4];
                        }
                        else{
                            Ann.text = cline[3];
                        }
                        announcements.add(Ann);
                        count += 1;
                    }
                }
            }
        }
        ServerToolsDataBank.messagelist.setAnnouncements(announcements);
    }
    
    public void readRestartWarnings(){
        File RestartWarningsTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/restartwarnings.txt");
        if (RestartWarningsTxt.exists()){
            String content = Utils.FileUtils.readStringFromFile(RestartWarningsTxt);
            if(content != null && !content.isEmpty()){
                String[] lines = content.split("\r\n|\n|\r");
                ArrayList<LocalDateTime> restartTimes = new ArrayList<>();
                int[] minuteWarnings = null;
                int[] secondWarnings = null;
                for (String line : lines){
                    String[] cline = line.split("=");
                    switch (cline[0]) {
                        case "restartTimes":
                            String[] times = cline[1].split(";");
                            for (int i=0;i<times.length;i++){
                                String[] time = times[i].split(":");
                                if (time.length == 2){
                                    int hour = Integer.parseInt(time[0]);
                                    int minute = Integer.parseInt(time[1]);
                                    
                                    LocalTime crestart = LocalTime.of(hour, minute);
                                    LocalTime ctime = LocalTime.now();
                                    
                                    if (crestart.isAfter(ctime)){
                                        LocalDate date = LocalDate.now();
                                        restartTimes.add(LocalDateTime.of(date, crestart));
                                    }
                                    else if (crestart.equals(LocalTime.MIDNIGHT)){
                                        LocalDate date = LocalDate.now();
                                        restartTimes.add(LocalDateTime.of(date, crestart));
                                    }
                                    else if (crestart.isBefore(ctime)){
                                        LocalDate date = LocalDate.now().plusDays(1);
                                        restartTimes.add(LocalDateTime.of(date, crestart));
                                    }
                                }
                            }
                            break;
                        case "restartWarningsMinutes":
                            String[] minutes = cline[1].split(";");
                            minuteWarnings = new int[minutes.length];
                            for (int i=0;i<minutes.length;i++){
                                minuteWarnings[i] = Integer.parseInt(minutes[i]);
                            }
                           
                            ServerToolsDataBank.maxMinuteWarning = -1;
                            for (int i : minuteWarnings){
                                if (ServerToolsDataBank.maxMinuteWarning < i){
                                    ServerToolsDataBank.maxMinuteWarning = i;
                                }
                            }
                            break;
                        case "restartWarningsSeconds":
                            String[] seconds = cline[1].split(";");
                            secondWarnings = new int[seconds.length];
                            for (int i=0;i<seconds.length;i++){
                                secondWarnings[i] = Integer.parseInt(seconds[i]);
                            }
                            
                            ServerToolsDataBank.minSecondWarning = 61;
                            for (int i : secondWarnings){
                                if (ServerToolsDataBank.minSecondWarning > i){
                                    ServerToolsDataBank.minSecondWarning = i;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
                
                if (secondWarnings != null && minuteWarnings != null){
                    for (LocalDateTime cdatetime : restartTimes){
                        ServerToolsDataBank.restartWarningTimes.add(cdatetime.minusMinutes(ServerToolsDataBank.maxMinuteWarning));
                    }

                    ServerToolsDataBank.allWarnings = new int[secondWarnings.length + minuteWarnings.length];
                    int count = 0;
                    for (int minutes : minuteWarnings){
                        ServerToolsDataBank.allWarnings[count] = minutes * 60;
                        count += 1;
                    }
                    for (int seconds : secondWarnings){
                        ServerToolsDataBank.allWarnings[count] = seconds;
                        count += 1;
                    }
                }
                else{
                    System.out.println("Error in ServerTools plugin! You have not set the restartWarningsMinutes and restartWarningsSeconds settings!");
                }
            }
        }
    }
    
    public void WriteBlackListTxt(){
        File BlackListTxt = new File(ServerToolsDataBank.pluginPath  + "/assets/blacklist.txt");
        ArrayList<ServerToolsObjects.blacklistplayer> blacklistdata = ServerToolsDataBank.BlackList.getBlackList();
        String outdata;
        String[] outarr = new String[blacklistdata.size()];
        for(int i=0;i<blacklistdata.size();i++){
            outarr[i] = blacklistdata.get(i).name + ";" + blacklistdata.get(i).offence;
        }
        outdata = Arrays.toString(outarr);
        Utils.FileUtils.writeStringToFile(outdata, BlackListTxt);
    }
    
    @Override
    public void onDisable(){
    }
    
}
