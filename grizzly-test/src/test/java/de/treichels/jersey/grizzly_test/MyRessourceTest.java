package de.treichels.jersey.grizzly_test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

public class MyRessourceTest extends JerseyTest {
	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		
		return new ResourceConfig(MyResource.class);
	}
	
	@Test
	public void test() {
		String result = target("myresource").request().get(String.class);
        assertEquals("Got it!", result);
	}
}
