package serializacion;


import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DeserializadorFecha implements JsonDeserializer<LocalDate>  {
	
	
	//el parámetro que le pasamos está en el primero: JsonElement json
		@Override
		public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			
			// Le decimos cómo se transforma el dato fecha (string) del json en LocalDate
			return LocalDate.parse(json.getAsString()); //convertimos el string en LocalDate, usando formato iso
			
			
		}

}
