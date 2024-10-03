package me.kenji;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DiscordBot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDA bot = JDABuilder.createDefault("MTIzOTU1ODQ0MzAwMjQ5NTA2MA.GH37hr.ovEMgct8HdGgU9icyu8794EGjsJKaXd-jsSJdA")
                .setActivity(Activity.listening("yappin"))
                .addEventListeners(new DiscordBot())
                .build();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        System.out.println("A msg rec");
    }
}