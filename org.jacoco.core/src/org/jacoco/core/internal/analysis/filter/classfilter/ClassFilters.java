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

public class ClassFilters extends ClassFilter {

	public static ClassFilter NONE = new ClassFilters();

	public static ClassFilter ALL = new ClassFilters(
			new ExcludeAnnotationClassFilter());

	private final ClassFilter[] classFilters;

	public ClassFilters() {
		classFilters = new ClassFilter[] {};
	}

	public ClassFilters(final ClassFilter... classFilters) {
		this.classFilters = classFilters;
	}

	@Override
	public void visitAnnotation(final String desc, final boolean visible) {
		for (final ClassFilter filter : classFilters) {
			filter.visitAnnotation(desc, visible);
		}
	}

	@Override
	public void visit(final int version, final int access, final String name,
			final String signature, final String superName,
			final String[] interfaces) {
		for (final ClassFilter filter : classFilters) {
			filter.visit(version, access, name, signature, superName,
					interfaces);
		}
	}

	@Override
	public void visitSource(final String source, final String debug) {
		for (final ClassFilter filter : classFilters) {
			filter.visitSource(source, debug);
		}
	}

	@Override
	public void visitMethod(final int access, final String name,
			final String desc, final String signature,
			final String[] exceptions) {
		for (final ClassFilter filter : classFilters) {
			filter.visitMethod(access, name, desc, signature, exceptions);
		}
	}

	@Override
	public void visitField(final int access, final String name,
			final String desc, final String signature, final Object value) {
		for (final ClassFilter filter : classFilters) {
			filter.visitField(access, name, desc, signature, value);
		}
	}

	@Override
	public void visitTotalProbeCount(final int count) {
		for (final ClassFilter filter : classFilters) {
			filter.visitTotalProbeCount(count);
		}
	}

	@Override
	public void reset() {
		for (final ClassFilter filter : classFilters) {
			filter.reset();
		}
	}

	@Override
	public boolean isClassFiltered() {
		boolean result = false;
		for (final ClassFilter filter : classFilters) {
			if (filter.isClassFiltered()) {
				result = true;
			}
		}
		return result;
	}

}