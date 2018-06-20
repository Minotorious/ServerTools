package ServerTools;

import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.PivotPosition;
import net.risingworld.api.utils.ImageInformation;

public class ServerToolsGUI {
    
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
    
    public static GuiImage createVoteDayYesGuiImageLabel(){
        GuiImage yesImageLabel = new GuiImage(0.25f, 0.3f, true, 100f, 50f, false);
        yesImageLabel.setPivot(PivotPosition.Center);
        yesImageLabel.setColor(0.160f, 0.780f, 0.196f, 1.0f);
        yesImageLabel.setClickable(true);
        yesImageLabel.setVisible(false);
        
        return yesImageLabel;
    }
    
    public static GuiLabel createVoteDayYesTextGuiLabel(){
        GuiLabel yesTextLabel = new GuiLabel("YES", 0.5f, 0.5f, true);
        yesTextLabel.setPivot(PivotPosition.Center);
        yesTextLabel.setFontColor(0.0f, 0.0f, 0.0f, 1.0f);
        yesTextLabel.setClickable(true);
        yesTextLabel.setVisible(false);
        
        return yesTextLabel;
    }
    
    public static GuiImage createVoteDayNoGuiImageLabel(){
        GuiImage noImageLabel = new GuiImage(0.75f, 0.3f, true, 100f, 50f, false);
        noImageLabel.setPivot(PivotPosition.Center);
        noImageLabel.setColor(0.780f, 0.180f, 0.160f, 1.0f);
        noImageLabel.setClickable(true);
        noImageLabel.setVisible(false);
        
        return noImageLabel;
    }
    
    public static GuiLabel createVoteDayNoTextGuiLabel(){
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
        GuiLabel timerLabel = new GuiLabel(ServerToolsUtils.SettingbyName("VoteDayTimerDuration"), 0.5f, 0.7f, true);
        timerLabel.setPivot(PivotPosition.Center);
        timerLabel.setFontSize(30);
        timerLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        timerLabel.setClickable(false);
        timerLabel.setVisible(false);
        
        return timerLabel;
    }
    
    public static GuiPanel createServerToolsMainPanel(){
        GuiPanel mainPanel = new GuiPanel(0.5f, 0.5f, true, 1200f, 1000f, false);
        mainPanel.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        mainPanel.setPivot(PivotPosition.Center);
        mainPanel.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        mainPanel.setBorderThickness(2, false);
        mainPanel.setVisible(false);
        
        return mainPanel;
    }
    
    public static GuiLabel createServerToolsHeaderLabel(){
        GuiLabel headerLabel = new GuiLabel(" ServerTools Version 2.0.0 by Minotorious", 0.0f, 1.0f, true);
        headerLabel.setPivot(PivotPosition.TopLeft);
        headerLabel.setFontSize(20);
        headerLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        headerLabel.setColor(0.0f, 0.0f, 0.0f, 0.0f);
        headerLabel.setVisible(false);
        
        return headerLabel;
    }
    
    public static GuiImage createServerToolsGeneralTabImage(){
        GuiImage generalTabImage = new GuiImage(0f, 980f, false, 152f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsGeneralTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("General", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
    
    public static GuiImage createServerToolsMessagesTabImage(){
        GuiImage generalTabImage = new GuiImage(150f, 980f, false, 152f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsMessagesTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("Preset\nMessages", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
    
    public static GuiImage createServerToolsAnnouncementsTabImage(){
        GuiImage generalTabImage = new GuiImage(300f, 980f, false, 152f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsAnnouncementsTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("Automated\nAnnouncements", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
    
    public static GuiImage createServerToolsRankingTabImage(){
        GuiImage generalTabImage = new GuiImage(450f, 980f, false, 152f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsRankingTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("Ranking\nSystem", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
    
    public static GuiImage createServerToolsBannedListsTabImage(){
        GuiImage generalTabImage = new GuiImage(600f, 980f, false, 152f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsBannedListsTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("Banned\nWords / Items", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
    
    public static GuiImage createServerToolsBlacklistTabImage(){
        GuiImage generalTabImage = new GuiImage(750f, 980f, false, 152f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsBlacklistTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("Blacklist", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
    
    public static GuiImage createServerToolsRestWarnTabImage(){
        GuiImage generalTabImage = new GuiImage(900f, 980f, false, 152f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsRestWarnTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("Restart\nWarnings", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
    
    public static GuiImage createServerToolsSettingsTabImage(){
        GuiImage generalTabImage = new GuiImage(1050f, 980f, false, 150f, 50f, false);
        generalTabImage.setPivot(PivotPosition.TopLeft);
        generalTabImage.setBorderColor(0.0f, 0.6f, 0.933f, 1.0f);
        generalTabImage.setBorderThickness(2, false);
        generalTabImage.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabImage.setClickable(true);
        generalTabImage.setVisible(false);
        
        return generalTabImage;
    }
    
    public static GuiLabel createServerToolsSettingsTabLabel(){
        GuiLabel generalTabLabel = new GuiLabel("Settings", 0.5f, 0.5f, true);
        generalTabLabel.setPivot(PivotPosition.Center);
        generalTabLabel.setFontSize(20);
        generalTabLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabLabel.setClickable(true);
        generalTabLabel.setVisible(false);
        
        return generalTabLabel;
    }
}
