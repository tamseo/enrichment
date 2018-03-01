package enrich;

public class EnrichmentTest {
    public static void main(String[] args) {
        String s = "enrich sourceKey1 = Apple(appleId1){field1 field2, field3  }, sourceKey2=Apple(appleId2){field1,   field2 field3  } sourceKey3 = Apple(appleId3){field1, field2, field3 field4,field5 }";

        String wrongFormat1 = "sourceKey1 = Apple(appleId1){field1 field2, field3  }";
        String wrongFormat2 = "enrich sourceKey1 = Apple(){field1 field2, field3  }";
        String wrongFormat3 = "enrich sourceKey1 = Apple(appleId){field1 field2, field3  ";
        String wrongFormat4 = "enrich sourceKey1 = Apple(appleId1)field1 field2, field3  }, sourceKey2=Apple(appleId2){field1,   field2 field3  } sourceKey3 = Apple(appleId3){field1, field2, field3 field4,field5 }";
        String wrongFormat5 = "enrich sourceKey1 Apple(appleId1){field1 field2, field3  }, sourceKey2=Apple(appleId2){field1,   field2 field3  } sourceKey3 = Apple(appleId3){field1, field2, field3 field4,field5 }";

        EnrichmentParser parser = EnrichmentParser.getInstance();

        test(s, parser);
        test(wrongFormat1, parser);
        test(wrongFormat2, parser);
        test(wrongFormat3, parser);
        test(wrongFormat4, parser);
        test(wrongFormat5, parser);
    }

    private static void test(String s, EnrichmentParser parser) {
        parser.parse(s)
                .forEach(System.out::println);
    }
}
