
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import homework7.DayOfTheWeek;
import org.junit.jupiter.api.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfTheWeekTest {
        private DayOfTheWeek dayOfTheWeek;

        @BeforeAll
        static void beforeAll() {
            System.out.println("Before all...");
        }

        @BeforeEach
        void beforeTest() {
            dayOfTheWeek = new DayOfTheWeek();
            System.out.println("Before each...");
        }

        @Test
        void testPositiveValues() {
            assertEquals("Monday", dayOfTheWeek.getDay(2));
            assertEquals("Tuesday", dayOfTheWeek.getDay(3));
            assertEquals("Saturday", dayOfTheWeek.getDay(7));
        }

        @Test
        void testNegativeValues() {
            assertEquals("The number should be between 1 and 7 (inclusive)", dayOfTheWeek.getDay(0));
            assertEquals("The number should be between 1 and 7 (inclusive)", dayOfTheWeek.getDay(8));
        }

        @Test
        void testNullValue() {
            assertThrows(NullPointerException.class, () -> dayOfTheWeek.getDay(null));
        }

        @AfterEach
        void afterTest() {
            System.out.println("After each...");
        }

        @AfterAll
        static void afterAll() {
            System.out.println("After all...");
        }
    @ParameterizedTest
    @MethodSource("dataProvider")
    void methodSourceParamsTest(int dayNumber, String expectedDay) {
        assertEquals(expectedDay, dayOfTheWeek.getDay(dayNumber));
    }

    static Stream <Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(2, "Monday"),
                Arguments.of(3, "Tuesday"),
                Arguments.of(7, "Saturday")

        );
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 7})
    void summaryParamsTest(int dayNumber) {
        String expectedDay = getExpectedDay(dayNumber);
        assertEquals(expectedDay, dayOfTheWeek.getDay(dayNumber));
    }

    private String getExpectedDay(int dayNumber) {
        switch (dayNumber) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                throw new IllegalArgumentException("Invalid day number");
        }
    }

    }
