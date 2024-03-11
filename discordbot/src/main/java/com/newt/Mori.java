package com.newt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import com.newt.commands.AddCommand;
import com.newt.commands.SortCommand;
import com.newt.config.Constructor;

import ca.tristan.easycommands.commands.EasyCommands;
import ca.tristan.easycommands.commands.HelpCmd;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;


public class Mori {
    
    public static JDA api = Constructor.getJDA();
    

    public static void main(String args[]) throws InterruptedException, IOException, URISyntaxException {
    
        api.getPresence().setActivity(Activity.playing("Sorteando Bagres"));

        EasyCommands easy = new EasyCommands(api, false);
        easy.addExecutor(new HelpCmd(), new SortCommand(), new AddCommand());
        easy.updateCommands();
        api.addEventListener(easy);
        easy.logCurrentExecutors();
    
    }

    
}
