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
package org.jacoco.core.internal.analysis.filter;

import java.util.List;

import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * Filters methods annotated with <code>@ExcludeFromCoverage</code>.
 */
public class ExcludeAnnotationMethodFilter extends AbstractAnnotatedMethodFilter {

	/**
	 * New filter.
	 */
	public ExcludeAnnotationMethodFilter() {
		super(ExcludeAnnotationConst.ANNOTATION_EXCLUDE);
	}

	@Override
	public void filter(final String className, final String superClassName,
			final MethodNode methodNode, final IFilterOutput output) {
		super.filter(className, superClassName, methodNode, output);
	}

	@Override
	List<AnnotationNode> getAnnotations(final MethodNode methodNode) {
		return methodNode.visibleAnnotations;
	}
}
