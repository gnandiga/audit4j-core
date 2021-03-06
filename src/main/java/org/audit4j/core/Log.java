/*
 * Copyright 2014 Janith Bandara, This source is a part of 
 * Audit4j - An open source auditing framework.
 * http://audit4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.audit4j.core;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Default logger for Audit4j internal usage. 
 * 
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 * 
 * @since 1.0.0
 */
public class Log {

	/** The Constant AUDIT4J_INFO. */
	private static final String APP_INFO = CoreConstants.APP_NAME + ":INFO ";

	/** The Constant AUDIT4J_WARN. */
	private static final String APP_WARN = CoreConstants.APP_NAME + ":WARN ";

	/** The Constant AUDIT4J_ERROR. */
	private static final String APP_ERROR = CoreConstants.APP_NAME + ":ERROR ";

	/** The info stream. */
	private static PrintStream infoStream = System.out;
	
	/** The warn stream. */
	private static PrintStream warnStream = System.err;
	
	/** The error stream. */
	private static PrintStream errorStream = System.err;
	
	/**
	 * Write information in the console.
	 * 
	 * @param message
	 *            the message
	 */
	public static void info(final Object message) {
		infoStream.println(APP_INFO + message.toString());
	}



	/**
	 * Write warn messasge on console.
	 * 
	 * @param message
	 *            the message
	 */
	public static void warn(final Object message) {
		warnStream.println(APP_WARN + message.toString());
	}

	/**
	 * Write warn message on console with exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public static void warn(final Object message, final Throwable t) {
		warnStream.println(APP_WARN + message.toString());
		warnStream.println(stackTraceToString(t));
	}
	
	/**
	 * Write error message on console.
	 * 
	 * @param message
	 *            the message
	 */
	public static void error(final Object message) {
		errorStream.println(APP_ERROR + message.toString());
	}
	
	/**
	 * Write error messages on console with exception.
	 *
	 * @param message the message
	 * @param t the t
	 */
	public static void error(final Object message, final Throwable t) {
		errorStream.println(APP_ERROR + message.toString());
		errorStream.println(stackTraceToString(t));
	}
	
	/**
	 * Convert Stack trace to string.
	 *
	 * @param t the t
	 * @return the string
	 */
	private static String stackTraceToString(final Throwable t) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}
}
