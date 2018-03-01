package enrich;

public class EnrichmentTest {
    public static void main(String[] args) {
        String s = "enrich sourceKey1 = Apple(appleId1){field1 field2, field3  }, sourceKey2=Apple(appleId2){field1,   field2 field3  } sourceKey3 = Apple(appleId3){field1, field2, field3 field4,field5 }";

        String wrongFormat = "sourceKey1 = Apple(appleId1){field1 field2, field3  }";
        EnrichmentParser parser = EnrichmentParser.getInstance();
        try {
            test(s, parser);
            test(wrongFormat, parser);
        } catch (Exception e) {
            return;
        }
    }

    private static void test(String s, EnrichmentParser parser) throws Exception {
        parser.parse(s)
                .forEach(System.out::println);
    }
}
