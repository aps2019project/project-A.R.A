package Menus.Cammands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Command {
       // View view = View.getInstance();
        Pattern pattern;
        Matcher matcher;

        Command(String string) {
            this.pattern = Pattern.compile(string);
        }

        abstract void execute();
}
