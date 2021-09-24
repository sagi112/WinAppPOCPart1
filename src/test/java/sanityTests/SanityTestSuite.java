package sanityTests;

import Functional.TestEnvSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Functional.TestEnvSetup.process;


@ExtendWith(TestEnvSetup.class)
public class SanityTestSuite {
    @Test
    void passTest() {
        Assertions.assertTrue(true);

        System.out.println("Process status: " + process.isAlive());
    }

    @Test
    void failTest() {
        Assertions.assertTrue(false);
    }


}
