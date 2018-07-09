package ServerTools.Utils;

import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.GuiTextField;
import net.risingworld.api.objects.Player;

public class ServerToolsShowHideGui {

    public static void showHideVoteDayGui(Player player, boolean showHide){
        GuiPanel personalVoteDayPanel = (GuiPanel) player.getAttribute("STVoteDayPanel");
        GuiLabel personalVoteDayDescriptionLabel = (GuiLabel) player.getAttribute("STVoteDayDescriptionLabel");
        GuiLabel personalVoteDayTimerLabel = (GuiLabel) player.getAttribute("STVoteDayTimerLabel");
        GuiImage personalVoteDayYesImage = (GuiImage) player.getAttribute("STVoteDayYesImage");
        GuiLabel personalVoteDayYesLabel = (GuiLabel) player.getAttribute("STVoteDayYesLabel");
        GuiImage personalVoteDayNoImage = (GuiImage) player.getAttribute("STVoteDayNoImage");
        GuiLabel personalVoteDayNoLabel = (GuiLabel) player.getAttribute("STVoteDayNoLabel");
        
        personalVoteDayPanel.setVisible(showHide);
        personalVoteDayDescriptionLabel.setVisible(showHide);
        personalVoteDayTimerLabel.setVisible(showHide);
        personalVoteDayYesImage.setVisible(showHide);
        personalVoteDayYesLabel.setVisible(showHide);
        personalVoteDayNoImage.setVisible(showHide);
        personalVoteDayNoLabel.setVisible(showHide);
    }
    
    public static void showHideMainGui(Player player, boolean showHide){
        GuiPanel personalMainPanel = (GuiPanel) player.getAttribute("STMainPanel");
        GuiLabel personalHeaderLabel = (GuiLabel) player.getAttribute("STHeaderLabel");
        GuiLabel personalCloseLabel = (GuiLabel) player.getAttribute("STCloseLabel");
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
        personalCloseLabel.setVisible(showHide);
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
        
        GuiPanel personalGeneralTabPanel = (GuiPanel) player.getAttribute("STGeneralTabPanel");
        GuiLabel personalGeneralTabPlayerLabel = (GuiLabel) player.getAttribute("STGeneralTabPlayerLabel");
        GuiLabel personalGeneralTabPlayerNameLabel = (GuiLabel) player.getAttribute("STGeneralTabPlayerNameLabel");
        
        personalGeneralTabPanel.setVisible(showHide);
        personalGeneralTabPlayerLabel.setVisible(showHide);
        personalGeneralTabPlayerNameLabel.setVisible(showHide);
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
        
        GuiPanel personalSettingsTabPanel = (GuiPanel) player.getAttribute("STSettingsTabPanel");
        GuiLabel personalSaveLabel = (GuiLabel) player.getAttribute("STSettingsTabSaveLabel");
        GuiImage personalSaveImage = (GuiImage) player.getAttribute("STSettingsTabSaveImage");
        GuiLabel personalAutoMessageBotNameLabel = (GuiLabel) player.getAttribute("STSettingsTabAutoMessageBotNameLabel");
        GuiTextField personalAutoMessageBotNameTextField = (GuiTextField) player.getAttribute("STSettingsTabAutoMessageBotNameTextField");
        GuiLabel personalPoliceBotModeLabel = (GuiLabel) player.getAttribute("STSettingsTabPoliceBotModeLabel");
        GuiLabel personalPoliceBotModeToggleLabel = (GuiLabel) player.getAttribute("STSettingsTabPoliceBotModeToggleLabel");
        GuiLabel personalPoliceBotNameLabel = (GuiLabel) player.getAttribute("STSettingsTabPoliceBotNameLabel");
        GuiTextField personalPoliceBotNameTextField = (GuiTextField) player.getAttribute("STSettingsTabPoliceBotNameTextField");
        GuiLabel personalPoliceBotChatColourLabel = (GuiLabel) player.getAttribute("STSettingsTabPoliceBotChatColourLabel");
        GuiTextField personalPoliceBotChatColourTextField = (GuiTextField) player.getAttribute("STSettingsTabPoliceBotChatColourTextField");
        GuiLabel personalRankingBotNameLabel = (GuiLabel) player.getAttribute("STSettingsTabRankingBotNameLabel");
        GuiTextField personalRankingBotNameTextField = (GuiTextField) player.getAttribute("STSettingsTabRankingBotNameTextField");
        GuiLabel personalRestWarnBotNameLabel = (GuiLabel) player.getAttribute("STSettingsTabRestWarnBotNameLabel");
        GuiTextField personalRestWarnBotNameTextField = (GuiTextField) player.getAttribute("STSettingsTabRestWarnBotNameTextField");
        
        personalSettingsTabPanel.setVisible(showHide);
        personalSaveLabel.setVisible(showHide);
        personalSaveImage.setVisible(showHide);
        personalAutoMessageBotNameLabel.setVisible(showHide);
        personalAutoMessageBotNameTextField.setVisible(showHide);
        personalPoliceBotModeLabel.setVisible(showHide);
        personalPoliceBotModeToggleLabel.setVisible(showHide);
        personalPoliceBotNameLabel.setVisible(showHide);
        personalPoliceBotNameTextField.setVisible(showHide);
        personalPoliceBotChatColourLabel.setVisible(showHide);
        personalPoliceBotChatColourTextField.setVisible(showHide);
        personalRankingBotNameLabel.setVisible(showHide);
        personalRankingBotNameTextField.setVisible(showHide);
        personalRestWarnBotNameLabel.setVisible(showHide);
        personalRestWarnBotNameTextField.setVisible(showHide);
    }
}
