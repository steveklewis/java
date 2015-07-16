/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformat.business;

/**
 *
 * @author slewis
 */
public interface IDataExporter {
    public void addRow(Object ... objects);
    public void addColumn(String ... strings);
    public void finishExporting();    
}
