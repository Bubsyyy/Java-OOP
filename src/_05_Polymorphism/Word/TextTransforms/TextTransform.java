package _05_Polymorphism.Word.TextTransforms;

public interface TextTransform {
    void invokeOn(StringBuilder text, int startIndex, int endIndex);
}