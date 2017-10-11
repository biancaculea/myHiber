package hibernate.one;

//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.ser.std.StdSerializer;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//import java.util.stream.Stream;

import static com.fasterxml.jackson.core.Version.unknownVersion;

// https://www.airpair.com/java/posts/spring-streams-memory-efficiency
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport {
    public class WebMvcConfig  {
//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(jackson2HttpMessageConverter());
//    }
//
//    private MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter jackson = new MappingJackson2HttpMessageConverter();
//        ObjectMapper om = jackson.getObjectMapper();
//        JsonSerializer<?> streamSer = new StdSerializer<Stream<?>>(Stream.class, true) {
//            @Override public void serialize(
//                    Stream<?> stream, JsonGenerator jgen, SerializerProvider provider
//            ) throws IOException, JsonGenerationException
//            {
//                provider.findValueSerializer(Iterator.class, null)
//                        .serialize(stream.iterator(), jgen, provider);
//            }
//        };
//        om.registerModule(new SimpleModule("Streams API", unknownVersion(), Arrays.asList(streamSer)));
//        return jackson;
//    }

}