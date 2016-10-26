package funcitonal;

import com.xosmig.function.Function2;

import java.util.Iterator;

public interface LazyBox<T> {
    T get();
}


/*package*/ class FoldrBox<T, R> implements LazyBox<R> {
    final Function2<? super T, ? super R, ? extends R> f;
    final R init;
    final Iterator<? extends T> it;

    public FoldrBox(Function2<? super T, ? super R, ? extends R> f, R init, Iterator<? extends T> it) {
        this.f = f;
        this.init = init;
        this.it = it;
    }

    @Override
    public R get() {
        return foldrImpl();
    }

    private R foldrImpl() {
        if (it.hasNext()) {
            T e = it.next();
            return f.apply(e, foldrImpl());
        } else {
            return init;
        }
    }
}