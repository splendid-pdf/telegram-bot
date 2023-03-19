package com.github.splendidpdf.utils.command.impl;

import com.github.splendidpdf.command.MainMenu;
import com.github.splendidpdf.utils.command.MainMenuCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

@Component
public class CreateEventMainMenuCommandImpl implements MainMenuCommand {

    @Override
    public String getCommandSyntax() {
        return MainMenu.CREATE_EVENT.getName();
    }

    @Override
    public List<SendMessage> execute(List<SendMessage> sendMessages) {
//        sendMessages.setText("Show create event window");

        return sendMessages;
    }
}