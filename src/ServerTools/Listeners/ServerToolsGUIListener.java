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
        
        if (player.hasAttribute("STVoteDayYesImageLabel") 
            && player.hasAttribute("STVoteDayYesTextLabel") 
            && player.hasAttribute("STVoteDayNoImageLabel") 
            && player.hasAttribute("STVoteDayNoTextLabel")){
        
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
        
        if (player.isAdmin() || player.getPermissionGroup().equals(ServerToolsUtils.SettingbyName("PluginAdminAccessPermGroup"))){
            
            if (element == (GuiImage) player.getAttribute("STGeneralTabImage") || element == (GuiLabel) player.getAttribute("STGeneralTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.GENERAL_TAB_GUI);
            }
            else if (element == (GuiImage) player.getAttribute("STMessagesTabImage") || element == (GuiLabel) player.getAttribute("STMessagesTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.MESSAGES_TAB_GUI);
            }
            else if (element == (GuiImage) player.getAttribute("STAnnouncementsTabImage") || element == (GuiLabel) player.getAttribute("STAnnouncementsTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI);
            }
            else if (element == (GuiImage) player.getAttribute("STRankingTabImage") || element == (GuiLabel) player.getAttribute("STRankingTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.RANKING_TAB_GUI);
            }
            else if (element == (GuiImage) player.getAttribute("STBannedListsTabImage") || element == (GuiLabel) player.getAttribute("STBannedListsTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.BANNED_LISTS_TAB_GUI);
            }
            else if (element == (GuiImage) player.getAttribute("STBlacklistTabImage") || element == (GuiLabel) player.getAttribute("STBlacklistTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.BLACKLIST_TAB_GUI);
            }
            else if (element == (GuiImage) player.getAttribute("STRestWarnTabImage") || element == (GuiLabel) player.getAttribute("STRestWarnTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.REST_WARN_TAB_GUI);
            }
            else if (element == (GuiImage) player.getAttribute("STSettingsTabImage") || element == (GuiLabel) player.getAttribute("STSettingsTabLabel")){
                ServerToolsUtils.switchTab(player, (int) player.getAttribute("STPreviousTab"), ServerToolsDataBank.SETTINGS_TAB_GUI);
            }
        }
    }
}
