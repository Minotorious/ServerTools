package ServerTools.Utils;

import ServerTools.ServerToolsDataBank;
import net.risingworld.api.objects.Player;

public class ServerToolsGeneralUtils {
    
    public static String SettingbyName(String input){
        String[][] settings =  ServerToolsDataBank.Settings.getSettings();
        String output = "";
        
        for (String[] setting : settings){
            if (setting[0].equals(input)){
                output = setting[1];
            }
        }
        
        return output;
    }
    
    public static void switchTab(Player player, int currentTab, int nextTab){
        
        switch (currentTab) {
            case ServerToolsDataBank.GENERAL_TAB_GUI:
                ServerToolsShowHideGui.showHideGeneralTabGui(player, false);
                break;
            case ServerToolsDataBank.MESSAGES_TAB_GUI:
                ServerToolsShowHideGui.showHideMessagesTabGui(player, false);
                break;
            case ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI:
                ServerToolsShowHideGui.showHideAnnouncementsTabGui(player, false);
                break;
            case ServerToolsDataBank.RANKING_TAB_GUI:
                ServerToolsShowHideGui.showHideRankingTabGui(player, false);
                break;
            case ServerToolsDataBank.BANNED_LISTS_TAB_GUI:
                ServerToolsShowHideGui.showHideBannedListsTabGui(player, false);
                break;
            case ServerToolsDataBank.BLACKLIST_TAB_GUI:
                ServerToolsShowHideGui.showHideBlacklistTabGui(player, false);
                break;
            case ServerToolsDataBank.REST_WARN_TAB_GUI:
                ServerToolsShowHideGui.showHideRestWarnTabGui(player, false);
                break;
            case ServerToolsDataBank.SETTINGS_TAB_GUI:
                ServerToolsShowHideGui.showHideSettingsTabGui(player, false);
                break;
            default:
                break;
        }
        
        switch (nextTab) {
            case ServerToolsDataBank.GENERAL_TAB_GUI:
                ServerToolsShowHideGui.showHideGeneralTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.GENERAL_TAB_GUI);
                break;
            case ServerToolsDataBank.MESSAGES_TAB_GUI:
                ServerToolsShowHideGui.showHideMessagesTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.MESSAGES_TAB_GUI);
                break;
            case ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI:
                ServerToolsShowHideGui.showHideAnnouncementsTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI);
                break;
            case ServerToolsDataBank.RANKING_TAB_GUI:
                ServerToolsShowHideGui.showHideRankingTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.RANKING_TAB_GUI);
                break;
            case ServerToolsDataBank.BANNED_LISTS_TAB_GUI:
                ServerToolsShowHideGui.showHideBannedListsTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.BANNED_LISTS_TAB_GUI);
                break;
            case ServerToolsDataBank.BLACKLIST_TAB_GUI:
                ServerToolsShowHideGui.showHideBlacklistTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.BLACKLIST_TAB_GUI);
                break;
            case ServerToolsDataBank.REST_WARN_TAB_GUI:
                ServerToolsShowHideGui.showHideRestWarnTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.REST_WARN_TAB_GUI);
                break;
            case ServerToolsDataBank.SETTINGS_TAB_GUI:
                ServerToolsShowHideGui.showHideSettingsTabGui(player, true);
                player.setAttribute("STCurrentTab", ServerToolsDataBank.SETTINGS_TAB_GUI);
                break;
            default:
                break;
        }
    }
    
    public static void closeGui(Player player, int currentTab){
        
        switch (currentTab) {
            case ServerToolsDataBank.GENERAL_TAB_GUI:
                ServerToolsShowHideGui.showHideGeneralTabGui(player, false);
                break;
            case ServerToolsDataBank.MESSAGES_TAB_GUI:
                ServerToolsShowHideGui.showHideMessagesTabGui(player, false);
                break;
            case ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI:
                ServerToolsShowHideGui.showHideAnnouncementsTabGui(player, false);
                break;
            case ServerToolsDataBank.RANKING_TAB_GUI:
                ServerToolsShowHideGui.showHideRankingTabGui(player, false);
                break;
            case ServerToolsDataBank.BANNED_LISTS_TAB_GUI:
                ServerToolsShowHideGui.showHideBannedListsTabGui(player, false);
                break;
            case ServerToolsDataBank.BLACKLIST_TAB_GUI:
                ServerToolsShowHideGui.showHideBlacklistTabGui(player, false);
                break;
            case ServerToolsDataBank.REST_WARN_TAB_GUI:
                ServerToolsShowHideGui.showHideRestWarnTabGui(player, false);
                break;
            case ServerToolsDataBank.SETTINGS_TAB_GUI:
                ServerToolsShowHideGui.showHideSettingsTabGui(player, false);
                break;
            default:
                break;
        }
        ServerToolsShowHideGui.showHideMainGui(player, false);
        player.setMouseCursorVisible(false);
    }
}
