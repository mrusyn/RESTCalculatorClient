package client;

import impl.CalculatorRS;

import java.util.Properties;

import javax.ws.rs.core.Response;




import org.apache.catalina.WebResource;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static  Logger LOG = Logger.getLogger(CalculatorTest.class);

    @BeforeClass
    public static void setUp() throws Exception {
        BasicConfigurator.configure();
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(CalculatorRS.class);
        sf.setResourceProvider(CalculatorRS.class, 
        new SingletonResourceProvider(new CalculatorRS()));
        sf.setAddress("http://localhost:8080/RESTCalculator/rest?_wadl");
        Server server = sf.create();
        System.out.println("Client was created");
        
    }

    @Test
    public void testAdd() throws Exception {
        
        LOG.info("The test Add was started");
        CalculatorRS calculatorService = new CalculatorRS();
        System.out.println("Calculate Sum operation on calculate Service");
        int suma = calculatorService.add(4, 6);
        System.out.println("Sum of 4 and 6 is " + suma);
        assertEquals(10, suma);
       
    }
    
    @Test
    public void testMultiply() throws Exception {
        
        LOG.info("The test was started");
        CalculatorRS calculatorService = new CalculatorRS();
        System.out.println("Calculate Multiply operation on calculate Service");
        int multiply = calculatorService.multiply(10, 2);
        System.out.println("Multiply of 10 and 2 is " + multiply);
        assertEquals(20, multiply);
       
    }
}
