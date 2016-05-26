package com.sf.weather.injection

import cn.nekocode.kotgo.component.util.Dependency

object TestDep : Dependency() {
    var int = 0
    var str = "old"

    override fun createDependencies() {
        bindSingleton<Int> {
            args ->

            int += args[0] as Int + args[1] as Int
            int
        }

        bind<String> {
            args ->

            str
        }
    }
}