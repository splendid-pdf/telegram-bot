package com.github.splendidpdf.utils.command.impl;

import com.github.splendidpdf.command.MainMenu;
import com.github.splendidpdf.utils.command.MainMenuCommand;
import com.github.splendidpdf.utils.keyboard.inline.ProfileInlineKeyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProfileMainMenuCommandImpl implements MainMenuCommand {

    private final ProfileInlineKeyboard profileInlineKeyboard;

    @Override
    public String getCommandSyntax() {
        return MainMenu.MY_PROFILE.getName();
    }

    @Override
    public List<SendMessage> execute(List<SendMessage> sendMessages) {
//        sendMessages.setText("Show my profile");
//        sendMessages.setReplyMarkup(profileInlineKeyboard.getInlineKeyboardMarkup());
        return sendMessages;
    }
}