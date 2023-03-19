package com.github.splendidpdf.utils.command;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface MainMenuCommand {

    String getCommandSyntax();

    InlineKeyboardMarkup execute();
}