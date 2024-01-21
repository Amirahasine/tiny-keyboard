/*
 * New class, for status bar
 *
 * app/src/main/java/rkr/tinykeyboard/inputmethod/StatusBar.java
 *
 */

package rkr.tinykeyboard.inputmethod;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Duration;

public class StatusBar {
    public String string;
    public long time;
    public int count;

    public StatusBar() {
        this.string = "";
        this.time = Instant.now().toEpochMilli();
    }

    public void update() {
        this.count++;
        int timediff = calculateDiff(Instant.now().toEpochMilli()) / 1000;
        if (timediff == 0) {
            this.string = "presses: " + this.count + ", time spent typing: " + timediff;
        }
        else {
            this.string = "presses: " + this.count + ", time spent typing: " + timediff + ", speed in p/s: " + this.count / timediff;
        }
    }

    public void updateTime() {
        int timediff = calculateDiff(Instant.now().toEpochMilli()) / 1000;
        if (timediff == 0) {
            this.string = "presses: " + this.count + ", time spent typing: " + timediff;
        }
        else {
            this.string = "presses: " + this.count + ", time spent typing: " + timediff + ", speed in p/s: " + this.count / timediff;
        }
    }

    public int calculateDiff(long time){
        LocalDateTime firstPress = LocalDateTime.ofEpochSecond(this.time, 0,
                java.time.ZoneOffset.UTC);
        LocalDateTime currentPress = LocalDateTime.ofEpochSecond(time, 0,
                java.time.ZoneOffset.UTC);
        return (int) Duration.between(firstPress, currentPress).getSeconds();
    }

    @Override public String toString() {
        return this.string;
    }
}
