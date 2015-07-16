package multiformat.exporters;


import com.brsanthu.dataexporter.DataExporter;
import com.brsanthu.dataexporter.model.json.JsonExporter;
import com.brsanthu.dataexporter.output.csv.CsvExporter;
import com.brsanthu.dataexporter.output.html.HtmlExporter;
import com.brsanthu.dataexporter.output.xml.XmlExporter;
import java.io.StringWriter;
import multiformat.business.IDataExporter;

/**
 *
 * @author slewis
 */
public class DataExporterFactory {
    public IDataExporter createDataExporter(String type, StringWriter sw) {
        if ("json".equals(type)) {
            return new DataExporterImpl(new JsonExporter(sw));
        } else if ("csv".equals(type)) {
            return new DataExporterImpl(new CsvExporter(sw));
        } else if ("html".equals(type)) {
            return new DataExporterImpl(new HtmlExporter(sw));
        } else if ("xml".equals(type)) {
            return new DataExporterImpl(new XmlExporter(sw));
        }         
        return null;
    }
}
