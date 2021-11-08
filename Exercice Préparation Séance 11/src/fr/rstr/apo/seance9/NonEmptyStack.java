package fr.rstr.apo.seance9;

public class NonEmptyStack<Element> implements StackInterface<Element> {

    private final Element top;
    private NonEmptyStack<Element> pop;

    public NonEmptyStack(Element top) {
        this.top = top;
    }

    public NonEmptyStack(Element top, NonEmptyStack<Element> pop) {
        this.top = top;
        this.pop = pop;
    }

    public NonEmptyStack<Element> push(Element e) {
        return new NonEmptyStack<>(e, this);
    }

    @Override
    public NonEmptyStack<Element> pop() {
        return pop;
    }

    @Override
    public Element top() {
        return top;
    }

    @Override
    public int size() {
        if (pop == null)
            return 1;
        return 1 + pop.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        if (pop == null)
            return top.toString();
        return top.toString() + "\n----------\n" + pop.toString();
    }
}
