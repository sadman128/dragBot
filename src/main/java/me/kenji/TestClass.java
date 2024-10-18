package me.kenji;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class TestClass extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
            if (event.getName().equals("kall")) {
               OptionMapping option = event.getOption("user");

               if (option == null) {
                   event.deferReply().queue();
                   event.getHook().sendMessage("You must mention a user").queue();
               }
               else {
                   if(option.getAsMember().getVoiceState().inAudioChannel()){

                       if(event.getMember().getRoles().getLast().getId().equals("1260907837358477344")) { // create a role for accessibility
                           AudioChannel audioChannel = option.getAsMember().getVoiceState().getChannel();
                           AudioChannel channel = event.getGuild().getAfkChannel();
                           Member member = option.getAsMember();

                           // i know its dirty

                           event.deferReply().queue();

                           option.getAsMember().getGuild().moveVoiceMember(member, channel).queue();
                           option.getAsMember().getGuild().moveVoiceMember(member, audioChannel).queue();

                           option.getAsMember().getGuild().moveVoiceMember(member, channel).queue();
                           option.getAsMember().getGuild().moveVoiceMember(member, audioChannel).queue();
                           String user = event.getUser().getAsTag();
                           String victim = option.getAsUser().getAsTag();
                           System.out.println(user + " kalled " + victim);

                           event.getHook().sendMessage("Ok dude").queue();
                       }
                       else{
                           event.deferReply().queue();
                           event.getHook().sendMessage("You dont have perms bro").queue();
                       }


                   }
                   else{
                       event.deferReply().queue();
                       event.getHook().sendMessage("Dude is not connected in a voice channel").queue();
                   }



               }

            }
    }
}
