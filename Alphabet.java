public class Alphabet {
    private static final String UPPER_CASE_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_LETTER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "~!@#$%^&*()_-+=<>?/";

    StringBuilder pool;
    Alphabet(boolean upperCaseIncluded, boolean lowerCaseIncluded, boolean numbersIncluded, boolean symbolIncluded){
        pool = new StringBuilder();

        if(upperCaseIncluded) pool.append(UPPER_CASE_LETTER);
        if(lowerCaseIncluded) pool.append(LOWER_CASE_LETTER);
        if(numbersIncluded) pool.append(NUMBERS);
        if(symbolIncluded) pool.append(SYMBOLS);

    }

    public String getAlphabets(){
        return pool.toString();
    }
}

