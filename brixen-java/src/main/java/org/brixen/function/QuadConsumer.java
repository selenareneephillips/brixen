package org.brixen.function;

public interface QuadConsumer<T,U,V,Z> {
    void accept(T t, U u, V v, Z z);
}

