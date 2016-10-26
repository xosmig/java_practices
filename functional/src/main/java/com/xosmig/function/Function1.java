package com.xosmig.function;

public interface Function1<T, R> {
    R apply(T param);

    default <G>
    Function1<G, R> compose(Function1<? super G, ? extends T> g) {
        return x -> this.apply(g.apply(x));
    }
}