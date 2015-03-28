package drivers;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import Interfaces.TestCaseParams;

public class ExtendedRunner extends BlockJUnit4ClassRunner {

	public ExtendedRunner(Class<?> klass) throws InitializationError {
		super(klass);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Statement methodBlock(FrameworkMethod method) {
		// TODO Auto-generated method stub

		// TestMethod testMethod =
		// extendedParamsTestsClassRunner.testMethodFor(method);
		// getBrowserParam(testMethod);

		TestCaseParams params = method.getAnnotation(TestCaseParams.class);

		if (params.browser() != null) {
			System.setProperty("browser", params.browser());
		}

		return super.methodBlock(method);
	}

}
