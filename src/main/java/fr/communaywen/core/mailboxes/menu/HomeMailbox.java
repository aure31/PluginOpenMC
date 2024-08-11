package fr.communaywen.core.mailboxes.menu;

import fr.communaywen.core.mailboxes.utils.MailboxMenuManager;
import fr.communaywen.core.mailboxes.menu.letter.SendingLetter;
import fr.communaywen.core.mailboxes.utils.MailboxInv;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import static fr.communaywen.core.mailboxes.utils.MailboxMenuManager.getCustomItem;
import static fr.communaywen.core.mailboxes.utils.MailboxUtils.getHead;
import static fr.communaywen.core.mailboxes.utils.MailboxUtils.getItem;

public class HomeMailbox extends MailboxInv {
    private static final String INV_NAME = "\uF990\uE004";

    public HomeMailbox(Player player) {
        super(player);
        this.inventory = Bukkit.createInventory(this, 9, MailboxMenuManager.getInvTitle(INV_NAME));
        inventory.setItem(3, getCustomItem(Component.text("En attente", NamedTextColor.DARK_AQUA, TextDecoration.BOLD), 2006));
        inventory.setItem(4, getHead(player, Component.text("Ma boite aux lettres", NamedTextColor.GOLD, TextDecoration.BOLD)));
        inventory.setItem(5, getCustomItem(Component.text("Envoyer", NamedTextColor.DARK_AQUA, TextDecoration.BOLD), 2007));
        inventory.setItem(8, getItem(Component.text("Paramètres", NamedTextColor.DARK_AQUA, TextDecoration.BOLD), Material.COMPARATOR));
    }

    public static void openPlayersList(Player player) {
        PlayersList playersList = new PlayersList(player);
        playersList.openInventory();
    }

    public static void openSendingMailbox(Player player, OfflinePlayer receiver) {
        SendingLetter sendingLetter = new SendingLetter(player, receiver);
        sendingLetter.openInventory();
    }

    public static void openPlayerMailbox(Player player) {
        PlayerMailbox playerMailbox = new PlayerMailbox(player);
        playerMailbox.openInventory();
    }

    public static void openPendingMailbox(Player player) {
        PendingMailbox pendingMailbox = new PendingMailbox(player);
        pendingMailbox.openInventory();
    }

    public static void openSettings(Player player) {
    }

    public static void openHomeMailbox(Player player) {
        HomeMailbox homeMailbox = new HomeMailbox(player);
        homeMailbox.openInventory();
    }

    @Override
    public void openInventory() {
        player.openInventory(this.inventory);
    }
}
