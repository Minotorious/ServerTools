package ServerTools;

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
        GuiPanel personalVoteDayPanel = ServerToolsGUI.createVoteDayGuiPanel();
        GuiLabel personalVoteDayDescriptionLabel = ServerToolsGUI.createVoteDayDescriptionGuiLabel();
        GuiLabel personalVoteDayTimerLabel = ServerToolsGUI.createVoteDayTimerGuiLabel();
        GuiImage personalVoteDayYesImageLabel = ServerToolsGUI.createVoteDayYesGuiImageLabel();
        GuiLabel personalVoteDayYesTextLabel = ServerToolsGUI.createVoteDayYesTextGuiLabel();
        GuiImage personalVoteDayNoImageLabel = ServerToolsGUI.createVoteDayNoGuiImageLabel();
        GuiLabel personalVoteDayNoTextLabel = ServerToolsGUI.createVoteDayNoTextGuiLabel();
        
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
        GuiPanel personalMainPanel = ServerToolsGUI.createServerToolsMainPanel();
        GuiLabel personalHeaderLabel = ServerToolsGUI.createServerToolsHeaderLabel();
        GuiImage personalGeneralTabImage = ServerToolsGUI.createServerToolsGeneralTabImage();
        GuiLabel personalGeneralTabLabel = ServerToolsGUI.createServerToolsGeneralTabLabel();
        GuiImage personalMessagesTabImage = ServerToolsGUI.createServerToolsMessagesTabImage();
        GuiLabel personalMessagesTabLabel = ServerToolsGUI.createServerToolsMessagesTabLabel();
        GuiImage personalAnnouncementsTabImage = ServerToolsGUI.createServerToolsAnnouncementsTabImage();
        GuiLabel personalAnnouncementsTabLabel = ServerToolsGUI.createServerToolsAnnouncementsTabLabel();
        GuiImage personalRankingTabImage = ServerToolsGUI.createServerToolsRankingTabImage();
        GuiLabel personalRankingTabLabel = ServerToolsGUI.createServerToolsRankingTabLabel();
        GuiImage personalBannedListsTabImage = ServerToolsGUI.createServerToolsBannedListsTabImage();
        GuiLabel personalBannedListsTabLabel = ServerToolsGUI.createServerToolsBannedListsTabLabel();
        GuiImage personalBlacklistTabImage = ServerToolsGUI.createServerToolsBlacklistTabImage();
        GuiLabel personalBlacklistTabLabel = ServerToolsGUI.createServerToolsBlacklistTabLabel();
        GuiImage personalRestWarnTabImage = ServerToolsGUI.createServerToolsRestWarnTabImage();
        GuiLabel personalRestWarnTabLabel = ServerToolsGUI.createServerToolsRestWarnTabLabel();
        GuiImage personalSettingsTabImage = ServerToolsGUI.createServerToolsSettingsTabImage();
        GuiLabel personalSettingsTabLabel = ServerToolsGUI.createServerToolsSettingsTabLabel();
        
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
}
