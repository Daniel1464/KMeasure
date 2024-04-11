package com.batterystaple.kmeasure.quantities

import com.batterystaple.kmeasure.dimensions.AnyDimension
import kotlin.jvm.JvmInline
import java.util.function.DoubleSupplier

typealias QuantityNumber = Double

@JvmInline
value class Quantity<D : AnyDimension>(val siValue: QuantityNumber) : Comparable<Quantity<D>>, DoubleSupplier {
    inline operator fun plus(other: Quantity<D>): Quantity<D> =
        Quantity(siValue + other.siValue)
    inline operator fun minus(other: Quantity<D>): Quantity<D> =
        Quantity(siValue - other.siValue)

    inline operator fun rem(other: Quantity<D>): Quantity<D> =
        Quantity(siValue % other.siValue)

    inline operator fun unaryMinus(): Quantity<D> =
        Quantity(-siValue)

    inline operator fun unaryPlus(): Quantity<D> =
        Quantity(+siValue)

    override fun compareTo(other: Quantity<D>): Int = siValue.compareTo(other.siValue)

    override fun getAsDouble(): Double = siValue

    override fun toString(): String =
        "Quantity(siValue=$siValue) (Units erased)"
}
