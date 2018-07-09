package ServerTools.GuiComponents;

import net.risingworld.api.gui.GuiPanel;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.PivotPosition;

public class ServerToolsGeneralTabGui {
    
    public static GuiPanel createServerToolsGeneralTabPanel(){
        GuiPanel generalTabPanel = new GuiPanel(2f, 930f, false, 1196f, 928f, false);
        generalTabPanel.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        generalTabPanel.setPivot(PivotPosition.TopLeft);
        generalTabPanel.setVisible(false);
        
        return generalTabPanel;
    }
    
    public static GuiLabel createGeneralTabPlayerLabel(){
        GuiLabel generalTabPlayerLabel = new GuiLabel("Player: ", 0.05f, 0.95f, true);
        generalTabPlayerLabel.setPivot(PivotPosition.TopLeft);
        generalTabPlayerLabel.setFontSize(20);
        generalTabPlayerLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabPlayerLabel.setVisible(false);
        
        return generalTabPlayerLabel;
    }
    
    public static GuiLabel createGeneralTabPlayerNameLabel(){
        GuiLabel generalTabPlayerNameLabel = new GuiLabel("Minotorious", 1.0f, 1.0f, true);
        generalTabPlayerNameLabel.setPivot(PivotPosition.TopLeft);
        generalTabPlayerNameLabel.setFontSize(20);
        generalTabPlayerNameLabel.setFontColor(1.0f, 0.533f, 0.0f, 1.0f);
        generalTabPlayerNameLabel.setClickable(true);
        generalTabPlayerNameLabel.setVisible(false);
        
        return generalTabPlayerNameLabel;
    }
    
}
