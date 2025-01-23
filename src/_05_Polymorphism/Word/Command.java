package _05_Polymorphism.Word;

import _05_Polymorphism.Word.TextTransforms.TextTransform;

public class Command {
    private String text;
    private TextTransform textTransform;

    public Command(String text, TextTransform textTransform){
        this.text = text;
        this.textTransform = textTransform;
    }

    public String getText() {
        return this.text;
    }

    public TextTransform getTextTransform() {
        return this.textTransform;
    }

}