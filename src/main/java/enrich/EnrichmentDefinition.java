package enrich;

import java.util.Set;

public class EnrichmentDefinition {
    private String sourceKey, tableName, id;
    private Set<String > fields;

    public String getSourceKey() {
        return sourceKey;
    }

    public EnrichmentDefinition setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public EnrichmentDefinition setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getId() {
        return id;
    }

    public EnrichmentDefinition setId(String id) {
        this.id = id;
        return this;
    }

    public Set<String> getFields() {
        return fields;
    }

    public EnrichmentDefinition setFields(Set<String> fields) {
        this.fields = fields;
        return this;
    }

    @Override
    public String toString() {
        return "EnrichmentDefinition{" +
                "sourceKey='" + sourceKey + '\'' +
                ", tableName='" + tableName + '\'' +
                ", id='" + id + '\'' +
                ", fields=" + fields +
                '}';
    }
}
