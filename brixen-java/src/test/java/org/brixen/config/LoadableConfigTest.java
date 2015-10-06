package org.brixen.config;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.extern.slf4j.XSlf4j;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Optional;

import static org.testng.Assert.*;

@XSlf4j
@Test(groups = "ConfigUnitTests")
public class LoadableConfigTest {

    @Test(groups = {"ConfigDeserializationUnitTests"})
    public void deserializeConfigWithLoadTimeoutAndNoCustomProperties() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("{");
        buffer.append("  \"type\":\"org.brixen.config.LoadableConfigImpl\",");
        buffer.append("  \"loadTimeout\":10");
        buffer.append("}");

        log.info("Test Scenario: Deserialization of LoadableConfig from JSON source with a load timeout specified " +
                "with no custom properties: {}", buffer.toString());

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());

        try {
            LoadableConfig config = mapper.readValue(buffer.toString(), LoadableConfig.class);

            assertNotNull(config.getLoadTimeout(), "Optional<Integer> load timeout field in LoadableConfigImpl POJO " +
                    "should not be null");
            assertTrue(config.getLoadTimeout().isPresent(), "Optional<Integer> load timeout field in " +
                    "LoadableConfigImpl POJO should return true for Optional<Integer>.isPresent()");
            assertNotNull(config.getLoadTimeout().get(), "Optional<Integer> load timeout field in LoadableConfigImpl " +
                    "POJO should not return null for Optional<Integer>.get()");
            assertEquals(config.getLoadTimeout().get().intValue(), 10, "Optional<Integer> load timeout field in " +
                    "LoadableConfigImpl POJO should return 10 for Optional<Integer>.get().intValue()");
            assertTrue(config.getAdditionalProperties().isEmpty(), "The Map<String,Object> additionalProperties " +
                    "field should have no mappings");
        } catch(JsonMappingException e) {
            log.catching(e);
            fail("There was a problem mapping the JSON source test data to the configuration bean POJO: " +
                    buffer.toString());
        } catch(JsonParseException e) {
            log.catching(e);
            fail("There was a problem parsing the JSON source test data: " + buffer.toString());
        } catch(IOException e) {
            log.catching(e);
            fail("There was a problem reading the JSON source test data String: " + buffer.toString());
        }
    }

    @Test(groups = {"ConfigDeserializationUnitTests"})
    public void deserializeConfigWithExplicitNullLoadTimeoutAndNoCustomProperties() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("{");
        buffer.append("  \"type\":\"org.brixen.config.LoadableConfigImpl\",");
        buffer.append("  \"loadTimeout\":null");
        buffer.append("}");

        log.info("Test Scenario: Deserialization of LoadableConfig from JSON source with a load timeout specified " +
                "with no custom properties: {}", buffer.toString());

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());

        try {
            LoadableConfig config = mapper.readValue(buffer.toString(), LoadableConfig.class);

            assertNotNull(config.getLoadTimeout(), "Optional<Integer> load timeout field in LoadableConfigImpl POJO " +
                    "should not be null");
            assertFalse(config.getLoadTimeout().isPresent(), "Optional<Integer> load timeout field in " +
                    "LoadableConfigImpl POJO should return false for Optional<Integer>.isPresent()");
            assertTrue(config.getAdditionalProperties().isEmpty(), "The Map<String,Object> additionalProperties " +
                    "field should have no mappings");
        } catch(JsonMappingException e) {
            log.catching(e);
            fail("There was a problem mapping the JSON source test data to the configuration bean POJO: " +
                    buffer.toString());
        } catch(JsonParseException e) {
            log.catching(e);
            fail("There was a problem parsing the JSON source test data: " + buffer.toString());
        } catch(IOException e) {
            log.catching(e);
            fail("There was a problem reading the JSON source test data String: " + buffer.toString());
        }
    }

    @Test(groups = {"ConfigDeserializationUnitTests"})
    public void deserializeConfigWithNoLoadTimeoutSpecifiedAndNoCustomProperties() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("{");
        buffer.append("  \"type\":\"org.brixen.config.LoadableConfigImpl\"");
        buffer.append("}");

        log.info("Test Scenario: Deserialization of LoadableConfig from JSON source with a load timeout specified " +
                "with no custom properties: {}", buffer.toString());

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());

        try {
            LoadableConfig config = mapper.readValue(buffer.toString(), LoadableConfig.class);

            assertNull(config.getLoadTimeout(), "Optional<Integer> load timeout field in LoadableConfigImpl POJO " +
                    "should be null");
            assertTrue(config.getAdditionalProperties().isEmpty(), "The Map<String,Object> additionalProperties " +
                    "field should have no mappings");
        } catch(JsonMappingException e) {
            log.catching(e);
            fail("There was a problem mapping the JSON source test data to the configuration bean POJO: " +
                    buffer.toString());
        } catch(JsonParseException e) {
            log.catching(e);
            fail("There was a problem parsing the JSON source test data: " + buffer.toString());
        } catch(IOException e) {
            log.catching(e);
            fail("There was a problem reading the JSON source test data String: " + buffer.toString());
        }
    }

    @Test(groups = {"ConfigDeserializationUnitTests"})
    public void deserializeConfigWithLoadTimeoutAndCustomProperties() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("{");
        buffer.append("  \"type\":\"org.brixen.config.LoadableConfigImpl\",");
        buffer.append("  \"loadTimeout\":10,");
        buffer.append("  \"customPropertyOne\":-1,");
        buffer.append("  \"customPropertyTwo\":false,");
        buffer.append("  \"customPropertyThree\":\"Test String\"");
        buffer.append("}");

        log.info("Test Scenario: Deserialization of LoadableConfig from JSON source with a load timeout specified " +
                "with no custom properties: {}", buffer.toString());

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());

        try {
            LoadableConfig config = mapper.readValue(buffer.toString(), LoadableConfig.class);

            assertNotNull(config.getLoadTimeout(), "Optional<Integer> load timeout field in LoadableConfigImpl POJO " +
                    "should not be null");
            assertTrue(config.getLoadTimeout().isPresent(), "Optional<Integer> load timeout field in " +
                    "LoadableConfigImpl POJO should return true for Optional<Integer>.isPresent()");
            assertNotNull(config.getLoadTimeout().get(), "Optional<Integer> load timeout field in LoadableConfigImpl " +
                    "POJO should not return null for Optional<Integer>.get()");
            assertEquals(config.getLoadTimeout().get().intValue(), 10, "Optional<Integer> load timeout field in " +
                    "LoadableConfigImpl POJO should return 10 for Optional<Integer>.get().intValue()");
            assertFalse(config.getAdditionalProperties().isEmpty(), "The Map<String,Object> additionalProperties " +
                    "field should contain some mappings");
            assertEquals(config.getAdditionalProperties().values().size(), 3);
            assertEquals(((Integer) config.getAdditionalProperties().get("customPropertyOne")).intValue(), -1);
            assertEquals(((Boolean) config.getAdditionalProperties().get("customPropertyTwo")).booleanValue(), false);
            assertEquals(((String) config.getAdditionalProperties().get("customPropertyThree")), "Test String");
        } catch(JsonMappingException e) {
            log.catching(e);
            fail("There was a problem mapping the JSON source test data to the configuration bean POJO: " +
                    buffer.toString());
        } catch(JsonParseException e) {
            log.catching(e);
            fail("There was a problem parsing the JSON source test data: " + buffer.toString());
        } catch(IOException e) {
            log.catching(e);
            fail("There was a problem reading the JSON source test data String: " + buffer.toString());
        }
    }

    @Test(groups = {"ConfigDeserializationUnitTests"})
    public void deserializeConfigWithNoLoadTimeoutSpecifiedAndCustomProperties() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("{");
        buffer.append("  \"type\":\"org.brixen.config.LoadableConfigImpl\",");
        buffer.append("  \"customPropertyOne\":-1,");
        buffer.append("  \"customPropertyTwo\":false,");
        buffer.append("  \"customPropertyThree\":\"Test String\"");
        buffer.append("}");

        log.info("Test Scenario: Deserialization of LoadableConfig from JSON source with a load timeout specified " +
                "with no custom properties: {}", buffer.toString());

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());

        try {
            LoadableConfig config = mapper.readValue(buffer.toString(), LoadableConfig.class);

            assertNull(config.getLoadTimeout(), "Optional<Integer> load timeout field in LoadableConfigImpl POJO " +
                    "should be null");
            assertFalse(config.getAdditionalProperties().isEmpty(), "The Map<String,Object> additionalProperties " +
                    "field should contain some mappings");
            assertEquals(config.getAdditionalProperties().values().size(), 3);
            assertEquals(((Integer)config.getAdditionalProperties().get("customPropertyOne")).intValue(), -1);
            assertEquals(((Boolean) config.getAdditionalProperties().get("customPropertyTwo")).booleanValue(), false);
            assertEquals(((String) config.getAdditionalProperties().get("customPropertyThree")), "Test String");
        } catch(JsonMappingException e) {
            log.catching(e);
            fail("There was a problem mapping the JSON source test data to the configuration bean POJO: " +
                    buffer.toString());
        } catch(JsonParseException e) {
            log.catching(e);
            fail("There was a problem parsing the JSON source test data: " + buffer.toString());
        } catch(IOException e) {
            log.catching(e);
            fail("There was a problem reading the JSON source test data String: " + buffer.toString());
        }
    }

    @Test(
            groups = {"ConfigSerializationUnitTests"}, 
            dependsOnMethods = {"deserializeConfigWithLoadTimeoutAndNoCustomProperties"}
    )
    public void serializeConfigWithLoadTimeoutAndNoCustomProperties() {
        LoadableConfig inputConfig = new LoadableConfigImpl();
        inputConfig.setType(LoadableConfigImpl.class);
        inputConfig.setLoadTimeout(Optional.of(10));

        log.info("Test Scenario: Serialization of LoadableConfig from JSON source with a load timeout specified " +
                "with no custom properties: {}", inputConfig);

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());


        String serializedConfig = null;
        
        try {
            serializedConfig = mapper.writeValueAsString(inputConfig);
        } catch(JsonProcessingException e) {
            log.catching(e);
            fail("Could not serialize input LoadableConfig bean to JSON: " + inputConfig);
        }

        try {
            LoadableConfig outputConfig = mapper.readValue(serializedConfig, LoadableConfigImpl.class);
            assertEquals(outputConfig, inputConfig);
        } catch(IOException e) {
            log.catching(e);
            fail("Could not serialize the JSON output from the serialization of the input config bean back into " +
                    "the output LoadableConfigImpl bean: " + inputConfig);
        }
    }

    @Test(
            groups = {"ConfigSerializationUnitTests"},
            dependsOnMethods = {"deserializeConfigWithExplicitNullLoadTimeoutAndNoCustomProperties"}
    )
    public void serializeConfigWithExplicitNullLoadTimeoutAndNoCustomProperties() {
        LoadableConfig inputConfig = new LoadableConfigImpl();
        inputConfig.setType(LoadableConfigImpl.class);
        inputConfig.setLoadTimeout(Optional.empty());

        log.info("Test Scenario: Serialization of LoadableConfig from JSON source with a explicit null specified for " +
                "load timeout with no custom properties: {}", inputConfig);

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());


        String serializedConfig = null;

        try {
            serializedConfig = mapper.writeValueAsString(inputConfig);
        } catch(JsonProcessingException e) {
            log.catching(e);
            fail("Could not serialize input LoadableConfig bean to JSON: " + inputConfig);
        }

        try {
            LoadableConfig outputConfig = mapper.readValue(serializedConfig, LoadableConfigImpl.class);
            assertEquals(outputConfig, inputConfig);
        } catch(IOException e) {
            log.catching(e);
            fail("Could not serialize the JSON output from the serialization of the input config bean back into " +
                    "the output LoadableConfigImpl bean: " + inputConfig);
        }
    }

    @Test(
            groups = {"ConfigSerializationUnitTests"},
            dependsOnMethods = {"deserializeConfigWithNoLoadTimeoutSpecifiedAndNoCustomProperties"}
    )
    public void serializeConfigWithNoLoadTimeoutSpecifiedAndNoCustomProperties() {
        LoadableConfig inputConfig = new LoadableConfigImpl();
        inputConfig.setType(LoadableConfigImpl.class);
        inputConfig.setLoadTimeout(null);

        log.info("Test Scenario: Serialization of LoadableConfig from JSON source with no load timeout specified " +
                "with no custom properties: {}", inputConfig);

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());


        String serializedConfig = null;

        try {
            serializedConfig = mapper.writeValueAsString(inputConfig);
        } catch(JsonProcessingException e) {
            log.catching(e);
            fail("Could not serialize input LoadableConfig bean to JSON: " + inputConfig);
        }

        try {
            LoadableConfig outputConfig = mapper.readValue(serializedConfig, LoadableConfigImpl.class);
            assertEquals(outputConfig, inputConfig);
        } catch(IOException e) {
            log.catching(e);
            fail("Could not serialize the JSON output from the serialization of the input config bean back into " +
                    "the output LoadableConfigImpl bean: " + inputConfig);
        }
    }

    @Test(
            groups = {"ConfigSerializationUnitTests"},
            dependsOnMethods = {"deserializeConfigWithLoadTimeoutAndCustomProperties"}
    )
    public void serializeConfigWithLoadTimeoutAndCustomProperties() {
        LoadableConfig inputConfig = new LoadableConfigImpl();
        inputConfig.setType(LoadableConfigImpl.class);
        inputConfig.setLoadTimeout(Optional.of(10));
        inputConfig.setAdditionalProperty("customPropertyOne", -1);
        inputConfig.setAdditionalProperty("customPropertyTwo", false);
        inputConfig.setAdditionalProperty("customPropertyThree", "Test String");

        log.info("Test Scenario: Serialization of LoadableConfig from JSON source with non-null load timeout " +
                "specified with custom properties: {}", inputConfig);

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());


        String serializedConfig = null;

        try {
            serializedConfig = mapper.writeValueAsString(inputConfig);
        } catch(JsonProcessingException e) {
            log.catching(e);
            fail("Could not serialize input LoadableConfig bean to JSON: " + inputConfig);
        }

        try {
            LoadableConfig outputConfig = mapper.readValue(serializedConfig, LoadableConfigImpl.class);
            assertEquals(outputConfig, inputConfig);
        } catch(IOException e) {
            log.catching(e);
            fail("Could not serialize the JSON output from the serialization of the input config bean back into " +
                    "the output LoadableConfigImpl bean: " + inputConfig);
        }
    }

    @Test(
            groups = {"ConfigSerializationUnitTests"},
            dependsOnMethods = {"deserializeConfigWithNoLoadTimeoutSpecifiedAndCustomProperties"}
    )
    public void serializeConfigWithNoLoadTimeoutSpecifiedAndCustomProperties() {
        LoadableConfig inputConfig = new LoadableConfigImpl();
        inputConfig.setType(LoadableConfigImpl.class);
        inputConfig.setLoadTimeout(null);
        inputConfig.setAdditionalProperty("customPropertyOne", -1);
        inputConfig.setAdditionalProperty("customPropertyTwo", false);
        inputConfig.setAdditionalProperty("customPropertyThree", "Test String");

        log.info("Test Scenario: Serialization of LoadableConfig from JSON source with no load timeout specified " +
                "with custom properties: {}", inputConfig);

        ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());


        String serializedConfig = null;

        try {
            serializedConfig = mapper.writeValueAsString(inputConfig);
        } catch(JsonProcessingException e) {
            log.catching(e);
            fail("Could not serialize input LoadableConfig bean to JSON: " + inputConfig);
        }

        try {
            LoadableConfig outputConfig = mapper.readValue(serializedConfig, LoadableConfigImpl.class);
            assertEquals(outputConfig, inputConfig);
        } catch(IOException e) {
            log.catching(e);
            fail("Could not serialize the JSON output from the serialization of the input config bean back into " +
                    "the output LoadableConfigImpl bean: " + inputConfig);
        }
    }
}
