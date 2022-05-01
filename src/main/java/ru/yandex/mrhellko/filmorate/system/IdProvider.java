package ru.yandex.mrhellko.filmorate.system;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IdProvider {
    private final AtomicLong id = new AtomicLong(0);

    public long next() {
        return id.incrementAndGet();
    }
}
