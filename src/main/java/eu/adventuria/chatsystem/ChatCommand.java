package eu.adventuria.chatsystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(strings.length == 0){
                p.sendMessage(Messages.prefix + "§eNutze: /chat <toggle,check>");
            }else if(strings[0].equalsIgnoreCase("check") && strings.length == 1){
                if(ArangoMethods.getGlobalChatBoolean(p.getUniqueId().toString()) == true){
                    p.sendMessage(Messages.prefix + "§7Du hast den Globall-Chat derzeit §aAktiviert§7.");
                }else{
                    p.sendMessage(Messages.prefix + "§7Du hast den Globall-Chat derzeit §cDeaktiviert§7.");
                }
            }else if(strings[0].equalsIgnoreCase("toggle")){
                ArangoMethods.changeGlobalChatBoolean(p.getUniqueId().toString());
                if(ArangoMethods.getGlobalChatBoolean(p.getUniqueId().toString()) == true){
                    p.sendMessage(Messages.prefix + "§7Du hast den Globall-Chat §aAktiviert§7.");
                }else{
                    p.sendMessage(Messages.prefix + "§7Du hast den Globall-Chat §cDeaktiviert§7.");
                }
            }
        }
        return false;
    }
}

// -> /chat check
