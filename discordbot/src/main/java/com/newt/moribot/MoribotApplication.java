package com.newt.moribot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import com.newt.bot.config.*;
import com.newt.bot.commands.*;

import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.utils.ConfigFile;
import ca.tristan.easycommands.utils.LocalStorage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;




public class MoribotApplication {


	private static EasyCommands easy;
	

	public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
			easy = new EasyCommands();
			JDA api = Constructor.getJDA();
			api.getPresence().setActivity(Activity.playing("Sorteando Bagres"));
			easy.clearExecutors();
        easy.addExecutor(new MapPick(),
			new PickCaptains(), 
			new HelpCommand(easy), 
			new SortCommand(), 
			new AddCommand()
		);
			easy.buildJDA().awaitReady();
			easy.loadGuildProperties();
	}
}