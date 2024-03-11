package com.newt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import com.newt.commands.AddCommand;
import com.newt.commands.SortCommand;

import ca.tristan.easycommands.commands.EasyCommands;
import ca.tristan.easycommands.commands.HelpCmd;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Mori {
    
    public static final GatewayIntent[] gatewayIntents = {
        GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
        GatewayIntent.GUILD_VOICE_STATES,
        GatewayIntent.DIRECT_MESSAGES,
        GatewayIntent.GUILD_MEMBERS,
        GatewayIntent.GUILD_MESSAGES,
        GatewayIntent.GUILD_PRESENCES,
        GatewayIntent.MESSAGE_CONTENT,
        GatewayIntent.GUILD_PRESENCES
     };
    


    public static void main(String args[]) throws InterruptedException, IOException, URISyntaxException {
        Mori mori = new Mori();

        JDABuilder builder = JDABuilder.create("MTEwNjI0ODgxODc5MTU1NTIwMw.GUJZoG.25uMr0w2UJYQL2BbzVopUPwNSD88HRvPHjz9vw", Arrays.asList(gatewayIntents));
        JDA jda = builder.build().awaitReady();
        jda.getPresence().setActivity(Activity.playing("Sorteando Bagres"));

        System.out.println(jda.getInviteUrl(Permission.ADMINISTRATOR));
        EasyCommands easy = new EasyCommands(jda, false);
        easy.addExecutor(new HelpCmd(), new SortCommand(), new AddCommand());
        easy.updateCommands();
        jda.addEventListener(easy);
        easy.logCurrentExecutors();
    
    }

    
}
