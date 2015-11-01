package org.brixen.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.extern.slf4j.XSlf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@XSlf4j
public class ConfigServiceImpl implements ConfigService {
    private static final InputStream PROFILE_DIR_STREAM =
            ConfigServiceImpl.class.getClassLoader().getResourceAsStream("./pageobject_config/");

    private Map<String,HashMap<String,LoadableConfig>> profiles = new HashMap<>();

    private static final class Loader {
        private static final ConfigServiceImpl INSTANCE = new ConfigServiceImpl();
    }

    /** Constructs the singleton instance of this {@code ConfigServiceImpl}. */
    private ConfigServiceImpl() {
        if(PROFILE_DIR_STREAM != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(PROFILE_DIR_STREAM));
            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    log.debug("Processing item in config directory: {}", line);
                    File file = new File(line);

                    final URL url = ConfigServiceImpl.class.getClassLoader()
                            .getResource("./pageobject_config/" + file.getName());

                    ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());
                    MapType mapType = mapper.getTypeFactory()
                            .constructMapType(HashMap.class, String.class, LoadableConfig.class);

                    try {
                        //noinspection ConstantConditions
                        profiles.put(file.getName(), mapper.readValue(new File(url.toURI()), mapType));
                    } catch (URISyntaxException | IOException e) {
                        throw new IllegalStateException("Could not read and process profile " + file + ", " + file.toURI(), e);
                    }

                }

                reader.close();
            } catch(IOException e) {
                throw new IllegalStateException("Could not read file list from profile directory");
            }
        }
    }

    /**
     * Returns the singleton instance of {@code ConfigServiceImpl}.
     *
     * @return  the singleton instance of {@code ConfigServiceImpl}
     */
    public static ConfigServiceImpl getInstance() {
        return Loader.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <ConfigT extends LoadableConfig> ConfigT getConfig(String configId, WebDriver driver) {

        //noinspection unchecked
        Map<String,LoadableConfig> profile = profiles.get(getProfileName(driver));

        if(profile != null) {
            return (ConfigT) profile.get(configId);
        }

        return null;
    }

    private String getProfileName(WebDriver driver) {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

        String browserName = cap.getBrowserName();
        String browserVersion = cap.getVersion();
        String osName = cap.getPlatform().name().toLowerCase();
        return browserName + browserVersion + "-" + osName;
    }
}
