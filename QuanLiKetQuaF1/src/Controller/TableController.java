/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ResultModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thu
 */
public class TableController extends AbstractTableModel{
    private ArrayList<ResultModel> listResult;
    private final Class[] mClasses = {Integer.class, String.class, String.class, String.class, String.class, String.class};
    private final String[] columnNames = {"ID", "Tên tay đua", "Tên chặng đua", "Số vòng đua", "Thời gian", "Trạng thái"};

    public TableController(ArrayList<ResultModel> listResult) {
        this.listResult = listResult;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ResultModel rs = listResult.get(rowIndex);
        switch(columnIndex){
            case 3:
                rs.setLapNumber((String) aValue);
                break;
            case 4:
                rs.setTime((String) aValue);
                break;
            case 5:
                rs.setStatus((String) aValue);
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex < 3){
            return false;
        }
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return mClasses[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return listResult.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ResultModel rs = listResult.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rs.getId();
            case 1: 
                return rs.getRacerName();
            case 2: 
                return rs.getRaceName();
            case 3: 
                return rs.getLapNumber();
            case 4:
                return rs.getTime() ;
            case 5:
                return rs.getStatus();
            default:
                return null;
        }
    }
}
