import java.util.Objects;
import java.util.Random;

public class HashMapImplTest {
    private static int passed;
    private static int failed;

    public static void main(String[] args) {
        run("empty", HashMapImplTest::testEmpty);
        run("put/get", HashMapImplTest::testPutGet);
        run("overwrite", HashMapImplTest::testOverwrite);
        run("missing key", HashMapImplTest::testMissingKey);
        run("delete", HashMapImplTest::testDelete);
        run("collisions", HashMapImplTest::testCollisions);
        run("random", HashMapImplTest::testRandom);
        run("100000 keys", HashMapImplTest::testMany);

        System.out.println();
        System.out.println("passed: " + passed + ", failed: " + failed);
        if (failed != 0) {
            System.exit(1);
        }
    }

    private static void run(String name, Runnable test) {
        try {
            test.run();
            passed++;
            System.out.println("OK   " + name);
        } catch (Throwable e) {
            failed++;
            System.out.println("FAIL " + name + ": " + e);
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void checkEquals(Object expected, Object actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(
                    message + ": expected " + expected + ", got " + actual);
        }
    }

    private static void testEmpty() {
        HashMapImpl<String> map = new HashMapImpl<>();

        checkEquals(null, map.getValue("missing"), "get from empty");
        checkEquals(null, map.delete("missing"), "delete from empty");
    }

    private static void testPutGet() {
        HashMapImpl<String> map = new HashMapImpl<>();

        map.put("hello", "world");
        map.put("name", "ilya");

        checkEquals("world", map.getValue("hello"), "hello");
        checkEquals("ilya", map.getValue("name"), "name");
    }

    private static void testOverwrite() {
        HashMapImpl<Integer> map = new HashMapImpl<>();

        map.put("key", 1);
        map.put("key", 2);

        checkEquals(2, map.getValue("key"), "new value");
        checkEquals(2, map.delete("key"), "delete after overwrite");
        checkEquals(null, map.getValue("key"), "key after delete");
    }

    private static void testMissingKey() {
        HashMapImpl<Integer> map = new HashMapImpl<>();

        map.put("exists", 10);

        checkEquals(null, map.getValue("missing"), "missing get");
        checkEquals(null, map.delete("missing"), "missing delete");
        checkEquals(10, map.getValue("exists"), "existing key");
    }

    private static void testDelete() {
        HashMapImpl<String> map = new HashMapImpl<>();

        map.put("a", "one");
        map.put("b", "two");

        checkEquals("one", map.delete("a"), "delete a");
        checkEquals(null, map.getValue("a"), "a after delete");
        checkEquals("two", map.getValue("b"), "b still exists");
        checkEquals(null, map.delete("a"), "delete a again");

        map.put("a", "three");
        checkEquals("three", map.getValue("a"), "put after delete");
    }

    private static void testCollisions() {
        HashMapImpl<Integer> map = new HashMapImpl<>();

        map.put("a", 1);
        map.put("aovo", 2);

        checkEquals(1, map.getValue("a"), "a");
        checkEquals(2, map.getValue("aovo"), "aovo");

        map.put("a", 3);
        checkEquals(3, map.getValue("a"), "a overwritten");
        checkEquals(2, map.getValue("aovo"), "aovo after overwrite");

        checkEquals(3, map.delete("a"), "delete a");
        checkEquals(null, map.getValue("a"), "a after delete");
        checkEquals(2, map.getValue("aovo"), "aovo after delete");
    }

    private static void testRandom() {
        HashMapImpl<Integer> map = new HashMapImpl<>();
        java.util.HashMap<String, Integer> expected = new java.util.HashMap<>();
        Random random = new Random(51);

        String[] keys = new String[500];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = "key" + random.nextInt(1000) + "_" + i;
        }

        for (int step = 0; step < 20_000; step++) {
            String key = keys[random.nextInt(keys.length)];
            int action = random.nextInt(10);

            if (action < 5) {
                int value = random.nextInt(100_000);
                map.put(key, value);
                expected.put(key, value);
            } else if (action < 8) {
                checkEquals(expected.get(key), map.getValue(key), "random get " + key);
            } else {
                checkEquals(expected.remove(key), map.delete(key), "random delete " + key);
            }
        }

        for (String key : keys) {
            checkEquals(expected.get(key), map.getValue(key), "final get " + key);
        }
    }

    private static void testMany() {
        int size = 100_000;
        HashMapImpl<Integer> map = new HashMapImpl<>();

        for (int i = 0; i < size; i++) {
            map.put("key" + i, i);
        }

        for (int i = 0; i < size; i++) {
            checkEquals(i, map.getValue("key" + i), "get key" + i);
        }

        for (int i = 0; i < size; i++) {
            checkEquals(i, map.delete("key" + i), "delete key" + i);
        }

        for (int i = 0; i < size; i++) {
            checkEquals(null, map.getValue("key" + i), "get deleted key" + i);
        }
    }
}
