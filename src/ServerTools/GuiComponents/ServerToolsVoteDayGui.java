package ServerTools.GuiComponents;

import ServerTools.Utils.ServerToolsGeneralUtils;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.PivotPosition;

public class ServerToolsVoteDayGui {
    
    public static GuiPanel createVoteDayGuiPanel(){
        GuiPanel voteDayPanel = new GuiPanel(0.1f, 0.5f, true, 250f, 150f, false);
        voteDayPanel.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        voteDayPanel.setPivot(PivotPosition.Center);
        voteDayPanel.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        voteDayPanel.setBorderThickness(2, false);
        voteDayPanel.setClickable(false);
        voteDayPanel.setVisible(false);
        
        return voteDayPanel;
    }
    
    public static GuiImage createVoteDayYesGuiImage(){
        GuiImage yesImageLabel = new GuiImage(0.25f, 0.3f, true, 100f, 50f, false);
        yesImageLabel.setPivot(PivotPosition.Center);
        yesImageLabel.setColor(0.160f, 0.780f, 0.196f, 1.0f);
        yesImageLabel.setClickable(true);
        yesImageLabel.setVisible(false);
        
        return yesImageLabel;
    }
    
    public static GuiLabel createVoteDayYesGuiLabel(){
        GuiLabel yesTextLabel = new GuiLabel("YES", 0.5f, 0.5f, true);
        yesTextLabel.setPivot(PivotPosition.Center);
        yesTextLabel.setFontColor(0.0f, 0.0f, 0.0f, 1.0f);
        yesTextLabel.setClickable(true);
        yesTextLabel.setVisible(false);
        
        return yesTextLabel;
    }
    
    public static GuiImage createVoteDayNoGuiImage(){
        GuiImage noImageLabel = new GuiImage(0.75f, 0.3f, true, 100f, 50f, false);
        noImageLabel.setPivot(PivotPosition.Center);
        noImageLabel.setColor(0.780f, 0.180f, 0.160f, 1.0f);
        noImageLabel.setClickable(true);
        noImageLabel.setVisible(false);
        
        return noImageLabel;
    }
    
    public static GuiLabel createVoteDayNoGuiLabel(){
        GuiLabel noTextLabel = new GuiLabel("NO", 0.5f, 0.5f, true);
        noTextLabel.setPivot(PivotPosition.Center);
        noTextLabel.setFontColor(0.0f, 0.0f, 0.0f, 1.0f);
        noTextLabel.setClickable(true);
        noTextLabel.setVisible(false);
        
        return noTextLabel;
    }
    
    public static GuiLabel createVoteDayDescriptionGuiLabel(){
        GuiLabel descriptionLabel = new GuiLabel("Vote to switch to daytime!", 0.5f, 0.9f, true);
        descriptionLabel.setPivot(PivotPosition.Center);
        descriptionLabel.setFontSize(20);
        descriptionLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        descriptionLabel.setClickable(false);
        descriptionLabel.setVisible(false);
        
        return descriptionLabel;
    }
    
    public static GuiLabel createVoteDayTimerGuiLabel(){
        GuiLabel timerLabel = new GuiLabel(ServerToolsGeneralUtils.SettingbyName("VoteDayTimerDuration"), 0.5f, 0.7f, true);
        timerLabel.setPivot(PivotPosition.Center);
        timerLabel.setFontSize(30);
        timerLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        timerLabel.setClickable(false);
        timerLabel.setVisible(false);
        
        return timerLabel;
    }
}
