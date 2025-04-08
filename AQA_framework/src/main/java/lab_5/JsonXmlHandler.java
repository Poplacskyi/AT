package lab_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonXmlHandler {
    public static void handle() throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // JSON
        InputStream jsonStream = JsonXmlHandler.class.getClassLoader().getResourceAsStream("input.json");
        Person personFromJson = jsonMapper.readValue(jsonStream, Person.class);
        personFromJson.name = "Updated Name";
        personFromJson.isEmployed = true;

        Path outputDir = Paths.get("target");
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }

        jsonMapper.writeValue(new File("target/output.json"), personFromJson);

        // XML
        InputStream xmlStream = JsonXmlHandler.class.getClassLoader().getResourceAsStream("input.xml");
        Person personFromXml = xmlMapper.readValue(xmlStream, Person.class);
        personFromXml.address.city = "Updated City";

        xmlMapper.writeValue(new File("target/output.xml"), personFromXml);
    }
}
