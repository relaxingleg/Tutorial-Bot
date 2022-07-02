package com.relaxingleg;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listeners extends ListenerAdapter {

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if(event.getButton().getId().equals("yes-button")) {
            event.reply("Nice, so do I").queue();
        } else if(event.getButton().getId().equals("no-button")) {
            event.reply("What! you monster").queue();
        }
        event.getMessage().delete().queue();
    }
}
