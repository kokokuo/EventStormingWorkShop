package solid.humank.coffeeshop.order.models;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {

    INITIAL(0), PROCESSING(1), DELIVER(2), CLOSED(3), CANCEL(4);

    OrderStatus(int i) {
        this.value = value;
    }

    private int value;
    private static Map map = new HashMap<>();

    static {
        for (OrderStatus pageType : OrderStatus.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static OrderStatus valueOf(int pageType) {
        return (OrderStatus) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}

