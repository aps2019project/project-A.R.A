package Menus.Cammands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Command {
       // View view = View.getInstance();
        Pattern pattern;
        public Matcher matcher;

        public Command(String string) {
            this.pattern = Pattern.compile(string);
        }

        abstract public void execute();
}
