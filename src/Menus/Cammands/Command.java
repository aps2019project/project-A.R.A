package Menus.Cammands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Menus.View;

abstract public class Command {
        public View view = View.getInstance();
        private final Pattern pattern;
        protected Matcher matcher;

        public void setMatcher(Matcher matcher) {
                this.matcher = matcher;
        }

        public Pattern getPattern() {
                return pattern;
        }

        public Matcher getMatcher() {
                return matcher;
        }



        public Command(String string) {
            this.pattern = Pattern.compile(string);
        }

        abstract public void execute();
}


//todo put "BACK" command for every single Menu