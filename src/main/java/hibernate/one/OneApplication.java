package hibernate.one;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static com.fasterxml.jackson.core.Version.unknownVersion;


@SpringBootApplication
@EntityScan(basePackages = {"model"} )
@EnableJpaRepositories(basePackages = {"Repositories"})
@EnableAsync


public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

// nu mi-a mers !

//	@Bean
//	public  MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter jackson = new MappingJackson2HttpMessageConverter();
//		ObjectMapper om = jackson.getObjectMapper();
//		JsonSerializer<?> streamSer = new StdSerializer<Stream<?>>(Stream.class, true) {
//			@Override public void serialize(
//					Stream<?> stream, JsonGenerator jgen, SerializerProvider provider
//			) throws IOException, JsonGenerationException
//			{
//				provider.findValueSerializer(Iterator.class, null)
//						.serialize(stream.iterator(), jgen, provider);
//			}
//		};
//		om.registerModule(new SimpleModule("Streams API", unknownVersion(), Arrays.asList(streamSer)));
//		return jackson;
//	}


}
