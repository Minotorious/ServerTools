package ServerTools;

import ServerTools.Utils.ServerToolsGeneralUtils;
import ServerTools.Utils.ServerToolsShowHideGui;
import java.time.LocalDateTime;
import java.util.ArrayList;
import net.risingworld.api.Timer;
import net.risingworld.api.objects.Player;
import net.risingworld.api.gui.GuiLabel;

public class ServerToolsTimersInit {
    
    ServerToolsMain STM = new ServerToolsMain();
    
    public void RankCheckTimerInit(){
        Timer timer = new Timer(Float.parseFloat(ServerToolsGeneralUtils.SettingbyName("RankcheckTimer")),0f,-1,()->{
            for(Player player : STM.getServer().getAllPlayers()){
                int playtime = player.getTotalPlayTime();
                String permission = player.getPermissionGroup();
                for(int i=1;i<ServerToolsDataBank.Ranks.getRankList().size();i++){
                    if (playtime > ServerToolsDataBank.Ranks.getRankList().get(i).reqtime && permission.equals(ServerToolsDataBank.Ranks.getRankList().get(i-1).name)){
                        player.setPermissionGroup(ServerToolsDataBank.Ranks.getRankList().get(i).name);
                        STM.getServer().broadcastTextMessage(ServerToolsGeneralUtils.SettingbyName("RankingBotChatColour") + ServerToolsGeneralUtils.SettingbyName("RankingBotName") + ": " + player.getName() + " is now a " + player.getPermissionGroup() + "!");
                        if (!ServerToolsDataBank.Ranks.getRankList().get(i).message.isEmpty()){
                            player.sendTextMessage(ServerToolsGeneralUtils.SettingbyName("RankingBotChatColour") + ServerToolsGeneralUtils.SettingbyName("RankingBotName") + ": " + ServerToolsDataBank.Ranks.getRankList().get(i).message);
                        }
                    }
                }
            }
        });
        ServerToolsDataBank.TimerList.getTimers().add(timer);
        timer.start();
    }
    
    public void initRestartTimer(){
        ServerToolsDataBank.restartTimer = new Timer(Float.parseFloat(ServerToolsGeneralUtils.SettingbyName("RestartWarningsCheckInterval")), 0f, -1, ()->{
            LocalDateTime now = LocalDateTime.now();
            for (LocalDateTime cdatetime : ServerToolsDataBank.restartWarningTimes){
                if (now.isAfter(cdatetime)){
                    startWarningTimers(cdatetime);
                    ServerToolsDataBank.restartTimer.pause();
                    break;
                }
            }
        });
        
        ServerToolsDataBank.restartTimer.start();
    }
    
    public void startWarningTimers(LocalDateTime triggerWarningTime){
        for (int i=0;i<ServerToolsDataBank.allWarnings.length;i++){
            int minutesToRestart = ServerToolsDataBank.allWarnings[i] / 60;
            int secondsToRestart = ServerToolsDataBank.allWarnings[i] % 60;
            
            if (ServerToolsDataBank.allWarnings[i] == ServerToolsDataBank.minSecondWarning){
                Timer timer = new Timer(ServerToolsDataBank.maxMinuteWarning * 60 - ServerToolsDataBank.allWarnings[i], 0f, 0, ()->{
                    STM.getServer().broadcastTextMessage(ServerToolsGeneralUtils.SettingbyName("RestartWarningsChatColour") + ServerToolsGeneralUtils.SettingbyName("RestartWarningsBotName") + ": Server restarting in " + Integer.toString(minutesToRestart) + " minutes and " + Integer.toString(secondsToRestart) + " seconds");
                    
                    Timer timer2 = new Timer(60f, 0f, 0, ()->{
                        ServerToolsDataBank.restartWarningTimes.remove(triggerWarningTime);
                        ServerToolsDataBank.restartTimer.start();
                    });
                    
                    timer2.start();
                });
            
                ServerToolsDataBank.TimerList.getTimers().add(timer);
                timer.start();
            }
            else{
                Timer timer = new Timer(ServerToolsDataBank.maxMinuteWarning * 60 - ServerToolsDataBank.allWarnings[i], 0f, 0, ()->{
                    STM.getServer().broadcastTextMessage(ServerToolsGeneralUtils.SettingbyName("RestartWarningsChatColour") + ServerToolsGeneralUtils.SettingbyName("RestartWarningsBotName") + ": Server restarting in " + Integer.toString(minutesToRestart) + " minutes and " + Integer.toString(secondsToRestart) + " seconds");
                });
                
                ServerToolsDataBank.TimerList.getTimers().add(timer);
                timer.start();
            }
        }
    }
    
    public void RecurringMessages(){
        ArrayList<ServerToolsObjects.announcement> ann = ServerToolsDataBank.messagelist.getAnnouncements();
        ArrayList<Timer> timers = new ArrayList<>();
        for (int i=0;i<ann.size();i++){
            if (ann.get(i).type.equals("recurring") && ann.get(i).recur > 0){
                final String message = ann.get(i).colourcode + ServerToolsGeneralUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text;
                Timer timer = new Timer(ann.get(i).recur,0f,-1,()->{
                    STM.getServer().broadcastTextMessage(message);
                });
                timers.add(timer);
            }
        }
        ServerToolsDataBank.TimerList.setTimers(timers);
        for (Timer timer : timers){
            timer.start();
        }
    }
    
    public void voteDayTimerInit(){
        ServerToolsDataBank.voteDayTimer = new Timer(1f, 0f, Integer.parseInt(ServerToolsGeneralUtils.SettingbyName("VoteDayTimerDuration")), ()->{
            boolean timerDone = false;
            for (Player player : STM.getServer().getAllPlayers()){
                GuiLabel personalVoteDayTimerLabel = (GuiLabel) player.getAttribute("STVoteDayTimerLabel");
                int seconds = Integer.parseInt(personalVoteDayTimerLabel.getText()) - 1;
                if (seconds > 0){
                    personalVoteDayTimerLabel.setText(Integer.toString(seconds));
                }
                else{
                    ServerToolsShowHideGui.showHideVoteDayGui(player, false);
                    player.setMouseCursorVisible(false);
                    personalVoteDayTimerLabel.setText(ServerToolsGeneralUtils.SettingbyName("VoteDayTimerDuration"));
                    timerDone = true;
                }
            }
            if (timerDone){
                if (((float) (ServerToolsDataBank.noVotes + ServerToolsDataBank.yesVotes)/ServerToolsDataBank.NoPlayers)*100 >= Float.parseFloat(ServerToolsGeneralUtils.SettingbyName("VoteDayPercentageQuota"))){
                    if (ServerToolsDataBank.yesVotes > ServerToolsDataBank.noVotes){
                        STM.getServer().broadcastTextMessage(ServerToolsGeneralUtils.SettingbyName("GeneralPluginTextColour") + "/voteday was successful with " + ServerToolsDataBank.yesVotes + " yes and " + ServerToolsDataBank.noVotes + " no votes");
                        STM.getServer().setGameTime(8, 0);
                    }
                    else{
                        STM.getServer().broadcastTextMessage(ServerToolsGeneralUtils.SettingbyName("GeneralPluginTextColour") + "/voteday failed with " + ServerToolsDataBank.yesVotes + " yes and " + ServerToolsDataBank.noVotes + " no votes");
                    }
                }
                else{
                    STM.getServer().broadcastTextMessage(ServerToolsGeneralUtils.SettingbyName("GeneralPluginTextColour") + "/voteday failed because less than " + ServerToolsGeneralUtils.SettingbyName("VoteDayPercentageQuota") + "% of the currently online players voted");
                }
            }
        });
        
        ServerToolsDataBank.voteDayTimer.start();
    }
    
}
