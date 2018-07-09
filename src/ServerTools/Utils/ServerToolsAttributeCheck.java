package ServerTools.Utils;

import net.risingworld.api.objects.Player;

public class ServerToolsAttributeCheck {
    
    public static boolean checkVoteDayAttributes(Player player){
        return player.hasAttribute("STVoteDayYesImage")
            && player.hasAttribute("STVoteDayYesLabel")
            && player.hasAttribute("STVoteDayNoImage")
            && player.hasAttribute("STVoteDayNoLabel");
    }
    
    public static boolean checkMainPanelAttributes(Player player){
        return player.hasAttribute("STGeneralTabImage") 
            && player.hasAttribute("STGeneralTabLabel") 
            && player.hasAttribute("STMessagesTabImage") 
            && player.hasAttribute("STMessagesTabLabel")
            && player.hasAttribute("STAnnouncementsTabImage") 
            && player.hasAttribute("STAnnouncementsTabLabel")
            && player.hasAttribute("STRankingTabImage") 
            && player.hasAttribute("STRankingTabLabel")
            && player.hasAttribute("STBannedListsTabImage") 
            && player.hasAttribute("STBannedListsTabLabel")
            && player.hasAttribute("STBlacklistTabImage")
            && player.hasAttribute("STBlacklistTabLabel")
            && player.hasAttribute("STRestWarnTabImage")
            && player.hasAttribute("STRestWarnTabLabel")
            && player.hasAttribute("STSettingsTabImage")
            && player.hasAttribute("STSettingsTabLabel")
            && player.hasAttribute("STCurrentTab");
    }
    
}
