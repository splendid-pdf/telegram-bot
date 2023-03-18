package com.github.splendidpdf.command;

public enum PersonalMenuCommand implements Command {
    SHOW_PROFILE() {
        @Override
        public String getName() {
            return "Show my profile";
        }
    },

    SHOW_GITHUB() {
        @Override
        public String getName() {
            return "Show github";
        }
    },

    EVENTS_CALENDAR {
        @Override
        public String getName() {
            return "Events calendar";
        }
    }

}
