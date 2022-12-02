package org.example;

import java.time.Duration;
import java.time.LocalDateTime;

public class SwimTiming {
        private final CompetitiveSwimmer swimmer;
        private final Duration timing;

    public SwimTiming(CompetitiveSwimmer swimmer, Duration timing) {
        this.swimmer = swimmer;
        this.timing = timing;
    }

    public CompetitiveSwimmer getSwimmer() {
        return swimmer;
    }

    public Duration getTiming() {
        return timing;
    }

    @Override
    public String toString() {
        return "SwimTiming{" +
                "swimmer=" + swimmer +
                ", timing=" + timing +
                '}';
    }
}
