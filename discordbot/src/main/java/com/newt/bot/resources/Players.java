package com.newt.bot.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.tristan.easycommands.commands.EventData;
import kotlin.collections.builders.ListBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

public abstract class Players {
    private static Map<String, String> usersIcons = new HashMap<String, String>();
    private static ArrayList<String> keyValues = new ArrayList<String>();

    public static void build(EventData data){
        List<Member> tempMemberList = data.getMemberVoiceState().getChannel().getMembers();
        List<User> tempUserList = new ListBuilder<User>();

        for (Member m : tempMemberList)
            tempUserList.add(m.getUser());

        for (User user : tempUserList) {
            String participant = "nullUser";
            if (user.getGlobalName() != null) {
                participant = user.getGlobalName();
            } else {
                participant = user.getEffectiveName();
            }
            usersIcons.put(participant, user.getAvatarUrl());
            addIfNotIn(participant, user.getAvatarUrl());
        }
    }

    public static int playerQuantity(){
        return keyValues.size();
    }

    public static String getPlayer(int index){
        return keyValues.get(index);
    }

    public static void addPlayer(EventData data){
        String participante = data.getCommand().getOptions().get(0).getAsString();
        addIfNotIn(participante, null);
    }

    public static void removePlayer(String keyValue){
        for (int i = 0; i < keyValues.size(); i++){
            if (keyValues.get(i).equalsIgnoreCase(keyValue)){
                keyValues.remove(i);
                usersIcons.remove(keyValue);
            }
        }
    }

    public static String getUserIconURL(String user){
        return usersIcons.get(user);
    }

    public static List<String> getPlayers(){
        return keyValues;
    }

    private static void addIfNotIn(String value, String iconURL){
        boolean add = true;
        for (String s : keyValues) {
            if (s.equalsIgnoreCase(value))
                add = false;
        }
        if (add)
            keyValues.add(value);
            usersIcons.put(value, iconURL);    
    }

    public static void close(){
        keyValues.clear();
        usersIcons.clear();
    }

}
