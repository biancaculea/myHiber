package hibernate.one;

import hibernate.one.Controllers.myController01;
import model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;


import java.util.List;
import  model.Person;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.RANDOM_PORT)
public class myController01Tests {

	@Autowired
	private myController01 controller01;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;



	@Test
	public void contextLoads() {
		assertThat(controller01).isNotNull();
	}

	@Test
	public void ShouldReturnOne() throws Exception {
		String expected ="[{'id':2,'firstname':'Bianca','lastname':'Culea','email':'bianca_culea@yahoo.com','phone':'0040722609975'}]";
		String result=this.restTemplate.getForObject("http://localhost:"+port+"/my02/bianca/",String.class);
		JSONAssert.assertEquals(expected, result, false);
	}

	@Test
	public void ShouldReturnFirstTwo() throws Exception {
		//String expected ="[{\"id\":1,\"firstname\":\"George\",\"lastname\":\"Culea\",\"email\":\"george.culea@bcr.ro\",\"phone\":\"0040722609975\"},{\"id\":2,\"firstname\":\"Bianca\",\"lastname\":\"Culea\",\"email\":\"bianca_culea@yahoo.com\",\"phone\":\"0040722609975\"}]";
		String expected ="[\n" +
				"{\"id\":1,\n" +
				"\"firstname\":\"George\",\n" +
				"\"lastname\":\"Culea\",\n" +
				"\"email\":\"george.culea@bcr.ro\",\n" +
				"\"phone\":\"0040722609975\"},\n" +
				"\n" +
				"{\"id\":2,\n" +
				"\"firstname\":\"Bianca\",\n" +
				"\"lastname\":\"Culea\",\n" +
				"\"email\":\"bianca_culea@yahoo.com\",\n" +
				"\"phone\":\"0040722609975\"}\n" +
				"]\n";
		String result=this.restTemplate.getForObject("http://localhost:"+port+"/my04?lastname=culea",String.class);
//		List<Person> result_bis =this.restTemplate.getForObject("http://localhost:"+port+"/my04?lastname=culea",String.class);
		JSONAssert.assertEquals(expected, result, false); // verifica formate JSON
        // "stricttrue" require all of the elements requested to be returned, and only those elements (ie, the tests are non-extensible).
		// Arrays of elements must be returned in the same order as expected.

	}

	@Test
	public void ShouldReturnFirstTwoWithCoreAssertThat() throws Exception {
		String result=this.restTemplate.getForObject("http://localhost:"+port+"/my04?lastname=culea",String.class);
		String expected = "{\"id\":1," + "\"firstname\":\"George\"," + "\"lastname\":\"Culea\"," + "\"email\":\"george.culea@bcr.ro\"," + "\"phone\":\"0040722609975\"";
		assertThat(result).contains(expected); // verifica adliteram
		assertThat(result).contains("George");
	}
}
