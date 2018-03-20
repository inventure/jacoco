/*******************************************************************************
 * Copyright (c) 2009, 2017 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vladimir Farafonov - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.internal.analysis.filter.classfilter;

public abstract class ClassFilter {

	public void visitAnnotation(final String desc, final boolean visible) {
	}

	public void visit(final int version, final int access, final String name,
			final String signature, final String superName,
			final String[] interfaces) {
	}

	public void visitSource(final String source, final String debug) {
	}

	public void visitMethod(final int access, final String name,
			final String desc, final String signature,
			final String[] exceptions) {
	}

	public void visitField(final int access, final String name,
			final String desc, final String signature, final Object value) {
	}

	public void visitTotalProbeCount(final int count) {
	}

	public void reset() {
	};

	public abstract boolean isClassFiltered();
}