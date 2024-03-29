package me.atticusthecoder.bulldog.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Multithreading {

    public static final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void runAsync(Runnable runnable) {
        POOL.execute(runnable);
    }

}
