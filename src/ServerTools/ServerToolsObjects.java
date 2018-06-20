package ServerTools;

import net.risingworld.api.gui.GuiLabel;
import net.risingworld.api.gui.GuiImage;

public class ServerToolsObjects {
    
    public class rank{
        public String name;
        public int reqtime;
        public String message;
    }
    
    public class message{
        public int number;
        public String name;
        public String text;
        public String colourcode;
    }
    
    public class announcement{
        public String type;
        public String name;
        public String text;
        public String colourcode;
        public float recur;
    }
    
    public class blacklistplayer{
        public String name;
        public String offence;
    }
    
    public class autoGM1listplayer{
        public String playerName;
        public long playerUserID;
    }
    
    public class restartWarning{
        public String time;
        public int minuteWarningA;
        public int minuteWarningB;
        public int minuteWarningC;
        public int minuteWarningD;
        public int minuteWarningE;
        public int minuteWarningF;
        public int minuteWarningG;
        public int minuteWarningH;
        public int minuteWarningI;
        public int minuteWarningJ;
        public int secondWarningA;
        public int secondWarningB;
        public int secondWarningC;
        public int secondWarningD;
        public int secondWarningE;
        public int secondWarningF;
        public int secondWarningG;
        public int secondWarningH;
        public int secondWarningI;
        public int secondWarningJ;
    }
}
