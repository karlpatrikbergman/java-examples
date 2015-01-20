package se.patrikbergman.java.annotations;

import com.google.common.base.Preconditions;
import org.junit.rules.ExternalResource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RestRequestConfigurationRule extends ExternalResource {
	public final Class target;

	public RestRequestConfigurationRule(Class target) {
		Preconditions.checkNotNull(target, "Test class cannot be null");
		this.target = target;
	}

	@Override
	public void before() throws IllegalAccessException, IOException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		for (Field field : target.getFields()) {
			if (field.isAnnotationPresent(InjectTestResource.class)) {
				final InjectTestResource injectTestResource = field.getAnnotation(InjectTestResource.class);
				final Class factoryClass = injectTestResource.getFactory();
				final Object factoryInstance = factoryClass.newInstance();
				final String methodName = injectTestResource.getMethod();
				final Method method = factoryClass.getMethod(methodName, null);
				method.setAccessible(true);
				final Object value = method.invoke(factoryInstance, null);
				field.set(target, value);
			}
		}
	}
}
