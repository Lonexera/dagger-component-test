package com.example.daggercomponenttest.di.feature

import com.example.daggercomponenttest.somedependency.TextGenerator
import dagger.Component
import javax.inject.Scope

@Component(
    modules = [FeatureModule::class],
    dependencies = [FeatureComponent.Dependencies::class]
)
@FeatureScope
interface FeatureComponent {

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder
        fun build(): FeatureComponent
    }

    interface Dependencies {
        val textGenerator: TextGenerator
    }
}

@Scope
annotation class FeatureScope
