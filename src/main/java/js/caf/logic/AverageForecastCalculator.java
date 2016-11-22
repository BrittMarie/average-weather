package js.caf.logic;

import java.util.List;

import js.caf.domain.DailyForecast;
import js.caf.exception.NotEnoughDataPointsException;

/**
 * Created by mentlsve on 22/11/16.
 */
public class AverageForecastCalculator {

    public float calculateAverageMaxTemperatureOverDays(List<DailyForecast> dailyForecasts, int numberOfDays){

		float averageMax;
		float sumMax = 0.0f;

		try {
			if (dailyForecasts.size() == 1) {
				new NotEnoughDataPointsException();
			}

			for (int i = 0; i < numberOfDays; i++) {
				sumMax = sumMax + dailyForecasts.get(i).getMaxTemperatureInCelsius();
			}

			averageMax = sumMax / (float) numberOfDays;

		} catch (IndexOutOfBoundsException e) {
			throw new NotEnoughDataPointsException();
		}

		return averageMax;
    }

}
