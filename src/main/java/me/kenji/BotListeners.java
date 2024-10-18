package me.kenji;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotListeners extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(! event.getAuthor().isBot()  ) {
            String MessageSent = event.getMessage().getContentRaw();
            String MessageID = event.getMessage().getId();
            String SenderID = event.getAuthor().getAsTag();
            if(MessageSent.contains("chomu")){
                event.getChannel().sendMessage("Yes, <@324549948165324802> is chomu").queue();
            }
            else if (MessageSent.startsWith("ring")){
                String victim = MessageSent.replaceFirst("ring <@", "").replace(">", "");
                Member user = event.getGuild().getMember(UserSnowflake.fromId(victim));
                String victimname = user.getUser().getAsTag();
                if(user.getVoiceState().inAudioChannel()) {


                    if (event.getMember().getRoles().getLast().getId().equals("1260907837358477344")) { // create a role for accessibility


                        AudioChannel audioChannel = user.getVoiceState().getChannel();
                        AudioChannel channel = event.getGuild().getAfkChannel();

                        user.getGuild().moveVoiceMember(user, channel).queue();
                        user.getGuild().moveVoiceMember(user, audioChannel).queue();

                        user.getGuild().moveVoiceMember(user, channel).queue();
                        user.getGuild().moveVoiceMember(user, audioChannel).queue();

                        //event.getChannel().sendMessage("Done").queue();
                        event.getMessage().reply("ok Dude").queue();

                        System.out.println(event.getAuthor().getAsTag() + " ring " + victimname);

                    } else {
                        //event.getChannel().sendMessage("You dont have the role <bot-cum>").queue();
                        event.getMessage().reply("You dont have the role <bot-cum>").queue();
                        System.out.println("no perm:" + event.getAuthor().getAsTag() + " ring " + victimname);
                    }

                }
                else{
                   // event.getChannel().sendMessage("Dude is not in a vc").queue();
                    event.getMessage().reply("Dude is not in a vc").queue();
                    System.out.println("no connected: " + event.getAuthor().getAsTag() + " ring " + victimname);
                }

            }
            else if(MessageSent.contains("office")){
                event.getChannel().sendMessage("Did you mean garments?").queue();
            }
            else if(MessageSent.contains("<@681939399818346517>")){
                event.getChannel().sendMessage("<@681939399818346517> halay to nigro").queue();
                //event.getMessage().reply("<@681939399818346517> halay to nigro");

            }
            else if(MessageSent.contains("<@791978025742237697>")){
                event.getChannel().sendMessage("<@791978025742237697> halay to snake").queue();
            }
            else if (MessageSent.startsWith("k/") && event.getMember().getRoles().getLast().getId().equals("1260907837358477344")){ // create a role for accessibility

                event.getChannel().deleteMessageById(MessageID).queue();
                event.getChannel().sendMessage("```"  + MessageSent.replaceFirst("k/","") + "```").queue();

                System.out.println(MessageSent + "  -" + SenderID);
            }
        }
    }





}
