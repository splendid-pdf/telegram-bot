package com.github.splendidpdf.utils.command.impl;

import com.github.splendidpdf.command.MainMenu;
import com.github.splendidpdf.utils.command.MainMenuCommand;
import com.github.splendidpdf.utils.keyboard.inline.ProjectInlineKeyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectMainMenuCommandImpl implements MainMenuCommand {
    private final ProjectInlineKeyboard projectInlineKeyboard;

    @Override
    public String getCommandSyntax() {
        return MainMenu.PROJECT.getName();
    }

    @Override
    public SendMessage execute(String chatId, Object object) {
        return null;

    }
}
