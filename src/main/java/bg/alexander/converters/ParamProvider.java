package bg.alexander.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class ParamProvider implements ParamConverterProvider{
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType,
			Type genericType, Annotation[] annotations) {
		
		if(genericType.equals(LocalDate.class)){
			JodaTimeParamConverter candidateConverter = new JodaTimeParamConverter();
			
			return (ParamConverter<T>) candidateConverter;
		}
		
		return null;
	}
}
