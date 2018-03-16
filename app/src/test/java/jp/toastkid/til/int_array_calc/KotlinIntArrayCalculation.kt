/*
 * Copyright (c) 2018 toastkidjp.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html.
 */
package jp.toastkid.til.int_array_calc

import org.junit.Test

/**
 * @author toastkidjp
 */
class KotlinIntArrayCalculation {

    /**
     * <pre>
     * max = 10
     * min = 2
     * sum = 32
     * average = 5.333333333333333
     * </pre>
     */
    @Test
    fun test() {
        val numbers = intArrayOf(3, 2, 10, 4, 7, 6)
        println("max = ${numbers.max()}")
        println("min = ${numbers.min()}")
        println("sum = ${numbers.sum()}")
        println("average = ${numbers.average()}")
    }
}
