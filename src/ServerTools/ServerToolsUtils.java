package ServerTools;

import ServerTools.GuiComponents.ServerToolsVoteDayGui;
import ServerTools.GuiComponents.ServerToolsMainPanelGui;

import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.objects.Player;

public class ServerToolsUtils {
    
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
    
    public static void setVoteDayGuiAttributes(Player player){
        GuiPanel personalVoteDayPanel = ServerToolsVoteDayGui.createVoteDayGuiPanel();
        GuiLabel personalVoteDayDescriptionLabel = ServerToolsVoteDayGui.createVoteDayDescriptionGuiLabel();
        GuiLabel personalVoteDayTimerLabel = ServerToolsVoteDayGui.createVoteDayTimerGuiLabel();
        GuiImage personalVoteDayYesImageLabel = ServerToolsVoteDayGui.createVoteDayYesGuiImageLabel();
        GuiLabel personalVoteDayYesTextLabel = ServerToolsVoteDayGui.createVoteDayYesTextGuiLabel();
        GuiImage personalVoteDayNoImageLabel = ServerToolsVoteDayGui.createVoteDayNoGuiImageLabel();
        GuiLabel personalVoteDayNoTextLabel = ServerToolsVoteDayGui.createVoteDayNoTextGuiLabel();
        
        personalVoteDayPanel.addChild(personalVoteDayDescriptionLabel);
        personalVoteDayPanel.addChild(personalVoteDayTimerLabel);
        personalVoteDayPanel.addChild(personalVoteDayYesImageLabel);
        personalVoteDayPanel.addChild(personalVoteDayNoImageLabel);
        personalVoteDayYesImageLabel.addChild(personalVoteDayYesTextLabel);
        personalVoteDayNoImageLabel.addChild(personalVoteDayNoTextLabel);
        
        player.setAttribute("STVoteDayPanel", personalVoteDayPanel);
        player.setAttribute("STVoteDayDescriptionLabel", personalVoteDayDescriptionLabel);
        player.setAttribute("STVoteDayYesImageLabel", personalVoteDayYesImageLabel);
        player.setAttribute("STVoteDayYesTextLabel", personalVoteDayYesTextLabel);
        player.setAttribute("STVoteDayNoImageLabel", personalVoteDayNoImageLabel);
        player.setAttribute("STVoteDayNoTextLabel", personalVoteDayNoTextLabel);
        player.setAttribute("STVoteDayTimerLabel", personalVoteDayTimerLabel);
        
        player.addGuiElement((GuiPanel) player.getAttribute("STVoteDayPanel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayDescriptionLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STVoteDayYesImageLabel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayYesTextLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STVoteDayNoImageLabel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayNoTextLabel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayTimerLabel"));
    }
    
    public static void showHideVoteDayGui(Player player, boolean showHide){
        GuiPanel personalVoteDayPanel = (GuiPanel) player.getAttribute("STVoteDayPanel");
        GuiLabel personalVoteDayDescriptionLabel = (GuiLabel) player.getAttribute("STVoteDayDescriptionLabel");
        GuiLabel personalVoteDayTimerLabel = (GuiLabel) player.getAttribute("STVoteDayTimerLabel");
        GuiImage personalVoteDayYesImageLabel = (GuiImage) player.getAttribute("STVoteDayYesImageLabel");
        GuiLabel personalVoteDayYesTextLabel = (GuiLabel) player.getAttribute("STVoteDayYesTextLabel");
        GuiImage personalVoteDayNoImageLabel = (GuiImage) player.getAttribute("STVoteDayNoImageLabel");
        GuiLabel personalVoteDayNoTextLabel = (GuiLabel) player.getAttribute("STVoteDayNoTextLabel");
        
        personalVoteDayPanel.setVisible(showHide);
        personalVoteDayDescriptionLabel.setVisible(showHide);
        personalVoteDayTimerLabel.setVisible(showHide);
        personalVoteDayYesImageLabel.setVisible(showHide);
        personalVoteDayYesTextLabel.setVisible(showHide);
        personalVoteDayNoImageLabel.setVisible(showHide);
        personalVoteDayNoTextLabel.setVisible(showHide);
    }
    
    public static void setMainPanelAttributes(Player player){
        GuiPanel personalMainPanel = ServerToolsMainPanelGui.createServerToolsMainPanel();
        GuiLabel personalHeaderLabel = ServerToolsMainPanelGui.createServerToolsHeaderLabel();
        GuiImage personalGeneralTabImage = ServerToolsMainPanelGui.createServerToolsGeneralTabImage();
        GuiLabel personalGeneralTabLabel = ServerToolsMainPanelGui.createServerToolsGeneralTabLabel();
        GuiImage personalMessagesTabImage = ServerToolsMainPanelGui.createServerToolsMessagesTabImage();
        GuiLabel personalMessagesTabLabel = ServerToolsMainPanelGui.createServerToolsMessagesTabLabel();
        GuiImage personalAnnouncementsTabImage = ServerToolsMainPanelGui.createServerToolsAnnouncementsTabImage();
        GuiLabel personalAnnouncementsTabLabel = ServerToolsMainPanelGui.createServerToolsAnnouncementsTabLabel();
        GuiImage personalRankingTabImage = ServerToolsMainPanelGui.createServerToolsRankingTabImage();
        GuiLabel personalRankingTabLabel = ServerToolsMainPanelGui.createServerToolsRankingTabLabel();
        GuiImage personalBannedListsTabImage = ServerToolsMainPanelGui.createServerToolsBannedListsTabImage();
        GuiLabel personalBannedListsTabLabel = ServerToolsMainPanelGui.createServerToolsBannedListsTabLabel();
        GuiImage personalBlacklistTabImage = ServerToolsMainPanelGui.createServerToolsBlacklistTabImage();
        GuiLabel personalBlacklistTabLabel = ServerToolsMainPanelGui.createServerToolsBlacklistTabLabel();
        GuiImage personalRestWarnTabImage = ServerToolsMainPanelGui.createServerToolsRestWarnTabImage();
        GuiLabel personalRestWarnTabLabel = ServerToolsMainPanelGui.createServerToolsRestWarnTabLabel();
        GuiImage personalSettingsTabImage = ServerToolsMainPanelGui.createServerToolsSettingsTabImage();
        GuiLabel personalSettingsTabLabel = ServerToolsMainPanelGui.createServerToolsSettingsTabLabel();
        
        personalMainPanel.addChild(personalHeaderLabel);
        personalMainPanel.addChild(personalGeneralTabImage);
        personalMainPanel.addChild(personalMessagesTabImage);
        personalMainPanel.addChild(personalAnnouncementsTabImage);
        personalMainPanel.addChild(personalRankingTabImage);
        personalMainPanel.addChild(personalBannedListsTabImage);
        personalMainPanel.addChild(personalBlacklistTabImage);
        personalMainPanel.addChild(personalRestWarnTabImage);
        personalMainPanel.addChild(personalSettingsTabImage);
        
        personalGeneralTabImage.addChild(personalGeneralTabLabel);
        personalMessagesTabImage.addChild(personalMessagesTabLabel);
        personalAnnouncementsTabImage.addChild(personalAnnouncementsTabLabel);
        personalRankingTabImage.addChild(personalRankingTabLabel);
        personalBannedListsTabImage.addChild(personalBannedListsTabLabel);
        personalBlacklistTabImage.addChild(personalBlacklistTabLabel);
        personalRestWarnTabImage.addChild(personalRestWarnTabLabel);
        personalSettingsTabImage.addChild(personalSettingsTabLabel);
        
        player.setAttribute("STPreviousTab", 1);
        
        player.setAttribute("STMainPanel", personalMainPanel);
        player.setAttribute("STHeaderLabel", personalHeaderLabel);
        player.setAttribute("STGeneralTabImage", personalGeneralTabImage);
        player.setAttribute("STGeneralTabLabel", personalGeneralTabLabel);
        player.setAttribute("STMessagesTabImage", personalMessagesTabImage);
        player.setAttribute("STMessagesTabLabel", personalMessagesTabLabel);
        player.setAttribute("STAnnouncementsTabImage", personalAnnouncementsTabImage);
        player.setAttribute("STAnnouncementsTabLabel", personalAnnouncementsTabLabel);
        player.setAttribute("STRankingTabImage", personalRankingTabImage);
        player.setAttribute("STRankingTabLabel", personalRankingTabLabel);
        player.setAttribute("STBannedListsTabImage", personalBannedListsTabImage);
        player.setAttribute("STBannedListsTabLabel", personalBannedListsTabLabel);
        player.setAttribute("STBlacklistTabImage", personalBlacklistTabImage);
        player.setAttribute("STBlacklistTabLabel", personalBlacklistTabLabel);
        player.setAttribute("STRestWarnTabImage", personalRestWarnTabImage);
        player.setAttribute("STRestWarnTabLabel", personalRestWarnTabLabel);
        player.setAttribute("STSettingsTabImage", personalSettingsTabImage);
        player.setAttribute("STSettingsTabLabel", personalSettingsTabLabel);
        
        player.addGuiElement((GuiPanel) player.getAttribute("STMainPanel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STHeaderLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STGeneralTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STGeneralTabLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STMessagesTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STMessagesTabLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STAnnouncementsTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STAnnouncementsTabLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STRankingTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STRankingTabLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STBannedListsTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STBannedListsTabLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STBlacklistTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STBlacklistTabLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STRestWarnTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STRestWarnTabLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STSettingsTabImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabLabel"));
    }
    
    public static void showHideMainGui(Player player, boolean showHide){
        GuiPanel personalMainPanel = (GuiPanel) player.getAttribute("STMainPanel");
        GuiLabel personalHeaderLabel = (GuiLabel) player.getAttribute("STHeaderLabel");
        GuiImage personalGeneralTabImage = (GuiImage) player.getAttribute("STGeneralTabImage");
        GuiLabel personalGeneralTabLabel = (GuiLabel) player.getAttribute("STGeneralTabLabel");
        GuiImage personalMessagesTabImage = (GuiImage) player.getAttribute("STMessagesTabImage");
        GuiLabel personalMessagesTabLabel = (GuiLabel) player.getAttribute("STMessagesTabLabel");
        GuiImage personalAnnouncementsTabImage = (GuiImage) player.getAttribute("STAnnouncementsTabImage");
        GuiLabel personalAnnouncementsTabLabel = (GuiLabel) player.getAttribute("STAnnouncementsTabLabel");
        GuiImage personalRankingTabImage = (GuiImage) player.getAttribute("STRankingTabImage");
        GuiLabel personalRankingTabLabel = (GuiLabel) player.getAttribute("STRankingTabLabel");
        GuiImage personalBannedListsTabImage = (GuiImage) player.getAttribute("STBannedListsTabImage");
        GuiLabel personalBannedListsTabLabel = (GuiLabel) player.getAttribute("STBannedListsTabLabel");
        GuiImage personalBlacklistTabImage = (GuiImage) player.getAttribute("STBlacklistTabImage");
        GuiLabel personalBlacklistTabLabel = (GuiLabel) player.getAttribute("STBlacklistTabLabel");
        GuiImage personalRestWarnTabImage = (GuiImage) player.getAttribute("STRestWarnTabImage");
        GuiLabel personalRestWarnTabLabel = (GuiLabel) player.getAttribute("STRestWarnTabLabel");
        GuiImage personalSettingsTabImage = (GuiImage) player.getAttribute("STSettingsTabImage");
        GuiLabel personalSettingsTabLabel = (GuiLabel) player.getAttribute("STSettingsTabLabel");
        
        personalMainPanel.setVisible(showHide);
        personalHeaderLabel.setVisible(showHide);
        personalGeneralTabImage.setVisible(showHide);
        personalGeneralTabLabel.setVisible(showHide);
        personalMessagesTabImage.setVisible(showHide);
        personalMessagesTabLabel.setVisible(showHide);
        personalAnnouncementsTabImage.setVisible(showHide);
        personalAnnouncementsTabLabel.setVisible(showHide);
        personalRankingTabImage.setVisible(showHide);
        personalRankingTabLabel.setVisible(showHide);
        personalBannedListsTabImage.setVisible(showHide);
        personalBannedListsTabLabel.setVisible(showHide);
        personalBlacklistTabImage.setVisible(showHide);
        personalBlacklistTabLabel.setVisible(showHide);
        personalRestWarnTabImage.setVisible(showHide);
        personalRestWarnTabLabel.setVisible(showHide);
        personalSettingsTabImage.setVisible(showHide);
        personalSettingsTabLabel.setVisible(showHide);
    }
    
    public static void showHideGeneralTabGui(Player player, boolean showHide){
        GuiLabel personalGeneralTabLabel = (GuiLabel) player.getAttribute("STGeneralTabLabel");
        
        if (showHide){
            personalGeneralTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalGeneralTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void showHideMessagesTabGui(Player player, boolean showHide){
        GuiLabel personalMessagesTabLabel = (GuiLabel) player.getAttribute("STMessagesTabLabel");
        
        if (showHide){
            personalMessagesTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalMessagesTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void showHideAnnouncementsTabGui(Player player, boolean showHide){
        GuiLabel personalAnnouncementsTabLabel = (GuiLabel) player.getAttribute("STAnnouncementsTabLabel");
        
        if (showHide){
            personalAnnouncementsTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalAnnouncementsTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void showHideRankingTabGui(Player player, boolean showHide){
        GuiLabel personalRankingTabLabel = (GuiLabel) player.getAttribute("STRankingTabLabel");
        
        if (showHide){
            personalRankingTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalRankingTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void showHideBannedListsTabGui(Player player, boolean showHide){
        GuiLabel personalBannedListsTabLabel = (GuiLabel) player.getAttribute("STBannedListsTabLabel");
        
        if (showHide){
            personalBannedListsTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalBannedListsTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void showHideBlacklistTabGui(Player player, boolean showHide){
        GuiLabel personalBlacklistTabLabel = (GuiLabel) player.getAttribute("STBlacklistTabLabel");
        
        if (showHide){
            personalBlacklistTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalBlacklistTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void showHideRestWarnTabGui(Player player, boolean showHide){
        GuiLabel personalRestWarnTabLabel = (GuiLabel) player.getAttribute("STRestWarnTabLabel");
        
        if (showHide){
            personalRestWarnTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalRestWarnTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void showHideSettingsTabGui(Player player, boolean showHide){
        GuiLabel personalSettingsTabLabel = (GuiLabel) player.getAttribute("STSettingsTabLabel");
        
        if (showHide){
            personalSettingsTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
        }
        else {
            personalSettingsTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        }
    }
    
    public static void switchTab(Player player, int previousTab, int nextTab){
        
        switch (previousTab) {
            case ServerToolsDataBank.GENERAL_TAB_GUI:
                showHideGeneralTabGui(player, false);
                break;
            case ServerToolsDataBank.MESSAGES_TAB_GUI:
                showHideMessagesTabGui(player, false);
                break;
            case ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI:
                showHideAnnouncementsTabGui(player, false);
                break;
            case ServerToolsDataBank.RANKING_TAB_GUI:
                showHideRankingTabGui(player, false);
                break;
            case ServerToolsDataBank.BANNED_LISTS_TAB_GUI:
                showHideBannedListsTabGui(player, false);
                break;
            case ServerToolsDataBank.BLACKLIST_TAB_GUI:
                showHideBlacklistTabGui(player, false);
                break;
            case ServerToolsDataBank.REST_WARN_TAB_GUI:
                showHideRestWarnTabGui(player, false);
                break;
            case ServerToolsDataBank.SETTINGS_TAB_GUI:
                showHideSettingsTabGui(player, false);
                break;
            default:
                break;
        }
        
        switch (nextTab) {
            case ServerToolsDataBank.GENERAL_TAB_GUI:
                showHideGeneralTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.GENERAL_TAB_GUI);
                break;
            case ServerToolsDataBank.MESSAGES_TAB_GUI:
                showHideMessagesTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.MESSAGES_TAB_GUI);
                break;
            case ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI:
                showHideAnnouncementsTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI);
                break;
            case ServerToolsDataBank.RANKING_TAB_GUI:
                showHideRankingTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.RANKING_TAB_GUI);
                break;
            case ServerToolsDataBank.BANNED_LISTS_TAB_GUI:
                showHideBannedListsTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.BANNED_LISTS_TAB_GUI);
                break;
            case ServerToolsDataBank.BLACKLIST_TAB_GUI:
                showHideBlacklistTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.BLACKLIST_TAB_GUI);
                break;
            case ServerToolsDataBank.REST_WARN_TAB_GUI:
                showHideRestWarnTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.REST_WARN_TAB_GUI);
                break;
            case ServerToolsDataBank.SETTINGS_TAB_GUI:
                showHideSettingsTabGui(player, true);
                player.setAttribute("STPreviousTab", ServerToolsDataBank.SETTINGS_TAB_GUI);
                break;
            default:
                break;
        }
    }
}
