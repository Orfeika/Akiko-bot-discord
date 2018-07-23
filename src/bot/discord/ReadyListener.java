package bot.discord;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.entities.Guild;
import sun.invoke.empty.Empty;

public class ReadyListener extends ListenerAdapter {


    public void onReady (ReadyEvent e){
        String out = "\n This bot is running on the following servers: \n";
        for (Guild g : e.getJDA().getGuilds()){
            out += g.getName() + "(" + g.getId() + ")\n";
        }
        System.out.println(out);

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
        //Object
        User objUser = evt.getAuthor();
        MessageChannel objMsgCh = evt.getChannel();
        Message objMsg = evt.getMessage();
        User objMentionedUser = evt.getMessage().getMentionedUsers().get(0);
        //commands
        if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "hi")) {
            objMsgCh.sendMessage(objUser.getAsMention() + "\n Hello, it's nice to see you here").queue();
        } else if (objMsg.getContentRaw().contains(Ref.prefix + "hug")) {
                    String message = objMsg.getContentRaw();

            objMsgCh.sendMessage(objUser.getAsMention() + " has hugged " +
                    objMentionedUser.getAsMention()).queue();

        }

    }
}
