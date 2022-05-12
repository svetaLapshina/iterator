import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Randoms implements Iterable<Integer> {
    protected Random random = new Random();
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Integer value() {
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new EndlessRandomIterator(this);
    }

    class EndlessRandomIterator implements Iterator<Integer> {
        Randoms randoms;

        private EndlessRandomIterator(Randoms randoms) {
            this.randoms = randoms;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return randoms.value();
        }
    }
}
