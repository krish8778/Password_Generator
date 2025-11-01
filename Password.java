public class Password {
    private final String val;
    private final int length;

    Password(String str){
        val = str;
        length = str.length();
    }


    public String calculateScore() {
        int score = this.checkStrength();
        if (score == 6)
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        else if (score >= 4)
            return "This is a good password :) but you can still do better";
        else if(score > 2)
            return "This is a medium password :/ try making it better";
        else
            return "This is a weak password :( definitely find a new one";
    }

    private int checkStrength() {
        String str = this.val;
        boolean usedLower = false;
        boolean usedUpper = false;
        boolean usedNumber = false;
        boolean usedSymbol = false;

        for(int i = 0; i < length; i++){
            char ch = str.charAt(i);
            int type = charType(ch);

            if(type == 1) usedUpper = true;
            else if (type == 2) usedLower = true;
            else if(type == 3) usedNumber = true;
            else if(type == 4) usedSymbol = true;
        }
        int score = 0;
        if(usedUpper) score++;
        if (usedLower) score++;
        if (usedNumber) score++;
        if(usedSymbol) score++;

        if(str.length() >= 8) score++;
        if (str.length() >= 16) score++;

        return score;

    }

    private int charType(char ch) {
        //uppercase
        if((int)ch >= 65 && (int)ch <= 90) return 1;
        //lowercase
        else if ((int)ch >= 97 && (int)ch <= 122) return 2;
        //numbers
        else if ((int)ch >= 48 && (int)ch <= 57) return 3;
        //symbol
        else return 4;
    }
}
