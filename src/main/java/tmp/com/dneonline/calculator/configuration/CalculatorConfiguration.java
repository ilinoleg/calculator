package tmp.com.dneonline.calculator.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import tmp.com.dneonline.calculator.client.CalculatorClient;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("tmp.com.dneonline.wsdl");
        return marshaller;
    }

    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller){
        CalculatorClient calculatorClient = new CalculatorClient();
        calculatorClient.setDefaultUri("http://tempuri.org/");
        calculatorClient.setMarshaller(marshaller);
        calculatorClient.setUnmarshaller(marshaller);
        return calculatorClient;
    }
}
