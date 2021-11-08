package fr.rstr.apo.seance9;

public class Stack<Element> implements StackInterface<Element> {

    private final NonEmptyStack<Element> contents;

    public Stack() {
        contents = null;
    }

    public Stack(NonEmptyStack<Element> contents) {
        this.contents = contents;
    }

    public Stack<Element> push(Element e) {
        if (contents == null)
            return new Stack<>(new NonEmptyStack<>(e));
        return new Stack<>(contents.push(e));
    }

    @Override
    public String toString() {
        if (contents == null)
            return "";
        return contents.toString();
    }

    @Override
    public Stack<Element> pop() {
        if (contents == null)
            return this;
        return new Stack<>(contents.pop());
    }

    @Override
    public Element top() {
        if (contents == null)
            return null;
        return contents.top();
    }

    @Override
    public int size() {
        if (contents == null)
            return 0;
        return contents.size();
    }

    @Override
    public boolean isEmpty() {
        return contents == null;
    }
}
