package ServerTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.risingworld.api.database.Database;
import java.util.ArrayList;

public class ServerToolsDataBase {
    
    ServerToolsMain STM = new ServerToolsMain();
    ServerToolsObjects STO = new ServerToolsObjects();
    
    public static Database mainSTDB;
    
    public void setmainSTDB(Database db){
        mainSTDB = db;
    }
    
    public void initmainSTDB(){
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'AutoGM1List' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'PlayerName' VARCHAR(64), "
                + "'PlayerUserID' LONG"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'Announcements' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'Type' VARCHAR(64), "
                + "'Name' VARCHAR(64), "
                + "'Colourcode' VARCHAR(64), "
                + "'Text' VARCHAR(256), "
                + "'Recur' FLOAT"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'Messages' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'Name' VARCHAR(64), "
                + "'Colourcode' VARCHAR(64), "
                + "'Text' VARCHAR(256)"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'Ranklist' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'RankName' VARCHAR(64), "
                + "'Time' INTEGER, "
                + "'Message' VARCHAR(256)"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'RestartWarnings' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'Time' VARCHAR(64), "
                + "'MinuteWarningA' INTEGER, "
                + "'MinuteWarningB' INTEGER, "
                + "'MinuteWarningC' INTEGER, "
                + "'MinuteWarningD' INTEGER, "
                + "'MinuteWarningE' INTEGER, "
                + "'MinuteWarningF' INTEGER, "
                + "'MinuteWarningG' INTEGER, "
                + "'MinuteWarningH' INTEGER, "
                + "'MinuteWarningI' INTEGER, "
                + "'MinuteWarningJ' INTEGER, "
                + "'SecondWarningA' INTEGER, "
                + "'SecondWarningB' INTEGER, "
                + "'SecondWarningC' INTEGER, "
                + "'SecondWarningD' INTEGER, "
                + "'SecondWarningE' INTEGER, "
                + "'SecondWarningF' INTEGER, "
                + "'SecondWarningG' INTEGER, "
                + "'SecondWarningH' INTEGER, "
                + "'SecondWarningI' INTEGER, "
                + "'SecondWarningJ' INTEGER"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'BannedItems' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'ItemName' VARCHAR(64)"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'BannedWords' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'Word' VARCHAR(64)"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'Blacklist' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'PlayerName' VARCHAR(64), "
                + "'PlayerUserID' LONG, "
                + "'Offence' VARCHAR(256)"
                + ")");
        
        mainSTDB.execute("CREATE TABLE IF NOT EXISTS 'Settings' ("
                + "'idNo' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'SettingName' VARCHAR(64) UNIQUE ,"
                + "'SettingValue' VARCHAR(64)"
                + ")");
    }
    
    public void initSettingsTable(){
        Connection con = mainSTDB.getConnection();
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "AutoMessageBotName");
                prep.setString(2, "MinoBot");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "PoliceBotMode");
                prep.setString(2, "on");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "PoliceBotName");
                prep.setString(2, "MinoCop");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "PoliceBotChatColour");
                prep.setString(2, "[#1B00CC]");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RankingBotMode");
                prep.setString(2, "on");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RankingBotName");
                prep.setString(2, "MinoRank");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RankingBotChatColour");
                prep.setString(2, "[#00FF00]");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RankcheckTimer");
                prep.setString(2, "300");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RankingStartPermGroup");
                prep.setString(2, "Player");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "Autogm1Mode");
                prep.setString(2, "on");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "Autogm1DeniedPermGroup");
                prep.setString(2, "Visitor");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "NewPlayerPermGroup");
                prep.setString(2, "Visitor");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RestartWarningsMode");
                prep.setString(2, "on");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RestartWarningsBotName");
                prep.setString(2, "MinoWarning");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RestartWarningsChatColour");
                prep.setString(2, "[#EA4343]");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "RestartWarningsCheckInterval");
                prep.setString(2, "2");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "VoteDayCommand");
                prep.setString(2, "on");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "VoteDayTimerDuration");
                prep.setString(2, "60");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "VoteDayTimerCoolDown");
                prep.setString(2, "300");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "VoteDayPercentageQuota");
                prep.setString(2, "50");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "PluginAdminAccessPermGroup");
                prep.setString(2, "Admin");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO Settings (SettingName,SettingValue) VALUES (?,?)");
                prep.setString(1, "GeneralPluginTextColour");
                prep.setString(2, "[#00eeee]");
                
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
    }
    
    public void setInAutoGM1List(Long playerUserID, String playerName){
        Connection con = mainSTDB.getConnection();
        
        try{
            PreparedStatement prep = con.prepareStatement("INSERT INTO AutoGM1List (PlayerUserID,PlayerName) VALUES (?,?)");
                prep.setLong(1, playerUserID);
                prep.setString(2, playerName);
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
    }
    
    public void delFromAutoGM1List(Long playerUserID){
        Connection con = mainSTDB.getConnection();
        try{
            PreparedStatement prep = con.prepareStatement("DELETE FROM AutoGM1List WHERE playerUserID LIKE ?");
                
                prep.setLong(1, playerUserID); 
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
    }
    
    public void changePlayerNameInAutoGM1List(Long playerUserID, String playerName){
        Connection con = mainSTDB.getConnection();
        try{
            PreparedStatement prep = con.prepareStatement("UPDATE AutoGM1List SET PlayerName = ? WHERE PlayerUserID = ?");
                prep.setString(1, playerName);
                prep.setLong(2, playerUserID);
                prep.executeUpdate();
        }
        catch(SQLException e){
        }
    }
    
    public ArrayList<ServerToolsObjects.autoGM1listplayer> getAutoGM1List(){
        Connection con = mainSTDB.getConnection();
        
        ArrayList<ServerToolsObjects.autoGM1listplayer> autoGM1List = new ArrayList<>();
        
        try{
            PreparedStatement prep = con.prepareStatement("SELECT * FROM AutoGM1List");
            ResultSet result = prep.executeQuery();
            while (result.next()){
                ServerToolsObjects.autoGM1listplayer A = STO.new autoGM1listplayer();
                A.playerUserID = result.getLong("PlayerUserID");
                A.playerName = result.getString("PlayerName");
                
                autoGM1List.add(A);
            }
        }
        catch(SQLException e){
        }
        
        return autoGM1List;
    }
}
