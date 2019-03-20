public class Association {

    //Atributes
    String englishWord;
    String spanishWord;

    public Association(String englishWord, String spanishWord){
        setEnglishWord(englishWord);
        setSpanishWord(spanishWord);
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getSpanishWord() {
        return spanishWord;
    }

    public void setSpanishWord(String spanishWord) {
        this.spanishWord = spanishWord;
    }

    @Override
    public String toString() {
        return getEnglishWord();
    }
}
