package funcitonal;

import com.xosmig.function.*;


public final class Functional {
    public static <T, R>
    LazyList<R> map(Function1<? super T, ? extends R> f, Iterable<? extends T> a) {
        return new MapList<T, R>(f, a.iterator());
    }

    public static <T>
    LazyList<T> filter(Predicate1<? super T> p, Iterable<? extends T> a) {
        return new FilterList<>(p, a.iterator());
    }

    public static <T>
    LazyList<T> takeWhile(Predicate1<? super T> p, Iterable<? extends T> a) {
        return new TakeWhileList<>(p, a.iterator());
    }

    public static <T>
    LazyList<T> takeUntil(Predicate1<? super T> p, Iterable<? extends T> a) {
        return takeWhile(p.not(), a);
    }

    public static <T, R>
    LazyBox<R> foldr(Function2<? super T, ?super R, ? extends R> f, R init, Iterable<? extends T> a) {
        return new FoldrBox<>(f, init, a.iterator());
    }

    public static <T, R>
    LazyBox<R> foldl(Function2<?super R, ? super T, ? extends R> f, R init, Iterable<? extends T> a) {
        return new FoldlBox<>(f, init, a.iterator());
    }
}
