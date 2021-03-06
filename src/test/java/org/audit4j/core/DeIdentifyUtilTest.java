package org.audit4j.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeIdentifyUtilTest {

	private String text;

	@Before
	public void setUp() {
		text = "0123456789";
	}

	@Test
	public void testDeidentifyAll() {
		Assert.assertEquals("**********", DeIndentifyUtil.deidentify(text, 0, 0, 0, 0));
	}

	@Test
	public void testDeidentifyLeft() {
		Assert.assertEquals("****456789", DeIndentifyUtil.deidentify(text, 4, 0, 0, 0));
	}

	@Test
	public void testDeidentifyRight() {
		Assert.assertEquals("012345****", DeIndentifyUtil.deidentify(text, 0, 4, 0, 0));
	}

	@Test
	public void testDeidentifyFromRight() {
		Assert.assertEquals("0123******", DeIndentifyUtil.deidentify(text, 0, 0, 4, 0));
	}

	@Test
	public void testDidentifyFromLeft() {
		Assert.assertEquals("******6789", DeIndentifyUtil.deidentify(text, 0, 0, 0, 4));
	}

	@Test
	public void testDeidentifyMiddle() {
		Assert.assertEquals("01*****789", DeIndentifyUtil.deidentify(text, 0, 0, 2, 3));
	}

	@Test
	public void testDeidentifyEdge() {
		Assert.assertEquals("**23456***", DeIndentifyUtil.deidentify(text, 2, 3, 0, 0));
	}
}
