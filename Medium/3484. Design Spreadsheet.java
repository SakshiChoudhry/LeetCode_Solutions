import java.util.HashMap;
import java.util.Map;

class Spreadsheet {
    private boolean isNumber(String s) {
        return s.matches("\\d+");
    }
    Map<String, Integer> m;
    public Spreadsheet(int rows) {
        m=new HashMap<>();
    }

    public void setCell(String cell, int value) {
        m.put(cell,value);
    }

    public void resetCell(String cell) {
        m.put(cell,0);
    }

    public int getValue(String formula) {
        String[] arr= formula.substring(1).split("\\+");

        int l = isNumber(arr[0]) ? Integer.parseInt(arr[0]) : m.getOrDefault(arr[0], 0);
        int r = isNumber(arr[1]) ? Integer.parseInt(arr[1]) : m.getOrDefault(arr[1], 0);


        return l+r;

    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */