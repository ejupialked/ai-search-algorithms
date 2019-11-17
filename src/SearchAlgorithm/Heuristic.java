package SearchAlgorithm;

public interface Heuristic {

    public int g(Node node);

    public int h(Node node);

    public int f(Node node);
}
