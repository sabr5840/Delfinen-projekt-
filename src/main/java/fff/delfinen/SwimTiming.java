package fff.delfinen;

import java.time.Duration;

public class SwimTiming {
        private CompetitiveSwimmer swimmer;
        private Duration timing;

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
