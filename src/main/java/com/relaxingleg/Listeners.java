package com.relaxingleg;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listeners extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        for(Guild guild : event.getJDA().getGuilds()) {
            for(TextChannel channel : guild.getTextChannels()) {
                channel.sendMessage("Hello").queue();
            }
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        MessageChannel channel = event.getChannel();
        channel.sendMessage(event.getMessage().getContentRaw()).queue();
    }
}
