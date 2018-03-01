package enrich;

public class EnrichmentTest {
    public static void main(String[] args) {
        String s = "enrich sourceKey1 = Apple(appleId1){field1 field2, field3  }, sourceKey2=Apple(appleId2){field1,   field2 field3  } sourceKey3 = Apple(appleId3){field1, field2, field3 field4,field5 }";
        EnrichmentParser parser = EnrichmentParser.getInstance();
        parser.parse(s)
                .forEach(System.out::println);
    }
}
