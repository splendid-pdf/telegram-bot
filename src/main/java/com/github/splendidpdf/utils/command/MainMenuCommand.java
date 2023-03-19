package com.github.splendidpdf.utils.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

public interface MainMenuCommand {

    String getCommandSyntax();

    List<SendMessage> execute(List<SendMessage> sendMessages);
}