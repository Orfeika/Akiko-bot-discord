package bot.discord.commands;

import bot.discord.Ref;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class AnimeEmotionsCommands extends Commands {

    public void onCommand(MessageReceivedEvent e) {
        MessageChannel objMsgCh = e.getChannel();
       // objMsgCh.





    }

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        //Object
        User objUser = e.getAuthor();
        MessageChannel objMsgCh = e.getChannel();
        Message objMsg = e.getMessage();
        User objMentionedUser = e.getMessage().getMentionedUsers().get(0);
        //commands
        if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "hi")) {
            objMsgCh.sendMessage(objUser.getAsMention() + "\n Hello, it's nice to see you here").queue();
        } else if (objMsg.getContentRaw().contains(Ref.prefix + "hug")) {
            String message = objMsg.getContentRaw();

            objMsgCh.sendMessage(objUser.getAsMention() + " has hugged " +
                    objMentionedUser.getAsMention()).queue();

        }

    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getUsageInstructions() {
        return null;
    }
}
