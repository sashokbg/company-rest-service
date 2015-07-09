package bg.alexander.converters;

import java.time.LocalDate;

import javax.ws.rs.ext.ParamConverter;

public class JodaTimeParamConverter implements ParamConverter<LocalDate>{

	@Override
	public LocalDate fromString(String value){
		LocalDate localDate = LocalDate.parse(value);
		return localDate;
	}

	@Override
	public String toString(LocalDate value) {
		return value.toString();
	}

}
