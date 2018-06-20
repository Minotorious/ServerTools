package ServerTools.Listeners;

import ServerTools.ServerToolsDataBank;
import ServerTools.ServerToolsDataBase;
import ServerTools.ServerToolsMain;
import ServerTools.ServerToolsObjects;
import ServerTools.ServerToolsUtils;
import ServerTools.ServerToolsTimersInit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.risingworld.api.Timer;
import net.risingworld.api.database.WorldDatabase;
import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.player.PlayerCommandEvent;
import net.risingworld.api.objects.Player;
import net.risingworld.api.objects.Weather;
import net.risingworld.api.events.Listener;
import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.GuiLabel;

public class ServerToolsCommandListener implements Listener {
    
    ServerToolsMain STM =  new ServerToolsMain();
    ServerToolsDataBase STDB = new ServerToolsDataBase();
    ServerToolsTimersInit STTI = new ServerToolsTimersInit();
    ServerToolsObjects STO = new ServerToolsObjects();
    
    @EventMethod
    public void onCommand(PlayerCommandEvent event){
        Player player = event.getPlayer();
        String command = event.getCommand();
        String[] cmd = command.split(" ");
        if (cmd[0].equals("/st")){
            if (player.isAdmin()){
                if (cmd.length >= 2){
                    switch (cmd[1]) {
                        case "lastonline":
                            if (cmd.length == 3){
                                WorldDatabase database = STM.getWorldDatabase();
                                if (!cmd[2].contains("'") || !cmd[2].contains(";") || cmd[2].contains(" ")){
                                    try(ResultSet result = database.executeQuery("SELECT LastTimeOnline FROM Player WHERE Name LIKE '" + cmd[2] + "'")){
                                        if (result.next()){
                                            Date olddate = new Date(result.getLong("LastTimeOnline"));
                                            SimpleDateFormat Sdf = new SimpleDateFormat("dd MMMM yyyy");
                                            String datestr = Sdf.format(olddate);
                                            Date date = new Date();
                                            long difference = (date.getTime() - olddate.getTime())/(1000*60*60*24);
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Player " + cmd[2] + " was last online on: " + datestr + ". That was " + Long.toString(difference) + " days ago");
                                        }
                                    }
                                    catch(SQLException e){
                                        player.sendTextMessage("[#FF0000]You have to provide a correct player name!");
                                    }
                                }
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide a player name!");
                            }
                            break;
                        case "blacklist":
                            if (cmd.length == 3){
                                switch (cmd[2]){
                                    case "show":
                                        if (ServerToolsDataBank.BlackList.getBlackList() != null && !ServerToolsDataBank.BlackList.getBlackList().isEmpty()){
                                            for (ServerToolsObjects.blacklistplayer bp : ServerToolsDataBank.BlackList.getBlackList()){
                                                player.sendTextMessage(ServerToolsUtils.SettingbyName("PoliceBotChatColour") + ServerToolsUtils.SettingbyName("PoliceBotName") + ": Player " + bp.name + " said: " + bp.offence);
                                            }
                                        }
                                        else{
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Blacklist is empty");
                                        }
                                        break;
                                    case "clear":
                                        if (ServerToolsDataBank.BlackList.getBlackList() != null && !ServerToolsDataBank.BlackList.getBlackList().isEmpty()){
                                            ServerToolsDataBank.BlackList.getBlackList().clear();
                                            STM.WriteBlackListTxt();
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Blacklist has been cleared");
                                        }
                                        else{
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Blacklist is empty");
                                        }
                                        break;
                                    default:
                                        player.sendTextMessage("[#FF0000]You have to provide a correct blacklist command!");
                                        player.sendTextMessage("[#FF0000]For more information type: /st blacklist help");
                                        break;
                                }
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                player.sendTextMessage("[#FF0000]For more information type: /st help");
                            }
                            break;
                        case "heal":
                            if (cmd.length == 3){
                                Player healplayer = STM.getServer().getPlayer(cmd[2]);
                                if (healplayer != null){
                                    healplayer.setHealth(100);
                                    healplayer.setHunger(100);
                                    healplayer.setThirst(100);
                                    healplayer.setBrokenBones(false);
                                    healplayer.setBleeding(false);
                                    healplayer.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "You have been healed by " + player.getName());
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "You have healed " + healplayer.getName());
                                }
                                else{
                                    player.sendTextMessage("[#FF0000]You have to provide a correct player name!");
                                }
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide a player name!");
                            }
                            break;
                        case "tod":
                            if (cmd.length == 3){
                                try{
                                    int tod = Integer.parseInt(cmd[2]);
                                    if (tod >= 0 && tod <= 23){
                                        STM.getServer().setGameTime(tod, 0);
                                        STM.getServer().broadcastTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Time has been changed by " + player.getName());
                                    }
                                    else{
                                        player.sendTextMessage("[#FF0000]You have to provide a valid integer between 0 and 23!");
                                    }
                                }
                                catch (NumberFormatException e){
                                    player.sendTextMessage("[#FF0000]You have to provide a valid integer between 0 and 23!");
                                }
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide an integer between 0 and 23!");
                            }
                            break;
                        case "weather":
                            if (cmd.length == 3){
                                String weatherstr = cmd[2];
                                Weather weather = null;
                                for (Weather w : Weather.values()){
                                    if (w.name().toLowerCase().equals(weatherstr)){
                                        weather = w;
                                    }
                                }
                                if (weather != null){
                                    STM.getServer().setWeather(weather, true);
                                    STM.getServer().broadcastTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Weather has been changed by " + player.getName());
                                }
                                else{
                                    player.sendTextMessage("[#FF0000]You have to provide a valid weather type!");
                                }
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide a weather type!");
                            }
                            break;
                        case "timespeed":
                            if (cmd.length == 3){
                                try{
                                    float newtimespeed = Float.parseFloat(cmd[2]);
                                    float oldtimespeed = STM.getServer().getGameTimeSpeed();
                                    STM.getServer().setGameTimeSpeed(newtimespeed);
                                    STM.getServer().broadcastTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "GameTimeSpeed has been changed from " + Float.toString(oldtimespeed) + " to " + Float.toString(newtimespeed) + " by " + player.getName());
                                }
                                catch (NumberFormatException e){
                                    player.sendTextMessage("[#FF0000]You have to provide a valid float point number!");
                                }
                            }
                            break;
                        case "list":
                            if(cmd.length == 2) {
                                player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Automated messages list:");
                                for (int i=0;i<ServerToolsDataBank.messagelist.getMessages().size();i++){
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + Integer.toString(ServerToolsDataBank.messagelist.getMessages().get(i).number) + " " + ServerToolsDataBank.messagelist.getMessages().get(i).name);
                                }
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                player.sendTextMessage("[#FF0000]For more information type: /st help");
                            }
                            break;
                        case "sayn":
                            switch (cmd.length) {
                                case 3:
                                    String MNs = cmd[2];
                                    try{
                                        String[] MNa = MNs.split(",");
                                        int[] MNi = new int[MNa.length];
                                        for(int i=0;i<MNa.length;i++){
                                            MNi[i] = Integer.parseInt(MNa[i]);
                                        }
                                        for(int i=0;i<MNi.length;i++){
                                            if (MNi[i] > 0 && MNi[i] < ServerToolsDataBank.messagelist.getMessages().size()+1){
                                                STM.getServer().broadcastTextMessage(ServerToolsDataBank.messagelist.getMessages().get(MNi[i]-1).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ServerToolsDataBank.messagelist.getMessages().get(MNi[i]-1).text);
                                            }
                                            else{
                                                player.sendTextMessage("[#FF0000]Please enter the number of a valid automated message, type /st list to see all valid inputs");
                                            }
                                        }
                                    }
                                    catch (NumberFormatException e){
                                        player.sendTextMessage("[#FF0000]Please enter a valid comma separated series of numbers!");
                                    }
                                    break;
                                case 4:
                                    MNs = cmd[2];
                                    String pmplayerstr = cmd[3];
                                    try{
                                        String[] MNa = MNs.split(",");
                                        int[] MNi = new int[MNa.length];
                                        for(int i=0;i<MNa.length;i++){
                                            MNi[i] = Integer.parseInt(MNa[i]);
                                        }
                                        Player pmplayer = STM.getServer().getPlayer(pmplayerstr);
                                        if (pmplayer != null){
                                            for(int i=0;i<MNi.length;i++){
                                                if (MNi[i] > 0 && MNi[i] < ServerToolsDataBank.messagelist.getMessages().size()+1){
                                                    pmplayer.sendTextMessage(ServerToolsDataBank.messagelist.getMessages().get(MNi[i]-1).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ServerToolsDataBank.messagelist.getMessages().get(MNi[i]-1).text);
                                                }
                                                else{
                                                    pmplayer.sendTextMessage("[#FF0000]Please enter the number of a valid automated message, type /st list to see all valid inputs");
                                                }
                                            }
                                        }
                                        else{
                                            player.sendTextMessage("[#FF0000]Please enter a valid player name!");
                                        }
                                    }
                                    catch (NumberFormatException e){
                                        player.sendTextMessage("[#FF0000]Please enter a valid comma separated series of numbers!");
                                    }
                                    break;
                                default:
                                    player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                    player.sendTextMessage("[#FF0000]For more information type: /st help");
                                    break;
                            }
                            break;
                        case "sayt":
                            switch (cmd.length) {
                                case 3:
                                    String MS = cmd[2];
                                    String messageout = null;
                                    for (int i=0;i<ServerToolsDataBank.messagelist.getMessages().size();i++){
                                        if (MS.equals(ServerToolsDataBank.messagelist.getMessages().get(i).name)){
                                            messageout = ServerToolsDataBank.messagelist.getMessages().get(i).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ServerToolsDataBank.messagelist.getMessages().get(i).text;
                                        }
                                    }
                                    if (messageout == null){
                                        player.sendTextMessage("[#FF0000]Please enter the name of a valid automated message, type /st list to see all valid inputs");
                                    }
                                    else{
                                        STM.getServer().broadcastTextMessage(messageout);
                                    }
                                    break;
                                case 4:
                                    MS = cmd[2];
                                    String pmplayerstr = cmd[3];
                                    Player pmplayer = STM.getServer().getPlayer(pmplayerstr);
                                    messageout = null;
                                    for (int i=0;i<ServerToolsDataBank.messagelist.getMessages().size();i++){
                                        if (MS.equals(ServerToolsDataBank.messagelist.getMessages().get(i).name)){
                                            messageout = ServerToolsDataBank.messagelist.getMessages().get(i).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ServerToolsDataBank.messagelist.getMessages().get(i).text;
                                        }
                                    }
                                    if (messageout == null){
                                        player.sendTextMessage("[#FF0000]Please enter the name of a valid automated message, type /st list to see all valid inputs");
                                    }
                                    else{
                                        if (pmplayer != null){
                                            pmplayer.sendTextMessage(messageout);
                                        }
                                        else{
                                            player.sendTextMessage("[#FF0000]Please enter a valid player name!");
                                        }
                                    }
                                    break;
                                default:
                                    player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                    player.sendTextMessage("[#FF0000]For more information type: /st help");
                                    break;
                            }
                            break;
                        case "anntest":
                            if (cmd.length == 3){
                                ArrayList<ServerToolsObjects.announcement> ann = ServerToolsDataBank.messagelist.getAnnouncements();
                                switch (cmd[2]){
                                    case "onlogin":
                                        for (int i=0;i<ann.size();i++){
                                            if (ann.get(i).type.equals("onlogin")){
                                                player.sendTextMessage(ann.get(i).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                                            }
                                        }
                                        break;
                                    case "onloginnew":
                                        for (int i=0;i<ann.size();i++){
                                            if (ann.get(i).type.equals("onloginnew")){
                                                player.sendTextMessage(ann.get(i).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                                            }
                                        }
                                        break;
                                    case "onloginadmin":
                                        for (int i=0;i<ann.size();i++){
                                            if (ann.get(i).type.equals("onloginadmin")){
                                                player.sendTextMessage(ann.get(i).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                                            }
                                        }
                                        break;
                                    case "onloginadminbroadcast":
                                        for (int i=0;i<ann.size();i++){
                                            if (ann.get(i).type.equals("onloginadminbroadcast")){
                                                player.sendTextMessage(ann.get(i).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                                            }
                                        }
                                        break;
                                    case "recurring":
                                        for (int i=0;i<ann.size();i++){
                                            if (ann.get(i).type.equals("recurring")){
                                                player.sendTextMessage(ann.get(i).colourcode + ServerToolsUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text +  ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + " | Occurs every: " + ann.get(i).recur + "seconds");
                                            }
                                        }
                                        break;
                                    default:
                                        player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                        player.sendTextMessage("[#FF0000]For more information type: /st help");
                                        break;
                                }
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                player.sendTextMessage("[#FF0000]For more information type: /st help");
                            }
                            break;
                        case "reload":
                            if (cmd.length == 2){
                                STM.ReadFiles();
                                STM.ReadAMFiles();
                                ArrayList<Timer> timers = ServerToolsDataBank.TimerList.getTimers();
                                for (Timer timer : timers){
                                    timer.kill();
                                }
                                STTI.RecurringMessages();
                                if (ServerToolsUtils.SettingbyName("RankingBotMode").equals("on")){
                                    STTI.RankCheckTimerInit();
                                }
                                if (ServerToolsUtils.SettingbyName("RestartWarningsMode").equals("on")){
                                    ServerToolsDataBank.restartTimer.kill();
                                    STM.readRestartWarnings();
                                    STTI.initRestartTimer();
                                }
                                if (ServerToolsUtils.SettingbyName("VoteDayCommand").equals("on")){
                                    for (Player p : STM.getServer().getAllPlayers()){
                                        GuiLabel personalVoteDayTimerLabel = (GuiLabel) p.getAttribute("STVoteDayTimerLabel");
                                        personalVoteDayTimerLabel.setText(ServerToolsUtils.SettingbyName("VoteDayTimerDuration"));
                                    }
                                }
                                player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "ServerTools plugin has been successfully reloaded");
                            }
                            else{
                                player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                player.sendTextMessage("[#FF0000]For more information type: /st help");
                            }
                            break;
                        case "help":
                            switch (cmd.length){
                                case 2:
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Available ServerTools Commands:");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st help blacklist, show help for blacklist");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st help am, show help for automates messages");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st lastonline playername, show the date when a player was last on the server");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st heal playername, heals named player");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st tod hour, sets the server time, where hour an integer between 0 and 23");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st weather weathername, sets the server weather, weathername can be any of: clear, default, densefog, fog, heavyrain, heavyrainthunder, overcast, rain, rainthunder, storm");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st timespeed float, sets the server game time speed");
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st reload, used to read the text files again without the need to restart your server");
                                    break;
                                case 3:
                                    switch (cmd[2]){
                                        case "am":
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Available AutomatedMessages Commands:");
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st list, lists all available automated messages");
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st sayn comma separated numbers, broadcasts the selected automated messages by message number");
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st sayt messagename, broadcasts the selected automated message by message name");
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "optionally you can add a player name at the end of the /am say* commands to send a personal automated message");
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st anntest annid, used to test automated announcements, annid can be any of: onlogin, onloginnew, onloginadminbroadcast, onloginadmin, or recurring");
                                            break;
                                        case "blacklist":
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Available blacklist Commands:");
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st blacklist show, displays the blacklist in the chat");
                                            player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/st blacklist clear, clears the blacklist of all entries");
                                            break;
                                        default:
                                            player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                            player.sendTextMessage("[#FF0000]For more information type: /st help");
                                            break;
                                    }
                                    break;
                                default:
                                    player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                                    player.sendTextMessage("[#FF0000]For more information type: /st help");
                                    break;
                            }
                            break;
                        default:
                            player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                            player.sendTextMessage("[#FF0000]For more information type: /st help");
                            break;
                    }
                }
                else{
                    player.sendTextMessage("[#FF0000]You have to provide a correct ServerTools command!");
                    player.sendTextMessage("[#FF0000]For more information type: /st help");
                }
            }
            else{
                player.sendTextMessage("[#FF0000]Insufficient permission to use ServerTools");
            }
        }
        else if (cmd[0].equals("/autogm1")){
            if (ServerToolsUtils.SettingbyName("Autogm1Mode").equals("on")){
                if (!player.getPermissionGroup().equals(ServerToolsUtils.SettingbyName("Autogm1DeniedPermGroup"))){
                    if (cmd.length == 2){
                        ServerToolsObjects.autoGM1listplayer autoGM1Player = STO.new  autoGM1listplayer();
                        ArrayList<ServerToolsObjects.autoGM1listplayer> players = ServerToolsDataBank.Autogm1List.getAutogm1List();
                        switch (cmd[1]){
                            case "set":
                                boolean addcheck = true;
                                for (int i=0;i<players.size();i++){
                                    if (players.get(i).playerUserID == player.getUID()){
                                        addcheck = false;
                                        player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "You are already in the autogm1 list!");
                                    }
                                }
                                if (addcheck == true){
                                    STDB.setInAutoGM1List(player.getUID(), player.getName());
                                    autoGM1Player.playerName = player.getName();
                                    autoGM1Player.playerUserID = player.getUID();
                                    ServerToolsDataBank.Autogm1List.getAutogm1List().add(autoGM1Player);
                                    player.setCreativeModeEnabled(true);
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "You have been succesfully added to the autogm1 list!");
                                }
                                break;
                            case "del":
                                boolean delcheck = false;
                                for (int i=0;i<players.size();i++){
                                    if (players.get(i).playerUserID == player.getUID()){
                                        STDB.delFromAutoGM1List(player.getUID());
                                        autoGM1Player.playerName = player.getName();
                                        autoGM1Player.playerUserID = player.getUID();
                                        ServerToolsDataBank.Autogm1List.getAutogm1List().remove(autoGM1Player);
                                        player.setCreativeModeEnabled(false);
                                        player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "You have been succesfully removed from the autogm1 list!");
                                        delcheck = true;
                                        break;
                                    }
                                }
                                if (delcheck == false){
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "You are not in the autogm1 list!");
                                }
                                break;
                            case "list":
                                if (player.isAdmin()){
                                    ArrayList<ServerToolsObjects.autoGM1listplayer> autoGM1list = ServerToolsDataBank.Autogm1List.getAutogm1List();
                                    int count = 1;
                                    for (ServerToolsObjects.autoGM1listplayer autoGM1player : autoGM1list){
                                        player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + count + " " + autoGM1player.playerName + " " + Long.toString(autoGM1player.playerUserID));
                                        count += 1;
                                    }
                                }
                                break;
                            case "help":
                                player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "Available Autogm1 Commands:");
                                player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/autogm1 set, add yourself to the list for auto gm 1 upon login");
                                player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/autogm1 del, remove yourself from the list for auto gm 1 upon login");
                                if (player.isAdmin()){
                                    player.sendTextMessage(ServerToolsUtils.SettingbyName("GeneralPluginTextColour") + "/autogm1 list, shows all UIDs in the autogm1 list");
                                }
                                break;
                            default:
                                player.sendTextMessage("[#FF0000]You have to provide a correct autogm1 command!");
                                player.sendTextMessage("[#FF0000]For more information type: /autogm1 help");
                                break;
                        }
                    }
                    else{
                        player.sendTextMessage("[#FF0000]You have to provide a correct autogm1 command!");
                        player.sendTextMessage("[#FF0000]For more information type: /autogm1 help");
                    }
                }
                else{
                    player.sendTextMessage("[#FF0000]Insufficient permission to use autogm1!");
                }
            }
        }
        else if (cmd[0].equals("/voteday")){
            if (ServerToolsUtils.SettingbyName("VoteDayCommand").equals("on")){
                if (cmd.length == 1){
                    if (!ServerToolsDataBank.voteDayCoolDownTimer.isActive()){
                        ServerToolsDataBank.voteDayCoolDownTimer = new Timer(Float.parseFloat(ServerToolsUtils.SettingbyName("VoteDayTimerDuration")) + Float.parseFloat(ServerToolsUtils.SettingbyName("VoteDayTimerCoolDown")), 0f, 0, ()->{ ServerToolsDataBank.voteDayCoolDownTimer.pause(); });
                        ServerToolsDataBank.voteDayCoolDownTimer.start();
                        for (Player p : STM.getServer().getAllPlayers()){
                            ServerToolsUtils.showHideVoteDayGui(p, true);
                            p.setMouseCursorVisible(true);
                        }
                        ServerToolsDataBank.yesVotes = 0;
                        ServerToolsDataBank.noVotes = 0;
                        ServerToolsDataBank.NoPlayers = STM.getServer().getAllPlayers().size();
                        STTI.voteDayTimerInit();
                    }
                    else{
                        player.sendTextMessage("[#FF0000]A /voteday has been recently triggered! Please wait " + Integer.toString(Integer.parseInt(ServerToolsUtils.SettingbyName("VoteDayTimerDuration")) + Integer.parseInt(ServerToolsUtils.SettingbyName("VoteDayTimerCoolDown")) - (int) ServerToolsDataBank.voteDayCoolDownTimer.getTick()) + " seconds until you can trigger a new vote!");
                    }
                }
            }
        }
    }
}
