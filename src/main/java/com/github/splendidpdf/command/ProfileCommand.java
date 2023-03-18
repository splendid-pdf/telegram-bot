package com.github.splendidpdf.command;

public enum ProfileCommand implements Command {

    REGISTER() {
        @Override
        public String getName() {
            return "/start";
        }
    },

    EDIT_ROLE() {
        @Override
        public String getName() {
            return "edit role";
        }
    },

    EDIT_LOCATION() {
        @Override
        public String getName() {
            return "edit location";
        }
    },



}
