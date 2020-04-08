package tmp.com.dneonline.calculator.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tmp.com.dneonline.calculator.client.CalculatorClient;
import tmp.com.dneonline.wsdl.AddResponse;
import tmp.com.dneonline.wsdl.DivideResponse;
import tmp.com.dneonline.wsdl.MultiplyResponse;
import tmp.com.dneonline.wsdl.SubtractResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class OperationController {

    private CalculatorClient calculatorClient;
    private static final String OPERAND_PATTERN = "[-]?[0-9]*$";
    private static final String DELIMITER_PATTERN = "[-]?[1-9][0-9]*$";

    public OperationController(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }

    @GetMapping("/add")
    public AddResponse add(@RequestParam @NotNull @Pattern(regexp = OPERAND_PATTERN) String leftOperand,
                           @RequestParam @NotNull @Pattern(regexp = OPERAND_PATTERN) String rightOperand){

        return calculatorClient.getAddition(leftOperand, rightOperand);
    }

    @GetMapping("/subtract")
    public SubtractResponse subtract(@RequestParam @NotNull @Pattern(regexp = OPERAND_PATTERN) String leftOperand,
                                     @RequestParam @NotNull @Pattern(regexp = OPERAND_PATTERN) String rightOperand){

        return calculatorClient.getSubtraction(leftOperand, rightOperand);
    }

    @GetMapping("/multiply")
    public MultiplyResponse multiply(@RequestParam @NotNull @Pattern(regexp = OPERAND_PATTERN) String leftOperand,
                                     @RequestParam @NotNull @Pattern(regexp = OPERAND_PATTERN) String rightOperand){

        return calculatorClient.getMultiplication(leftOperand, rightOperand);
    }

    @GetMapping("/divide")
    public DivideResponse divide(@RequestParam @NotNull @Pattern(regexp = OPERAND_PATTERN) String leftOperand,
                                 @RequestParam
                                 @NotNull
                                 @Pattern(regexp = DELIMITER_PATTERN, message = "делитель не может быть равен 0") String rightOperand){

        return calculatorClient.getDivision(leftOperand, rightOperand);
    }
}
