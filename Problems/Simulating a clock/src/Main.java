class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (minutes < 59) {
            minutes++;
        } else {
            hours++;
            minutes = 0;
        }

        if (hours == 13) {
            hours = 1;
        }
    }
}