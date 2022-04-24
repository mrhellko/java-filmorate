package ru.yandex.mrhellko.filmorate.system;

import java.util.concurrent.atomic.AtomicLong;

public class IdProvider {
    private final AtomicLong id = new AtomicLong(0);

    public long next() {
        return id.incrementAndGet();
    }
}
