package hu.dodotech.bakeryrateapp;

import org.robolectric.RuntimeEnvironment;

public class TestHelper {
    public static BakeryApp setTestInjector() {
        BakeryApp application = (BakeryApp) RuntimeEnvironment.application;
        application.setInjector(DaggerTestComponent.builder().testModule(new TestModule()).build());
        return application;
    }
}
