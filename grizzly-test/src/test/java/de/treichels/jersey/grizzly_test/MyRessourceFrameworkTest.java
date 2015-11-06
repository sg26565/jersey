package de.treichels.jersey.grizzly_test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

public class MyRessourceFrameworkTest extends JerseyTest {
	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		
		return new ResourceConfig().packages("de.treichels.jersey.grizzly_test");
	}
	
	@Test
	public void test() {
		String result = target("myresource").request().get(String.class);
        assertEquals("Got it!", result);
	}
}
