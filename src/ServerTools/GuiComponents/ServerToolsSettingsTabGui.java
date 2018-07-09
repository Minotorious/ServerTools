package ServerTools.GuiComponents;

import ServerTools.Utils.ServerToolsGeneralUtils;
import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.GuiTextField;
import net.risingworld.api.gui.PivotPosition;

public class ServerToolsSettingsTabGui {
    
    public static GuiPanel createServerToolsSettingsTabPanel(){
        GuiPanel settingsTabPanel = new GuiPanel(2f, 930f, false, 1196f, 928f, false);
        settingsTabPanel.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        settingsTabPanel.setPivot(PivotPosition.TopLeft);
        settingsTabPanel.setVisible(false);
        
        return settingsTabPanel;
    }
    
    public static GuiLabel createSettingsTabSaveLabel(){
        GuiLabel saveLabel = new GuiLabel("Save\nSettings", 0.5f, 0.5f, true);
        saveLabel.setPivot(PivotPosition.Center);
        saveLabel.setFontSize(20);
        saveLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        saveLabel.setClickable(true);
        saveLabel.setVisible(false);
        
        return saveLabel;
    }
    
    public static GuiImage createSettingsTabSaveImage(){
        GuiImage saveImage = new GuiImage(0.5f, 0.05f, true, 152f, 50f, false);
        saveImage.setPivot(PivotPosition.Center);
        saveImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        saveImage.setBorderThickness(2, false);
        saveImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        saveImage.setClickable(true);
        saveImage.setVisible(false);
        
        return saveImage;
    }
    
    public static GuiLabel createSettingsTabAutoMessageBotNameLabel(){
        GuiLabel autoMessageBotNameLabel = new GuiLabel("AutoMessageBotName:", 0.05f, 0.95f, true);
        autoMessageBotNameLabel.setPivot(PivotPosition.TopLeft);
        autoMessageBotNameLabel.setFontSize(20);
        autoMessageBotNameLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        autoMessageBotNameLabel.setVisible(false);
        autoMessageBotNameLabel.setClickable(true);
        
        return autoMessageBotNameLabel;
    }
    
    public static GuiTextField createSettingsTabAutoMessageBotNameTextField(){
        GuiTextField autoMessageBotNameTextField = new GuiTextField(0.30f, 0.95f, true, 200f, 30f, false);
        autoMessageBotNameTextField.setPivot(PivotPosition.TopLeft);
        autoMessageBotNameTextField.setMaxCharacters(64);
        autoMessageBotNameTextField.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        autoMessageBotNameTextField.setBackgroundPreset(1);
        autoMessageBotNameTextField.setText(ServerToolsGeneralUtils.SettingbyName("AutoMessageBotName"));
        autoMessageBotNameTextField.setVisible(false);
        
        return autoMessageBotNameTextField;
    }
    
    public static GuiLabel createSettingsTabPoliceBotModeLabel(){
        GuiLabel policeBotModeLabel = new GuiLabel("PoliceBotMode:", 0.05f, 0.90f, true);
        policeBotModeLabel.setPivot(PivotPosition.TopLeft);
        policeBotModeLabel.setFontSize(20);
        policeBotModeLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        policeBotModeLabel.setVisible(false);
        
        return policeBotModeLabel;
    }
    
    public static GuiLabel createSettingsTabPoliceBotModeToggleLabel(){
        GuiLabel policeBotModeToggleLabel = new GuiLabel(ServerToolsGeneralUtils.SettingbyName("PoliceBotMode"), 0.305f, 0.90f, true);
        policeBotModeToggleLabel.setPivot(PivotPosition.TopLeft);
        policeBotModeToggleLabel.setFontSize(20);
        policeBotModeToggleLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        policeBotModeToggleLabel.setClickable(true);
        policeBotModeToggleLabel.setVisible(false);
        
        return policeBotModeToggleLabel;
    }
    
    public static GuiLabel createSettingsTabPoliceBotNameLabel(){
        GuiLabel policeBotNameLabel = new GuiLabel("PoliceBotName:", 0.05f, 0.85f, true);
        policeBotNameLabel.setPivot(PivotPosition.TopLeft);
        policeBotNameLabel.setFontSize(20);
        policeBotNameLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        policeBotNameLabel.setVisible(false);
        
        return policeBotNameLabel;
    }
    
    public static GuiTextField createSettingsTabPoliceBotNameTextField(){
        GuiTextField policeBotNameTextField = new GuiTextField(0.30f, 0.85f, true, 200f, 30f, false);
        policeBotNameTextField.setPivot(PivotPosition.TopLeft);
        policeBotNameTextField.setMaxCharacters(64);
        policeBotNameTextField.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        policeBotNameTextField.setBackgroundPreset(1);
        policeBotNameTextField.setText(ServerToolsGeneralUtils.SettingbyName("PoliceBotName"));
        policeBotNameTextField.setVisible(false);
        
        return policeBotNameTextField;
    }
    
    public static GuiLabel createSettingsTabPoliceBotChatColourLabel(){
        GuiLabel policeBotChatColourLabel = new GuiLabel("PoliceBotChatColour:", 0.05f, 0.80f, true);
        policeBotChatColourLabel.setPivot(PivotPosition.TopLeft);
        policeBotChatColourLabel.setFontSize(20);
        policeBotChatColourLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        policeBotChatColourLabel.setVisible(false);
        
        return policeBotChatColourLabel;
    }
    
    public static GuiTextField createSettingsTabPoliceBotChatColourTextField(){
        GuiTextField policeBotChatColourTextField = new GuiTextField(0.30f, 0.80f, true, 200f, 30f, false);
        policeBotChatColourTextField.setPivot(PivotPosition.TopLeft);
        policeBotChatColourTextField.setMaxCharacters(64);
        policeBotChatColourTextField.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        policeBotChatColourTextField.setBackgroundPreset(1);
        policeBotChatColourTextField.setText(ServerToolsGeneralUtils.SettingbyName("PoliceBotChatColour"));
        policeBotChatColourTextField.setListenForInput(true);
        policeBotChatColourTextField.setVisible(false);
        
        return policeBotChatColourTextField;
    }
    
    public static GuiLabel createSettingsTabRankingBotNameLabel(){
        GuiLabel rankingBotNameLabel = new GuiLabel("RankingBotName:", 0.05f, 0.10f, true);
        rankingBotNameLabel.setPivot(PivotPosition.TopLeft);
        rankingBotNameLabel.setFontSize(20);
        rankingBotNameLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        rankingBotNameLabel.setVisible(false);
        
        return rankingBotNameLabel;
    }
    
    public static GuiTextField createSettingsTabRankingBotNameTextField(){
        GuiTextField rankingBotNameTextField = new GuiTextField(0.30f, 0.10f, true, 200f, 30f, false);
        rankingBotNameTextField.setPivot(PivotPosition.TopLeft);
        rankingBotNameTextField.setMaxCharacters(64);
        rankingBotNameTextField.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        rankingBotNameTextField.setBackgroundPreset(1);
        rankingBotNameTextField.setText(ServerToolsGeneralUtils.SettingbyName("RankingBotName"));
        rankingBotNameTextField.setVisible(false);
        
        return rankingBotNameTextField;
    }
    
    public static GuiLabel createSettingsTabRestWarnBotNameLabel(){
        GuiLabel restWarnBotNameLabel = new GuiLabel("RestartWarningsBotName:", 0.05f, 0.10f, true);
        restWarnBotNameLabel.setPivot(PivotPosition.TopLeft);
        restWarnBotNameLabel.setFontSize(20);
        restWarnBotNameLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        restWarnBotNameLabel.setVisible(false);
        
        return restWarnBotNameLabel;
    }
    
    public static GuiTextField createSettingsTabRestWarnBotNameTextField(){
        GuiTextField restWarnBotNameTextField = new GuiTextField(0.30f, 0.10f, true, 200f, 30f, false);
        restWarnBotNameTextField.setPivot(PivotPosition.TopLeft);
        restWarnBotNameTextField.setMaxCharacters(64);
        restWarnBotNameTextField.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        restWarnBotNameTextField.setBackgroundPreset(1);
        restWarnBotNameTextField.setText(ServerToolsGeneralUtils.SettingbyName("RestartWarningsBotName"));
        restWarnBotNameTextField.setVisible(false);
        
        return restWarnBotNameTextField;
    }
}
