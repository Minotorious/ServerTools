package ServerTools.Listeners;

import ServerTools.ServerToolsMain;
import ServerTools.ServerToolsDataBank;
import ServerTools.Utils.ServerToolsGeneralUtils;
import ServerTools.Utils.ServerToolsShowHideGui;
import ServerTools.Utils.ServerToolsAttributeCheck;
import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.Listener;
import net.risingworld.api.events.player.gui.PlayerGuiElementClickEvent;
import net.risingworld.api.events.player.gui.PlayerGuiInputEvent;
import net.risingworld.api.gui.GuiElement;
import net.risingworld.api.gui.GuiImage;
import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.objects.Player;

public class ServerToolsGUIListener implements Listener {
    
    ServerToolsMain STM = new ServerToolsMain();
    
    @EventMethod
    public void onGuiElementClick(PlayerGuiElementClickEvent event){
        Player player = event.getPlayer();
        GuiElement element = event.getGuiElement();
        
        player.sendTextMessage(element.toString());
        
        if (ServerToolsAttributeCheck.checkVoteDayAttributes(player)){
        
            if (element == (GuiImage) player.getAttribute("STVoteDayYesImage") || element == (GuiLabel) player.getAttribute("STVoteDayYesLabel")){
                ServerToolsDataBank.yesVotes += 1;
                ServerToolsShowHideGui.showHideVoteDayGui(player, false);
                player.setMouseCursorVisible(false);
            }
            else if(element == (GuiImage) player.getAttribute("STVoteDayNoImage") || element == (GuiLabel) player.getAttribute("STVoteDayNoLabel")){
                ServerToolsDataBank.noVotes += 1;
                ServerToolsShowHideGui.showHideVoteDayGui(player, false);
                player.setMouseCursorVisible(false);
            }
        }
        
        if (player.isAdmin() || player.getPermissionGroup().equals(ServerToolsGeneralUtils.SettingbyName("PluginAdminAccessPermGroup"))){
            
            if (player.hasAttribute("STSettingsTabPoliceBotModeToggleLabel")){
                if (element == (GuiLabel) player.getAttribute("STSettingsTabPoliceBotModeToggleLabel")){
                    GuiLabel personalPoliceBotModeToggleLabel = (GuiLabel) player.getAttribute("STSettingsTabPoliceBotModeToggleLabel");
                    
                    if (personalPoliceBotModeToggleLabel.getText().equals("On")){
                        personalPoliceBotModeToggleLabel.setText("Off");
                    }
                    else if (personalPoliceBotModeToggleLabel.getText().equals("Off")){
                        personalPoliceBotModeToggleLabel.setText("On");
                    }
                }
            }
            
            if (player.hasAttribute("STCloseLabel")){
                if (element == (GuiLabel) player.getAttribute("STCloseLabel")){
                    ServerToolsGeneralUtils.closeGui(player, (int) player.getAttribute("STCurrentTab"));
                }
            }
            
            if (ServerToolsAttributeCheck.checkMainPanelAttributes(player)){
                
                if (element == (GuiImage) player.getAttribute("STGeneralTabImage") || element == (GuiLabel) player.getAttribute("STGeneralTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.GENERAL_TAB_GUI);
                }
                else if (element == (GuiImage) player.getAttribute("STMessagesTabImage") || element == (GuiLabel) player.getAttribute("STMessagesTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.MESSAGES_TAB_GUI);
                }
                else if (element == (GuiImage) player.getAttribute("STAnnouncementsTabImage") || element == (GuiLabel) player.getAttribute("STAnnouncementsTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.ANNOUNCEMENTS_TAB_GUI);
                }
                else if (element == (GuiImage) player.getAttribute("STRankingTabImage") || element == (GuiLabel) player.getAttribute("STRankingTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.RANKING_TAB_GUI);
                }
                else if (element == (GuiImage) player.getAttribute("STBannedListsTabImage") || element == (GuiLabel) player.getAttribute("STBannedListsTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.BANNED_LISTS_TAB_GUI);
                }
                else if (element == (GuiImage) player.getAttribute("STBlacklistTabImage") || element == (GuiLabel) player.getAttribute("STBlacklistTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.BLACKLIST_TAB_GUI);
                }
                else if (element == (GuiImage) player.getAttribute("STRestWarnTabImage") || element == (GuiLabel) player.getAttribute("STRestWarnTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.REST_WARN_TAB_GUI);
                }
                else if (element == (GuiImage) player.getAttribute("STSettingsTabImage") || element == (GuiLabel) player.getAttribute("STSettingsTabLabel")){
                    ServerToolsGeneralUtils.switchTab(player, (int) player.getAttribute("STCurrentTab"), ServerToolsDataBank.SETTINGS_TAB_GUI);
                }
            }
        }
    }
    
    @EventMethod
    public void onGuiInput(PlayerGuiInputEvent event){
        Player player = event.getPlayer();
        GuiElement element = event.getGuiElement();
        
        player.sendTextMessage(element.toString() + ": " + event.getInput());
    }
}
