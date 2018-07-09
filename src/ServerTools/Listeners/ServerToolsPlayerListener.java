package ServerTools.Listeners;

import ServerTools.ServerToolsMain;
import ServerTools.ServerToolsObjects;
import ServerTools.ServerToolsDataBase;
import ServerTools.Utils.ServerToolsGeneralUtils;
import ServerTools.Utils.ServerToolsAttributeSet;
import ServerTools.ServerToolsDataBank;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.risingworld.api.events.Listener;
import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.player.PlayerChatEvent;
import net.risingworld.api.events.player.PlayerConnectEvent;
import net.risingworld.api.events.player.PlayerSpawnEvent;
import net.risingworld.api.events.player.inventory.PlayerChestToInventoryEvent;
import net.risingworld.api.events.player.inventory.PlayerInventoryAddEvent;
import net.risingworld.api.objects.Item;
import net.risingworld.api.objects.Player;

public class ServerToolsPlayerListener implements Listener {
    
    ServerToolsMain STM = new ServerToolsMain();
    ServerToolsObjects STO = new ServerToolsObjects();
    ServerToolsDataBase STDB = new ServerToolsDataBase();
    
    @EventMethod
    public void onChat(PlayerChatEvent event){
        if (ServerToolsGeneralUtils.SettingbyName("PoliceBotMode").equals("on")){
            Player player = event.getPlayer();
            String[] messageArr = event.getChatMessage().toLowerCase().split("]", 2);
            Date date = new Date();
            SimpleDateFormat Sdf = new SimpleDateFormat("dd/MM/yyyy");
            String datestr = Sdf.format(date);
            String message = messageArr[1] + " on " + datestr;
            boolean check = false;
            for (String bannedWord : ServerToolsDataBank.BannedLists.getBannedWords()){
                if (message.contains(bannedWord)){
                    check = true;
                }
            }
            
            if (check == true){
                ArrayList<ServerToolsObjects.blacklistplayer> blacklist = ServerToolsDataBank.BlackList.getBlackList();
                ServerToolsObjects.blacklistplayer blp = STO.new blacklistplayer();
                blp.name = player.getName();
                blp.offence = message;
                blacklist.add(blp);
                player.sendTextMessage(ServerToolsGeneralUtils.SettingbyName("PoliceBotChatColour") + ServerToolsGeneralUtils.SettingbyName("PoliceBotName") + ": You have commited an illegal language offence. Please watch the language!");

                ServerToolsDataBank.BlackList.setBlackList(blacklist);
                STM.WriteBlackListTxt();
            }
        }
    }
    
    @EventMethod
    public void onItemPickUp(PlayerInventoryAddEvent event){
        if (ServerToolsGeneralUtils.SettingbyName("PoliceBotMode").equals("on")){
            Player player = event.getPlayer();
            if (!player.isAdmin() || !player.getPermissionGroup().equals(ServerToolsGeneralUtils.SettingbyName("PluginAdminAccessPermGroup"))){
                Item item = event.getItem();
                for (String BannedItem : ServerToolsDataBank.BannedLists.getBannedItems()){
                    if (item.getName().equals(BannedItem)){
                        event.setCancelled(true);
                        player.sendTextMessage(ServerToolsGeneralUtils.SettingbyName("PoliceBotChatColour") + ServerToolsGeneralUtils.SettingbyName("PoliceBotName") + ": Attempting to obtain illegal goods: " + item.getName() + ". Action denied!");
                    }
                }
            }
        }
    }
    
    @EventMethod
    public void onItemPickUpFromChest(PlayerChestToInventoryEvent event){
        if (ServerToolsGeneralUtils.SettingbyName("PoliceBotMode").equals("on")){
            Player player = event.getPlayer();
            if (!player.isAdmin() || !player.getPermissionGroup().equals(ServerToolsGeneralUtils.SettingbyName("PluginAdminAccessPermGroup"))){
                Item item = event.getItem();
                if (item != null){
                    for (String BannedItem : ServerToolsDataBank.BannedLists.getBannedItems()){
                        if (item.getName() != null && BannedItem != null){
                            if (item.getName().equals(BannedItem)){
                                event.setCancelled(true);
                                player.sendTextMessage(ServerToolsGeneralUtils.SettingbyName("PoliceBotChatColour") + ServerToolsGeneralUtils.SettingbyName("PoliceBotName") + ": Attempting to obtain illegal goods: " + item.getName() + ". Action denied!");
                            }
                        }
                    }
                }
            }
        }
    }
    
    @EventMethod
    public void onPlayerSpawn(PlayerSpawnEvent event){
        Player player = event.getPlayer();
        ArrayList<ServerToolsObjects.announcement> ann = ServerToolsDataBank.messagelist.getAnnouncements();
        if (player.getPermissionGroup().equals(ServerToolsGeneralUtils.SettingbyName("NewPlayerPermGroup"))){
            for (int i=0;i<ann.size();i++){
                if (ann.get(i).type.equals("onloginnew")){
                    player.sendTextMessage(ann.get(i).colourcode + ServerToolsGeneralUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                }
            }
        }
        else if (player.isAdmin() || player.getPermissionGroup().equals(ServerToolsGeneralUtils.SettingbyName("PluginAdminAccessPermGroup"))){
            for (int i=0;i<ann.size();i++){
                if (ann.get(i).type.equals("onlogin") || ann.get(i).type.equals("onloginadmin")){
                    player.sendTextMessage(ann.get(i).colourcode + ServerToolsGeneralUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                }
            }
        }
        else{
            for (int i=0;i<ann.size();i++){
                if (ann.get(i).type.equals("onlogin")){
                    player.sendTextMessage(ann.get(i).colourcode + ServerToolsGeneralUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                }
            }
        }
        
        if (ServerToolsGeneralUtils.SettingbyName("Autogm1Mode").equals("on")){
            ArrayList<ServerToolsObjects.autoGM1listplayer> players = ServerToolsDataBank.Autogm1List.getAutogm1List();
            for (int i=0;i<players.size();i++) {
                long currentplayerUID = players.get(i).playerUserID;
                if (player.getUID() == currentplayerUID) {
                    player.setCreativeModeEnabled(true);
                    String currentplayerName = players.get(i).playerName;
                    if (!player.getName().equals(currentplayerName)){
                        STDB.changePlayerNameInAutoGM1List(currentplayerUID, player.getName());
                    }
                    break;
                }
            }
        }
        
        ServerToolsAttributeSet.setVoteDayGuiAttributes(player);
        if (player.isAdmin() || player.getPermissionGroup().equals(ServerToolsGeneralUtils.SettingbyName("PluginAdminAccessPermGroup"))){
            ServerToolsAttributeSet.setMainPanelAttributes(player);
            ServerToolsAttributeSet.setGeneralTabAttributes(player);
            ServerToolsAttributeSet.setSettingsTabAttributes(player);
        }
    }
    
    @EventMethod
    public void onPlayerConnect(PlayerConnectEvent event){
        Player player = event.getPlayer();
        ArrayList<ServerToolsObjects.announcement> ann = ServerToolsDataBank.messagelist.getAnnouncements();
        if (player.isAdmin() || player.getPermissionGroup().equals(ServerToolsGeneralUtils.SettingbyName("PluginAdminAccessPermGroup"))){
            for (int i=0;i<ann.size();i++){
                if (ann.get(i).type.equals("onloginadminbroadcast")){
                    STM.getServer().broadcastTextMessage(ann.get(i).colourcode + ServerToolsGeneralUtils.SettingbyName("AutoMessageBotName") + ": " + ann.get(i).text);
                }
            }
        }
    }
    
}
