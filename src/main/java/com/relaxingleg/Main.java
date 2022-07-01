package com.relaxingleg;

import com.relaxingleg.commands.Sum;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(Token.TOKEN).build();
        jda.addEventListener(new Listeners());
        jda.addEventListener(new Sum());
        /*
            Global - Used anywhere
            Guild - Used in certain guilds
         */
    }
}
