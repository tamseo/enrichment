package enrich;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnrichmentParser {

    private static EnrichmentParser parser = new EnrichmentParser();

    public static EnrichmentParser getInstance() {
        return parser;
    }

    public List<EnrichmentDefinition> parse(String s) {

        if (!isValid(s)) {
            System.out.printf("Wrong format: %s\n", s);
            return Collections.emptyList();
        }

        List<EnrichmentDefinition> enrichmentDefinitions = new ArrayList<>();

        String regex = "[a-zA-Z0-9._]+\\s*=\\s*[a-zA-Z0-9._]+\\(\\s*[a-zA-Z0-9._]+\\s*\\)\\s*\\{\\s*([a-zA-Z0-9._]+,?\\s*)+\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        Pattern pattern2 = Pattern.compile("[a-zA-Z0-9._]+");
        while (matcher.find()) {
            String group = matcher.group();
            Matcher matcher2 = pattern2.matcher(group);
            List<String> fields = parseAllFields(matcher2);
            EnrichmentDefinition enrichmentDefinition = getEnrichmentDefinition(fields);
            enrichmentDefinitions.add(enrichmentDefinition);
        }

        return enrichmentDefinitions;
    }

    private boolean isValid(String s) {
        String validPattern = "enrich\\s*([a-zA-Z0-9._]+\\s*=\\s*[a-zA-Z0-9._]+\\(\\s*[a-zA-Z0-9._]+\\s*\\)\\s*\\{\\s*([a-zA-Z0-9._]+,?\\s*)+\\},?\\s*)*";
        Pattern validatePattern = Pattern.compile(validPattern);
        Matcher validateMatcher = validatePattern.matcher(s);
        return validateMatcher.matches();
    }

    private List<String> parseAllFields(Matcher matcher) {
        List<String> fields = new ArrayList<>();
        while (matcher.find()) {
            fields.add(matcher.group());
        }
        return fields;
    }

    private EnrichmentDefinition getEnrichmentDefinition(List<String> fields) {
        EnrichmentDefinition enrichmentDefinition = new EnrichmentDefinition();
        enrichmentDefinition
                .setSourceKey(fields.get(0))
                .setTableName(fields.get(1))
                .setId(fields.get(2))
                .setFields(
                        IntStream
                                .range(3, fields.size())
                                .mapToObj(i -> fields.get(i))
                                .collect(Collectors.toSet())
                );
        return enrichmentDefinition;
    }
}
