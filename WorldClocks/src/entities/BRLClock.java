package entities;

public non-sealed class BRLClock extends Clock {

	@Override
	public Clock convert(final Clock clock) {
		this.second = clock.getSecond();
		this.minute = clock.getMinute();

		if (clock instanceof USClock usClock) {
			this.hour = (usClock.getPeriodIndicator().equals("PM"))
					? usClock.getHour() + 12
					: usClock.getHour();
		} else if (clock instanceof BRLClock brlClock) {
			this.hour = brlClock.getHour();
		}

		return this;
	}
}

