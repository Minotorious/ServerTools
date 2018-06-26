package ServerTools.GuiComponents;

import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.PivotPosition;

public class ServerToolsMainPanelGui {
    
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
        generalTabLabel.setFontColor(0.765f, 0.808f, 0.110f, 1.0f);
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
