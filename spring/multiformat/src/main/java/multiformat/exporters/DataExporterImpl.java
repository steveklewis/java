/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformat.exporters;

import com.brsanthu.dataexporter.DataExporter;
import multiformat.business.IDataExporter;

/**
 *
 * @author slewis
 */
public class DataExporterImpl implements IDataExporter {
    
    private DataExporter _dataExporter;
    
    public DataExporterImpl(DataExporter dataExporter) {
        this._dataExporter = dataExporter;
    }
    
    public void addRow(Object ... objects) {
        _dataExporter.addRow(objects);
    }
    public void addColumn(String ... strings) {
        _dataExporter.addColumn(strings);
    }
    
    public void finishExporting() {
        _dataExporter.finishExporting();
    }    
}
