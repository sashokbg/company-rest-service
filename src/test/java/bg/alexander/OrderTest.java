package bg.alexander;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import bg.alexander.service.EmployeeService;
import bg.alexander.service.OrdersService;

@RunWith(Arquillian.class)
public class OrderTest {

	    @Deployment
	    public static JavaArchive createDeployment() {
	    	JavaArchive  jar = ShrinkWrap.create(JavaArchive.class)
		            .addClass(OrdersService.class)
		            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	    	System.out.println(jar.toString(true));
	        return jar;
	    }

	    @Inject
	    private EmployeeService employeeService;
	    
	    @Test
	    public void ordersTest() {
	    	employeeService.getBy(1056L);
	    }
	    
	    @Test
	    public void should_create_greeting() {
	        Assert.fail("Not yet implemented");
	    }
}
