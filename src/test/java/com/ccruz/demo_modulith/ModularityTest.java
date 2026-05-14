package com.ccruz.demo_modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTest {

    @Test
    void virifiesModularStructure() {
        ApplicationModules.of(DemoModulithApplication.class).verify();
    }
}
