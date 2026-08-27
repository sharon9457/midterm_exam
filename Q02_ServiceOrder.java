import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sound.sampled.Line;

public class Q02_ServiceOrder {
public static class LineItem {
    private final String name;
    private final int unitPrice;
    private final int quantity;
public LineItem(String name, int unitPrice, int quantity){
    this.name = name;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
}
public String getName(){
    return name;
}
public int getUnitPrice(){

    return unitPrice;
}
public int getQuantity(){
    return quantity;
}
public int subtotal(){
    return quantity *unitPrice;
}
}
private final String orderId;
private final List<LineItem> items;
public Q02_ServiceOrder(String orderId){
    this.orderId = orderId;
    this.items = new ArrayList<>();

    if(orderId == null||orderId.trim().isEmpty()){
        throw new IllegalArgumentException("false");
    }
}
public boolean addItem(String name, int unitPrice, int quantity){
    if(name == null||name.trim().isEmpty()){
        return false;
    }if(unitPrice<0){
        return false;
    }if(quantity<0){
        return false;
    }
    this.items.add(new LineItem(name, unitPrice, quantity));
    return true;
}
public int itemCount(){
    return items.size();

}
public int totalAmount(){
    int total =0;
    for(LineItem item:items){
        total += item.subtotal();
        }
        return total;
    }
public String largestItemName(){
    if(items.isEmpty()){
        return "";
    }
    LineItem largest = items.get(0);
    for(int i =1;i<items.size();i++){
        LineItem current = items.get(i);
        if(current.subtotal() > largest.subtotal()){
            largest = current;
        }
    }
    return largest.getName();
}
public List<String> itemSummaries(){
    List<String> summaries = new ArrayList<>();
    for(LineItem item:items){
        summaries.add(item.getName()+":"+item.subtotal());
    }
    return Collections.unmodifiableList(summaries);
}
public static void main(String[] args){
    Q02_ServiceOrder order = new Q02_ServiceOrder("001");
    order.addItem("清潔", 500, 5);
    order.addItem("檢查", 100, 10);
    order.addItem("修理", 1000, 20);

    System.out.println(order.itemCount());
    System.out.println(order.totalAmount());
    System.out.println(order.largestItemName());
    System.out.println(order.itemSummaries());
}
}