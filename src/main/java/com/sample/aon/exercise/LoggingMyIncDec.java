package com.sample.aon.exercise;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class used decorator pattern overriding methods of MyIncDec class
 * to perform logging around method execution.  This is a simple approach to introduce
 * logging without modification to the original class, there's more sophisticated way to
 * introduce cross cutting logging solution using Spring AOP in Part 2.
 *
 * Invoke main class : LoggingMyIncDec 2
 * 20:21:37.085 [main] INFO com.sample.aon.LoggingMyIncDec --  Start increment(): 1749032497085
 * 20:21:37.088 [main] INFO com.sample.aon.LoggingMyIncDec --  End increment(): 1749032497088
 * 20:21:37.088 [main] INFO com.sample.aon.LoggingMyIncDec --  Duration increment() execution: 3 milliseconds
 * 20:21:37.088 [main] INFO com.sample.aon.LoggingMyIncDec --  Start decrement(): 1749032497088
 * 20:21:37.088 [main] INFO com.sample.aon.LoggingMyIncDec --  End decrement(): 1749032497088
 * 20:21:37.088 [main] INFO com.sample.aon.LoggingMyIncDec --  Duration decrement() execution: 0 milliseconds
 *
 */
@Slf4j
public class LoggingMyIncDec extends MyIncDec {

    private final static Logger logger = LoggerFactory.getLogger(LoggingMyIncDec.class);

    public LoggingMyIncDec(int x) {
        super(x);
    }

    @Override
    public void increment() {
        long startTime = System.currentTimeMillis();
        logger.info(" Start increment(): {} ", startTime);
        super.increment();
        long endTime =  System.currentTimeMillis();
        logger.info(" End increment(): {} ", endTime);
        long duration = endTime - startTime;
        logger.info(" Duration increment() execution: {} milliseconds", duration);
    }

    @Override
    public void decrement() {
        long startTime = System.currentTimeMillis();
        logger.info(" Start decrement(): {} ", startTime);
        super.decrement();
        long endTime =  System.currentTimeMillis();
        logger.info(" End decrement(): {} ", endTime);
        long duration = endTime - startTime;
        logger.info(" Duration decrement() execution: {} milliseconds", duration);
    }

    public static void main(@NonNull String args[]) {
        LoggingMyIncDec incDec = new LoggingMyIncDec(Integer.parseInt(args[0]));
        incDec.increment();
        incDec.decrement();
        System.out.println("6678".indexOf("67") +" test");
    }
}
