package Menus.Cammands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import View.View;

abstract public class Command {
        public View view = View.getInstance();
        Pattern pattern;
        public Matcher matcher;

        public Command(String string) {
            this.pattern = Pattern.compile(string);
        }

        abstract public void execute();
}
