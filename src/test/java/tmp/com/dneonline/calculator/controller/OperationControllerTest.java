package tmp.com.dneonline.calculator.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OperationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void add() {

        ResponseEntity<String> response = restTemplate.getForEntity("/add?leftOperand=60&rightOperand=10", String.class);

        String expected = "{\"addResult\":70}";
        Assert.assertEquals(expected, response.getBody());
    }

    @Test
    public void subtract() {

        ResponseEntity<String> response = restTemplate.getForEntity("/subtract?leftOperand=60&rightOperand=10", String.class);

        String expected = "{\"subtractResult\":50}";
        Assert.assertEquals(expected, response.getBody());
    }

    @Test
    public void multiply() {

        ResponseEntity<String> response = restTemplate.getForEntity("/multiply?leftOperand=60&rightOperand=10", String.class);

        String expected = "{\"multiplyResult\":600}";
        Assert.assertEquals(expected, response.getBody());
    }

    @Test
    public void divide() {

        ResponseEntity<String> response = restTemplate.getForEntity("/divide?leftOperand=60&rightOperand=10", String.class);

        String expected = "{\"divideResult\":6}";
        Assert.assertEquals(expected, response.getBody());
    }

    @Test
    public void divideByZero() {

        ResponseEntity<String> response = restTemplate.getForEntity("/divide?leftOperand=60&rightOperand=0", String.class);

        String expected = "делитель не может быть равен 0";
        Assert.assertEquals(500, response.getStatusCodeValue());
        Assert.assertTrue(response.getBody().contains(expected));
    }
}
