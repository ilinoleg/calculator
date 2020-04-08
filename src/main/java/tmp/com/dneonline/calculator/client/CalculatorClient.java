package tmp.com.dneonline.calculator.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tmp.com.dneonline.wsdl.*;


@Log4j2
public class CalculatorClient extends WebServiceGatewaySupport {

    private final String host = "http://www.dneonline.com/calculator.asmx";
    private final String tempUri = "http://tempuri.org/";
    private final ObjectFactory objectFactory = new ObjectFactory();


    public AddResponse getAddition(String a, String b){
        Add request = objectFactory.createAdd();
        request.setIntA(Integer.parseInt(a));
        request.setIntB(Integer.parseInt(b));

        return (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(host, request, new SoapActionCallback(tempUri + "Add"));
    }

    public SubtractResponse getSubtraction(String a, String b){
        Subtract request = objectFactory.createSubtract();
        request.setIntA(Integer.parseInt(a));
        request.setIntB(Integer.parseInt(b));

        return (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(host, request, new SoapActionCallback(tempUri + "Subtract"));
    }

    public MultiplyResponse getMultiplication(String a, String b){
        Multiply request = objectFactory.createMultiply();
        request.setIntA(Integer.parseInt(a));
        request.setIntB(Integer.parseInt(b));

        return (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(host, request,new SoapActionCallback(tempUri + "Multiply"));
    }

    public DivideResponse getDivision(String a, String b){
        Divide request = objectFactory.createDivide();
        request.setIntA(Integer.parseInt(a));
        request.setIntB(Integer.parseInt(b));

        return (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(host, request, new SoapActionCallback(tempUri + "Divide"));
    }

}
