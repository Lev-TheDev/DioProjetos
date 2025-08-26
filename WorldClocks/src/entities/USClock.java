package entities;

public non-sealed class USClock extends Clock {

    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidDay() {
        this.periodIndicator = "PM";
    }

    public void setBeforeMidDay() {
        this.periodIndicator = "AM";
    }

    @Override
    public void setHour(int hour) {
        setBeforeMidDay();
        if ((hour >= 12) && (hour <= 23)) {
            this.hour = hour - 12;
            setAfterMidDay();
        } else if (hour >= 24) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    @Override
    public Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        if (clock instanceof USClock usClock) {
            this.hour = usClock.getHour();
            this.periodIndicator = usClock.getPeriodIndicator();
        } else if (clock instanceof BRLClock brlClock) {
            this.setHour(brlClock.getHour());
        }

        return this;
    }

    @Override
    public String getTime() {
        String period = (periodIndicator == null) ? "" : " " + periodIndicator;
        return super.getTime() + period;
    }
}

