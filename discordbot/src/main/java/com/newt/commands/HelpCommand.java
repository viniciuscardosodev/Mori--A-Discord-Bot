package com.newt.commands;

import java.awt.Color;

import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.commands.EventData;
import ca.tristan.easycommands.commands.defaults.HelpCmd;
import ca.tristan.easycommands.commands.prefix.PrefixExecutor;
import ca.tristan.easycommands.commands.slash.SlashExecutor;
import ca.tristan.easycommands.database.MySQL;
import net.dv8tion.jda.api.EmbedBuilder;

public class HelpCommand extends HelpCmd{

    private final EasyCommands easyCommands;

    public HelpCommand(EasyCommands easyCommands) {
      super(easyCommands);
      this.easyCommands = easyCommands;  
    }

    @Override
    public void execute(EventData data, MySQL mySQL) {
      
      EmbedBuilder builder = new EmbedBuilder();
      builder.setTitle("Ajuda - " + data.getGuild().getName());
      builder.setColor(Color.GREEN);
      builder.addField("Slash Commands", "--------------------", false);

      this.easyCommands.getExecutors().forEach((name, commandExecutor) -> {
         if (commandExecutor instanceof SlashExecutor && !commandExecutor.isOwnerOnly() && !commandExecutor.getName().equals("help") && (commandExecutor.getDescription() != null || !commandExecutor.getDescription().isEmpty()) && !commandExecutor.getAliases().contains(name)) {
            builder.addField("/" + name, commandExecutor.getDescription(), false);
         }

      });
      if (EasyCommands.getConfig().getUsePrefixCommands()) {
         builder.addField("Prefixo dos Comandos", "--------------------", false);
         this.easyCommands.getExecutors().forEach((name, commandExecutor) -> {
            if (commandExecutor instanceof PrefixExecutor && !commandExecutor.isOwnerOnly() && !commandExecutor.getName().equals("help") && (commandExecutor.getDescription() != null || !commandExecutor.getDescription().isEmpty()) && !commandExecutor.getAliases().contains(name)) {
               builder.addField(this.easyCommands.getPrefixCommands().getPrefix() + name, commandExecutor.getDescription(), false);
            }

         });
      }

      if (builder.getFields().isEmpty()) {
         builder.setDescription("Não há nenhum comando para ser mostrado para este servidor");
      } else {
         builder.setDescription("Este servidor não está apto a executar nenhum comando.");
      }

      builder.setFooter("Bot desenvolvido por: newt.dev", "https://avatars.githubusercontent.com/u/135279307?v=4");
      data.reply(builder.build(), true).queue();

    }

}
