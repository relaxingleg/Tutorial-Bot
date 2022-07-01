package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

public class Listeners extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById(858374541976666122L);
        guild.upsertCommand("sum", "Gives the sum of two numbers").addOptions(
                new OptionData(OptionType.INTEGER, "number1", "The first number", true)
                        .setMinValue(1)
                        .setMaxValue(100),
                new OptionData(OptionType.INTEGER, "number2", "The second number", false)
                        .setMinValue(1)
                        .setMaxValue(100)
        ).queue();
    }

//    @Override
//    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
//        if(event.getAuthor().isBot()) return;
//        MessageChannel channel = event.getChannel();
//        channel.sendMessage(event.getMessage().getContentRaw()).queue();
//    }
}
