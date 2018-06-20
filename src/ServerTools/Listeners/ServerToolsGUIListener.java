package ServerTools.Listeners;

import ServerTools.ServerToolsDataBank;
import ServerTools.ServerToolsUtils;
import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.Listener;
import net.risingworld.api.events.player.gui.PlayerGuiElementClickEvent;
import net.risingworld.api.gui.GuiElement;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.objects.Player;

public class ServerToolsGUIListener implements Listener {
    
    @EventMethod
    public void onGuiElementClick(PlayerGuiElementClickEvent event){
        Player player = event.getPlayer();
        GuiElement element = event.getGuiElement();
        
        if (element == (GuiImage) player.getAttribute("STVoteDayYesImageLabel") || element == (GuiLabel) player.getAttribute("STVoteDayYesTextLabel")){
            ServerToolsDataBank.yesVotes += 1;
            ServerToolsUtils.showHideVoteDayGui(player, false);
            player.setMouseCursorVisible(false);
        }
        else if(element == (GuiImage) player.getAttribute("STVoteDayNoImageLabel") || element == (GuiLabel) player.getAttribute("STVoteDayNoTextLabel")){
            ServerToolsDataBank.noVotes += 1;
            ServerToolsUtils.showHideVoteDayGui(player, false);
            player.setMouseCursorVisible(false);
        }
    }
}
