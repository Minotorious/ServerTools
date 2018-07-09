package ServerTools.Utils;

import ServerTools.GuiComponents.ServerToolsGeneralTabGui;
import ServerTools.GuiComponents.ServerToolsMainPanelGui;
import ServerTools.GuiComponents.ServerToolsSettingsTabGui;
import ServerTools.GuiComponents.ServerToolsVoteDayGui;
import ServerTools.ServerToolsDataBank;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.GuiTextField;
import net.risingworld.api.objects.Player;

public class ServerToolsAttributeSet {
  
    public static void setVoteDayGuiAttributes(Player player){
        GuiPanel personalVoteDayPanel = ServerToolsVoteDayGui.createVoteDayGuiPanel();
        GuiLabel personalVoteDayDescriptionLabel = ServerToolsVoteDayGui.createVoteDayDescriptionGuiLabel();
        GuiLabel personalVoteDayTimerLabel = ServerToolsVoteDayGui.createVoteDayTimerGuiLabel();
        GuiImage personalVoteDayYesImage = ServerToolsVoteDayGui.createVoteDayYesGuiImage();
        GuiLabel personalVoteDayYesLabel = ServerToolsVoteDayGui.createVoteDayYesGuiLabel();
        GuiImage personalVoteDayNoImage = ServerToolsVoteDayGui.createVoteDayNoGuiImage();
        GuiLabel personalVoteDayNoLabel = ServerToolsVoteDayGui.createVoteDayNoGuiLabel();
        
        personalVoteDayPanel.addChild(personalVoteDayDescriptionLabel);
        personalVoteDayPanel.addChild(personalVoteDayTimerLabel);
        personalVoteDayPanel.addChild(personalVoteDayYesImage);
        personalVoteDayPanel.addChild(personalVoteDayNoImage);
        personalVoteDayYesImage.addChild(personalVoteDayYesLabel);
        personalVoteDayNoImage.addChild(personalVoteDayNoLabel);
        
        player.setAttribute("STVoteDayPanel", personalVoteDayPanel);
        player.setAttribute("STVoteDayDescriptionLabel", personalVoteDayDescriptionLabel);
        player.setAttribute("STVoteDayYesImage", personalVoteDayYesImage);
        player.setAttribute("STVoteDayYesLabel", personalVoteDayYesLabel);
        player.setAttribute("STVoteDayNoImage", personalVoteDayNoImage);
        player.setAttribute("STVoteDayNoLabel", personalVoteDayNoLabel);
        player.setAttribute("STVoteDayTimerLabel", personalVoteDayTimerLabel);
        
        player.addGuiElement((GuiPanel) player.getAttribute("STVoteDayPanel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayDescriptionLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STVoteDayYesImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayYesLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STVoteDayNoImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayNoLabel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STVoteDayTimerLabel"));
    }
    
    public static void setMainPanelAttributes(Player player){
        GuiPanel personalMainPanel = ServerToolsMainPanelGui.createServerToolsMainPanel();
        GuiLabel personalHeaderLabel = ServerToolsMainPanelGui.createServerToolsHeaderLabel();
        GuiLabel personalCloseLabel = ServerToolsMainPanelGui.createServerToolsCloseLabel();
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
        personalMainPanel.addChild(personalCloseLabel);
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
        
        player.setAttribute("STCurrentTab", ServerToolsDataBank.GENERAL_TAB_GUI);
        
        player.setAttribute("STMainPanel", personalMainPanel);
        player.setAttribute("STHeaderLabel", personalHeaderLabel);
        player.setAttribute("STCloseLabel", personalCloseLabel);
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
        player.addGuiElement((GuiLabel) player.getAttribute("STCloseLabel"));
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
    
    public static void setGeneralTabAttributes(Player player){
        GuiPanel personalMainPanel = (GuiPanel) player.getAttribute("STMainPanel");
        
        GuiPanel personalGeneralTabPanel = ServerToolsGeneralTabGui.createServerToolsGeneralTabPanel();
        GuiLabel personalGeneralTabPlayerLabel = ServerToolsGeneralTabGui.createGeneralTabPlayerLabel();
        GuiLabel personalGeneralTabPlayerNameLabel = ServerToolsGeneralTabGui.createGeneralTabPlayerNameLabel();
        
        personalMainPanel.addChild(personalGeneralTabPanel);
        
        personalGeneralTabPanel.addChild(personalGeneralTabPlayerLabel);
        
        personalGeneralTabPlayerLabel.addChild(personalGeneralTabPlayerNameLabel);
        
        player.setAttribute("STGeneralTabPanel", personalGeneralTabPanel);
        player.setAttribute("STGeneralTabPlayerLabel", personalGeneralTabPlayerLabel);
        player.setAttribute("STGeneralTabPlayerNameLabel", personalGeneralTabPlayerNameLabel);
        
        player.addGuiElement((GuiPanel) player.getAttribute("STGeneralTabPanel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STGeneralTabPlayerLabel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STGeneralTabPlayerNameLabel"));
    }
    
    public static void setSettingsTabAttributes(Player player){
        GuiPanel personalMainPanel = (GuiPanel) player.getAttribute("STMainPanel");
        
        GuiPanel personalSettingsTabPanel = ServerToolsSettingsTabGui.createServerToolsSettingsTabPanel();
        GuiLabel personalSaveLabel = ServerToolsSettingsTabGui.createSettingsTabSaveLabel();
        GuiImage personalSaveImage = ServerToolsSettingsTabGui.createSettingsTabSaveImage();
        GuiLabel personalAutoMessageBotNameLabel = ServerToolsSettingsTabGui.createSettingsTabAutoMessageBotNameLabel();
        GuiTextField personalAutoMessageBotNameTextField = ServerToolsSettingsTabGui.createSettingsTabAutoMessageBotNameTextField();
        GuiLabel personalPoliceBotModeLabel = ServerToolsSettingsTabGui.createSettingsTabPoliceBotModeLabel();
        GuiLabel personalPoliceBotModeToggleLabel = ServerToolsSettingsTabGui.createSettingsTabPoliceBotModeToggleLabel();
        GuiLabel personalPoliceBotNameLabel = ServerToolsSettingsTabGui.createSettingsTabPoliceBotNameLabel();
        GuiTextField personalPoliceBotNameTextField = ServerToolsSettingsTabGui.createSettingsTabPoliceBotNameTextField();
        GuiLabel personalPoliceBotChatColourLabel = ServerToolsSettingsTabGui.createSettingsTabPoliceBotChatColourLabel();
        GuiTextField personalPoliceBotChatColourTextField = ServerToolsSettingsTabGui.createSettingsTabPoliceBotChatColourTextField();
        GuiLabel personalRankingBotNameLabel = ServerToolsSettingsTabGui.createSettingsTabRankingBotNameLabel();
        GuiTextField personalRankingBotNameTextField = ServerToolsSettingsTabGui.createSettingsTabRankingBotNameTextField();
        GuiLabel personalRestWarnBotNameLabel = ServerToolsSettingsTabGui.createSettingsTabRestWarnBotNameLabel();
        GuiTextField personalRestWarnBotNameTextField = ServerToolsSettingsTabGui.createSettingsTabRestWarnBotNameTextField();
        
        personalMainPanel.addChild(personalSettingsTabPanel);
        
        personalSettingsTabPanel.addChild(personalSaveImage);
        personalSettingsTabPanel.addChild(personalAutoMessageBotNameLabel);
        personalSettingsTabPanel.addChild(personalAutoMessageBotNameTextField);
        personalSettingsTabPanel.addChild(personalPoliceBotModeLabel);
        personalSettingsTabPanel.addChild(personalPoliceBotModeToggleLabel);
        personalSettingsTabPanel.addChild(personalPoliceBotNameLabel);
        personalSettingsTabPanel.addChild(personalPoliceBotNameTextField);
        personalSettingsTabPanel.addChild(personalPoliceBotChatColourLabel);
        personalSettingsTabPanel.addChild(personalPoliceBotChatColourTextField);
        personalSettingsTabPanel.addChild(personalRankingBotNameLabel);
        personalSettingsTabPanel.addChild(personalRankingBotNameTextField);
        personalSettingsTabPanel.addChild(personalRestWarnBotNameLabel);
        personalSettingsTabPanel.addChild(personalRestWarnBotNameTextField);
        
        personalSaveImage.addChild(personalSaveLabel);
        
        player.setAttribute("STSettingsTabPanel", personalSettingsTabPanel);
        player.setAttribute("STSettingsTabSaveLabel", personalSaveLabel);
        player.setAttribute("STSettingsTabSaveImage", personalSaveImage);
        player.setAttribute("STSettingsTabAutoMessageBotNameLabel", personalAutoMessageBotNameLabel);
        player.setAttribute("STSettingsTabAutoMessageBotNameTextField", personalAutoMessageBotNameTextField);
        player.setAttribute("STSettingsTabPoliceBotModeLabel", personalPoliceBotModeLabel);
        player.setAttribute("STSettingsTabPoliceBotModeToggleLabel", personalPoliceBotModeToggleLabel);
        player.setAttribute("STSettingsTabPoliceBotNameLabel", personalPoliceBotNameLabel);
        player.setAttribute("STSettingsTabPoliceBotNameTextField", personalPoliceBotNameTextField);
        player.setAttribute("STSettingsTabPoliceBotChatColourLabel", personalPoliceBotChatColourLabel);
        player.setAttribute("STSettingsTabPoliceBotChatColourTextField", personalPoliceBotChatColourTextField);
        player.setAttribute("STSettingsTabRankingBotNameLabel", personalRankingBotNameLabel);
        player.setAttribute("STSettingsTabRankingBotNameTextField", personalRankingBotNameTextField);
        player.setAttribute("STSettingsTabRestWarnBotNameLabel", personalRestWarnBotNameLabel);
        player.setAttribute("STSettingsTabRestWarnBotNameTextField", personalRestWarnBotNameTextField);
        
        
        player.addGuiElement((GuiPanel) player.getAttribute("STSettingsTabPanel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabSaveLabel"));
        player.addGuiElement((GuiImage) player.getAttribute("STSettingsTabSaveImage"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabAutoMessageBotNameLabel"));
        player.addGuiElement((GuiTextField) player.getAttribute("STSettingsTabAutoMessageBotNameTextField"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabPoliceBotModeLabel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabPoliceBotModeToggleLabel"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabPoliceBotNameLabel"));
        player.addGuiElement((GuiTextField) player.getAttribute("STSettingsTabPoliceBotNameTextField"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabPoliceBotChatColourLabel"));
        player.addGuiElement((GuiTextField) player.getAttribute("STSettingsTabPoliceBotChatColourTextField"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabRankingBotNameLabel"));
        player.addGuiElement((GuiTextField) player.getAttribute("STSettingsTabRankingBotNameTextField"));
        player.addGuiElement((GuiLabel) player.getAttribute("STSettingsTabRestWarnBotNameLabel"));
        player.addGuiElement((GuiTextField) player.getAttribute("STSettingsTabRestWarnBotNameTextField"));
    }
}
