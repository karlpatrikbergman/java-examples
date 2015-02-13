package se.patrikbergman.java.junit.configuration.rulechaintest;

import com.google.common.base.Preconditions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import se.patrikbergman.java.junit.configuration.rulechaintest.rule.FirstRule;
import se.patrikbergman.java.junit.configuration.rulechaintest.rule.SecondRule;
import se.patrikbergman.java.junit.configuration.rulechaintest.rule.ThirdRule;

public class RulesChainTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private FirstRule firstRule = new FirstRule("tjo");
	private SecondRule secondRule = new SecondRule("tja");
	private ThirdRule thirdRule = new ThirdRule("tjim");

	@Rule
	public TestRule chain = RuleChain
			.outerRule(firstRule)
			.around(secondRule)
			.around(thirdRule);

	@Test
	public void foo() {
		System.out.printf("In foo: firstRule.getConfig: %s, secondRule.getConfig: %s, thirdRule.getConfig: %s",
				firstRule.getConfig(), secondRule.getConfig(), thirdRule.getConfig());

	}

	//Should fail since the error message is not correct?
	@Test
	public void fii() {
		String clearingNumber = "33333";
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Clearingnumret");
		Preconditions.checkArgument(clearingNumber.length() < 5, "Clearingnumret är för långt");

	}
}
